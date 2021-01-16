package com.example.bookworm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class customer_verification extends AppCompatActivity {

    Button btn ;
    Button otpbtn,emailBtn;
    EditText edt;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        edt =(EditText) findViewById(R.id.editTextPhone);
        btn=(Button) findViewById(R.id.email);
        otpbtn=(Button) findViewById(R.id.sendotp);
        emailBtn=(Button)findViewById(R.id.email);

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
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2(){
        Intent intent= new Intent(this,CustomerLogin.class);
        startActivity(intent);
    }
}

