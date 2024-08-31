package com.example.shared_pref_task

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var edUserName: EditText =findViewById(R.id.filledTextField1)
        var edPassword: EditText =findViewById(R.id.filledTextField2)

        var btn_login: Button =findViewById(R.id.button)

        var sp=application.getSharedPreferences("Login", Context.MODE_PRIVATE)
        var editor=sp.edit()

        btn_login.setOnClickListener {
            editor.putString("Username",edUserName.text.toString())
            editor.putString("Password",edPassword.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Login Successfully", Toast.LENGTH_LONG).show()
            edUserName.setText("")
            edPassword.setText("")
        }

        btn_login.setOnClickListener {
            var i=Intent(this,ThirdActivity::class.java)
            startActivity(i)
        }
    }
}