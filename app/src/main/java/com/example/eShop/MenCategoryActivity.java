package com.example.eShop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenCategoryActivity extends AppCompatActivity {

    CardView geans1,geans2,geans3,geans5,geans6,geans7,geans8,geans9,geans10,geans11,geans12,geans14,geans15,geans16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_category);

        geans1 = findViewById(R.id.geans1);
        geans2 = findViewById(R.id.geans2);
        geans3 = findViewById(R.id.geans3);
        geans5 = findViewById(R.id.geans5);
        geans6 = findViewById(R.id.geans6);
        geans7 = findViewById(R.id.geans7);
        geans8 = findViewById(R.id.geans8);
        geans9 = findViewById(R.id.geans9);
        geans10 = findViewById(R.id.geans10);
        geans11 = findViewById(R.id.geans11);
        geans12 = findViewById(R.id.geans12);
        geans14 = findViewById(R.id.geans14);
        geans15 = findViewById(R.id.geans15);
        geans16 = findViewById(R.id.geans16);

        geans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans1";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        geans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans2";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans3";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans5";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans5";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans6";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans7";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans8";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans9";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans10";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans11";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans12";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans14";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans15";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        geans16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans16";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
    }
}