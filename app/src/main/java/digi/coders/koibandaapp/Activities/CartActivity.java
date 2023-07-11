package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import digi.coders.koibandaapp.R;

public class CartActivity extends AppCompatActivity implements PaymentResultWithDataListener {

    TextView textPay,textToalAmount;
    MaterialToolbar materialToolbarCart;
    MaterialCardView cardPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        materialToolbarCart = findViewById(R.id.materialToolbar_cart);
        textPay = findViewById(R.id.txt_pay);
        textToalAmount = findViewById(R.id.txt_totalamount);

        Checkout.preload(getApplicationContext());
     //   Checkout checkout = new Checkout();
     //   checkout.setKeyID("rzp_test_HNgCYoQZ9HmHb2");


        clickableMethod();
       // startPayment();



    }

    private void clickableMethod() {
        materialToolbarCart.setNavigationOnClickListener(v -> {
            finish();
        });

        textPay.setOnClickListener(v -> {
            startPayment();
        });
    }
//
public void startPayment() {
    /**
     * Instantiate Checkout
     */
    Checkout checkout = new Checkout();
    checkout.setKeyID("rzp_test_HNgCYoQZ9HmHb2");

    /**
     * Set your logo here
     */
    //checkout.setImage(R.drawable.logo);

    /**
     * Reference to current activity
     */
   // final Activity activity = this;

    /**
     * Pass your payment options to the Razorpay Checkout as a JSONObject
     */
    try {
        JSONObject options = new JSONObject();

        options.put("name", "Merchant Name");
        options.put("description", "Reference No. #123456");
        options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
        options.put("order_id", "order_LVEHpjz3hZUi2T");//from response of step 3.
        options.put("theme.color", "#3399cc");
        options.put("currency", "INR");
        options.put("amount","500");//pass amount in currency subunits
        options.put("prefill.email", "amitsingh955597@example.com");
        options.put("prefill.contact","9555972957");
        JSONObject retryObj = new JSONObject();
        retryObj.put("enabled", true);
        retryObj.put("max_count", 4);
        options.put("retry", retryObj);

        checkout.open(CartActivity.this, options);

    } catch(Exception e) {
        Log.d("PaymentGatWay", "Error in starting Razorpay Checkout", e);
    }
}

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();

    }
//
}