package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.R;

public class WhyBestActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarWhybest;
    ImageView timesavingImage,safetyImage,customerImage,professionalImage,equippedImage,paymentImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why_best);

        materialToolbarWhybest = findViewById(R.id.materialtoolbar_whybest);
        timesavingImage = findViewById(R.id.timesavingImage);
        safetyImage = findViewById(R.id.safetyImage);
        customerImage =  findViewById(R.id.customerImage);
        professionalImage = findViewById(R.id.professionalImage);
        equippedImage= findViewById(R.id.equippedImage);
        paymentImage = findViewById(R.id.paymentImage);

        Picasso.get().load("https://forexmillionersclub.com/appimg/Time%20Saving.png").into(timesavingImage);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Safety.png").into(safetyImage);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Support.png").into(customerImage);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Professionals.png").into(professionalImage);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Equipped.png").into(equippedImage);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Payment%20Method.png").into(paymentImage);




        materialToolbarWhybest.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}