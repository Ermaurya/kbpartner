package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.Models.RoWaterSendDataModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity {

    MaterialToolbar materialToolBarPayment;
    TextView txt_OrderAmount,textview_payamount,textview_orderamount;

    RadioGroup radioGroup_paymentype;
    RadioButton radioButtonPayment;
    Button btn_placeOrder;
    ProgressBar progressbar_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        materialToolBarPayment = findViewById(R.id.materialToolBarPayment);
        txt_OrderAmount = findViewById(R.id.txt_OrderAmount);
        btn_placeOrder = findViewById(R.id.btn_placeOrder);
        textview_payamount = findViewById(R.id.textview_payamount);
        textview_orderamount = findViewById(R.id.textview_orderamount);
        progressbar_payment = findViewById(R.id.progressbar_payment);

        Intent intentdata = getIntent();
        String Totalamount =  intentdata.getStringExtra("totalamount");
        textview_payamount.setText(Totalamount);
        textview_orderamount.setText(Totalamount);


        radioGroup_paymentype = findViewById(R.id.radioGroup_paymentype);
       radioButtonPayment= findViewById(radioGroup_paymentype.getCheckedRadioButtonId());




        materialToolBarPayment.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),DeliverDetailActivity.class);
            startActivity(intent);
            finish();
        });


        btn_placeOrder.setOnClickListener(v -> {
            progressbar_payment.setVisibility(View.VISIBLE);

            SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
            String Email = prefs.getString("custemail", "");
            String TotalAmount = prefs.getString("totalAmount", "");
            String WaterName = prefs.getString("nameWater", "");
            String Quantity = prefs.getString("Qnty", "");
            String DateTime = prefs.getString("datetime", "");

            String PaymentType = ((RadioButton)findViewById(radioGroup_paymentype.getCheckedRadioButtonId())).getText().toString();


            RetrofitClient.getClient().updateRoWaterSendData(Email,TotalAmount,WaterName,Quantity,DateTime,PaymentType).enqueue(new Callback<RoWaterSendDataModel>() {
                @Override
                public void onResponse(Call<RoWaterSendDataModel> call, Response<RoWaterSendDataModel> response) {
                    if(response.isSuccessful()){
                        progressbar_payment.setVisibility(View.GONE);
                       // Toast.makeText(PaymentActivity.this, "Ordered Successfull", Toast.LENGTH_SHORT).show();


                        AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                        builder.setTitle("");

                        // set the custom layout
                        final View customLayout = getLayoutInflater().inflate(R.layout.coustom_layoutalert, null);
                        builder.setView(customLayout);

                        // add a button
                        builder.setPositiveButton("OK", (dialog, which) -> {
                            // send data from the AlertDialog to the Activity
//                EditText editText = customLayout.findViewById(R.id.editText);
//                sendDialogDataToActivity(editText.getText().toString());
                            finish();
                        });
                        // create and show the alert dialog
                        AlertDialog dialog = builder.create();
                        dialog.show();




                    }else {
                        progressbar_payment.setVisibility(View.GONE);
                        Toast.makeText(PaymentActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RoWaterSendDataModel> call, Throwable t) {
                    progressbar_payment.setVisibility(View.GONE);
                    Toast.makeText(PaymentActivity.this, "Ordered not Successfull", Toast.LENGTH_SHORT).show();

                }
            });



        });





    }
}