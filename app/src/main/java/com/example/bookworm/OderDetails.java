package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OderDetails extends AppCompatActivity {

    DatabaseReference reference;
    TextView name;
    TextView price;
    MyArrayAdapter myArrayAdapter;
    Book_Details book_details;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_details);

        Intent i = getIntent();
        book_details = (Book_Details) i.getSerializableExtra("selectedBook");
        name = findViewById(R.id.itemnameod); // comment
        price = findViewById(R.id.itempriceod); // comment
        name.setText(book_details.getName() + " : "); // comment
        price.setText(book_details.getPrice()); // comment


        reference = FirebaseDatabase.getInstance().getReference().child("Book_Details"); //Change the col name
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                ArrayList<String> names = new ArrayList<>();
//                ArrayList<String> prices = new ArrayList<>();

                for (DataSnapshot ds :snapshot.getChildren())
                {
                    Book_Details booklist = new Book_Details();
                    booklist.setName(ds.child("bname").getValue().toString());
                    booklist.setPrice(ds.child("bprice").getValue().toString());
//                    names.add(booklist.getName());
//                    prices.add(booklist.getPrice());
                }

//                String[] snames = names.toArray(new String[names.size()]);
//                String[] sprices = prices.toArray(new String[prices.size()]);
//
//                myArrayAdapter = new MyArrayAdapter(getApplicationContext(),snames,sprices);
//                listView.setAdapter(myArrayAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}