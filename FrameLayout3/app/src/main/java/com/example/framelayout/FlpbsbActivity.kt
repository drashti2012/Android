package com.example.framelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView

class FlpbsbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flpbsb)

        var rb:RatingBar=findViewById(R.id.ratingBar)
        var tv1:TextView=findViewById(R.id.textView3)

        rb.setOnRatingBarChangeListener { ratingBar, fl, b ->
            tv1.setText("Rating Bar:$fl")
        }

        var sb:SeekBar=findViewById(R.id.seekBar3)
        var tv2:TextView=findViewById(R.id.textView5)
        sb.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv2.setText("SeekBar value:$p1")
                sb.secondaryProgress = p1 + 10

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}
