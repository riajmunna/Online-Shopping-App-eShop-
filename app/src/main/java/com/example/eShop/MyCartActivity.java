package com.example.eShop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MyCartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MyCartModel> myCartModels;
    MyCartAdapter myCartAdapter;
    FirebaseAuth auth;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        recyclerView = findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        myCartModels = new ArrayList<MyCartModel>();
        myCartAdapter = new MyCartAdapter(MyCartActivity.this,myCartModels);

        String userID = auth.getCurrentUser().getUid();

        db.collection("addtocart").document(userID).collection("user")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        MyCartModel myCartModel = documentSnapshot.toObject(MyCartModel.class);
                        myCartModels.add(myCartModel);
                        myCartAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}