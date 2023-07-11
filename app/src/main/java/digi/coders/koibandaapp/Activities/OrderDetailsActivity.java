package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import digi.coders.koibandaapp.R;

public class OrderDetailsActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_oredrDetail;
    RelativeLayout mainRelative;
    TextView txt_bookingId,txt_checkStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        materialtoolbar_oredrDetail = findViewById(R.id.materialtoolbar_oredrDetail);
        mainRelative = findViewById(R.id.mainRelative);
        txt_bookingId = findViewById(R.id.txt_bookingId);
        txt_checkStatus = findViewById(R.id.txt_checkStatus);

        materialtoolbar_oredrDetail.setNavigationOnClickListener(v -> {
            finish();
        });

        txt_checkStatus.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialogAddress = new BottomSheetDialog(OrderDetailsActivity.this);
            View bottomSheetView = LayoutInflater.from(OrderDetailsActivity.this).inflate(R.layout.status_bottomsheet,mainRelative,false);
            bottomSheetDialogAddress.setContentView(bottomSheetView);
            bottomSheetDialogAddress.show();

        });



    }
}