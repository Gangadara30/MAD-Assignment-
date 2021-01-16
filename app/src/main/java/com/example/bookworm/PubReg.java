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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PubReg extends AppCompatActivity {
    EditText pfname, plname, pemail, ppwd, pcpwd,pphn;
    Button pRegistrationBtn, pemailbtn, pphonebtn;
    DatabaseReference reff;
    FirebaseAuth fAuth;
    Publisher publisher;

    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_reg);

        pfname= findViewById(R.id.pfullname);
        plname=findViewById(R.id.plastname);
        pemail=findViewById(R.id.pemail);
        ppwd=findViewById(R.id.pubpassword);
        pcpwd=findViewById(R.id.pconfirmpassword);
        pphn=findViewById(R.id.pmobile);
        pRegistrationBtn=findViewById(R.id.pubrbtn);
        pemailbtn=findViewById(R.id.ebtn);
        pphonebtn=findViewById(R.id.phnbtn);
        fAuth = FirebaseAuth.getInstance();

        publisher= new Publisher();

        reff= FirebaseDatabase.getInstance().getReference().child("Publisher");
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



        pRegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= pemail.getText().toString().trim();
                String password = ppwd.getText().toString().trim();
                String lastname= plname.getText().toString().trim();
                String confirm = pcpwd.getText().toString().trim();
                String phone= pphn.getText().toString().trim();

                publisher.setName1(pfname.getText().toString().trim());
                publisher.setMail(email);
                publisher.setName2(lastname);
                publisher.setPass(password);
                publisher.setCpass(confirm);
                publisher.setNo(phone);

                if (TextUtils.isEmpty(email)){
                    pemail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    ppwd.setError("Password ie required");
                    return;
                }

                if (password.length()<6){
                    ppwd.setError("Password must be >= 6 characters");
                    return;
                }

                if (confirm.length()<6){
                    pcpwd.setError("Enter Password Correctly");
                    return;
                }

                reff.child(String.valueOf(maxid+1)).setValue(publisher);

                //Toast.makeText(PubReg.this,"Data Insert Successfully",Toast.LENGTH_LONG).show();

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(PubReg.this,"Data Insert Successfully",Toast.LENGTH_LONG).show();
                      }else{

                      }
                    }
                });




            }
        });

        pemailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        pphonebtn.setOnClickListener(new View.OnClickListener() {
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