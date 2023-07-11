package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import digi.coders.koibandaapp.Adapters.PlumberServiceAdapter;
import digi.coders.koibandaapp.Models.PlumberServiceModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlumbingServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarPlumbing;
    RecyclerView recyclerViewPlumber;
    ProgressBar progresbar_plumber;
    ArrayList<PlumberServiceModel>arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_service);

        materialToolbarPlumbing = findViewById(R.id.materialToolbar_plumbing);
        recyclerViewPlumber = findViewById(R.id.recycleview_Plumber);
        progresbar_plumber = findViewById(R.id.progresbar_plumber);


        clickableMethod();

        callPlumberService();


    }
    private void clickableMethod() {
        materialToolbarPlumbing.setNavigationOnClickListener(v -> {
            finish();
        });


    }

    private void callPlumberService() {
        progresbar_plumber.setVisibility(View.VISIBLE);

        RetrofitClient.getClient().getPlumberService().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if(response.isSuccessful()){
                    progresbar_plumber.setVisibility(View.GONE);
                    Log.d("apitesting",""+response.body());

                    JsonObject jsonObject = response.body();

                    JsonArray jsonArray =jsonObject.getAsJsonArray("data");
                    for (int i=0;i< jsonArray.size();i++){
                        String ServiceName = jsonArray.get(i).getAsJsonObject().get("mcat_name").getAsString();
                        String CutPrise =jsonArray.get(i).getAsJsonObject().get("main_priz").getAsString();
                        String RealPrise = jsonArray.get(i).getAsJsonObject().get("discount").getAsString();

                        arrayList.add(new PlumberServiceModel(ServiceName,CutPrise,RealPrise));

                    }

                    recyclerViewPlumber.setLayoutManager(new LinearLayoutManager(PlumbingServiceActivity.this,RecyclerView.VERTICAL,false));
                    PlumberServiceAdapter plumberServiceAdapter = new PlumberServiceAdapter(PlumbingServiceActivity.this,arrayList);
                    plumberServiceAdapter.notifyDataSetChanged();
                    recyclerViewPlumber.setAdapter(plumberServiceAdapter);

                }else {
                    progresbar_plumber.setVisibility(View.GONE);
                    Toast.makeText(PlumbingServiceActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progresbar_plumber.setVisibility(View.GONE);
                Toast.makeText(PlumbingServiceActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}