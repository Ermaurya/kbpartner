package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.R;

public class HowWorkActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarHowWork;
    ImageView chooseservice_img,picktime_img,feelrlax_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_work);

        materialToolbarHowWork =findViewById(R.id.materialtoolbar_howwork);
        chooseservice_img = findViewById(R.id.image_choose_service);
        picktime_img = findViewById(R.id.image_pick_time);
        feelrlax_img = findViewById(R.id.image_feel_relax);

        Picasso.get().load("https://forexmillionersclub.com/appimg/Choose%20Services.png").into(chooseservice_img);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Pic%20A%20Time.png").into(picktime_img);
        Picasso.get().load("https://forexmillionersclub.com/appimg/Feel%20Relaxed.png").into(feelrlax_img);

        materialToolbarHowWork.setNavigationOnClickListener(v -> {
            finish();
        });
    }
}