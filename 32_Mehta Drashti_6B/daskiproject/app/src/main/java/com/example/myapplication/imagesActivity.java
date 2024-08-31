package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.FileOutputStream;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class imagesActivity extends AppCompatActivity {

    private static int REQUEST_CODE = 100;
    ImageView bird;
    ImageView img4;
    Button SaveImg;
    Button saveimage1;
    OutputStream outputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        SaveImg = findViewById(R.id.saveimgbtn);
        saveimage1 = findViewById(R.id.saveimage1);
        bird = findViewById(R.id.bird);
        SaveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(imagesActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                    saveImage();

                }else {


                    askPermission();

                }

            }
        });


        saveimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(imagesActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                    saveImage1();

                }else {


                    askPermission();

                }

            }
        });
    }

    private void askPermission() {

        ActivityCompat.requestPermissions(imagesActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {

        if (requestCode == REQUEST_CODE)
        {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){


                saveImage();

            }else {


                Toast.makeText(getApplicationContext(),"Please provide the required permissions",Toast.LENGTH_SHORT).show();

            }

        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void saveImage() {

        final String dir = Environment.getExternalStorageDirectory().toString() + "/DCIM/";
        File newdir = new File(dir);
        newdir.mkdirs();
        FileOutputStream outputStream = null;

        File imageFileName = new File(newdir, System.currentTimeMillis() + ".jpg");

        BitmapDrawable drawable = (BitmapDrawable) bird.getDrawable();
        Bitmap bitmap = drawable.getBitmap();


        try {
            outputStream =  new FileOutputStream(imageFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, outputStream);
        Toast.makeText(getApplicationContext(),"Successfuly Saved",Toast.LENGTH_SHORT).show();

        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveImage1() {

        final String dir = Environment.getExternalStorageDirectory().toString() + "/DCIM/";
        File newdir = new File(dir);
        newdir.mkdirs();
        FileOutputStream outputStream = null;

        File imageFileName = new File(newdir, System.currentTimeMillis() + ".png");

        BitmapDrawable drawable = (BitmapDrawable) img4.getDrawable();
        Bitmap bitmap = drawable.getBitmap();


        try {
            outputStream =  new FileOutputStream(imageFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100, outputStream);
        Toast.makeText(getApplicationContext(),"Successfuly Saved",Toast.LENGTH_SHORT).show();

        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}