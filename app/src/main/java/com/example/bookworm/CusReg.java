package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class CusReg extends AppCompatActivity {
    EditText cfname, clname, cemail, cpwd, ccpwd,cphn;
    Button cRegistrationBtn, cemailbtn, cphonebtn;
    DatabaseReference reff;
    Customer customer;

    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_reg);

        cfname= findViewById(R.id.cfullname);
        clname=findViewById(R.id.clastname);
        cemail=findViewById(R.id.cemail);
        cpwd=findViewById(R.id.cpassword);
        ccpwd=findViewById(R.id.confirmpassword);
        cphn=findViewById(R.id.cmobile);
        cRegistrationBtn=findViewById(R.id.cusrbtn);
        cemailbtn=findViewById(R.id.ebtn);
        cphonebtn=findViewById(R.id.phnbtn);

        customer= new Customer();

        reff= FirebaseDatabase.getInstance().getReference().child("Customer");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    maxid=(snapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        cRegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= cemail.getText().toString().trim();
                String password = cpwd.getText().toString().trim();
                String lastname= clname.getText().toString().trim();
                String confirm = ccpwd.getText().toString().trim();
                String phone= cphn.getText().toString().trim();

                customer.setName1(cfname.getText().toString().trim());
                customer.setMail(email);
                customer.setName2(lastname);
                customer.setPass(password);
                customer.setCpass(confirm);
                customer.setNo(phone);

                if (TextUtils.isEmpty(email)){
                    cemail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    cpwd.setError("Password ie required");
                    return;
                }

                if (password.length()<6){
                    cpwd.setError("Password must be >= 6 characters");
                    return;
                }

                if (confirm.length()<6){
                    ccpwd.setError("Enter Password Correctly");
                    return;
                }

                reff.child(String.valueOf(maxid+1)).setValue(customer);

                Toast.makeText(CusReg.this,"Data Insert Successfully",Toast.LENGTH_LONG).show();




            }
        });

        cemailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        cphonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });



    }

    public void openActivity1(){
        Intent intent= new Intent(this,AnukiLogin.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent=new Intent(this,BuddiPhone.class);
        startActivity(intent);
    }
}