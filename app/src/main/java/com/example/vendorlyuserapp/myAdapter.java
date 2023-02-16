package com.example.vendorlyuserapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.List;

//public class myAdapter extends FirebaseRecyclerAdapter<model,myAdapter.myViewHolder> {
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    private List<DataSnapshot> dataSnapshots;

//    /**
//     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
//     * {@link FirebaseRecyclerOptions} for configuration options.
//     *
//     * @param options
//     */
////    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
////        super(options);
////    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        DataSnapshot snapshot = dataSnapshots.get(position);

        Details details=snapshot.child("Details").getValue(Details.class);
        Product product = snapshot.child("Products").child("Potato").getValue(Product.class);
        holder.shopTxt.setText(details.getShopname());
        holder.priceTxt.setText("Rs. "+product.getPrice());
        holder.prodTxt.setText(product.getName());
        Glide.with(holder.imageView.getContext()).load(product.getImgurl()).into(holder.imageView);

        holder.interestedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String imgurl = product.getImgurl();
                String shopname = details.getShopname();
                String address = details.getAddress();
                String phone = details.getPhone();
                Intent intent = new Intent(view.getContext(),ShopProfile.class);
                intent.putExtra("imgurl",imgurl);
                intent.putExtra("shopname",shopname);
                intent.putExtra("address",address);
                intent.putExtra("phone",phone);
                view.getContext().startActivity(intent);


            }
        });


    }

    public void setDataSnapshots(List<DataSnapshot> dataSnapshots) {
        this.dataSnapshots = dataSnapshots;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSnapshots == null ? 0 : dataSnapshots.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView priceTxt,prodTxt,shopTxt;
        Button interestedBtn;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1);
            shopTxt = itemView.findViewById(R.id.shop_nameTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            prodTxt = itemView.findViewById(R.id.prod_nameTxt);
            interestedBtn = itemView.findViewById(R.id.interestedBtn);

        }
    }
}
