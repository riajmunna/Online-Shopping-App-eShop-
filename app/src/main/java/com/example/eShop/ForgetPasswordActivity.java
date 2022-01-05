package com.example.eShop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText forget_password_email;
    Button forget_password_submit;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget_password_email = findViewById(R.id.forget_password_email);
        forget_password_submit = findViewById(R.id.forget_password_submit);
        auth = FirebaseAuth.getInstance();
        forget_password_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 forgot();
            }
        });
    }

    private void forgot() {
        ProgressDialog progressDialog = ProgressDialog.show(this, "Forgot Password", "Please Wait...", true);
        String forgot_email = forget_password_email.getText().toString().trim();
        if (forgot_email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter Your Email..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(forgot_email).matches()) {
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email..", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.sendPasswordResetEmail(forgot_email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Check Your Email to Reset Password.", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "This Email Not Registered Yet!!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
}