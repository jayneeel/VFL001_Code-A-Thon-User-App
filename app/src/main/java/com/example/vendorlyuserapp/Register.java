package com.example.vendorlyuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    TextInputLayout fname,lname,email,pass,phno,cpass;
    Button btnSignup;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        cpass = findViewById(R.id.cpass);
        phno = findViewById(R.id.phno);
        btnSignup = findViewById(R.id.btnRegR);
        firebaseAuth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getFname = fname.getEditText().getText().toString();
                String getLname = lname.getEditText().getText().toString();
                String getPhno = phno.getEditText().getText().toString();
                String getEmail = email.getEditText().getText().toString();
                String getPass = pass.getEditText().getText().toString();

                Map<String,Object> map = new HashMap<>();
                map.put("first_name",getFname);
                map.put("last_name",getLname);
                map.put("phone",getPhno);
                map.put("email",getEmail);
                FirebaseDatabase.getInstance().getReference().child("Users").push().setValue(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
                                            }
                                        });



                firebaseAuth.createUserWithEmailAndPassword(getEmail, getPass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
//                                Toast.makeText(Register.this, "User Account Created", Toast.LENGTH_SHORT).show();
                                Intent it = new Intent(Register.this, Login.class);
                                startActivity(it);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}