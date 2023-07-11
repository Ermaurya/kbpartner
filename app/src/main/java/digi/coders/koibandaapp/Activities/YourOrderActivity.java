package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import digi.coders.koibandaapp.R;

public class YourOrderActivity extends AppCompatActivity {

    MaterialToolbar materilaltoolbar_yourorder;
    LinearLayout linear_myorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);

        materilaltoolbar_yourorder = findViewById(R.id.materilaltoolbar_yourorder);
        linear_myorder = findViewById(R.id.linear_myorder);

        linear_myorder.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),OrderDetailsActivity.class);
            startActivity(intent);
            finish();



        });

        materilaltoolbar_yourorder.setNavigationOnClickListener(v -> {
            finish();
        });






    }
}