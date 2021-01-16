package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpBtn extends AppCompatActivity {
    private Button button,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_btn);

        button = (Button) findViewById(R.id.supbtn);
        button2 = (Button) findViewById(R.id.anukibtn);
        button3 = (Button) findViewById(R.id.buddibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPubReg();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPubRegEmail();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPubRegPhone();
            }
        });

    }
    public void openPubReg(){
        startActivity(new Intent(getApplicationContext(), PubReg.class));
    }
    public void openPubRegEmail(){
        startActivity(new Intent(getApplicationContext(), PublishLogin.class));
    }
    public void openPubRegPhone(){
        startActivity(new Intent(getApplicationContext(), publisher_verification.class));
    }
}