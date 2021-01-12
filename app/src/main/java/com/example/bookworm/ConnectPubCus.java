package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectPubCus extends AppCompatActivity {
    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_pub_cus);

        button = (Button) findViewById(R.id.btn1);
        button1 = (Button) findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPublisher();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomer();
            }
        });







    }

    public void openPublisher(){
        Intent intent1 = new Intent(this,PubReg.class);
        startActivity(intent1);

    }
    public void openCustomer(){
        Intent intent2 = new Intent(this,CusReg.class);
        startActivity(intent2);

    }

}

