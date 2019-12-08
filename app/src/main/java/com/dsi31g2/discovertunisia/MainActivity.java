package com.dsi31g2.discovertunisia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView imgHotel;
    ImageView imgRestau;
    ImageView imgTransport;
    ImageView imgGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgHotel = findViewById(R.id.hotel);
        imgHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityHotel.class));
            }
        });

        imgRestau = findViewById(R.id.restaurant);
        imgRestau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityRestau.class));
            }
        });

        imgTransport = findViewById(R.id.transport);
        imgTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityRestau.class));
            }
        });

        imgGuide = findViewById(R.id.guide);
        imgGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityGuide.class));
            }
        });
    }
}
