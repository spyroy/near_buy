package com.example.near_buy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Document;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class register extends AppCompatActivity implements LocationListener {
    EditText mFullname, mEmail, mPassword, mConfirm, mphone, maddress, mcity;
    Button mRegisterbtn, button2,button3;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    private ImageButton gpsBtn;
    static final String USER = "user";

    private static final int LOCATION_REQUEST_CODE = 100;

    //    private static final String LOG_TAG =
//            register.class.getSimpleName();
    private String[] locationPermissoin;

    private LocationManager locationManager;

    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mFullname = findViewById(R.id.full_name);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.pass);
        mConfirm = findViewById(R.id.Confirm_pass);
        maddress = findViewById(R.id.addressCo);
        mphone = findViewById(R.id.phone);
        mRegisterbtn = findViewById(R.id.Register_button);
        mLoginBtn = findViewById(R.id.Login_button);
        button2 = findViewById(R.id.already_have_account);
        button3 = findViewById(R.id.register_seller);
        gpsBtn = findViewById(R.id.gpsBt);
        mcity = findViewById(R.id.cityCo);

        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        progressBar = findViewById(R.id.progressBar);

        gpsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // detect current location
                if (checklocationPerission()) {
                    //already allowed
                    detectLocation();
                } else {
                    // not allowed , request
                    requestlocationPrmission();
                }
            }
        });
        //init permissoin arry
        locationPermissoin = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};

        //Cbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        // @Override
        // public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //  if(isChecked) {
        //   AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
        // builder.setCancelable(true);
        //builder.setTitle("Are you sure you have a business?");
        //builder.setMessage("Marking this will take you to seller menu");
        // builder.setPositiveButton("Confirm",
        // new DialogInterface.OnClickListener() {
        // @Override
        // public void onClick(DialogInterface dialog, int id) {
        // Cbox.setChecked(true);
        //}
        //});
        //builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
        // @Override
        // public void onClick(DialogInterface dialog, int id) {
        //  Cbox.setChecked(false);
        //}
        // });

        //  AlertDialog dialog = builder.create();
        // dialog.show();
        // }
        //}
        // });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,RegisterSellerActivity.class));
            }
        });
        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String confirm = mConfirm.getText().toString().trim();
                String address = maddress.getText().toString().trim();
                int phone = 0;
                String mmm = mphone.getText().toString();

                if(mphone.getText().toString() != null && mphone.getText().toString().length() > 0){
                    try {
                        phone = Integer.parseInt(mphone.getText().toString());
                    } catch(Exception e) {
                        phone =  -1;   // or some value to mark this field is wrong. or make a function validates field first ...
                    }
                }


                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required.");
                    return;
                }

                if (!confirm.equals(password)) {
                    mConfirm.setError("incorrect password.");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("password must be at least 6 characters.");
                }

                progressBar.setVisibility(View.VISIBLE);

                //connect to firebase
                int finalPhone = phone;
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Toast.makeText(register.this, "User created", Toast.LENGTH_SHORT).show();
                            // FirebaseUser user = fAuth.getCurrentUser();
                            //if (Cbox.isChecked()) {
                            //start manager register activity
                            //Manager m = new Manager(mFullname.getText().toString().trim(), email, address, finalPhone, 1);
                            //FirebaseDatabase.getInstance().getReference("users")
                            //.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            // .setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
                            //@Override
                            //public void onComplete(@NonNull Task<Void> task) {
                            //if (task.isSuccessful()) {
                            // Toast.makeText(register.this, "seller saved!", Toast.LENGTH_SHORT).show();
                            // }
                            //}
                            // });
                            //startActivity(new Intent(getApplicationContext(), Seller_main_activity.class));
                            //return;
                            // }
                            user u = new user(mFullname.getText().toString().trim(), email, address, finalPhone, mcity.getText().toString().trim(), fAuth.getUid());
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(register.this, "user saved!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainUserActivity.class));
                            finish();
                        } else {
                            Toast.makeText(register.this, " ERROR!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            //startActivity(new Intent(getApplicationContext(),register.class));
                        }
                    }
                });
            }
        });


    }

    public void launchLoginActivity(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }


    private void detectLocation() {
        Toast.makeText(this, "Please wait :) ", Toast.LENGTH_SHORT).show();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    private boolean checklocationPerission(){
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) ==
                (PackageManager.PERMISSION_GRANTED);
        return  result;
    }
    private void requestlocationPrmission(){
        ActivityCompat.requestPermissions(this,locationPermissoin,LOCATION_REQUEST_CODE);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        findAddress();
        return;
    }

    private void findAddress() {
        Geocoder geocoder;
        List<Address>addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        try{
            addresses = geocoder.getFromLocation(latitude,longitude,1);
            String addres = addresses.get(0).getAddressLine(0);// complet address
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            maddress.setText(addres);
            return;

        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){

    }


    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(this, "Please turn on GPS location", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST_CODE:
                if(grantResults.length>0){
                    boolean locationaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(locationaccepted)
                    {
                        // permission allowed
                        detectLocation();
                    }
                    else{
                        // permission denied
                        Toast.makeText(this, "Location permission is necessary", Toast.LENGTH_SHORT).show();
                    }
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



}