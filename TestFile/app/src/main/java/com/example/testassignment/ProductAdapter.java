package com.example.testassignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ProductModel productModel;
    //ArrayList<ProductModel.Product> productModels=new ArrayList<>();
    Context context;

    public ProductAdapter(ProductModel productModel, Context context) {
        this.productModel = productModel;
        this.context = context;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.productprice.setText("\u20A8 "+String.valueOf(productModel.getProducts().get(position).getPrice()));
        holder.productName.setText(productModel.getProducts().get(position).getTitle());
        Glide.with(context)
                .load(productModel.getProducts().get(position).getThumbnail())
                .into(holder.productImgID);

        holder.productllID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ProductDetails.class);
                intent.putExtra("Product_name",productModel.getProducts().get(position).getTitle());
                intent.putExtra("Product_price",String.valueOf(productModel.getProducts().get(position).getPrice()));
                intent.putExtra("Discount_price",String.valueOf(productModel.getProducts().get(position).getDiscountPercentage()));
                intent.putExtra("description",productModel.getProducts().get(position).getDescription());
                intent.putExtra("rating_bar",Float.valueOf(productModel.getProducts().get(position).getRating()));
                intent.putExtra("image",productModel.getProducts().get(position).getThumbnail());
                intent.putExtra("stock",String.valueOf(productModel.getProducts().get(position).getStock()));

                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return productModel.getProducts().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName,productprice;
        LinearLayout productllID;
        ImageView productImgID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName=itemView.findViewById(R.id.productNameTVID);
            productprice=itemView.findViewById(R.id.productpriceTVID);
            productImgID=itemView.findViewById(R.id.productImgID);
            productllID=itemView.findViewById(R.id.productllID);
        }
    }
}
