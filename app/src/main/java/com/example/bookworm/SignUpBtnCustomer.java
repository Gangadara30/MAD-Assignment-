package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpBtnCustomer extends AppCompatActivity {
    private Button button,button3,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_btn_customer);

        button = (Button) findViewById(R.id.supbtn);
        button2 = (Button) findViewById(R.id.anukibtn);
        button3 = (Button) findViewById(R.id.buddibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCusReg();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailSignin();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhoneSignin();
            }
        });
    }
    public void openCusReg(){
        startActivity(new Intent(getApplicationContext(), CusReg.class));}
    public void openEmailSignin(){
        startActivity(new Intent(getApplicationContext(), CustomerLogin.class));}
    public void openPhoneSignin(){
        startActivity(new Intent(getApplicationContext(), customer_verification.class));}
}