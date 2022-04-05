package com.example.testassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView productsRVID;
    ProductAdapter productAdapter;
    GridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsRVID=findViewById(R.id.productsRVID);

        layoutManager=new GridLayoutManager(this,2);
        productsRVID.setLayoutManager(layoutManager);

        callproductItems();

    }

    private void callproductItems() {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ProductModel> productModelCall=apiInterface.products();
        Log.e("productApi",productModelCall.request().toString());
        productModelCall.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                progressDialog.dismiss();
                if(response.body()!=null && response.code()==200){
                    ProductModel productModel=response.body();

                    productAdapter=new ProductAdapter(productModel,MainActivity.this);
                    productsRVID.setAdapter(productAdapter);

                }

            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}