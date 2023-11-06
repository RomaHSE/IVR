package com.example.moneyway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.moneyway.databinding.ActivitySavingsCalculatorBinding
import java.lang.Exception
import java.math.RoundingMode

class SavingsCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivitySavingsCalculatorBinding

    lateinit var totalSum: TextView
    lateinit var monthlyProfit: EditText
    lateinit var savingsPercent: EditText
    lateinit var savingsPeriod: EditText
    lateinit var countSButton: Button
    lateinit var exitButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySavingsCalculatorBinding.inflate(layoutInflater)

        totalSum = binding.totalSavingsSum
        monthlyProfit = binding.monthlyProfit
        savingsPercent = binding.savingsPercent
        savingsPeriod = binding.periodSavings
        countSButton = binding.countSButton
        exitButton = binding.buttonToCalculatorsList

        countSButton.setOnClickListener {
            onClickCountSButton(it)
        }

        exitButton.setOnClickListener {
            onCLickExitButton(it)
        }
        setContentView(binding.root)
    }

    fun onClickCountSButton(view: View){
        var profit: Double = 0.0
        var percent: Double = 0.0
        var period: Double = 0.0
        var res: Double = 0.0

        try {
            profit = monthlyProfit.text.toString().toDouble()
            percent = savingsPercent.text.toString().toDouble()
            period = savingsPeriod.text.toString().toDouble()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
            return
        }

        percent /= 100

        res = (profit * percent) * period
        totalSum.text = res.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString()
    }

    fun onCLickExitButton(view: View){
        finish()
    }
}