package com.example.near_buy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.HolderProducts>{
    private Context context;
    public ArrayList<Manager> productList;

    public ProductsAdapter (Context context, ArrayList<Manager> productList){
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public HolderProducts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_products, parent, false);
        return new HolderProducts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProducts holder, int position) {
        Manager products = productList.get(position);
        List<ContactsContract.CommonDataKinds.Relation> prods = products.getProducts();
        //String price = products;
//        String shopName = shop.getStore();
//        String phone = String.valueOf(shop.getPhone());
//        String open = shop.getIsOpen();
//        String name = shop.getName();
//
//        holder.name.setText("seller name: " + name);
//        holder.address.setText("Address: " + Address);
//        holder.shop_name.setText("shop name: " + shopName);
//        holder.shop_phone.setText("shop phone: " + phone);
//
//        if(open.equals("true")){
//            holder.isOpen.setText("shop is open");
//            holder.isOpen.setBackgroundColor(Color.GREEN);
//        }
//        else {
//            holder.isOpen.setText("shop is closed");
//            holder.isOpen.setBackgroundColor(Color.RED);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, shopDetailsActivity.class);
                intent.putExtra("shopName", "productName");
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class HolderProducts extends RecyclerView.ViewHolder{
        private ImageView addToCart;
        private TextView product_name;
        private TextView price;
        private TextView description;
        private TextView onStock;
        private TextView discount;

        public HolderProducts(@NonNull View itemView) {
            super(itemView);
            addToCart = itemView.findViewById(R.id.shop_im);
            product_name = (TextView)itemView.findViewById(R.id.productName);
            price = (TextView)itemView.findViewById(R.id.productPrice);
            description = (TextView)itemView.findViewById(R.id.productDescription);
            onStock = (TextView)itemView.findViewById(R.id.stock);
            discount = (TextView)itemView.findViewById(R.id.Discount);
        }
    }
}
