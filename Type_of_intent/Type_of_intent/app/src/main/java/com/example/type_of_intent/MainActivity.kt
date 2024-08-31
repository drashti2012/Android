package com.example.type_of_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_send:Button=findViewById(R.id.button)
        var edname:EditText=findViewById(R.id.ed1)
        var edsurname:EditText=findViewById(R.id.ed2)

        btn_send.setOnClickListener {
            var i=Intent(this,SecondActivity::class.java)
            i.putExtra("Name",edname.text.toString())
            i.putExtra("Surname",edsurname.text.toString())
            startActivity(i)
        }



    }
}