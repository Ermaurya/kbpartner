package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

import digi.coders.koibandaapp.R;

public class ActivateWalletActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_wallet);
        materialtoolbar_act = findViewById(R.id.materialtoolbar_act);

        materialtoolbar_act.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}