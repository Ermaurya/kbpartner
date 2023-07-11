package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class AboutActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        materialToolbarAbout = findViewById(R.id.matertoolbar_about);

        materialToolbarAbout.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}