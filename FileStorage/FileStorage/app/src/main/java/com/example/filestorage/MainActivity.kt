package com.example.filestorage

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed_txt:EditText=findViewById(R.id.editTextTextMultiLine)
        var btn_write:Button=findViewById(R.id.btn_write)
        var btn_read:Button=findViewById(R.id.btn_read)

        var builder = AlertDialog.Builder(this)

        btn_write.setOnClickListener {
            var fos = openFileOutput("myFile",Context.MODE_PRIVATE)
            fos.write(ed_txt.text.toString().toByteArray())
            builder.setTitle("File Storage Demo")
            builder.setMessage("Data saved into file")
            builder.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                ed_txt.setText("")
            })
            builder.setNegativeButton("CANCEL",DialogInterface.OnClickListener { dialogInterface, i ->
                ed_txt.setText("")
            })
            builder.setNeutralButton("CLOSE",DialogInterface.OnClickListener { dialogInterface, i ->
                ed_txt.setText("")
            })
            builder.show()
        }
        btn_read.setOnClickListener {
            var line:String?=""
            var fip=application.openFileInput("myFile")
            var br = BufferedReader(InputStreamReader(fip))
            while (line!=null){
                line = br.readLine()
                if(line!=null){
                    Toast.makeText(applicationContext,line.toString(),Toast.LENGTH_LONG).show()
                    ed_txt.append(line.toString()+"\n")
                }
            }
        }
    }
}