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

public class Login extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    Button btnLog;
    TextInputLayout email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        btnLog = findViewById(R.id.LbtnLogin);
        email = findViewById(R.id.Lemail);
        pass = findViewById(R.id.Lpass);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail=email.getEditText().getText().toString();
                String pwd=pass.getEditText().getText().toString();
                firebaseAuth.signInWithEmailAndPassword(getEmail,pwd)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                Intent it = new Intent(Login.this, Homepage.class);
                                it.putExtra("itemDetails","");
                                startActivity(it);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Incorrect credentials"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}