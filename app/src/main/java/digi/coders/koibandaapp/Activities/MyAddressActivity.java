package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

import digi.coders.koibandaapp.Models.RegisterModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAddressActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_myaddress;
    MaterialCardView cardAddNewAddress;
    ProgressBar progress_myadress;
    TextView textName,textEmail,textMobile,textLandmark,textStreet,textPincode,textCity,textState,texttypeaddress,textEdit,textRemove,txt_fulladdress,textSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        materialtoolbar_myaddress = findViewById(R.id.materialtoolbar_myaddress);
        cardAddNewAddress = findViewById(R.id.card_addnewaddress);
        textName = findViewById(R.id.textName);
       // textEmail= findViewById(R.id.textEmail);
        textMobile = findViewById(R.id.textMobile);
     //   textLandmark = findViewById(R.id.textLandmark);
     //   textStreet = findViewById(R.id.textStreet);
     //   textPincode = findViewById(R.id.textPincode);
     //   textCity = findViewById(R.id.textCity);
     //   textState = findViewById(R.id.textState);
      //  texttypeaddress= findViewById(R.id.texttypeaddress);
        txt_fulladdress= findViewById(R.id.txt_fulladdress);
        textEdit = findViewById(R.id.textEdit);
        textRemove = findViewById(R.id.textRemove);
        textSelect = findViewById(R.id.textSelect);
        progress_myadress = findViewById(R.id.progress_myadress);


        SharedPreferences sharedPreferences = getSharedPreferences("AddressPre",MODE_PRIVATE);
        String Name=sharedPreferences.getString("CustName","");
        String Email=  sharedPreferences.getString("CustEmail","");
        String MobileNmber=sharedPreferences.getString("CustMobile","");
        String StreetName=sharedPreferences.getString("CustStreet","");
        String PinCode=sharedPreferences.getString("CustPincode","");
        String StateName=sharedPreferences.getString("CustState","");
        String CityName=sharedPreferences.getString("CustCity","");
        String LandMarkName =sharedPreferences.getString("CustLandMark","");
        String TypeAddress = sharedPreferences.getString("Custtypeaddress","");
        String FulllAddr = sharedPreferences.getString("FullAddress","");

        textName.setText("Name : "+Name);
      //  textEmail.setText("Email Id :"+Email);
        textMobile.setText("Mobile : "+MobileNmber);
      //  textStreet.setText(" "+StreetName);
     //   textPincode.setText(" "+PinCode);
     //   textState.setText(" - "+StateName);
      //  textCity.setText(" ,"+CityName);
   //     textLandmark.setText("Address : "+LandMarkName);
     //   texttypeaddress.setText(","+TypeAddress);
        txt_fulladdress.setText("Address : "+FulllAddr);

        materialtoolbar_myaddress.setNavigationOnClickListener(v -> {
            finish();
        });

        cardAddNewAddress.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AddNewAddressActivity.class);
            startActivity(intent);
            finish();
        });

        textEdit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AddNewAddressActivity.class);
            startActivity(intent);
            finish();
        });
        textRemove.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("CustName");
           // editor.remove("CustEmail");
            editor.remove("CustMobile");
          //  editor.remove("CustStreet");
        //    editor.remove("CustPincode");
         //   editor.remove("CustState");
          //  editor.remove("CustCity");
        //    editor.remove("CustLandMark");
            editor.remove("FullAddress");
            editor.apply();
            editor.commit();
            finish();

        });

        textSelect.setOnClickListener(v -> {
            progress_myadress.setVisibility(View.VISIBLE);

            RetrofitClient.getClient().updateRoWaterAddress(Email,Name,MobileNmber,FulllAddr).enqueue(new Callback<RegisterModel>() {
                @Override
                public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                    if(response.isSuccessful()){
                        progress_myadress.setVisibility(View.GONE);
                        Toast.makeText(MyAddressActivity.this, "save address", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),DeliverDetailActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        progress_myadress.setVisibility(View.GONE);
                        Toast.makeText(MyAddressActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterModel> call, Throwable t) {
                    progress_myadress.setVisibility(View.GONE);
                    Toast.makeText(MyAddressActivity.this, "not save data", Toast.LENGTH_SHORT).show();

                }
            });

        });


    }
}