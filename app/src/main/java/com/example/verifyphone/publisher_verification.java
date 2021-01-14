package com.example.verifyphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class publisher_verification extends AppCompatActivity {
    Button btn ;
    Button otpbtn ;
    EditText edt;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt =(EditText) findViewById(R.id.editTextPhone);
        btn=(Button) findViewById(R.id.email);
        otpbtn=(Button) findViewById(R.id.sendotp);
        findViewById(R.id.sendotp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = edt.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    edt.setError("Enter a valid mobile");
                    edt.requestFocus();
                    return;
                }

                Intent intent = new Intent(publisher_verification.this, customer_verifyOTP.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });





    }
}
// buddhini