package com.example.vendorlyuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {
AutoCompleteTextView autoCompleteTextView;
Button searchBtn;
TextInputEditText itemQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();
        autoCompleteTextView = findViewById(R.id.area_spinner);
        itemQuery = findViewById(R.id.itemQuery);
        searchBtn = findViewById(R.id.serachBtn);
        String[] areas = new String[]{"Sector 1","Sector 2","Sector 3","Sector 4","Sector 5","Sector 6","Sector 7","Sector 8","Sector 9"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, areas);
        autoCompleteTextView.setAdapter(adapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homepage.this,Result.class);
                i.putExtra("product",itemQuery.getText());
                startActivity(i);

            }
        });

    }

}