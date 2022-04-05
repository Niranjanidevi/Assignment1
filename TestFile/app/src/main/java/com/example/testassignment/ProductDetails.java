package com.example.testassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetails extends AppCompatActivity {

    ImageView produtImg,back;
    TextView producttitleTVID,priceTVID,discount,pdescriptionTVID,stock;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        back=findViewById(R.id.back);
        produtImg=findViewById(R.id.produtImg);
        producttitleTVID=findViewById(R.id.producttitleTVID);
        priceTVID=findViewById(R.id.priceTVID);
        discount=findViewById(R.id.discount);
        pdescriptionTVID=findViewById(R.id.pdescriptionTVID);
        stock=findViewById(R.id.stock);

        producttitleTVID.setText(getIntent().getStringExtra("Product_name"));
        pdescriptionTVID.setText(getIntent().getStringExtra("description"));
        priceTVID.setText(getIntent().getStringExtra("Product_price"));
        discount.setText("Discount: "+ getIntent().getStringExtra("Discount_price")+"%");
        stock.setText("INSTOCK: "+ getIntent().getStringExtra("stock"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Glide.with(ProductDetails.this)
                .load(getIntent().getStringExtra("image"))
                .into(produtImg);





    }


}