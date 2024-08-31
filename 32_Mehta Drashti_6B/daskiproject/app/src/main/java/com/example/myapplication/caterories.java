package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class caterories extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterories);

        b1 = findViewById(R.id.btn3d);
        b2 = findViewById(R.id.btnnature);
        b3 = findViewById(R.id.btnsimple);
        b4 = findViewById(R.id.btnpencil);
        b5 = findViewById(R.id.btnsketch);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(caterories.this,imagesActivity.class);

                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(caterories.this,imagesActivity2.class);

                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(caterories.this,imagesActivity3.class);

                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(caterories.this,imagesActivity4.class);

                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(caterories.this,imagesActivity5.class);

                startActivity(i);
            }
        });


    }
}