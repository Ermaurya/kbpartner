package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class MyAccountActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbarBack;
    LinearLayout wallet_linear,support_linear,payments_linear;
    TextView textView_name;

    CardView card_order,card_addressbook,card_share,card_about,card_rateapp,card_notification,card_logoutapp,card_whyBest,card_manageprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        materialtoolbarBack = findViewById(R.id.materialtoolbarBack);
        card_order = findViewById(R.id.card_order);
        card_addressbook = findViewById(R.id.card_addressbook);
        card_share = findViewById(R.id.card_share);
        card_about = findViewById(R.id.card_about);
        card_rateapp = findViewById(R.id.card_rateapp);
        card_notification = findViewById(R.id.card_notification);
        card_logoutapp = findViewById(R.id.card_logoutapp);
        wallet_linear = findViewById(R.id.wallet_linear);
        support_linear = findViewById(R.id.support_linear);
        payments_linear = findViewById(R.id.payments_linear);
        card_whyBest = findViewById(R.id.card_whyBest);
        card_manageprofile = findViewById(R.id.card_manageprofile);
        textView_name = findViewById(R.id.textView_name);

        SharedPreferences sharedPreferenced = getSharedPreferences("AddressPre",MODE_PRIVATE);
        String Name=sharedPreferenced.getString("CustName","");
        textView_name.setText(Name);

        SharedPreferences sharedPreferences =getSharedPreferences("LoginData",MODE_PRIVATE);
        sharedPreferences.getString("email","");
        sharedPreferences.getString("password","");

        materialtoolbarBack.setNavigationOnClickListener(v -> {
            finish();
        });

        card_logoutapp.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to logout");
            builder.setTitle("Alert!");
            builder.setCancelable(false);

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("email");
                    editor.remove("password");
                    editor.remove("customerLoginStatus");
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);

                }
            });
            builder.show();

        });


        actionPerformedOnCard();


    }

    private void actionPerformedOnCard() {

        SharedPreferences sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE);
        sharedPreferences.getString("email","");
        sharedPreferences.getString("password","");



        card_order.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),YourOrderActivity.class);
            startActivity(intent);
        });

        card_addressbook.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MyAddressActivity.class);
            startActivity(intent);

        });
        card_share.setOnClickListener(v -> {
            Toast.makeText(this, "share clicked", Toast.LENGTH_SHORT).show();
        });
        card_about.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);

        });
        card_rateapp.setOnClickListener(v -> {
            Toast.makeText(this, "under working", Toast.LENGTH_SHORT).show();
        });
        card_notification.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),NotificationPreferenceActivity.class);
            startActivity(intent);
        });


        card_whyBest.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),WhyBestActivity.class);
            startActivity(intent);
        });

        wallet_linear.setOnClickListener(v -> {
           Intent intent = new Intent(getApplicationContext(),WalletDetailActivity.class);
           startActivity(intent);
        });

        support_linear.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SupportActivity.class);
            startActivity(intent);
        });

        payments_linear.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ManagePaymentActivity.class);
            startActivity(intent);
        });

        card_manageprofile.setOnClickListener(v -> {
            Intent intent =new Intent(getApplicationContext(),ProfileActivity.class);
            startActivity(intent);
        });

    }
}