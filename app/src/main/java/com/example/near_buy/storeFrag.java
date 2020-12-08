package com.example.near_buy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link storeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class storeFrag extends Fragment {
    private RecyclerView recycle;
    ArrayList<Manager> shopsList;
    private ShopAdapter shopAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public storeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment storeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static storeFrag newInstance(String param1, String param2) {
        storeFrag fragment = new storeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container == null) {
            return null;
        }
        View RootView = inflater.inflate(R.layout.fragment_store, container, false);
        loadShops();
        recycle = (RecyclerView)RootView.findViewById(R.id.recycle);
//        if(recycle == null){
//            shopsList = new ArrayList<>();
//            shop shop = new shop("a@gmail.com", "a", "dummy", 0, 0, "a", "a" , "true");
//            shopsList.add(shop);
//            shopAdapter = new ShopAdapter(getContext(),shopsList);
//            recycle.setAdapter(shopAdapter);
//        }
        return RootView;
    }

    public void loadShops(){
        shopsList = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        ref.orderByChild("type").equalTo("seller").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shopsList.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    Manager shop = ds.getValue(Manager.class);
                    shopsList.add(shop);
                }
                shopAdapter = new ShopAdapter(getContext(),shopsList);
                recycle.setAdapter(shopAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void loadShops(String city){
        shopsList = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        ref.orderByChild("type").equalTo("seller").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shopsList.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    shop shop = ds.getValue(shop.class);
                    String shopCity = "" + ds.child("city").getValue();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}