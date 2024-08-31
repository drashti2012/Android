package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView:TextView=findViewById(R.id.textView)

        textView.setOnClickListener {
            Toast.makeText(applicationContext,"hello mca",Toast.LENGTH_LONG).show()
        }
    }
}