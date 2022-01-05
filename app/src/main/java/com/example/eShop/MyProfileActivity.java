package com.example.eShop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class MyProfileActivity extends AppCompatActivity {


    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;
    TextView MyEmail, MyName, MyPassword;
    Button button_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        MyEmail = findViewById(R.id.MyEmail);
        MyName = findViewById(R.id.MyName);
        MyPassword = findViewById(R.id.MyPassword);
        button_logout = findViewById(R.id.button_logout);



        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String myname = dataSnapshot.child("name").getValue(String.class);
                String myemail = dataSnapshot.child("email").getValue(String.class);
                String mypassword = dataSnapshot.child("password").getValue(String.class);
                MyName.setText("Name: "+myname);
                MyEmail.setText("Email: "+myemail);
                MyPassword.setText("Password: "+mypassword);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                MyName.setText("Name: " + "You aren't Logged In");
                MyEmail.setText("Email: " + "You aren't Logged In");
                MyPassword.setText("Password: " + "You aren't Logged In");
            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();

            }
        });

    }

    private void logout() {
        ProgressDialog progressDialog = ProgressDialog.show(this, "Logout", "Please Wait...", true);
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        startActivity(new Intent(getApplicationContext(), Login_Activity.class));
        finish();
    }
}