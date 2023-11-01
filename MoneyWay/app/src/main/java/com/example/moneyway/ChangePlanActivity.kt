package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.moneyway.databinding.ActivityChangePlanBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.BudgetPlans
import com.example.moneyway.localDB.BudgetPlansDB
import com.example.moneyway.localDB.BudgetPlansDBDao
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao

class ChangePlanActivity : AppCompatActivity() {

    lateinit var binding: ActivityChangePlanBinding
    lateinit var toPlanButton: ImageButton
    lateinit var db: AppDatabase
    lateinit var bDao: BudgetPlansDBDao
    lateinit var uDao: UserDao
    lateinit var onlineUsers: List<User>
    lateinit var bArray: List<BudgetPlansDB>
    lateinit var saveButton: Button

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
        saveButton = binding.savePlanButton

        db = AppDatabase.getInstance(this)
        bDao = db.budgetPlansDao()
        uDao = db.userDao()

        onlineUsers = uDao.getOnline()
        bArray = bDao.getByUid(onlineUsers[0].uid)

        toPlanButton.setOnClickListener{
            onClickToPlanButton(it)
        }

        saveButton.setOnClickListener{
            onClickSaveButton(it)
        }
    }

    fun onClickToPlanButton(view: View){
        finish()
    }

    fun onClickSaveButton(view: View){

        planSum = editPlanSum.text.toString().toInt()
        planProf = editPlanProf.text.toString().toInt()
        planRest = editPlanRest.text.toString().toInt()
        planTransp = editPlanSum.text.toString().toInt()
        planGoods = editPlanGoods.text.toString().toInt()
        planServ = editPlanServ.text.toString().toInt()
        planTransactions = editPlanTransactions.text.toString().toInt()
        planOther = editPlanOther.text.toString().toInt()

        if(bArray.isEmpty()){
            bDao.insert(BudgetPlans(
                planSum,
                planProf,
                planRest,
                planTransp,
                planGoods,
                planServ,
                planTransactions,
                planOther,
                onlineUsers[0].uid
            ))
        }
        else{
            bDao.updateInfo(
                bDao.getBidByUid(onlineUsers[0].uid),
                planSum,
                planProf,
                planRest,
                planTransp,
                planGoods,
                planServ,
                planTransactions,
                planOther)
        }
        startActivity(Intent(this, BudgetPlansActivity::class.java))
    }
}