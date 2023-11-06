package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat
import com.example.moneyway.databinding.ActivityProfilePageBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao
import java.lang.Exception
import java.net.UnknownServiceException

class ProfilePageActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfilePageBinding
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao

    lateinit var userName: TextView
    lateinit var userLogin: TextView
    lateinit var userPassword: TextView
    lateinit var editButton: Button
    lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfilePageBinding.inflate(layoutInflater)

        userName = binding.userName
        userLogin = binding.userLogin
        userPassword = binding.userPassword
        editButton = binding.editButton
        deleteButton = binding.deleteAccButton

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()

        var user: User? = null

        try {
            user = uDao.getOnline()[0]
        }
        catch (e: Exception){
            startActivity(Intent(this, LogInActivity::class.java))
        }

        if (user != null) {
            userName.text = user.u_name
        }
        if (user != null) {
            userLogin.text = user.u_login
        }
        if (user != null) {
            userPassword.text = user.u_password
        }

        //Считывание нажатий в navigation_view
        binding.apply {
            navMain.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.home -> startActivity(Intent(this@ProfilePageActivity, MainActivity::class.java))
                    R.id.calculators -> startActivity(Intent(this@ProfilePageActivity, CalculatorsListActivity::class.java))
                    R.id.plans -> {
                        val intent = Intent(this@ProfilePageActivity, BudgetPlansActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.account -> startActivity(Intent(this@ProfilePageActivity, LogInActivity::class.java))
                    R.id.exit -> {
                        val usersOnline = uDao.getOnline()
                        for(item in usersOnline){
                            uDao.updateOnlineSt(item.uid, 0)
                        }
                        startActivity(Intent(this@ProfilePageActivity, LogInActivity::class.java))
                    }
                }
                true
            }
        }

        editButton.setOnClickListener {
            onClickEditButton(it)
        }

        deleteButton.setOnClickListener {
            onClickDeleteUser(it)
        }

        setContentView(binding.root)
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

    fun onClickEditButton(view: View){
        startActivity(Intent(this, EditUserDataActivity::class.java))
    }

    fun onClickDeleteUser(view: View){
        uDao.deleteByUid(uDao.getOnline()[0].uid)
        startActivity(Intent(this, LogInActivity::class.java))
    }
}