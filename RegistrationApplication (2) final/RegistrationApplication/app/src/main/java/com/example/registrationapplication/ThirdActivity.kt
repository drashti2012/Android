package com.example.registrationapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import java.net.PasswordAuthentication

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var txtName:TextView=findViewById(R.id.tv2)
        var edEmail : TextView = findViewById(R.id.tv3)
        var txtgender:TextView=findViewById(R.id.tv4)
        var txthobby:TextView=findViewById(R.id.tv5)
        var txtcity:TextView=findViewById(R.id.tv6)
        var txtdate:TextView=findViewById(R.id.tv7)

        var Intent:Intent=intent

        var name=intent.getStringExtra("name")
        txtName.setText("Name: "+name)
        var email=intent.getStringExtra("E-mail")
        edEmail.setText("E-mail: "+ email)
        var gender=intent.getStringExtra("gender")
        txtgender.setText("Gender: "+gender)
        var hobbies=intent.getStringExtra("hobbies")
        txthobby.setText("Hobbies: "+ hobbies)
        var city=intent.getStringExtra("city")
        txtcity.setText("City: "+ city)
        var dateofbirth=intent.getStringExtra("dateofbirth")
        txtdate.setText("Date Of Birth: "+dateofbirth)



    }
}