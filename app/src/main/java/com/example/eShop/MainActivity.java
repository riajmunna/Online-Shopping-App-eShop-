package com.example.eShop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    ImageView geans11,ladies2,geans16,geans9,kids7,geans3,geans10,
            geans12,ladies3,kids1,geans7,kids4,menu;
    TextView Rec_All,Pop_All;

    SliderView sliderView;
    // image resources of slider
    int[] images = {R.drawable.onboardscreen1,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3,
            R.drawable.onboardscreen5,
            R.drawable.onboardscreen6,
            R.drawable.onboardscreen7,
            R.drawable.onboardscreen9,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geans3 = findViewById(R.id.geans3);
        geans7 = findViewById(R.id.geans7);
        geans9 = findViewById(R.id.geans9);
        geans10 = findViewById(R.id.geans10);
        geans11 = findViewById(R.id.geans11);
        geans12 = findViewById(R.id.geans12);
        geans16 = findViewById(R.id.geans16);
        ladies2 = findViewById(R.id.ladies2);
        ladies3 = findViewById(R.id.ladies3);
        kids1 = findViewById(R.id.kids1);
        kids4 = findViewById(R.id.kids4);
        kids7 = findViewById(R.id.kids7);
        menu = findViewById(R.id.menu);
        Rec_All = findViewById(R.id.Rec_All);
        Pop_All = findViewById(R.id.Pop_All);

        sliderView = findViewById(R.id.image_slider);

        // setting slider adapter
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();


        geans11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans11";
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
        geans16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans16";
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
        kids7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids7";
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
        geans10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "geans10";
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
        ladies3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "ladies3";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });
        kids1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids1";
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
        kids4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "kids4";
                Intent intent = new Intent(getApplicationContext(),ShowProduct.class);
                intent.putExtra("keyId", id);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

        Rec_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Feature will added soon..", Toast.LENGTH_SHORT).show();
            }
        });

        Pop_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Feature will added soon..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}