package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class CltvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cltv)

        var textView: TextView =findViewById(R.id.textview)

        textView.setOnClickListener {
            Toast.makeText(applicationContext,"hello mca", Toast.LENGTH_LONG).show()
        }
    }
}