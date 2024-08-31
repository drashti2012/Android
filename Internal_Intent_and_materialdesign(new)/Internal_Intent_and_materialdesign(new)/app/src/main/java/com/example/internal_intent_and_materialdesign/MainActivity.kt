package com.example.internal_intent_and_materialdesign

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_web = findViewById<Button>(R.id.button)
        btn_web.setOnClickListener {
            var uri= Uri.parse("https://www.google.com")
            var i= Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)
        }
        var ed_call:EditText=findViewById(R.id.edit_text)
        var btn_call:Button=findViewById(R.id.textButton)

        btn_call.setOnClickListener {
            var uri=Uri.parse("tel:" + ed_call.text.toString())
            var i=Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)
        }

        var btn_map=findViewById<Button>(R.id.button2)
        btn_map.setOnClickListener {
            var uri=Uri.parse("geo:0,0=?q"+"Atmiya University,Rajkot")
            var i=Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)
        }
    }
}