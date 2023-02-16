package com.example.vendorlyuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopProfile extends AppCompatActivity {
TextView shopTxt,addrTxt,phoneTxt;
ImageView imageView;
Button mapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_profile);
        imageView = findViewById(R.id.imageView1);
        shopTxt = findViewById(R.id.header);
        addrTxt = findViewById(R.id.address);
        phoneTxt = findViewById(R.id.phonenumber);
        mapBtn = findViewById(R.id.mapBtn);
        shopTxt.setText(getIntent().getStringExtra("shopname"));
        addrTxt.setText(getIntent().getStringExtra("address"));
        phoneTxt.setText(getIntent().getStringExtra("phone"));

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(addrTxt.getText().toString()));
//                Intent chooser = Intent.createChooser(intent, "Launch Map");
//                startActivity(chooser);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("google.navigation:q="+addrTxt.getText()));
                startActivity(intent);
            }
        });
    }
}