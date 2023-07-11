package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class ProfileActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        materialtoolbar_profile = findViewById(R.id.materialtoolbar_profile);

        materialtoolbar_profile.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}