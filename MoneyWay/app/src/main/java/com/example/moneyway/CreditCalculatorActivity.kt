package com.example.moneyway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.moneyway.databinding.ActivityCreditCalculatorBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.UserDao
import java.math.RoundingMode
import kotlin.math.pow

class CreditCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreditCalculatorBinding

    lateinit var totalSumText: TextView
    lateinit var monthlyPaymentText: TextView
    lateinit var generalSumText: TextView
    lateinit var generalPercent: TextView
    lateinit var editTextCapital: EditText
    lateinit var editTextPercent: EditText
    lateinit var editTextMonths: EditText

    lateinit var countButton: Button
    lateinit var toCalculatorsListButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreditCalculatorBinding.inflate(layoutInflater)

        totalSumText = binding.totalText
        monthlyPaymentText = binding.monthlyPaymentText
        generalSumText = binding.generalSumText
        generalPercent = binding.generalPercent
        editTextCapital = binding.editTextCapital
        editTextPercent = binding.editTextPercent
        editTextMonths = binding.editTextMonths

        countButton = binding.countButton
        toCalculatorsListButton = binding.buttonToClaculatorsList

        toCalculatorsListButton.setOnClickListener {
            onCLickToCalculatorsButton(it)
        }

        countButton.setOnClickListener {
            onClickCountButton(it)
        }

        setContentView(binding.root)
    }

    fun onCLickToCalculatorsButton(view: View){
        finish()
    }

    fun onClickCountButton(view: View){
        var capital = 0.0
        var percent = 0.0
        var months = 0.0
        var res = 0.0

        try {
            capital = editTextCapital.text.toString().toDouble()
            percent = editTextPercent.text.toString().toDouble()
            months = editTextMonths.text.toString().toDouble()
        }
        catch(e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
            return
        }

        //вычисление данных по кредиту по формуле для аннуитетных платежей
        var r = percent / 100.0
        var ak = (r * (1 + r).pow(months)) / (((1 + r).pow(months)) - 1)
        var mp = capital * ak
        res = mp * months

        totalSumText.text = res.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString()
        monthlyPaymentText.text = mp.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString()
        generalSumText.text = capital.toString()
        generalPercent.text = (res - capital).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString()
    }

}