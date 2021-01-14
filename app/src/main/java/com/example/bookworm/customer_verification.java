package com.example.bookworm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class customer_verification extends AppCompatActivity {

    Button btn ;
    Button otpbtn ;
    Button anuki,narmada;
    EditText edt;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edt =(EditText) findViewById(R.id.editTextPhone);
        btn=(Button) findViewById(R.id.email);
        otpbtn=(Button) findViewById(R.id.sendotp);

        anuki=(Button)findViewById(R.id.button2);
        narmada=(Button)findViewById(R.id.button3);

        findViewById(R.id.sendotp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = edt.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    edt.setError("Enter a valid mobile");
                    edt.requestFocus();
                    return;
                }

                Intent intent = new Intent(customer_verification.this, customer_verifyOTP.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });
        anuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        narmada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });



    }
    public void openActivity1(){
        Intent intent= new Intent(this,CustomerLogin.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

