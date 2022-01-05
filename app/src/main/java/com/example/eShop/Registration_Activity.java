package com.example.eShop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class Registration_Activity extends AppCompatActivity {
    EditText Reg_Name, Reg_Email, Reg_Pass;
    Button Register;
    TextView Login;
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Reg_Name = findViewById(R.id.Reg_Name);
        Reg_Email = findViewById(R.id.Reg_Email);
        Reg_Pass = findViewById(R.id.Reg_Pass);
        Register = findViewById(R.id.Register);
        Login = findViewById(R.id.Login);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });
    }

    private void registration() {
        ProgressDialog progressDialog = ProgressDialog.show(this, "Registration...","Please Wait...", true);
        String Name = Reg_Name.getText().toString();
        String Email = Reg_Email.getText().toString();
        String Password = Reg_Pass.getText().toString();

        if (TextUtils.isEmpty(Name)) {
            Toast.makeText(getApplicationContext(), "Please Enter Name..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(getApplicationContext(), "Please Enter Email..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(getApplicationContext(), "Please Enter Password..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password Must be greater than 6 digits", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User_Registration R = new User_Registration(Name, Email, Password);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(R);
                            Toast.makeText(getApplicationContext(), "Registration Complete..", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            Reg_Name.setText("");
                            Reg_Email.setText("");
                            Reg_Pass.setText("");
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }
}