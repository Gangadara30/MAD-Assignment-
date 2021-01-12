package my.bookworm.bw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpBtn extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_btn);

        button = (Button) findViewById(R.id.supbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPubReg();
            }
        });
    }
    public void openPubReg(){
        startActivity(new Intent(getApplicationContext(), PubReg.class));
    }
}