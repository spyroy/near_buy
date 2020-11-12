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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
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
                setContentView(R.layout.activity_register);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void launchLoginActivity(View view)
    {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

}