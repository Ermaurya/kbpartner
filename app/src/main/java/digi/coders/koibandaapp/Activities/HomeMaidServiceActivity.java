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

import digi.coders.koibandaapp.Adapters.HomeCleanAdapter;
import digi.coders.koibandaapp.Models.HomeCleanServiceModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeMaidServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarHomeMaid;
    RecyclerView recycleview_HomeCleaning;
    ArrayList<HomeCleanServiceModel> arrayList = new ArrayList<>();
    ProgressBar progress_homeclean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_maid_service);

        materialToolbarHomeMaid = findViewById(R.id.materialToolbar_homemaide);
        progress_homeclean = findViewById(R.id.progress_homeclean);
        recycleview_HomeCleaning = findViewById(R.id.recycleview_HomeCleaning);


        clickableMethod();

        callingHomeCleanService();
    }



    private void clickableMethod() {
        materialToolbarHomeMaid.setNavigationOnClickListener(v -> {
            finish();
        });


    }

    private void callingHomeCleanService() {
        progress_homeclean.setVisibility(View.VISIBLE);

        RetrofitClient.getClient().getHomeCleanService().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    progress_homeclean.setVisibility(View.GONE);

                    JsonObject jsonObject = response.body();

                    JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                    for (int i=0;i<jsonArray.size();i++){
                        String serviceName = jsonArray.get(i).getAsJsonObject().get("mcat_name").getAsString();
                        String realPrise =jsonArray.get(i).getAsJsonObject().get("discount").getAsString();
                        String cutPrise =jsonArray.get(i).getAsJsonObject().get("main_priz").getAsString();

                        arrayList.add(new HomeCleanServiceModel(serviceName,realPrise,cutPrise));
                    }
                    recycleview_HomeCleaning.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    HomeCleanAdapter homeCleanAdapter = new HomeCleanAdapter(getApplicationContext(),arrayList);
                    homeCleanAdapter.notifyDataSetChanged();
                    recycleview_HomeCleaning.setAdapter(homeCleanAdapter);
                }else {
                    progress_homeclean.setVisibility(View.GONE);
                    Toast.makeText(HomeMaidServiceActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progress_homeclean.setVisibility(View.GONE);
                Toast.makeText(HomeMaidServiceActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}