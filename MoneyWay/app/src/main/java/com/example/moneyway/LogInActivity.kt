package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.moneyway.databinding.ActivityLogInBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    lateinit var logInButton: Button
    lateinit var regLinkButton: Button
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logInButton = binding.logInButton
        regLinkButton = binding.regLinkButton
        logInButton.setOnClickListener{
            onClickLogInButton(it)
        }
        regLinkButton.setOnClickListener{
            onClickRegLinkButton(it)
        }

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()

    }

    fun onClickLogInButton(view: View){
        val login = binding.loginEdit.text.toString()
        val password = binding.passwordEdit.text.toString()
        val userInfo = uDao.getUserByLogin(login)
        //проверяем, если пользователь существует
        if (!userInfo.isEmpty()) {
            if (password == userInfo[0].u_password) {
                uDao.updateOnlineSt(userInfo[0].uid, 1)
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        else {
            Toast.makeText(this, "Такого пользователя не существует!", Toast.LENGTH_LONG).show()
            return
        }
    }

    fun onClickRegLinkButton(view: View){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}