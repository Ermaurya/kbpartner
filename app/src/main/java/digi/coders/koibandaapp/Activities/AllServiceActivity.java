package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

import digi.coders.koibandaapp.R;

public class AllServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolBar_allservice;
    MaterialCardView card1,card2,card3,card4,card5,card6,card7,card8,card9,card10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_service);

        materialToolBar_allservice = findViewById(R.id.materialToolBar_allservice);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);
        card10 = findViewById(R.id.card10);

        materialToolBar_allservice.setNavigationOnClickListener(v -> {
            finish();
        });

        card1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card4.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card7.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card8.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card9.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });
        card10.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);

        });



    }
}