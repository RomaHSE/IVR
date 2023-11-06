package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.moneyway.databinding.ActivityCalculatorsListBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.UserDao

class CalculatorsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorsListBinding
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()

        try {
            uDao.getOnline()[0]
        }
        catch (e: Exception){
            startActivity(Intent(this, LogInActivity::class.java))
        }

        binding.apply {
            navCalculators.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@CalculatorsListActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@CalculatorsListActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> startActivity(Intent(this@CalculatorsListActivity, BudgetPlansActivity::class.java))
                    R.id.account -> startActivity(Intent(this@CalculatorsListActivity, ProfilePageActivity::class.java))
                    R.id.exit -> {
                        val usersOnline = uDao.getOnline()
                        for(item in usersOnline){
                            uDao.updateOnlineSt(item.uid, 0)
                        }
                        startActivity(Intent(this@CalculatorsListActivity, LogInActivity::class.java))
                    }
                }
                true
            }
        }
        binding.toClassicCalculatorButton.setOnClickListener {
            onClickClassicCalculatorButton(it)
        }

        binding.toCreditCalculatorButton.setOnClickListener {
            onClickCreditCalculatorButton(it)
        }

        binding.toSavingsCalculator.setOnClickListener {
            onClickSavingsCalculatorButton(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.openMenu -> binding.drawerCalculators.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun onClickClassicCalculatorButton(view: View){
        startActivity(Intent(this, ClassicCalculatorActivity::class.java))
    }

    fun onClickCreditCalculatorButton(view: View){
        startActivity(Intent(this, CreditCalculatorActivity::class.java))
    }

    fun onClickSavingsCalculatorButton(view: View){
        startActivity(Intent(this, SavingsCalculatorActivity::class.java))
    }
}