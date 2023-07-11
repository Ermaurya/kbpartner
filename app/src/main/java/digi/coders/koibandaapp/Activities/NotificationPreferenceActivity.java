package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class NotificationPreferenceActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_notification;
    LinearLayout linear_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_preference);

        materialtoolbar_notification = findViewById(R.id.materialtoolbar_notification);
        linear_notification = findViewById(R.id.linear_notification);

        materialtoolbar_notification.setNavigationOnClickListener(v -> {
            finish();
        });

        linear_notification.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),OrderDetailsActivity.class);
            startActivity(intent);
            finish();
        });

    }
}