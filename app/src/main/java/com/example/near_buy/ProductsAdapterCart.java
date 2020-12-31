package com.example.near_buy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapterCart extends RecyclerView.Adapter<ProductsAdapterCart.HolderProductsCart>  {
    private Context context;
    public ArrayList<ModelProduct> productList, filterList;
    private ProductsFilterOnShops filter;

    public ProductsAdapterCart (Context context, ArrayList<ModelProduct> productList){
        this.context = context;
        this.productList = productList;
        this.filterList = productList;
    }

    @NonNull
    @Override
    public HolderProductsCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_products_for_cart, parent, false);
        return new HolderProductsCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProductsCart holder, int position) {
        ModelProduct products = productList.get(position);
        List<ContactsContract.CommonDataKinds.Relation> prods;
        String ProductId = products.getProductId();
        String ProductName = products.getProductName();
        String ProductPrice = products.getProductPrice();
        String ProductQuantity = products.getProductQuantity();
        String TimeStamp = products.getTimestamp();
        String uid = products.getUid();
        //description TODO

        holder.product_name.setText("Product Name: " + ProductName);
        holder.price.setText("Price: " + ProductPrice);
        holder.onStock.setText("On my Stock: " + ProductQuantity);

        if(Integer.parseInt(ProductQuantity) > 0){
            holder.onStock.setBackgroundColor(Color.GREEN);
        }
        else{
            holder.onStock.setBackgroundColor(Color.RED);
        }

        //TODO
        //add product to cart

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class HolderProductsCart extends RecyclerView.ViewHolder{
        private ImageView addToCart;
        private TextView product_name;
        private TextView price;
        private TextView description;
        private TextView onStock;
        private TextView discount;

        public HolderProductsCart(@NonNull View itemView) {
            super(itemView);
            product_name = (TextView)itemView.findViewById(R.id.productName);
            price = (TextView)itemView.findViewById(R.id.productPrice);
            description = (TextView)itemView.findViewById(R.id.productDescription);
            onStock = (TextView)itemView.findViewById(R.id.stock);
            discount = (TextView)itemView.findViewById(R.id.Discount);
        }
    }
}
