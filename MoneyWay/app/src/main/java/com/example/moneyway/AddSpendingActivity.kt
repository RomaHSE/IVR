package com.example.moneyway

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import com.example.moneyway.databinding.ActivityAddSpendingBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.SpendingsDataDBDao
import com.example.moneyway.localDB.SpendingsDataDBInsert
import com.example.moneyway.localDB.UserDao
import java.util.Calendar

class AddSpendingActivity : AppCompatActivity(){
    lateinit var binding: ActivityAddSpendingBinding
    lateinit var spinner: Spinner
    var spendingType: String? = null
    lateinit var buttonToMain: ImageButton
    lateinit var spendingAmount: EditText
    lateinit var spendingDescription: EditText
    lateinit var spendingDate: EditText
    lateinit var addSpending: Button
    lateinit var db: AppDatabase
    lateinit var sDao: SpendingsDataDBDao
    lateinit var uDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSpendingBinding.inflate(layoutInflater)
        buttonToMain = binding.buttonToMain
        spendingAmount = binding.spendingAmountEdit
        spendingDescription = binding.spendingDescrEdit
        spendingDate = binding.spendingDateEdit
        addSpending = binding.addSpendingButtonReady
        setContentView(binding.root)

        spinner = binding.spendingsSpinner
        ArrayAdapter.createFromResource(this,
            R.array.spendingTypes,
            android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spendingType = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@AddSpendingActivity, "Категория не выбрана", Toast.LENGTH_SHORT).show()
            }
        }

        buttonToMain.setOnClickListener {
            onClickToMainButton(it)
        }

        spendingDate.setOnClickListener{
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                {view, year1, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "." + (monthOfYear + 1) + "." + year)
                    spendingDate.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        addSpending.setOnClickListener{
            onClickAddSpendingButton(it)
        }

        db = AppDatabase.getInstance(this)
        sDao = db.spendingsDao()
        uDao = db.userDao()
    }

    fun onClickToMainButton(view: View) {
        finish()
    }

    fun onClickAddSpendingButton(view: View){

        var amount : Int
        var description : String
        var date : String
        var user : Int

        try {
            amount = binding.spendingAmountEdit.text.toString().toInt()
            description = binding.spendingDescrEdit.text.toString()
            date = binding.spendingDateEdit.text.toString()
            user = uDao.getOnline()[0].uid
        }
        catch (e: Exception){
            Toast.makeText(applicationContext, "Не все поля заполнены или заполнено неправильными типами данных", Toast.LENGTH_LONG).show()
            return
        }

        sDao.insert(SpendingsDataDBInsert(amount, spendingType, date, description, user))
        startActivity(Intent(this, MainActivity::class.java))
    }

}