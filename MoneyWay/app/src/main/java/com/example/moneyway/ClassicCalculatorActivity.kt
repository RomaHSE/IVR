package com.example.moneyway

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.moneyway.databinding.ActivityClassicCalculatorActivityBinding
import java.lang.Exception
import java.math.RoundingMode
import kotlin.math.roundToInt

class ClassicCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityClassicCalculatorActivityBinding

    lateinit var resultText: TextView
    lateinit var number1Text: EditText
    lateinit var number2Text: EditText
    lateinit var plusButton: Button
    lateinit var minusButton: Button
    lateinit var multiplicationButton: Button
    lateinit var divisionButton: Button
    lateinit var percentButton: Button
    lateinit var toCalculatorsList: ImageButton
    lateinit var copyResButton: ImageButton

    var number1Int: Long = 0
    var number2Int: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassicCalculatorActivityBinding.inflate(layoutInflater)

        resultText = binding.resultText
        number1Text = binding.editTextNumber1
        number2Text = binding.editTextNumber2
        plusButton = binding.buttonPlus
        minusButton = binding.buttonMinus
        multiplicationButton = binding.buttonMultiplication
        divisionButton = binding.buttonDivision
        percentButton = binding.buttonPercent
        toCalculatorsList = binding.buttonToClaculatorsList
        copyResButton = binding.copyResult

        if(("." in number1Text.text.toString()) || ("." in number2Text.text.toString())){
            Toast.makeText(this, "Значения в полях должны быть целочисленного типа!", Toast.LENGTH_LONG).show()
        }
        else{
            plusButton.setOnClickListener{
                onClickPlusButton(it)
            }
            minusButton.setOnClickListener{
                onClickMinusButton(it)
            }
            multiplicationButton.setOnClickListener{
                onClickMultiplicationButton(it)
            }
            divisionButton.setOnClickListener{
                onClickDivisionButton(it)
            }
            percentButton.setOnClickListener{
                onClickPercentButton(it)
            }
        }

        toCalculatorsList.setOnClickListener{
            onClickToCalculatorsList(it)
        }

        copyResButton.setOnClickListener{
            onClickCopyResButton(it)
        }

        setContentView(binding.root)
    }

    //функция для суммы
    fun onClickPlusButton(view: View){
        try {
            number1Int = number1Text.text.toString().toLong()
            number2Int = number2Text.text.toString().toLong()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }
        resultText.text = (number1Int + number2Int).toString()
    }
    //функция для разности
    fun onClickMinusButton(view: View){
        try {
            number1Int = number1Text.text.toString().toLong()
            number2Int = number2Text.text.toString().toLong()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }
        resultText.text = (number1Int - number2Int).toString()
    }
    //функция для умножения
    fun onClickMultiplicationButton(view: View){
        try {
            number1Int = number1Text.text.toString().toLong()
            number2Int = number2Text.text.toString().toLong()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }
        resultText.text = (number1Int * number2Int).toString()
    }
    //функция для деления
    fun onClickDivisionButton(view: View){
        try {
            number1Int = number1Text.text.toString().toLong()
            number2Int = number2Text.text.toString().toLong()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }
        resultText.text = (number1Int.toDouble() / number2Int.toDouble()).toBigDecimal().setScale(4, RoundingMode.UP).toString()
    }
    //функция для вычисления процента
    fun onClickPercentButton(view: View){
        try {
            number1Int = number1Text.text.toString().toLong()
            number2Int = number2Text.text.toString().toLong()
        }
        catch (e: Exception){
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }
        resultText.text = (((number1Int.toDouble() / 100) * number2Int.toDouble()).toBigDecimal().setScale(3, RoundingMode.UP)).toString()
    }
    //кнопка выхода
    fun onClickToCalculatorsList(view: View){
        finish()
    }
    //копирование результата
    fun onClickCopyResButton(view: View){
        val textToCopy = resultText.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Текст скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
    }
}