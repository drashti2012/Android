package com.example.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import java.util.*

class LletActivity : AppCompatActivity() {
    private lateinit var edEmail: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llet)

        var edEmail :EditText= findViewById(R.id.editEmail)
        var edDate :EditText= findViewById(R.id.editTextDate2)
        var c= Calendar.getInstance()

        var actvCIty: AutoCompleteTextView =findViewById(R.id.autoCompleteTextView)
        var city= arrayOf("Rajkot","Surat","Baroda","Jamnagar","Pune")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item)
        actvCIty.setAdapter(adapter)

        var mactvSkill: MultiAutoCompleteTextView =findViewById(R.id.multiAutoCompleteTextView)
        var skill= arrayOf("web design","web dev","seo","android")
        var skillAdapter= ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,skill)
        mactvSkill.setAdapter(skillAdapter)
        mactvSkill.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        var edTime:EditText=findViewById(R.id.editTextTime)

        button = findViewById(R.id.button)

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

        edDate.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day->
                edDate.setText("$day${month+1}/$year")
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }

        edTime.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hour, minutes ->
                edTime.setText("$hour:$minutes")
            },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),true).show()
        }
    }
}