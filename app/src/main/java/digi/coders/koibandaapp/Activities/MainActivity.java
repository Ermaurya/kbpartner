package digi.coders.koibandaapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import digi.coders.koibandaapp.Fragments.AboutFragment;
import digi.coders.koibandaapp.Fragments.HomeFragment;
import digi.coders.koibandaapp.Fragments.MyAccountFragment;
import digi.coders.koibandaapp.Fragments.MyOrdersFragment;
import digi.coders.koibandaapp.R;

public class MainActivity extends AppCompatActivity {

    ImageView imagesPoster;
    BottomNavigationView bottomNavigationView;

    MaterialToolbar materialToolbar;
    Fragment fragment;
    ImageView img_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnavigation_View);
        img_profile =findViewById(R.id.img_profile);

        img_profile.setOnClickListener(v -> {
            Intent intent  = new Intent(getApplicationContext(),MyAccountActivity.class);
            startActivity(intent);
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();





        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               int id = item.getItemId();

               switch (id)
               {
                   case R.id.home_nav:
                       fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
                       break;
                   case R.id.about_nav:
                       Intent intent1 = new Intent(getApplicationContext(),YourOrderActivity.class);
                       startActivity(intent1);
                      // fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new AboutFragment()).commit();
                       break;
//                   case R.id.whybest_nav:
//                       Intent intent1 = new Intent(getApplicationContext(),WhyBestActivity.class);
//                       startActivity(intent1);
//                       //fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new MyOrdersFragment()).commit();
//                       break;

                   case R.id.contact_nav:
                       Intent intent = new Intent(getApplicationContext(),NotificationPreferenceActivity.class);
                       startActivity(intent);
                       //fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new ContactFragment()).commit();
                       break;
                   case R.id.account_nav:
                       String contact = "+91 8470920996"; // use country code with your phone number
                       String url = "https://api.whatsapp.com/send?phone=" + contact;
                       try {
                           PackageManager pm = getBaseContext().getPackageManager();
                           pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                           Intent i = new Intent(Intent.ACTION_VIEW);
                           i.setData(Uri.parse(url));
                           startActivity(i);
                       } catch (PackageManager.NameNotFoundException e) {
                           Toast.makeText(getApplicationContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                           e.printStackTrace();
                       }

//                       fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new MyAccountFragment()).commit();
//                       break;
                   default:
                       fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
               }

                return true;
            }
        });

////////////////////////////////////////////////



    }
}