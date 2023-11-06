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
import java.lang.Exception

class BudgetPlansActivity : AppCompatActivity() {

    lateinit var binding: ActivityBudgetPlansBinding
    lateinit var db: AppDatabase
    private lateinit var uDao: UserDao
    lateinit var sDao: SpendingsDataDBDao
    lateinit var bDao: BudgetPlansDBDao
    lateinit var changePlanButton: Button
    var summ: Int = 0

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

        planProfitAm = binding.planProfitAm
        planRestAm = binding.planRestaurantsAm
        planTranspAm = binding.planTranspAm
        planGoodsAm = binding.planGoodsAm
        planServAm = binding.planServAm
        planTransactionsAm = binding.planTransactionAm
        planOtherAm = binding.planOtherAm
        planSumAm = binding.planSumAm

        factProfitAm = binding.factProfitAm
        factRestAm = binding.factRestaurantsAm
        factTranspAm = binding.factTranspAm
        factGoodsAm = binding.factGoodsAm
        factServAm = binding.factServAm
        factTransactionsAm = binding.factTransactionAm
        factOtherAm = binding.factOtherAm
        factSumAm = binding.factSumAm

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()
        sDao = db.spendingsDao()
        bDao = db.budgetPlansDao()

        //проверяю, есть ли активный пользователь
        try {
            uDao.getOnline()[0]
        }
        catch (e: Exception){
            startActivity(Intent(this, LogInActivity::class.java))
        }

        var budgetPlansUid = bDao.getByUid(uDao.getOnline()[0].uid)
        //если таблица "BudgetPlansDB" пустая то значения равны 0
        if(budgetPlansUid.isEmpty()){
            planProfitAm.text = "0"
            planRestAm.text = "0"
            planTranspAm.text = "0"
            planGoodsAm.text = "0"
            planServAm.text = "0"
            planTransactionsAm.text = "0"
            planOtherAm.text = "0"
            planSumAm.text = "0"
        } //иначе присваиваю данные из таблицы
        else {
            planProfitAm.text = budgetPlansUid[0].b_profit.toString()
            planRestAm.text = budgetPlansUid[0].b_restaurants.toString()
            planTranspAm.text = budgetPlansUid[0].b_transport.toString()
            planGoodsAm.text = budgetPlansUid[0].b_goods.toString()
            planServAm.text = budgetPlansUid[0].b_services.toString()
            planTransactionsAm.text = budgetPlansUid[0].b_transactions.toString()
            planOtherAm.text = budgetPlansUid[0].b_other.toString()
            planSumAm.text = budgetPlansUid[0].b_sum.toString()
        }

        var budgetFactUid = sDao.getByUid(uDao.getOnline()[0].uid)
        if(budgetFactUid.isEmpty()){
            factProfitAm.text = "0"
            factRestAm.text = "0"
            factTranspAm.text = "0"
            factGoodsAm.text = "0"
            factServAm.text = "0"
            factTransactionsAm.text = "0"
            factOtherAm.text = "0"
            factSumAm.text = "0"
        }
        else {
            factProfitAm.text = sDao.getByTypeAndUid("Прибыль", uDao.getOnline()[0].uid).sum().toString()
            factRestAm.text = sDao.getByTypeAndUid("Рестораны", uDao.getOnline()[0].uid).sum().toString()
            factTranspAm.text = sDao.getByTypeAndUid("Транспорт", uDao.getOnline()[0].uid).sum().toString()
            factGoodsAm.text = sDao.getByTypeAndUid("Товары", uDao.getOnline()[0].uid).sum().toString()
            factServAm.text = sDao.getByTypeAndUid("Услуги", uDao.getOnline()[0].uid).sum().toString()
            factTransactionsAm.text = sDao.getByTypeAndUid("Переводы", uDao.getOnline()[0].uid).sum().toString()
            factOtherAm.text = sDao.getByTypeAndUid("Прочее", uDao.getOnline()[0].uid).sum().toString()
            factSumAm.text = (factRestAm.text.toString().toInt() +
                    factTranspAm.text.toString().toInt() +
                    factGoodsAm.text.toString().toInt() +
                    factServAm.text.toString().toInt() +
                    factTransactionsAm.text.toString().toInt() +
                    factOtherAm.text.toString().toInt()).toString()
        }

        binding.apply {
            navBudgetPlans.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@BudgetPlansActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@BudgetPlansActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> startActivity(Intent(this@BudgetPlansActivity, BudgetPlansActivity::class.java))
                    R.id.account -> startActivity(Intent(this@BudgetPlansActivity, ProfilePageActivity::class.java))
                    R.id.exit -> {
                        val usersOnline = uDao.getOnline()
                        for(item in usersOnline){
                            uDao.updateOnlineSt(item.uid, 0)
                        }
                        startActivity(Intent(this@BudgetPlansActivity, LogInActivity::class.java))
                    }
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