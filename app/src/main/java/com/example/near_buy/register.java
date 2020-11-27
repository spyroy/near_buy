package com.example.near_buy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import java.util.concurrent.TimeUnit;


public class register extends AppCompatActivity {
    EditText mFullname,mEmail,mPassword,mConfirm;
    Button mRegisterbtn,button2;
    CheckBox Cbox;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    static final String USER = "user";

//    private static final String LOG_TAG =
//            register.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullname = findViewById(R.id.full_name);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.pass);
        mConfirm = findViewById(R.id.Confirm_pass);
        mRegisterbtn = findViewById(R.id.Register_button);
        mLoginBtn = findViewById(R.id.Login_button);
        button2 = findViewById(R.id.already_have_account);
        Cbox = findViewById(R.id.business_checkbox);

        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        progressBar = findViewById(R.id.progressBar);

        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String confirm = mConfirm.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }

                if(!confirm.equals(password)){
                    mConfirm.setError("incorrect password.");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("password must be at least 6 characters.");
                }

                progressBar.setVisibility(View.VISIBLE);

                //connect to firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this,"User created",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = fAuth.getCurrentUser();
                            if(Cbox.isClickable()){
                                //start manager register activity
                            }
                            user u = new user(mFullname.getText().toString().trim(),email);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(register.this, "user saved!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(register.this," ERROR!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            try {
                                TimeUnit.SECONDS.sleep(4);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressBar.setVisibility(View.INVISIBLE);
                            //startActivity(new Intent(getApplicationContext(),register.class));
                        }
                    }
                });
            }
        });



    }
    public void launchLoginActivity(View view)
    {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }


}

