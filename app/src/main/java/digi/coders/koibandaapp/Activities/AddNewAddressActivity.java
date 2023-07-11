package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class AddNewAddressActivity extends AppCompatActivity {

    MaterialToolbar materiltoolbar_address;
    TextView textEmail;
    TextInputEditText edittxt_name,edittext_mobile,edittext_street,edittext_pincode,edittext_state,edittext_city,edittext_landmark,edittext_fullAddress;
    Button button_countinue;
    RadioGroup  radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);

        materiltoolbar_address = findViewById(R.id.materiltoolbar_address);

        textEmail = findViewById(R.id.text_Email);
        edittxt_name=findViewById(R.id.edittxt_name);
        edittext_mobile= findViewById(R.id.edittext_mobile);
        edittext_street = findViewById(R.id.edittext_street);
        edittext_pincode = findViewById(R.id.edittext_pincode);
        edittext_state = findViewById(R.id.edittext_state);
        edittext_city = findViewById(R.id.edittext_city);
        edittext_landmark =findViewById(R.id.edittext_landmark);
        edittext_fullAddress =findViewById(R.id.edittext_fullAddress);
        button_countinue = findViewById(R.id.button_countinue);
        radioGroup =  findViewById(R.id.radiogroup);


        radioButton= findViewById(radioGroup.getCheckedRadioButtonId());

        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);

        String email = prefs.getString("custemail", "");
        textEmail.setText(email);

        button_countinue.setOnClickListener(v -> {
            addAddress();
        });

        materiltoolbar_address.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MyAddressActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void addAddress() {

        String Name = edittxt_name.getText().toString().trim();
        String Email = textEmail.getText().toString().trim();
        String Mobile= edittext_mobile.getText().toString().trim();
        String Street = edittext_street.getText().toString().trim();
        String Pincode = edittext_pincode.getText().toString().trim();
        String State = edittext_state.getText().toString().trim();
        String City = edittext_city.getText().toString().trim();
        String Landmark= edittext_landmark.getText().toString().trim();
        String fullAddress = edittext_fullAddress.getText().toString().trim();
        //String typeAddrss = radioButton.getText().toString();

        String Typeaddress= ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("AddressPre",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CustName",Name);
        editor.putString("CustEmail",Email);
        editor.putString("CustMobile",Mobile);
        editor.putString("CustStreet",Street);
        editor.putString("CustPincode",Pincode);
        editor.putString("CustState",State);
        editor.putString("CustCity",City);
        editor.putString("CustLandMark",Landmark);
        editor.putString("Custtypeaddress",Typeaddress);
        editor.putString("FullAddress",fullAddress);
        editor.apply();


        if(Name.isEmpty()){
            edittxt_name.setError("Please enter name");
            edittxt_name.requestFocus();
            return;
        }
        if(Email.isEmpty()){
            textEmail.requestFocus();
            textEmail.setError("please enter email");
            return;
        }


       if(Mobile.isEmpty()){
           edittext_mobile.requestFocus();
           edittext_mobile.setError("Please enter Mobile");
           return;
       }
       if(Mobile.length()!=10){
            edittext_mobile.requestFocus();
            edittext_mobile.setError("Please enter 10 digit numbers");
            return;
        }
       if(Street.isEmpty()){
           edittext_street.requestFocus();
           edittext_street.setError("Please enter Streete name");
           return;
       }
       if(Pincode.isEmpty()){
           edittext_pincode.requestFocus();
           edittext_pincode.setError("Please enter Pincode");
           return;
       }
       if(State.isEmpty()){
           edittext_state.requestFocus();
           edittext_state.setError("Please enter State name");
           return;
       }
       if(City.isEmpty()){
           edittext_city.requestFocus();
           edittext_city.setError("Please enter city");
           return;
       }
       if(Landmark.isEmpty()){
           edittext_landmark.requestFocus();
           edittext_landmark.setError("Please enter landmark");
           return;
       }
        if(fullAddress.isEmpty()){
            edittext_fullAddress.requestFocus();
            edittext_fullAddress.setError("Please enter landmark");
            return;
        }



        RetrofitClient.getClient().updateAddress(Name,Email,Mobile,Street,Pincode,State,City,Landmark,Typeaddress,fullAddress).enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AddNewAddressActivity.this, "Update Address", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MyAddressActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(AddNewAddressActivity.this, "Not Update", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(AddNewAddressActivity.this, "Some thing went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }
}