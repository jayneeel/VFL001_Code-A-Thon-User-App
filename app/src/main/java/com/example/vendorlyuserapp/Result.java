package com.example.vendorlyuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {
    RecyclerView recyclerView;
    myAdapter adapter;
//    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter
        adapter = new myAdapter();
        recyclerView.setAdapter(adapter);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("VendorsTemp");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot datas: dataSnapshot.getChildren()){
//                    DataSnapshot ds=datas.child("Products").child("Apple");
//                    String name=datas.child("Products").child("Apple").toString();
//
//                    if (!ds.getValue().equals(null))
//                    {
//                        System.out.println("*********"+ds.getValue().toString());
//                    }
//                }
                List<DataSnapshot> dataSnapshots = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    dataSnapshots.add(snapshot);
                    Product product = snapshot.getValue(Product.class);
                    Details details = snapshot.getValue(Details.class);
//                    System.out.println("**********\n"+snapshot.getValue().getClass().toString()+"\n************");
                }
                adapter.setDataSnapshots(dataSnapshots);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
//        recyclerView = findViewById(R.id.recycle);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        FirebaseRecyclerOptions<model> options =
//                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("VendorsTemp").child("Products"), model.class)
//                        .build();
//
//        adapter=new myAdapter(options);
//        recyclerView.setAdapter(adapter);

    }
}