package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import digi.coders.koibandaapp.R;

public class EnterOtpActivity extends AppCompatActivity {

    Button buttonSubmitOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        buttonSubmitOtp = findViewById(R.id.btn_submitOtp);

        buttonSubmitOtp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ResetPswdActivity.class);
            startActivity(intent);
            finish();
        });
    }
}