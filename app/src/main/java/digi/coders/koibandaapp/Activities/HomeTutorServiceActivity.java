package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import digi.coders.koibandaapp.Adapters.TutorViewPagerAdapter;
import digi.coders.koibandaapp.R;

public class HomeTutorServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbarHomeTutor;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabitem1,tabitem2,tabitem3,tabitem4,tabitem5,tabitem6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tutor_service);

        materialToolbarHomeTutor = findViewById(R.id.materialToolbar_hometutor);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        tabitem1 =findViewById(R.id.tabitem1);
        tabitem2 =findViewById(R.id.tabitem2);
        tabitem3 =findViewById(R.id.tabitem3);
        tabitem4 =findViewById(R.id.tabitem4);
        tabitem5 =findViewById(R.id.tabitem5);
        tabitem6 =findViewById(R.id.tabitem6);

        TutorViewPagerAdapter viewPagerAdapter = new TutorViewPagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 ||tab.getPosition()==2 ||tab.getPosition()==3|| tab.getPosition()==4 || tab.getPosition()==5){
                    viewPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));






        onclickableMthod();


    }

    private void onclickableMthod() {
        materialToolbarHomeTutor.setNavigationOnClickListener(v -> {
           finish();
        });

    }
}