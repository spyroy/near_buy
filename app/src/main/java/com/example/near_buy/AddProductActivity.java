package com.example.near_buy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddProductActivity extends AppCompatActivity {

    private ImageView imageProduct;
    private EditText proName,proPrice;
    private Button AddPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        imageProduct = findViewById(R.id.imageView3);
        proName = findViewById(R.id.titleEt);
        proPrice = findViewById(R.id.priceEt);
        AddPro = findViewById(R.id.addProductBtn);


        imageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AddPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}