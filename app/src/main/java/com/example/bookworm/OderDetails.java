package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OderDetails extends AppCompatActivity {

    DatabaseReference reference;
    ListView listView;
    ArrayList<Book_Details>bookArray=new ArrayList<>();
    ArrayAdapter<String>adapter;
    ArrayAdapter<String>subadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_details);
        listView = findViewById(R.id.booklist);
        reference = FirebaseDatabase.getInstance().getReference().child("Book_Details");
        Intent intent = getIntent();
        Contact_Details confirmedOrder = (Contact_Details) intent.getSerializableExtra("ConfirmedOrder");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> bnames = new ArrayList<>();
                ArrayList<String>price = new ArrayList<>();
                for (DataSnapshot ds :snapshot.getChildren())
                {
                    String name = ds.child("bname").getValue().toString();
                    bnames.add(name);
                    String bookprice = ds.child("bprice").getValue().toString();
                    price.add(bookprice);


                    Book_Details booklist = ds.getValue(Book_Details.class);
                    bookArray.add(booklist);
                }
                adapter=new ArrayAdapter<String>(OderDetails.this, android.R.layout.simple_list_item_1,bnames);
                listView.setAdapter(adapter);
                subadapter=new ArrayAdapter<String>(OderDetails.this, android.R.layout.simple_list_item_1,price);
                listView.setAdapter(subadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.logout:
                        startActivity(new Intent(getApplicationContext(),ConnectPubCus.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

    }
}