import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;


import com.example.test.MainActivity1;
import com.example.test.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class PublishLogin extends AppCompatActivity {


    private EditText emailTV, passwordTV;
    private Button PBtn;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        PBtn = findViewById(R.id.plogin);

        PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailTV.getText().toString().trim();
                String password = passwordTV.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {

                    emailTV.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {

                    passwordTV.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    passwordTV.setError("Password must be > 6 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);


                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);

                                    Intent intent = new Intent(PublishLogin.this, MainActivity1.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }


        });
    }}