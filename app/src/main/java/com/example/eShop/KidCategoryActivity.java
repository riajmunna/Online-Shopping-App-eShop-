package com.example.eShop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KidCategoryActivity extends AppCompatActivity {

    CardView kids1,kids2,kids4,kids5,kids6,kids7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_category);

        kids1 = findViewById(R.id.kids1);
        kids2 = findViewById(R.id.kids2);
        kids4 = findViewById(R.id.kids4);
        kids5 = findViewById(R.id.kids5);
        kids6 = findViewById(R.id.kids6);
        kids7 = findViewById(R.id.kids7);

        kids1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids1";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kid2";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids4";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids5";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kid6";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids7";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
    }
}