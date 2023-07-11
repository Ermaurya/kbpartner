package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

import digi.coders.koibandaapp.Models.RegisterModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileActivity extends AppCompatActivity {

    MaterialToolbar materialtoolbar_updateProfile;
    TextView textViewEmail;
    TextInputEditText editName,eidtMobile,editAdress;
    Button btnprofileUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        materialtoolbar_updateProfile = findViewById(R.id.materialtoolbar_updateProfile);
        textViewEmail = findViewById(R.id.textview_Email);
        editName = findViewById(R.id.editName);
        eidtMobile = findViewById(R.id.eidtMobile);
        editAdress = findViewById(R.id.editAdress);
        btnprofileUpdate = findViewById(R.id.btnprofileUpdate);



        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);

        String email = prefs.getString("custemail", "");

        // Display the user data in the UI elements

        textViewEmail.setText(email);

        btnprofileUpdate.setOnClickListener(v -> {
            updateProfile();
        });


        materialtoolbar_updateProfile.setNavigationOnClickListener(v -> {
            finish();
        });
    }

    private void updateProfile() {
        String Name =editName.getText().toString().trim();
        String Email=  textViewEmail.getText().toString().trim();
        String Mobile=  eidtMobile.getText().toString().trim();
        String Address=editAdress.getText().toString().trim();

        if(Name.isEmpty()){
            editName.requestFocus();
            editName.setError("Please Enter Name");
            return;
        }
        if(Mobile.isEmpty()){
            eidtMobile.requestFocus();
            eidtMobile.setError("Please Enter Mobile");
            return;
        }
        if (Address.isEmpty()){
            editAdress.requestFocus();
            editAdress.setError("Please Enter Address");
            return;
        }

        RetrofitClient.getClient().updateProfile(Name,Email,Mobile).enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(UpdateProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();

                    editName.setText("");
                    eidtMobile.setText("");
                    editAdress.setText("");
                }
                else {
                    Toast.makeText(UpdateProfileActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    eidtMobile.setText("");
                    editAdress.setText("");
                }

            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(UpdateProfileActivity.this, "Not Successfull", Toast.LENGTH_SHORT).show();
                editName.setText("");
                eidtMobile.setText("");
                editAdress.setText("");

            }
        });

    }
}