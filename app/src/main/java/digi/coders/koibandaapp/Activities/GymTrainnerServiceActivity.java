package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class GymTrainnerServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarGymTranner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_trainner);

        materialToolbarGymTranner = findViewById(R.id.materialToolbar_gymTrainner);

        clickableMethod();
    }

    private void clickableMethod() {
        materialToolbarGymTranner.setNavigationOnClickListener(v -> {
            finish();
        });


    }
}