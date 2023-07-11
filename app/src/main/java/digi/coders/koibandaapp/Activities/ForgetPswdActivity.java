package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class ForgetPswdActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar_getOpt;
    Button buttonGetOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pswd);

        materialToolbar_getOpt = findViewById(R.id.materialToolbar_otp);
        buttonGetOtp = findViewById(R.id.btn_getotp);

        materialToolbar_getOpt.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        });

        buttonGetOtp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),EnterOtpActivity.class);
            startActivity(intent);
            finish();
        });

    }
}