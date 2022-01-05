package com.example.eShop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    EditText subject, message;
    Button submit_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        submit_email = findViewById(R.id.submit_email);

        submit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] TO = {
                        "riajmunna3399@gmail.com"
                };
                String sub = subject.getText().toString();
                String mess = message.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, mess);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });
    }
}