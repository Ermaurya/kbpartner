package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import digi.coders.koibandaapp.Models.LoginResponse;
import digi.coders.koibandaapp.Models.RegisterModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    TextView textSignUp, textForget;
    TextInputEditText etEmail, etPassword;
    ImageView imageLogin;
    CardView card_Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.btn_signIn);
        textSignUp = findViewById(R.id.txt_signUp);
        textForget = findViewById(R.id.txt_forget);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_psd);
        imageLogin = findViewById(R.id.login_img);
        card_Skip = findViewById(R.id.card_Skip);

        //this method is used for Performing click Listerner
        clickableMethod();


    }

    private void clickableMethod() {
        buttonLogin.setOnClickListener(v -> {
            loginCustomer();



        });

        textSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });

        textForget.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ForgetPswdActivity.class);
            startActivity(intent);
        });

        card_Skip.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

    private void loginCustomer() {
        String customerEmail=etEmail.getText().toString().trim();
        String customerPassword=etPassword.getText().toString().trim();

        if(customerEmail.isEmpty()){
            etEmail.requestFocus();
            etEmail.setError("enter email");
            return;
        }
        if(customerPassword.isEmpty()){
            etPassword.requestFocus();
            etPassword.setError("enter Password");
            return;
        }


    Call<LoginResponse> call = RetrofitClient.getClient().loginData(customerEmail,customerPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.body().getMessage().equals("login success")){
                    SharedPreferences sharedPreferences = getSharedPreferences("LoginData",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email",etEmail.getText().toString());
                    editor.putString("password",etPassword.getText().toString());
                    editor.putBoolean("customerLoginStatus",true);
                    editor.commit();


                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("");

                    // set the custom layout
                    final View customLayout = getLayoutInflater().inflate(R.layout.costom_loginpoup, null);
                    builder.setView(customLayout);

                    // add a button
                    builder.setPositiveButton("OK", (dialog, which) -> {
                        // send data from the AlertDialog to the Activity
//                EditText editText = customLayout.findViewById(R.id.editText);
//                sendDialogDataToActivity(editText.getText().toString());
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();





                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalide email or password", Toast.LENGTH_SHORT).show();
                    etEmail.setText("");
                    etPassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Not Successfull"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });







    }
}