package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.R;

public class ManagePaymentActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_payment;
    ImageView img_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_payment);

        materialtoolbar_payment= findViewById(R.id.materialtoolbar_payment);
        img_payment = findViewById(R.id.img_payment);

        Picasso.get().load("https://i.pinimg.com/236x/06/52/72/0652720e301151cb515cfc8db303e35a.jpg").placeholder(R.drawable.img_placeholder).into(img_payment);

        materialtoolbar_payment.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}