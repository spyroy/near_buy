package com.example.near_buy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(){
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        if(fAuth.getCurrentUser() == null){
            Toast.makeText(MainActivity.this,"you are not logged in",Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), register.class));
        Toast.makeText(MainActivity.this,"logged out",Toast.LENGTH_SHORT).show();
        finish();
    }

    public void launchStoresActivity(View view) {
        Intent intent = new Intent(this, stores.class);
        startActivity(intent);

    }
    public void launchItemsActivity(View view) {
        Intent intent = new Intent(this, items.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //HANDLING ITEM SELECTIONS
        switch(item.getItemId()){

            case R.id.menu_search:
                Toast.makeText(this, "SOON TO BE IMPLEMENTED", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_user:
                Intent intent = new Intent(this, register.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                logout();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }



    }


}