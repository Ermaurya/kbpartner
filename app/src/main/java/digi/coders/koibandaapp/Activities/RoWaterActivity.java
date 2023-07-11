package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import digi.coders.koibandaapp.Adapters.RoWaterAdapter;
import digi.coders.koibandaapp.Models.RoWaterModel;
import digi.coders.koibandaapp.R;

public class RoWaterActivity extends AppCompatActivity {

    TextView txtcutprise1,txtcutprise2;
    MaterialToolbar materialToolbar_roWater;
    LinearLayout linearNormWaterAddCart,linearColdWaterAddCart;
    TextView txt_NormalWaterName,txt_NormwaterLtr,txt_NormWaterprise,txt_ColdWaterName,txt_ColdwaterLtr,txt_ColdWaterprise;
    RecyclerView recycleview;
    List<RoWaterModel> roWaterModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro_water);

        //txtcutprise1= findViewById(R.id.txtcutprise1);
        //txtcutprise2= findViewById(R.id.txtcutprise2);
        materialToolbar_roWater= findViewById(R.id.materialToolbar_roWater);
//        linearNormWaterAddCart= findViewById(R.id.linearNormWaterAddCart);
//        linearColdWaterAddCart= findViewById(R.id.linearColdWaterAddCart);
//        txt_NormalWaterName= findViewById(R.id.txt_NormalWaterName);
//        txt_NormwaterLtr= findViewById(R.id.txt_NormwaterLtr);
//        txt_NormWaterprise= findViewById(R.id.txt_NormWaterprise);
//        txt_ColdWaterName= findViewById(R.id.txt_ColdWaterName);
//        txt_ColdwaterLtr= findViewById(R.id.txt_ColdwaterLtr);
//        txt_ColdWaterprise= findViewById(R.id.txt_ColdWaterprise);
        recycleview= findViewById(R.id.recycleview);

//        txtcutprise1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//        txtcutprise2.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//
//       String NormWaterName = txt_NormalWaterName.getText().toString();
//       String NormWaterLtr = txt_NormwaterLtr.getText().toString();
//       String NormWaterPrise = txt_NormWaterprise.getText().toString();
//
//       String ColdWaterName = txt_ColdWaterName.getText().toString();
//       String ColdWaterLtr = txt_ColdwaterLtr.getText().toString();
//       String ColdWaterPrisePrise = txt_ColdWaterprise.getText().toString();

        materialToolbar_roWater.setNavigationOnClickListener(v -> {
            finish();
        });

        RoWaterAdapter roWaterAdapter = new RoWaterAdapter(this,roWaterModelList);
        recycleview.setAdapter(roWaterAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this));

        roWaterModelList.add(new RoWaterModel(R.drawable.panibottol,"Normal Water","20 LTR","30"));
        roWaterModelList.add(new RoWaterModel(R.drawable.panibottol,"Cold Water","20 LTR","35"));








//        linearNormWaterAddCart.setOnClickListener(v -> {
//            Intent intent = new Intent(getApplicationContext(),DeliverDetailActivity.class);
//            intent.putExtra("NormName",  NormWaterName);
//            intent.putExtra("NormLtr",  NormWaterLtr);
//            intent.putExtra("NormPrice",  NormWaterPrise);
//            startActivity(intent);
//            finish();
//        });
//
//        linearColdWaterAddCart.setOnClickListener(v -> {
//            Intent intent = new Intent(getApplicationContext(),DeliverDetailActivity.class);
//            intent.putExtra("ColdName",  ColdWaterName);
//            intent.putExtra("ColdLtr",  ColdWaterLtr);
//            intent.putExtra("ColdPrice",  ColdWaterPrisePrise);
//            startActivity(intent);
//            finish();
//        });


    }
}