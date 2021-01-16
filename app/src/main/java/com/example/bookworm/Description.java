package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Description extends AppCompatActivity {

    TextView bookname,bookdiscription,bookprice;
    Button oder;
    String name,discrip,price;
    //testing github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Button button = (Button)findViewById(R.id.oder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(Description.this, ContactDetails.class));
            }
        });

        bookname = findViewById(R.id.bookname);
        bookdiscription = findViewById(R.id.description);
        bookprice = findViewById(R.id.price);
        oder = findViewById(R.id.oder);

        Intent intent = getIntent();
        Book_Details book = (Book_Details) intent.getSerializableExtra("selectedBook");
        name = book.getName();
        System.out.println("name is"+ name);
        bookname.setText(name);
        discrip = book.getDescription();
        bookdiscription.setText(discrip);
        price = book.getPrice();
        bookprice.setText(price);

    }
    public void oder(View view) {
    }
}