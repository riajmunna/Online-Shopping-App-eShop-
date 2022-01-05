package com.example.eShop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WomenCategoryActivity extends AppCompatActivity {

    CardView ladies1,ladies2,ladies3,ladies4,ladies5,ladies6,ladies8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_category);

        ladies1 = findViewById(R.id.ladies1);
        ladies2 = findViewById(R.id.ladies2);
        ladies3 = findViewById(R.id.ladies3);
        ladies4 = findViewById(R.id.ladies4);
        ladies5 = findViewById(R.id.ladies5);
        ladies6 = findViewById(R.id.ladies6);
        ladies8 = findViewById(R.id.ladies8);

        ladies1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies1";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies2";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies3";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies4";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies5";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies6";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        ladies8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies8";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
    }
}