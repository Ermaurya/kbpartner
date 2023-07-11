package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class CookServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarCook;
    TextView textContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_service);

        materialToolbarCook = findViewById(R.id.materialToolbar_cook);
        textContinue = findViewById(R.id.txt_Continue);

        clickableMethod();

    }

    private void clickableMethod() {
        materialToolbarCook.setNavigationOnClickListener(v -> {
            finish();
        });

        textContinue.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),CartActivity.class);
            startActivity(intent);
        });
    }
}