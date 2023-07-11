package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class CarpentryServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarCarpentry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpentry_service);

        materialToolbarCarpentry = findViewById(R.id.materialToolbar_carpentry);


        clickableMthod();
    }

    private void clickableMthod() {
        materialToolbarCarpentry.setNavigationOnClickListener(v -> {
            finish();
        });


    }

}