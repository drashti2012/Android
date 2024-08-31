package com.example.shared_pref_task

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.core.view.ViewCompat
import java.util.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var btn: Button =findViewById(R.id.button_submit)

        //SurName:-
        var uSurName: EditText =findViewById(R.id.edit_text_surname)

        //Name:-
        var uName: EditText =findViewById(R.id.edit_text_name)

        //Password:-
        var uPassword:EditText=findViewById(R.id.edit_text_password)

        //Email:
        var email: EditText =findViewById(R.id.edit_text_email)
        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches())
                {
                    btn.isEnabled=false
                    email.setError("Invalid Input")
                }
                else
                {
                    btn.isEnabled=true
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }


        })

        //City:-
        var aCity: AutoCompleteTextView =findViewById(R.id.edit_text_city)
        var city= arrayOf("Ahemdabad ","Rajkot","Jamnagar","Baroda","Surat","Junagadh","Morabi")
        var adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        aCity.setAdapter(adapter)

        //Date:-
        var etDate: EditText =findViewById(R.id.edit_text_dob)
        var c= Calendar.getInstance()

        etDate.setOnClickListener {
            DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    etDate.setText("$dayOfMonth/${month+1}/$year")
                },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Gender:--
        var str:String=""
        var eGender: RadioGroup =findViewById(R.id.radio_group_gender)
        eGender.setOnCheckedChangeListener{ radioGroup,i->
            var rb=findViewById<RadioButton>(i)
            str=rb.text.toString()
        }


        var sp=application.getSharedPreferences("login", Context.MODE_PRIVATE)
        var editor=sp.edit()
        //Intent:-
        btn.setOnClickListener {


            editor.putString("surname",uSurName.text.toString())
            editor.putString("name",uName.text.toString())
            editor.putString("email",email.text.toString())
            editor.putString("password",uPassword.text.toString())
            editor.putString("date",etDate.text.toString())
            editor.putString("city",aCity.text.toString())
            editor.putString("gender",str)

            editor.commit()

            uSurName.setText("")
            uName.setText("")
            email.setText("")
            uPassword.setText("")
            etDate.setText("")
            aCity.setText("")


            var i= Intent(this,FourActivity::class.java)
            startActivity(i)
        }

        //Shared pref:

    }


    }
