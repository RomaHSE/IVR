package com.example.moneyway

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.moneyway.databinding.ActivityRegisterBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao
import com.example.moneyway.localDB.UserInsert

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var user_name: String
    lateinit var user_login: String
    lateinit var user_password: String
    lateinit var user_password2: String
    lateinit var reg_button: Button
    lateinit var log_in_link_button: Button
    lateinit var error_text: TextView
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reg_button = binding.regButton
        log_in_link_button = binding.logInLinkButton
        error_text = binding.errorText

        reg_button.setOnClickListener{
            onClickRegButton(it)
        }
        log_in_link_button.setOnClickListener{
            onClickLogInLinkButton(it)
        }

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()
    }

    fun onClickRegButton(view: View){
        user_name = binding.nameRegEdit.text.toString()
        user_login = binding.loginRegEdit.text.toString()
        user_password = binding.passwordRegEdit.text.toString()
        user_password2 = binding.password2RegEdit.text.toString()

        if(uDao.getUserByLogin(user_login).isEmpty()){
            if(user_name != "" && user_login != "" && user_password != "" && user_password2 != "") {
                if (user_password == user_password2) {
                    uDao.insert(UserInsert(user_name, user_login, user_password, true))
                    startActivity(Intent(this, LogInActivity::class.java))
                } else {
                    error_text.text = "Пароли не совпадают"
                    error_text.visibility = View.VISIBLE
                    return
                }
            }
            else{
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
                return
            }
        }
        else{
            Toast.makeText(this, "Пользователь с таким логином уже существует", Toast.LENGTH_LONG).show()
            return
        }
    }

    fun onClickLogInLinkButton(view: View){
        startActivity(Intent(this, LogInActivity::class.java))
    }
}