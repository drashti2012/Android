package com.example.list_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView:ListView=findViewById(R.id.list1)
        var city= arrayOf("surat","rajkot","ahemdabad","gandhinagar","baroda","pune")
        var adapter=ArrayAdapter<String>(this,R.layout.list_view,city)
        listView.adapter=adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            var value=listView.getItemAtPosition(i).toString()
            if(value=="surat"){
                var i=Intent(this,SuratActivity::class.java)
                startActivity(i)
            }else if (value=="rajkot"){
                var i2=Intent(this,RajkotActivity::class.java)
                startActivity(i2)
            }else if (value=="ahemdabad"){
                var i3=Intent(this,AhemdabadActivity::class.java)
                startActivity(i3)
            }else if (value=="gandhinagar"){
                var i4=Intent(this,GandhinagarActivity::class.java)
                startActivity(i4)
            }else if (value=="baroda"){
                var i5=Intent(this,BarodaActivity::class.java)
                startActivity(i5)
            }else if (value=="pune"){
                var i6=Intent(this,PuneActivity::class.java)
                startActivity(i6)
            }
//            Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
        }

    }
}