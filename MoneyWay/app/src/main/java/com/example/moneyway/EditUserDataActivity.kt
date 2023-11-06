package com.example.moneyway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.moneyway.databinding.ActivityEditUserDataBinding
import com.example.moneyway.localDB.AppDatabase
import com.example.moneyway.localDB.User
import com.example.moneyway.localDB.UserDao
import java.lang.Exception

class EditUserDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditUserDataBinding
    lateinit var db: AppDatabase
    lateinit var uDao: UserDao
    lateinit var user: User

    lateinit var editName: EditText
    lateinit var editLogin: EditText
    lateinit var editPassword: EditText
    lateinit var buttonBack: ImageButton
    lateinit var saveDataButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditUserDataBinding.inflate(layoutInflater)

        editName = binding.editName
        editLogin = binding.editLogin
        editPassword = binding.editPassword
        buttonBack = binding.buttonBack
        saveDataButton = binding.buttonSaveData

        db = AppDatabase.getInstance(this)
        uDao = db.userDao()



        try {
            user = uDao.getOnline()[0]
            editName.setText(user.u_name)
            editLogin.setText(user.u_login)
            editPassword.setText(user.u_password)
        }
        catch (e: Exception){
            startActivity(Intent(this, LogInActivity::class.java))
        }


        buttonBack.setOnClickListener {
            onClickBackButton(it)
        }

        saveDataButton.setOnClickListener {
            onClickSaveButton(it)
        }

        setContentView(binding.root)
    }
    //обновление данных в таблице
    fun onClickSaveButton(view: View){

        if(editName.text.toString() != "" && editLogin.text.toString() != "" && editPassword.text.toString() != "") {
            if (uDao.getUserByLogin(editLogin.text.toString()).isEmpty() ||
                uDao.getOnline()[0].u_login == editLogin.text.toString()){

                uDao.updateUserData(
                    editName.text.toString(),
                    editLogin.text.toString(),
                    editPassword.text.toString(),
                    user.uid
                )
            }
            else{
                Toast.makeText(this, "Пользователь с таким логином уже существует!", Toast.LENGTH_LONG).show()
                return
            }
        }
        else{
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_LONG).show()
            return
        }

        startActivity(Intent(this, ProfilePageActivity::class.java))
    }

    fun onClickBackButton(view: View){
        finish()
    }
}