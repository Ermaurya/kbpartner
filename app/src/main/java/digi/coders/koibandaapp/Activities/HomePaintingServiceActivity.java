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

import digi.coders.koibandaapp.Adapters.HomePaintAdapter;
import digi.coders.koibandaapp.Models.PaintServiceModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePaintingServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarHomepainting;
    RecyclerView recycleview_paint;
    ProgressBar progress_paint;

    ArrayList<PaintServiceModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_painting_service);

        materialToolbarHomepainting = findViewById(R.id.materialToolbar_homepainting);
        recycleview_paint = findViewById(R.id.recycleview_paint);
        progress_paint = findViewById(R.id.progress_paint);

        clickableMethod();

        callingPaintingService();
    }



    private void clickableMethod() {
        materialToolbarHomepainting.setNavigationOnClickListener(v -> {
            finish();
        });

    }
    private void callingPaintingService() {
        progress_paint.setVisibility(View.VISIBLE);

        RetrofitClient.getClient().getHomePaintService().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    progress_paint.setVisibility(View.GONE);
                    JsonObject jsonObject = response.body();

                    JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                    for (int i=0;i<jsonArray.size();i++){
                        String ServiceName = jsonArray.get(i).getAsJsonObject().get("mcat_name").getAsString();
                        String CutPrise = jsonArray.get(i).getAsJsonObject().get("main_priz").getAsString();
                        String RealPrise = jsonArray.get(i).getAsJsonObject().get("discount").getAsString();

                       arrayList.add(new PaintServiceModel(ServiceName,CutPrise,RealPrise)) ;
                    }
                    recycleview_paint.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    HomePaintAdapter homePaintAdapter = new HomePaintAdapter(getApplicationContext(),arrayList);
                    homePaintAdapter.notifyDataSetChanged();
                    recycleview_paint.setAdapter(homePaintAdapter);
                }else {
                    progress_paint.setVisibility(View.GONE);
                    Toast.makeText(HomePaintingServiceActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progress_paint.setVisibility(View.GONE);
                Toast.makeText(HomePaintingServiceActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}