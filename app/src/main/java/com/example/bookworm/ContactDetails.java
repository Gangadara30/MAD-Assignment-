package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContactDetails extends AppCompatActivity {

    EditText name;
    EditText address;
    EditText phone;
    Button button;
    DatabaseReference reference;
    Contact_Details contactdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        button = findViewById(R.id.button);

        contactdetails = new Contact_Details();
        reference = FirebaseDatabase.getInstance().getReference().child("Contact_Details");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){snapshot.getChildrenCount();}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cname = name.getText().toString().trim();
                String  cphone = phone.getText().toString().trim();
                contactdetails.setAddress(address.getText().toString().trim());
                contactdetails.setName(cname);
                contactdetails.setPhone(cphone);

                reference.child(String.valueOf(cname)).setValue(contactdetails);

                Button button = (Button)findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(ContactDetails.this,"contact details successfuly inserted",Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(ContactDetails.this,OderDetails.class);
                        intent.putExtra("ConfirmedOrder", contactdetails);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}