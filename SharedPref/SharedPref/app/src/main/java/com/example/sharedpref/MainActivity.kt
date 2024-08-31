package com.example.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edUserName: EditText=findViewById(R.id.filledTextField1)
        var edPassword: EditText=findViewById(R.id.filledTextField2)

        var btn_save:Button=findViewById(R.id.btn1)
        var btn_read:Button=findViewById(R.id.btn2)

        var sp=application.getSharedPreferences("LoginData",Context.MODE_PRIVATE)
        var editor=sp.edit()

        btn_save.setOnClickListener {
            editor.putString("Username",edUserName.text.toString())
            editor.putString("Password",edPassword.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Data Saved",Toast.LENGTH_LONG).show()
            edUserName.setText("")
            edPassword.setText("")
        }

        btn_read.setOnClickListener {
            edUserName.setText(sp.getString("Username",""))
            edPassword.setText(sp.getString("Password",""))
        }
    }
}