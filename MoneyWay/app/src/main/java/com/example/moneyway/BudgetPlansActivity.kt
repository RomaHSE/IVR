package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.moneyway.databinding.ActivityBudgetPlansBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.BudgetPlansDBDao
import com.example.moneyway.localDB.SpendingsDataDBDao
import com.example.moneyway.localDB.UserDao

class BudgetPlansActivity : AppCompatActivity() {

    lateinit var binding: ActivityBudgetPlansBinding
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao
    lateinit var sDao: SpendingsDataDBDao
    lateinit var bDao: BudgetPlansDBDao
    lateinit var changePlanButton: Button

    lateinit var planProfitAm: TextView
    lateinit var planRestAm: TextView
    lateinit var planTranspAm: TextView
    lateinit var planGoodsAm: TextView
    lateinit var planServAm: TextView
    lateinit var planTransactionsAm: TextView
    lateinit var planOtherAm: TextView
    lateinit var planSumAm: TextView

    lateinit var factProfitAm: TextView
    lateinit var factRestAm: TextView
    lateinit var factTranspAm: TextView
    lateinit var factGoodsAm: TextView
    lateinit var factServAm: TextView
    lateinit var factTransactionsAm: TextView
    lateinit var factOtherAm: TextView
    lateinit var factSumAm: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBudgetPlansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changePlanButton = binding.addPlanButton

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()
        sDao = db.spendingsDao()
        bDao = db.budgetPlansDao()

        binding.apply {
            navBudgetPlans.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@BudgetPlansActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@BudgetPlansActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> startActivity(Intent(this@BudgetPlansActivity, BudgetPlansActivity::class.java))
                    R.id.account -> startActivity(Intent(this@BudgetPlansActivity, LogInActivity::class.java))
                }
                true
            }
        }

        changePlanButton.setOnClickListener{
            onClickChangePlanButton(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.header, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.openMenu -> binding.budgetPlansDrawer.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickChangePlanButton(view: View){
        startActivity(Intent(this, ChangePlanActivity::class.java))
    }
}