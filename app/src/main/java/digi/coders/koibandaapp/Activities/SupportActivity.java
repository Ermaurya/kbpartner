package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.R;

public class SupportActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        materialtoolbar_support = findViewById(R.id.materialtoolbar_support);

        materialtoolbar_support.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}