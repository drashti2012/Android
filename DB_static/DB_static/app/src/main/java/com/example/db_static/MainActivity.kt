package com.example.db_static

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper=MyDBHelper(applicationContext)
        var db=helper.writableDatabase
        Toast.makeText(applicationContext,"DATABASE AND TABLE CREATED",Toast.LENGTH_LONG).show()
    }
}