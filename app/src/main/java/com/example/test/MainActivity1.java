package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.annotation.NonNull;
import android.view.View;
import android.text.TextUtils;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity1 extends AppCompatActivity {

    private Button publisher,customer;@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        publisher = (Button) findViewById(R.id.publisher);
        customer = (Button) findViewById(R.id.customer);


        publisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPublishLogin();
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCustomerLogin();
            }
        });
    }
    public void openPublishLogin() {
        Intent intent = new Intent(this, PublishLogin.class);
        startActivity(intent);
    }

    public void openCustomerLogin() {
        Intent intent = new Intent(this, CustomerLogin.class);
        startActivity(intent);
    }

    private class PublishLogin {
    }
}