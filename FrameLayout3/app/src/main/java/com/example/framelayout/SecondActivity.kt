package com.example.framelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var btn1:Button=findViewById(R.id.button)
        btn1.setOnClickListener {
            var i=Intent(this,CltvActivity::class.java)
            startActivity(i)
        }
        var btn2:Button=findViewById(R.id.button2)
        btn2.setOnClickListener {
            var i=Intent(this,LletActivity::class.java)
            startActivity(i)
        }
        var btn3:Button=findViewById(R.id.button3)
        btn3.setOnClickListener {
            var i=Intent(this, Rlbtn2Activity::class.java)
            startActivity(i)
        }
        var btn4:Button=findViewById(R.id.button4)
        btn4.setOnClickListener {
            var i=Intent(this,FlpbsbActivity::class.java)
            startActivity(i)
        }
    }



}