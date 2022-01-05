package com.example.eShop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Authentication;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ShowProduct extends AppCompatActivity {
    String id;
    FirebaseFirestore firebaseFirestore;
    ImageView show_img;
    FirebaseAuth auth;
    Button add_to_cart;
    TextView show_des, show_price, show_code, show_color, show_rating, show_size;
    String get_des, get_code, get_price, link;
    //ActivityReadDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Receive product id from previous intent
        id = getIntent().getStringExtra("keyId");


        auth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_show_product);
        show_img = findViewById(R.id.show_img);
        show_des = (TextView) findViewById(R.id.show_des);
        show_price = findViewById(R.id.show_price);
        show_code = findViewById(R.id.show_code);
        show_color = findViewById(R.id.show_color);
        add_to_cart = findViewById(R.id.add_to_cart);
        show_size = findViewById(R.id.show_size);
        show_rating = findViewById(R.id.show_rating);

        //fetch the from database
        DocumentReference reference = firebaseFirestore.getInstance().collection("products").document(id);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    get_des = documentSnapshot.getString("description");
                    //show_des.setText(documentSnapshot.getString("description"));
                    show_des.setText(get_des);
                    link = documentSnapshot.getString(String.valueOf("img"));
                    Picasso.get().load(link).into(show_img);
                    //show_code.setText("Product Code: " + documentSnapshot.getString("id"));
                    get_code = documentSnapshot.getString("id");
                    show_code.setText("Product Code: " + get_code);
                    show_color.setText("Color: " + documentSnapshot.getString("color"));
                    show_size.setText("Available Sizes: " + documentSnapshot.getString("size"));
                    show_rating.setText("Ratings: " + documentSnapshot.getString("rating"));
                    get_price = documentSnapshot.getString("price");
                    show_price.setText("Price: " + get_price);
                    //show_price.setText("Price: " + documentSnapshot.getString("price"));
                } else {
                    Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        })
                //If data not found then it will work
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_cart();
            }
        });
    }

    private void add_cart() {
        ProgressDialog progressDialog = ProgressDialog.show(this, "Add to Cart..", "Please Wait...", true);
        firebaseFirestore = FirebaseFirestore.getInstance();
        String savecurrentDate;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM,dd,yyyy");
        savecurrentDate = simpleDateFormat.format(calendar.getTime());

        Map<String, Object> cartMap = new HashMap<>();

        cartMap.put("code", get_code);
        cartMap.put("description", get_des);
        cartMap.put("price", get_price);
        cartMap.put("image", link);
        cartMap.put("date", savecurrentDate);
        String userId = auth.getCurrentUser().getUid();

        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();

        if (userId.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Login..", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        } else {
            firebaseFirestore.collection("addtocart").document("Users").
                    collection(email).add(cartMap)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}