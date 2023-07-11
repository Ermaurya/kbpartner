package digi.coders.koibandaapp.Activities;

import static java.lang.String.valueOf;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;

import digi.coders.koibandaapp.Models.RegisterModel;
import digi.coders.koibandaapp.R;
import digi.coders.koibandaapp.RetrofitClasses.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliverDetailActivity extends AppCompatActivity {

    MaterialToolbar materialtollbar_deliverDetails;
    LinearLayout linear_decre,linear_incre;
    TextView txt_Quatity,txt_TotalPrise,txt_price,txt_date,txt_time,txt_Addddress,textView_Address
            ,txtWaterName,txtWaterLtr,txt_onetimecharge,selectAddress;
    int clickcount=1;
    String dateTime;
    RadioButton radio_sheduledate;
    RelativeLayout mainRelative;

    EditText edt_Name,edt_Phone,edt_address;
    Button btn_Add;
    BottomSheetDialog  bottomSheetDialogAddress;
    Button btn_book;
    RadioGroup radioGroup_timeShedule;
    RadioButton radioButtontime;
    ProgressBar progress_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_detail);

        materialtollbar_deliverDetails = findViewById(R.id.materialtollbar_deliverDetails);
        linear_decre = findViewById(R.id.linear_decre);
        linear_incre = findViewById(R.id.linear_incre);
        txt_Quatity = findViewById(R.id.txt_Quatity);
        txt_TotalPrise = findViewById(R.id.txt_TotalPrise);
        txt_price = findViewById(R.id.txt_price);
        radio_sheduledate = findViewById(R.id.radio_sheduledate);
        txt_date = findViewById(R.id.txt_date);
        txt_time = findViewById(R.id.txt_time);
        txt_Addddress = findViewById(R.id.txt_Addddress);
        mainRelative = findViewById(R.id.mainRelative);
        textView_Address = findViewById(R.id.textView_Address);
        btn_book = findViewById(R.id.btn_book);
        txtWaterName = findViewById(R.id.txtWaterName);
        txtWaterLtr = findViewById(R.id.txtWaterLtr);
        txt_onetimecharge = findViewById(R.id.txt_onetimecharge);
        selectAddress = findViewById(R.id.selectAddress);

        radioGroup_timeShedule = findViewById(R.id.radioGroup_timeShedule);
        radioButtontime = findViewById(radioGroup_timeShedule.getCheckedRadioButtonId());


        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String Watername = prefs.getString("nameWater", "");
        String Waterltr = prefs.getString("LtrWater", "");
        String WaterPrise = prefs.getString("priceWater", "");
        // Display the user data in the UI elements
        txtWaterName.setText(Watername);
        txtWaterLtr.setText(Waterltr);
        txt_price.setText(WaterPrise);
        txt_TotalPrise.setText(WaterPrise);


        materialtollbar_deliverDetails.setNavigationOnClickListener(v -> {
            finish();
        });

        linear_incre.setOnClickListener(v -> {
            clickcount=clickcount+1;
            if(clickcount==0)
            {
                //first time clicked to do this
                Toast.makeText(getApplicationContext(),"Something Wrong", Toast.LENGTH_LONG).show();
            }
            else
            {
               // clickcount=clickcount+1;
                //check how many times clicked and so on
               // Toast.makeText(getApplicationContext(),"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();
                txt_Quatity.setText(valueOf(clickcount));
                String price = String.valueOf(txt_price.getText());
                int p= Integer.parseInt(price);

                int sum =0;

                sum = sum+p*clickcount;

                txt_TotalPrise.setText(""+sum);
            }

        });
        linear_decre.setOnClickListener(v -> {
            clickcount=clickcount-1;
            if(clickcount==0)
            {
                //first time clicked to do this
               // Toast.makeText(getApplicationContext(),"Something Wrong", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(),RoWaterActivity.class);
                startActivity(intent1);
            }
            else {
                //clickcount=clickcount-1;
                //check how many times clicked and so on
               // Toast.makeText(getApplicationContext(), "Button clicked count is" + clickcount, Toast.LENGTH_LONG).show();
                txt_Quatity.setText(valueOf(clickcount));
                String price = String.valueOf(txt_price.getText());
                int p= Integer.parseInt(price);

                int sum =0;

                sum = sum+p*clickcount;

                    txt_TotalPrise.setText(""+sum);

            }
        });


        radio_sheduledate.setOnClickListener(v -> {
            pickDate();
        });

//        txt_Addddress.setOnClickListener(v -> {
//
//            bottomSheetDialogAddress = new BottomSheetDialog(DeliverDetailActivity.this);
//            View bottomSheetView = LayoutInflater.from(DeliverDetailActivity.this).inflate(R.layout.address_bottomsheet,mainRelative,false);
//            bottomSheetDialogAddress.setContentView(bottomSheetView);
//            bottomSheetDialogAddress.show();
//
//            edt_Name = bottomSheetView.findViewById(R.id.edt_Name);
//            edt_Phone = bottomSheetView.findViewById(R.id.edt_Phone);
//            edt_address = bottomSheetView.findViewById(R.id.edt_address);
//            btn_Add = bottomSheetView.findViewById(R.id.btn_Add);
//            progress_address = bottomSheetView.findViewById(R.id.progress_address);
//
//            SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
//            String name = sharedPreferences.getString("custname", "");
//            String mobile = sharedPreferences.getString("custmobile", "");
//            edt_Name.setText(name);
//            edt_Phone.setText(mobile);
//
//            btn_Add.setOnClickListener(v1 -> {
//               // getAddressMethod();
//                progress_address.setVisibility(View.VISIBLE);
//
//                String Name =  edt_Name.getText().toString().trim();
//                String Phone =  edt_Phone.getText().toString().trim();
//                String Addreess =  edt_address.getText().toString().trim();
//
//
//                String Email = sharedPreferences.getString("custemail", "");
//
//                RetrofitClient.getClient().updateRoWaterAddress(Email,Name,Phone,Addreess).enqueue(new Callback<RegisterModel>() {
//                    @Override
//                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//                        if(response.isSuccessful()){
//                            progress_address.setVisibility(View.GONE);
//                            Toast.makeText(DeliverDetailActivity.this, " Save your  address Succefully", Toast.LENGTH_SHORT).show();
//
//                            SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("caddress", Addreess);
//                            editor.apply();
//
//                            bottomSheetDialogAddress.dismiss();
//                        }else {
//                            progress_address.setVisibility(View.GONE);
//                            Toast.makeText(DeliverDetailActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<RegisterModel> call, Throwable t) {
//                        progress_address.setVisibility(View.GONE);
//                        Toast.makeText(DeliverDetailActivity.this, "Not Save your Address", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//
//                SharedPreferences sharedPreferences2 = getSharedPreferences("myPrefs", MODE_PRIVATE);
//                String nameaa = sharedPreferences2.getString("custname", "");
//                String phoneaa = sharedPreferences2.getString("custmobile", "");
//                String addreess = sharedPreferences2.getString("caddress", "");
//
//                edt_Name.setText(nameaa);
//                edt_Phone.setText(phoneaa);
//                edt_address.setText(addreess);
//                textView_Address.setText(nameaa+"\n"+phoneaa+"\n"+addreess);
//
//
//
//            });
//
//
//        });
        txt_Addddress.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),AddNewAddressActivity.class);
            startActivity(intent);
            finish();
        });

        selectAddress.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MyAddressActivity.class);
            startActivity(intent);
            finish();
        });
        SharedPreferences sharedPreferences3 = getSharedPreferences("AddressPre",MODE_PRIVATE);
        String Name=sharedPreferences3.getString("CustName","");
        String MobileNmber=sharedPreferences3.getString("CustMobile","");
        String FulllAddr = sharedPreferences3.getString("FullAddress","");

        textView_Address.setText(Name+"\n"+MobileNmber+"\n"+FulllAddr);




        btn_book.setOnClickListener(v -> {


            String deliveryTime = ((RadioButton)findViewById(radioGroup_timeShedule.getCheckedRadioButtonId())).getText().toString();


            String quantity = txt_Quatity.getText().toString();
            String toatalPrice = txt_TotalPrise.getText().toString();
            String data = txt_date.getText().toString();
            String time = txt_time.getText().toString();
            String dataTime =deliveryTime+","+data+","+time;
            SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Qnty",quantity);
            editor.putString("totalAmount",toatalPrice);
            editor.putString("datetime",dataTime);
           // editor.putString("deliverytime",deliveryTime);
            editor.apply();

            Intent intent2 = new Intent(getApplicationContext(),PaymentActivity.class);
            intent2.putExtra("totalamount",toatalPrice);
            startActivity(intent2);
            finish();

        });


    }



    public  void pickDate(){


                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        DeliverDetailActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                txt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                txt_date.setVisibility(View.VISIBLE);


                                pickTime();

                            }
                        },

                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
      //  datePickerDialog.getDatePicker().setBackgroundColor(0xFF500000);


                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }


            public void pickTime(){

                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(DeliverDetailActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // on below line we are setting selected time
                                // in our text view.
                                txt_time.setText(hourOfDay + ":" + minute);
                                txt_time.setVisibility(View.VISIBLE);
                            }
                        }, hour, minute, false);
                // at last we are calling show to
                // display our time picker dialog.
                timePickerDialog.show();

            }

    //private void getAddressMethod() {
//      String Name =  edt_Name.getText().toString().trim();
//      String Phone =  edt_Phone.getText().toString().trim();
//      String Addreess =  edt_address.getText().toString().trim();
//
//        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
//        String Email = prefs.getString("custemail", "");
//
//        RetrofitClient.getClient().updateRoWaterAddress(Email,Name,Phone,Addreess).enqueue(new Callback<RegisterModel>() {
//            @Override
//            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(DeliverDetailActivity.this, "Save Address Succefull", Toast.LENGTH_SHORT).show();
//
//                    SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("caddress", Addreess);
//                    editor.apply();
//
//                    bottomSheetDialogAddress.dismiss();
//                }else {
//                    Toast.makeText(DeliverDetailActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterModel> call, Throwable t) {
//                Toast.makeText(DeliverDetailActivity.this, "Not Save Address", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
//        String name = sharedPreferences.getString("custname", "");
//        String phone = sharedPreferences.getString("custmobile", "");
//        String addreess = sharedPreferences.getString("caddress", "");
//
//        edt_Name.setText(name);
//        edt_Phone.setText(phone);
//        edt_address.setText(addreess);
//        textView_Address.setText(name+"\n"+phone+"\n"+addreess);
//


    }

