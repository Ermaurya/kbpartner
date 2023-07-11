package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.R;

public class WalletDetailActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    Button btn_activateWallet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_detail);


        materialToolbar = findViewById(R.id.materiltoolbar);
        btn_activateWallet = findViewById(R.id.btn_activateWallet);

        materialToolbar.setNavigationOnClickListener(v -> {
            finish();
        });

        btn_activateWallet.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ActivateWalletActivity.class);
            startActivity(intent);
            finish();
        });
    }
}