package com.example.vendorlyuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Navigation extends AppCompatActivity {
Button NbtnLogin,NbtnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        getSupportActionBar().hide();
        NbtnLogin = findViewById(R.id.btnLogN);
        NbtnRegister = findViewById(R.id.btnRegN);

        NbtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Navigation.this,Register.class);
                startActivity(i);
            }
        });

        NbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navigation.this,Login.class);
                startActivity(intent);
            }
        });
    }


}