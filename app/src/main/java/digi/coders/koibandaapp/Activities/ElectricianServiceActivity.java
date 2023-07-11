package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import digi.coders.koibandaapp.Adapters.ElectricServiceAdapter;
import digi.coders.koibandaapp.Models.ElectricServiceModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElectricianServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarElectrician;
    RecyclerView recycleView_ele;
    ProgressBar progress_ele;
    ArrayList<ElectricServiceModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_service);

         materialToolbarElectrician = findViewById(R.id.materialToolbar_electrician);
        recycleView_ele = findViewById(R.id.recycleView_ele);
        progress_ele = findViewById(R.id.progress_ele);


          clickableMethod();

          callingElectricService();

    }


    private void clickableMethod() {
        materialToolbarElectrician.setNavigationOnClickListener(v -> {
            finish();
        });


    }
    private void callingElectricService() {
        progress_ele.setVisibility(View.VISIBLE);

        RetrofitClient.getClient().getElectricService().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    progress_ele.setVisibility(View.GONE);
                    JsonObject jsonObject = response.body();

                    JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                    for (int i=0;i<jsonArray.size();i++){
                        String ServiceName = jsonArray.get(i).getAsJsonObject().get("mcat_name").getAsString();
                        String CutPrise = jsonArray.get(i).getAsJsonObject().get("main_priz").getAsString();
                        String RealPrise = jsonArray.get(i).getAsJsonObject().get("discount").getAsString();

                        arrayList.add(new ElectricServiceModel(ServiceName,CutPrise,RealPrise));

                    }
                    recycleView_ele.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    ElectricServiceAdapter electricServiceAdapter = new ElectricServiceAdapter(getApplicationContext(),arrayList);
                   electricServiceAdapter.notifyDataSetChanged();
                    recycleView_ele.setAdapter(electricServiceAdapter);


                }else {
                    progress_ele.setVisibility(View.GONE);
                    Toast.makeText(ElectricianServiceActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progress_ele.setVisibility(View.GONE);
                Toast.makeText(ElectricianServiceActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}