package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import digi.coders.koibandaapp.Models.ContactModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {

    AutoCompleteTextView autoTextViewSpinner,autotext_servicetime;
    FloatingActionButton floatingActionButton;
    MaterialToolbar materialToolbar;
    TextInputEditText et_Name,et_Email,et_Mobile,et_Address;
    Button btnSendMsg;

    String[] services = { "Home Tutor", "Gym Trainner",
            "Plumbing", "Dance Teacher",
            "Carpentry", "Cook","Yoga Teacher" ,"Home Maid","Hom Painting","Electrician"};
    String[] servicestime = { "Immediately", "Next withi 3 days",
            "Next within 7 days",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        materialToolbar = findViewById(R.id.materialtollbar_contact);
        floatingActionButton = findViewById(R.id.floating_action_button);
        autoTextViewSpinner= findViewById(R.id.autoCompleteTextViw);
        autotext_servicetime = findViewById(R.id.autotext_servicetime);
        et_Name =findViewById(R.id.et_Name);
        et_Email = findViewById(R.id.et_Email);
        et_Mobile = findViewById(R.id.et_Mobile);
        et_Address= findViewById(R.id.et_Address);
        btnSendMsg = findViewById(R.id.btn_sendmsg);



        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String name = prefs.getString("custname", "");
        String email = prefs.getString("custemail", "");
        String mobile = prefs.getString("custmobile", "");
        // Display the user data in the UI elements
        et_Name.setText(name);
        et_Email.setText(email);
        et_Mobile.setText(mobile);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,services);
        autoTextViewSpinner.setAdapter(arrayAdapter);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,servicestime);
        autotext_servicetime.setAdapter(adapter);

        floatingActionButton.setOnClickListener(v -> {
//           Uri number = Uri.parse("tel:");
//            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
//            startActivity(callIntent);

            String contact = "+91 7525976345"; // use country code with your phone number
            String url = "https://api.whatsapp.com/send?phone=" + contact;
            try {
                PackageManager pm = this.getPackageManager();
                pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } catch (PackageManager.NameNotFoundException e) {
                Toast.makeText(getApplicationContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });



        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       btnSendMsg.setOnClickListener(v -> {
           sendCustomerMessage();

       });

        }

    private void sendCustomerMessage() {
//        if(et_Name == null || et_Name.getText().toString().trim().equals("")) {
//            et_Name.requestFocus();
//            et_Name.setError("please enter name");
//            return;
//        }
//
//        if(et_Email == null || et_Name.getText().toString().trim().equals("")){
//            et_Email.requestFocus();
//            et_Email.setError("please enter email");
//            return;
//        }
//        if(et_Mobile == null || et_Mobile.getText().toString().trim().equals("")){
//            et_Mobile.requestFocus();
//            et_Mobile.setError("please enter mobile");
//            return;
//        }
//        if (autoTextViewSpinner == null || autoTextViewSpinner.getText().toString().trim().equals("")){
//            autoTextViewSpinner.requestFocus();
//            autoTextViewSpinner.setError("please choose the services");
//            return;
//        }
//
//        if(autotext_servicetime == null || autotext_servicetime.getText().toString().trim().equals("")){
//            autotext_servicetime.requestFocus();
//            autotext_servicetime.setError("please service time");
//            return;
//        }
//        if(et_Address == null || et_Address.getText().toString().trim().equals("")){
//            et_Address.requestFocus();
//            et_Address.setError("please enter address");
//            return;
//        }

        String customername = et_Name.getText().toString().trim();
        String customeremail = et_Email.getText().toString().trim();
        String customermobile = et_Mobile.getText().toString().trim();
        String customerservicetype = autoTextViewSpinner.getText().toString().trim();
        String customerservicetime = autotext_servicetime.getText().toString().trim();
        String customeraddress = et_Address.getText().toString().trim();

        if(customername.isEmpty()){
            et_Name.requestFocus();
            et_Name.setError("Please enter name");
            return;
        }
        if(customeremail.isEmpty()){
            et_Email.requestFocus();
            et_Email.setError("Please enter email");
            return;
        }
        if (!customeremail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(customeremail).matches()) {
            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
        if (customermobile.isEmpty() && customermobile.length()!=10){
            et_Mobile.requestFocus();
            et_Mobile.setError("Please enter 10 digits mobile number");
            return;
        }
        if(customerservicetype.isEmpty()){
            autoTextViewSpinner.requestFocus();
            autoTextViewSpinner.setError("Please select service type");
            return;
        }
        if(customerservicetime.isEmpty()){
            autotext_servicetime.requestFocus();
            autotext_servicetime.setError("Please select service time");
            return;
        }
        if(customeraddress.isEmpty()){
            et_Address.requestFocus();
            et_Address.setError("Please enter address");
            return;
        }




        Log.d("apicalling",""+customername+""+customeremail+""+customermobile+""+customerservicetype+""+customerservicetime+""+customeraddress);

        RetrofitClient.getClient().contactData(customername,customeremail,customermobile,customerservicetype,customerservicetime,customeraddress).enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ContactActivity.this, "Send Successfull", Toast.LENGTH_SHORT).show();
                    et_Name.setText("");
                    et_Email.setText("");
                    et_Mobile.setText("");
                    autoTextViewSpinner.setText("");
                    autotext_servicetime.setText("");
                    et_Address.setText("");
                }
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                Toast.makeText(ContactActivity.this, "Not Send", Toast.LENGTH_SHORT).show();

            }
        });



    }
}