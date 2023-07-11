package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
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

public class RegisterActivity extends AppCompatActivity {

    Button buttonSignUp;
    TextView textSignIn;
    MaterialToolbar materialToolbarRegister;
    TextInputEditText textName,textEmail,textMobile,textPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonSignUp = findViewById(R.id.btn_SignUp);
        textSignIn = findViewById(R.id.txt_SignIn);
        materialToolbarRegister = findViewById(R.id.materialToolbar_Register);

        textName = findViewById(R.id.txt_name);
        textEmail = findViewById(R.id.txt_email);
        textMobile = findViewById(R.id.txt_mobile);
        textPassword = findViewById(R.id.txt_psd);

        //this method perform clickable
        clickableMethod();
    }

    private void clickableMethod() {
        buttonSignUp.setOnClickListener(v -> {
            registerCustomer();

        });

        textSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        });

        materialToolbarRegister.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });
    }

    private void registerCustomer() {


        String customerName=textName.getText().toString().trim();
        String customerEmail=textEmail.getText().toString().trim();
        String customerMobile=textMobile.getText().toString().trim();
        String customerPassword=textPassword.getText().toString().trim();

        if(customerName.isEmpty()){
            textName.requestFocus();
            textName.setError("Please enter name");
            return;
        }
        if(customerEmail.isEmpty()){
            textEmail.requestFocus();
            textEmail.setError("Please enter email");
            return;
        }
        if (!customerEmail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(customerEmail).matches()) {
            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }

        if(customerMobile.isEmpty()){
            textMobile.requestFocus();
            textMobile.setError("Please enter mobile number");
            return;
        }
        if(customerPassword.isEmpty()){
            textPassword.requestFocus();
            textPassword.setError("Please enter password");
            return;
        }

        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("custname", customerName);
        editor.putString("custemail", customerEmail);
        editor.putString("custmobile", customerMobile);
        editor.apply();


        Log.d("APiData",""+customerName+""+customerEmail+""+customerMobile+""+customerPassword);

        RetrofitClient.getClient().registerData(customerName,customerEmail,customerMobile,customerPassword).enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Successfull Register", Toast.LENGTH_SHORT).show();

                    textName.setText("");
                    textEmail.setText("");
                    textMobile.setText("");
                    textPassword.setText("");

                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("");

                    // set the custom layout
                    final View customLayout = getLayoutInflater().inflate(R.layout.custom_registerpopup, null);
                    builder.setView(customLayout);

                    // add a button
                    builder.setPositiveButton("OK", (dialog, which) -> {
                        // send data from the AlertDialog to the Activity
//                EditText editText = customLayout.findViewById(R.id.editText);
//                sendDialogDataToActivity(editText.getText().toString());
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        finish();
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();




                }
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Not SuccesFull"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}