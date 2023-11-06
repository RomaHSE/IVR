package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.moneyway.databinding.ActivityMainBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.SpendingsDataDB
import com.example.moneyway.localDB.SpendingsDataDBDao
import com.example.moneyway.localDB.SpendingsDataDBInsert
import com.example.moneyway.localDB.UserDao

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao
    lateinit var sDao: SpendingsDataDBDao
    lateinit var listAdapter: CustomListArrayAdapter
    lateinit var addSpendingButton: Button
    lateinit var deleteAllButton: Button
    lateinit var spendings: List<SpendingsDataDB>
    lateinit var totalAmount: TextView

    var listArrayData = ArrayList<SpendingsDataDB>()
    var summ = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        addSpendingButton = binding.addSpendingButton
        totalAmount = binding.totalAmount
        deleteAllButton = binding.deleteAllButton
        setContentView(binding.root)

        //подключение бд и функций
        db = AppDatabase.getInstance(this)
        uDao = db.userDao()
        sDao = db.spendingsDao()

        //Считывание нажатий в navigation_view
        binding.apply {
            navMain.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@MainActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> {
                        val intent = Intent(this@MainActivity, BudgetPlansActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.account -> startActivity(Intent(this@MainActivity, ProfilePageActivity::class.java))
                    R.id.exit -> {
                        val usersOnline = uDao.getOnline()
                        for(item in usersOnline){
                            uDao.updateOnlineSt(item.uid, 0)
                        }
                        startActivity(Intent(this@MainActivity, LogInActivity::class.java))
                    }
                }
                true
            }
        }


        addSpendingButton.setOnClickListener{
            onClickToAddSpendingButton(it)
        }

        deleteAllButton.setOnClickListener {
            onClickDeleteAll(it)
        }

        //Обработка исключений, когда is_online==0
        try {
            spendings = sDao.getByUid(uDao.getOnline()[0].uid)

            for(item in spendings){
                listArrayData.add(SpendingsDataDB(
                    item.sid,
                    item.s_amount,
                    item.s_type,
                    item.s_date,
                    item.s_description,
                    item.s_user))

                if(item.s_type == "Прибыль")
                    summ += item.s_amount
                else{
                    summ -= item.s_amount
                }

            }
        }
        catch (e: Exception){
            startActivity(Intent(this, LogInActivity::class.java))
        }

        totalAmount.text = "Остаток: " + summ.toString()

        //подключаю кастомный адаптер для item'а списка
        listAdapter = CustomListArrayAdapter(this@MainActivity, listArrayData)
        binding.sList.adapter = listAdapter

    }

    //подключаю header
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //считывание нажатий на кнопку меню и выдвижение navigation_view
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.openMenu -> binding.drawerMain.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    //считывание нажатий на кнопку добавления расхода
    fun onClickToAddSpendingButton(view: View){
        startActivity(Intent(this, AddSpendingActivity::class.java))
    }

    fun onClickDeleteAll(view: View){
        sDao.deleteAllByUid(uDao.getOnline()[0].uid)
        finish()
        startActivity(intent)
    }
}