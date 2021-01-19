 package com.example.bookworm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    DatabaseReference reference;
    ArrayList<Book_Details>bookArray=new ArrayList<>();

    ArrayAdapter<String>adapter;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        listView=findViewById(R.id.booklist);

        reference = FirebaseDatabase.getInstance().getReference().child("Book_Details");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            ArrayList<String>bnames = new ArrayList<>();

            for (DataSnapshot ds :snapshot.getChildren())
            {
                String name = ds.child("bname").getValue().toString();
                bnames.add(name);
                String decription = ds.child("bdiscrip").getValue().toString();
                String price = ds.child("bprice").getValue().toString();


                Book_Details booklist = new Book_Details(name,decription,price);
                System.out.println("bookname is"+booklist.getName());
                bookArray.add(booklist);
            }
                adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,bnames);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = (String) parent.getItemAtPosition(position);
                        Intent nextIntent = new Intent(MainActivity.this,Description.class);
                        for (Book_Details bookDetails : bookArray){
                            System.out.println("lenght of bookArray"+bookArray.size());
                            Log.d("X",bookDetails.getName());

                            if (bookDetails.getName().equals(selectedItem))
                            {
                                nextIntent.putExtra("selectedBook",bookDetails);
                                break;
                            }
                        }
                        startActivity(nextIntent);
                        System.out.println(selectedItem);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
}





































