package com.example.moneyway

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.moneyway.databinding.ActivityChangePlanBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.BudgetPlans
import com.example.moneyway.localDB.BudgetPlansDB
import com.example.moneyway.localDB.BudgetPlansDBDao
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao
import java.lang.Exception

class ChangePlanActivity : AppCompatActivity() {

    private val TAG = "Exception In Calculations"

    lateinit var binding: ActivityChangePlanBinding
    lateinit var toPlanButton: ImageButton
    lateinit var db: AppDatabase
    lateinit var bDao: BudgetPlansDBDao
    lateinit var uDao: UserDao
    lateinit var onlineUsers: List<User>
    lateinit var bArray: List<BudgetPlansDB>
    lateinit var saveButton: Button
    lateinit var otherRemains: Button

    lateinit var editPlanSum: EditText
    lateinit var editPlanProf: EditText
    lateinit var editPlanRest: EditText
    lateinit var editPlanTransp: EditText
    lateinit var editPlanGoods: EditText
    lateinit var editPlanServ: EditText
    lateinit var editPlanTransactions: EditText
    lateinit var editPlanOther: EditText
    var planSum: Int = 0
    var planProf: Int = 0
    var planRest: Int = 0
    var planTransp: Int = 0
    var planGoods: Int = 0
    var planServ: Int = 0
    var planTransactions: Int = 0
    var planOther: Int = 0
    var factSum: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editPlanSum = binding.editPlanSum
        editPlanProf = binding.editPlanProf
        editPlanRest = binding.editPlanRest
        editPlanTransp = binding.editPlanTransp
        editPlanGoods = binding.editPlanGoods
        editPlanServ = binding.editPlanServ
        editPlanTransactions = binding.editPlanTransitions
        editPlanOther = binding.editPlanOther

        toPlanButton = binding.buttonToPlans
        otherRemains = binding.otherRemains
        saveButton = binding.savePlanButton

        db = AppDatabase.getInstance(this)
        bDao = db.budgetPlansDao()
        uDao = db.userDao()

        onlineUsers = uDao.getOnline()
        bArray = bDao.getByUid(onlineUsers[0].uid)

        //вставляю значения в поля, если есть данные в таблице по активному пользователю, чтобы не заполнять заново
        if(bArray.isNotEmpty()){
            editPlanSum.setText(bArray[0].b_sum.toString())
            editPlanProf.setText(bArray[0].b_profit.toString())
            editPlanRest.setText(bArray[0].b_restaurants.toString())
            editPlanTransp.setText(bArray[0].b_transport.toString())
            editPlanGoods.setText(bArray[0].b_goods.toString())
            editPlanServ.setText(bArray[0].b_services.toString())
            editPlanTransactions.setText(bArray[0].b_transactions.toString())
            editPlanOther.setText(bArray[0].b_other.toString())
        }

        toPlanButton.setOnClickListener{
            onClickToPlanButton(it)
        }

        saveButton.setOnClickListener{
            onClickSaveButton(it)
        }

        otherRemains.setOnClickListener{
            onClickOtherRemains(it)
        }
    }

    fun onClickToPlanButton(view: View){
        finish()
    }

    fun onClickOtherRemains(view: View){
        //проверяю, заполнил ли пользователь все поля
        try {
            planSum = editPlanSum.text.toString().toInt()
            planProf = editPlanProf.text.toString().toInt()
            planRest = editPlanRest.text.toString().toInt()
            planTransp = editPlanTransp.text.toString().toInt()
            planGoods = editPlanGoods.text.toString().toInt()
            planServ = editPlanServ.text.toString().toInt()
            planTransactions = editPlanTransactions.text.toString().toInt()
        }
        catch (e: Exception){
            Toast.makeText(this, "Вы не заполнили поля!", Toast.LENGTH_LONG).show()
            return
        }

        editPlanOther.setText((planSum - (planTransp + planRest + planGoods + planServ + planTransactions)).toString())
    }

    fun onClickSaveButton(view: View){

        try {
            planSum = editPlanSum.text.toString().toInt()
            planProf = editPlanProf.text.toString().toInt()
            planRest = editPlanRest.text.toString().toInt()
            planTransp = editPlanTransp.text.toString().toInt()
            planGoods = editPlanGoods.text.toString().toInt()
            planServ = editPlanServ.text.toString().toInt()
            planTransactions = editPlanTransactions.text.toString().toInt()
            planOther = editPlanOther.text.toString().toInt()
        }
        catch (e: Exception){
            Toast.makeText(this, "Вы не заполнили поля!", Toast.LENGTH_LONG).show()
            return
        }



        factSum = planRest + planTransp + planGoods + planServ + planTransactions + planOther
        //если получившаяся сумма равна запланированной, то сохраняю в бд(кнопка остаток в категории разно позволяет записать оставшуюся сумму)
        if(factSum == planSum) {
            if (bArray.isEmpty()) {
                bDao.insert(
                    BudgetPlans(
                        planSum,
                        planProf,
                        planRest,
                        planTransp,
                        planGoods,
                        planServ,
                        planTransactions,
                        planOther,
                        onlineUsers[0].uid
                    )
                )
            } else {
                bDao.updateInfo(
                    bDao.getBidByUid(onlineUsers[0].uid),
                    planSum,
                    planProf,
                    planRest,
                    planTransp,
                    planGoods,
                    planServ,
                    planTransactions,
                    planOther
                )
            }
            startActivity(Intent(this, BudgetPlansActivity::class.java))
        }
        else{
            Toast.makeText(this, "Сумма, которая в итоге получается не равна запланированной!", Toast.LENGTH_LONG).show()
        }

    }
}