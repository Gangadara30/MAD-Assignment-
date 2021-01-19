package com.example.bookworm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.jar.Attributes;

public class Description extends AppCompatActivity {

    TextView bookname,bookdiscription,bookprice;
    Button oder;
    String name,discrip,price;
    //testing github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        Book_Details book = (Book_Details) intent.getSerializableExtra("selectedBook");

        Button button = (Button)findViewById(R.id.oder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),ContactDetails.class);
                i.putExtra("selectedBook",book);
                startActivity(i);
            }
        });

        bookname = findViewById(R.id.bookname);
        bookdiscription = findViewById(R.id.description);
        bookprice = findViewById(R.id.price);
        oder = findViewById(R.id.oder);

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