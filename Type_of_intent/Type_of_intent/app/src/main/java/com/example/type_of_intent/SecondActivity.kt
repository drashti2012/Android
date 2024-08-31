package com.example.type_of_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var txtname:TextView=findViewById(R.id.textView3)
        var txtsurname:TextView=findViewById(R.id.textView4)

        var intent:Intent=getIntent()
        var name=intent.getStringExtra("Name")
        var surname=intent.getStringExtra("Surname")

        txtname.setText("Name:"+name)
        txtsurname.setText("Surname:"+surname)
    }
}