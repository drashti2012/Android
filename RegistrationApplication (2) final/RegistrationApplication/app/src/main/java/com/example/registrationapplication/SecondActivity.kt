package com.example.registrationapplication

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var name : EditText = findViewById(R.id.editText1)
        var edEmail : EditText = findViewById(R.id.editText3)
        var button : Button = findViewById(R.id.button)
        edEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = s.toString()
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edEmail.error = null
                    button.isEnabled = true
                } else {
                    edEmail.error = "Invalid email address"
                    button.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        var edDate : EditText = findViewById(R.id.editTextDate2)

        var c= Calendar.getInstance()
        edDate.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day->
                edDate.setText("$day/${month+1}/$year")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        var actvCIty: AutoCompleteTextView =findViewById(R.id.autoCompleteTextView)
        var city= arrayOf("Rajkot","Surat","Baroda","Jamnagar","Pune")
        var adapter = ArrayAdapter<String>(this,R.layout.text_edit,city)
        actvCIty.setAdapter(adapter)



        var ch1: CheckBox =findViewById(R.id.checkBox1)
        var ch2: CheckBox =findViewById(R.id.checkBox2)
        var ch3: CheckBox =findViewById(R.id.checkBox3)
        var text: TextView =findViewById(R.id.textView)
        var str1 : String= "" // This will store the selected hobbies

        ch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                str1 += "Reading, "
            }
        }

        ch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                str1 += "Travelling, "
            }
        }

        ch3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                str1 += "Music, "
            }
        }

//        ch1.setOnClickListener {
//            var str="Reading:${ch1.isChecked}\nTravelling:${ch2.isChecked}\nMusic:${ch3.isChecked}"
//
//        }
//        ch2.setOnClickListener {
//            var str="Reading:${ch1.isChecked}\nTravelling:${ch2.isChecked}\nMusic:${ch3.isChecked}"
//
//        }
//        ch3.setOnClickListener {
//            var str="Reading:${ch1.isChecked}\nTravelling:${ch2.isChecked}\nMusic:${ch3.isChecked}"
//
//        }
        var str:String=""
        var egender:RadioGroup=findViewById(R.id.rgp1)
        egender.setOnCheckedChangeListener { radioGroup, i ->
            var rb=findViewById<RadioButton>(i)
            str=rb.text.toString()
        }
        button.setOnClickListener {
            var i=Intent(this,ThirdActivity::class.java)
            i.putExtra("name",name.text.toString())

            i.putExtra("E-mail",edEmail.text.toString())

            i.putExtra("gender",str)

            i.putExtra("hobbies",str1)

            i.putExtra("city",actvCIty.text.toString())

            i.putExtra("dateofbirth",edDate.text.toString())
            startActivity(i)

        }
        

    }
}