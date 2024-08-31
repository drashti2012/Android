package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Rlbtn2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rlbtn2)

        var btn: Button =findViewById(R.id.button)
        var imgbtn: ImageButton =findViewById(R.id.imageButton)
        var tglbtn: ToggleButton =findViewById(R.id.toggleButton)
        var imgview: ImageView =findViewById(R.id.imageView2)

        var ch1: CheckBox =findViewById(R.id.checkBox1)
        var ch2: CheckBox =findViewById(R.id.checkBox2)
        var ch3: CheckBox =findViewById(R.id.checkBox3)
        var text: TextView =findViewById(R.id.textView)



        btn.setOnClickListener {
            Toast.makeText(applicationContext,"Simple button click!", Toast.LENGTH_LONG).show()
        }
        imgbtn.setOnClickListener {
            Toast.makeText(applicationContext,"Image button click", Toast.LENGTH_LONG).show()
        }
        tglbtn.setOnClickListener {
            if (tglbtn.text.equals("OFF")) {
                imgview.setImageResource(R.drawable.off)
            } else {
                imgview.setImageResource(R.drawable.on)
            }
        }

        ch1.setOnClickListener {
            var str="ANDROID:${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nJAVA:${ch3.isChecked}"
            text.setText(str)
        }
        ch2.setOnClickListener {
            var str="ANDROID:${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nJAVA:${ch3.isChecked}"
            text.setText(str)
        }
        ch3.setOnClickListener {
            var str="ANDROID:${ch1.isChecked}\nKOTLIN:${ch2.isChecked}\nJAVA:${ch3.isChecked}"
            text.setText(str)
        }

        var rgp: RadioGroup =findViewById(R.id.radio1)
        var tv2: TextView =findViewById(R.id.textView2)
        rgp.setOnCheckedChangeListener { radioGroup, i ->
            var rbtn=findViewById<RadioButton>(i)
            if (rbtn!=null){
                tv2.setText(rbtn.text)
            }
        }

        var resetbtn: Button =findViewById(R.id.button2)
        resetbtn.setOnClickListener {
            rgp.clearCheck()
            tv2.setText("Select Option")
        }

    }
}