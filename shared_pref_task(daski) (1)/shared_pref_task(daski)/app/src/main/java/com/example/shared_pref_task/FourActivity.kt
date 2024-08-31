package com.example.shared_pref_task

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        var txtSName: EditText =findViewById(R.id.edit_text_surname)
        var txtName: EditText =findViewById(R.id.edit_text_name)
        var txtEmail: EditText =findViewById(R.id.edit_text_email)
        var txtPass:EditText=findViewById(R.id.edit_text_password)
        var txtDate: EditText =findViewById(R.id.edit_text_dob)
        var txtGender: RadioGroup =findViewById(R.id.radio_group_gender)
        var txtCity: EditText =findViewById(R.id.edit_text_city)
        var btn_edit: Button =findViewById(R.id.button_edit)

        var sp1=application.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor=sp1.edit()

        txtSName.setText(sp1.getString("surname",""))
        txtName.setText(sp1.getString("name",""))
        txtEmail.setText(sp1.getString("email",""))
        txtPass.setText(sp1.getString("password",""))
        txtDate.setText(sp1.getString("date",""))
        txtCity.setText(sp1.getString("city",""))


        btn_edit.setOnClickListener {
            editor.putString("surname",txtSName.text.toString())
            editor.putString("name",txtName.text.toString())
            editor.putString("email",txtEmail.text.toString())
            editor.putString("password",txtPass.text.toString())
            editor.putString("date",txtDate.text.toString())
            editor.putString("city",txtCity.text.toString())

            editor.commit()



        }


    }
}