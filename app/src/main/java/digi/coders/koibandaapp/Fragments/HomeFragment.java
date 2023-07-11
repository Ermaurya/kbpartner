package digi.coders.koibandaapp.Fragments;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import digi.coders.koibandaapp.Activities.AllServiceActivity;
import digi.coders.koibandaapp.Activities.CarpentryServiceActivity;
import digi.coders.koibandaapp.Activities.ContactActivity;
import digi.coders.koibandaapp.Activities.CookServiceActivity;
import digi.coders.koibandaapp.Activities.DanceTeacherServiceActivity;
import digi.coders.koibandaapp.Activities.ElectricianServiceActivity;
import digi.coders.koibandaapp.Activities.GymTrainnerServiceActivity;
import digi.coders.koibandaapp.Activities.HomeMaidServiceActivity;
import digi.coders.koibandaapp.Activities.HomePaintingServiceActivity;
import digi.coders.koibandaapp.Activities.HomeTutorServiceActivity;
import digi.coders.koibandaapp.Activities.HowWorkActivity;
import digi.coders.koibandaapp.Activities.LoginActivity;
import digi.coders.koibandaapp.Activities.PlumbingServiceActivity;
import digi.coders.koibandaapp.Activities.RegisterActivity;
import digi.coders.koibandaapp.Activities.RoWaterActivity;
import digi.coders.koibandaapp.Activities.WhyBestActivity;
import digi.coders.koibandaapp.Activities.YogaTeacherServiceActivity;
import digi.coders.koibandaapp.Adapters.SliderAdapter;
import digi.coders.koibandaapp.Models.SliderItem;
import digi.coders.koibandaapp.R;


public class HomeFragment extends Fragment  {

    ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

TextView txtcut_prise,txtcut_prise2,txtcut_prise3,txtcut_prise4,txtcut_prise5,txtcut_prise6,txtcut_prise7,txtcut_prise8,txtcut_prise9,txtcut_prise10,txtcut_prise11,txtcut_prise12;
 ImageSlider imageSlider;
  MaterialCardView card1Hometutor,card2GymTraner,card3Plumbing,card4DanceTeacher,card5Carpentry,card6Cook,card7YogaTeacher,card8HomeMaid
    ,card_electrician,card_homepaint,card_pg,card_education,card_beauty,card_rent,card_consultant,card_job,card_rowater;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);




        card1Hometutor = view.findViewById(R.id.card1_hometutor);
        card2GymTraner = view.findViewById(R.id.card2_gymtrainner);
        card3Plumbing = view.findViewById(R.id.card3_plumbing);
        card4DanceTeacher = view.findViewById(R.id.card4_danceteacher);
        card5Carpentry = view.findViewById(R.id.card5_carpentry);
        card6Cook= view.findViewById(R.id.card6_cook);
        card7YogaTeacher = view.findViewById(R.id.card7_yogatrainner);
        card8HomeMaid = view.findViewById(R.id.card8_homemaid);
        card_education = view.findViewById(R.id.card_education);
        card_rowater = view.findViewById(R.id.card_rowater);

        card_pg= view.findViewById(R.id.card_pg);
        card_homepaint = view.findViewById(R.id.card_homepaint);
        card_electrician = view.findViewById(R.id.card_electrician);
        card_beauty = view.findViewById(R.id.card_beauty);
        card_rent = view.findViewById(R.id.card_rent);
        card_consultant = view.findViewById(R.id.card_consultant);
        card_job = view.findViewById(R.id.card_job);
//..start handle price cut
        txtcut_prise= view.findViewById(R.id.txtcut_prise);
        txtcut_prise2=view.findViewById(R.id.txtcut_prise2);
        txtcut_prise3=view.findViewById(R.id.txtcut_prise3);
        txtcut_prise4=view.findViewById(R.id.txtcut_prise4);
        txtcut_prise5=view.findViewById(R.id.txtcut_prise5);
        txtcut_prise6=view.findViewById(R.id.txtcut_prise6);
        txtcut_prise7=view.findViewById(R.id.txtcut_prise7);
        txtcut_prise8=view.findViewById(R.id.txtcut_prise8);
        txtcut_prise9=view.findViewById(R.id.txtcut_prise9);
        txtcut_prise10=view.findViewById(R.id.txtcut_prise10);
        txtcut_prise11=view.findViewById(R.id.txtcut_prise11);
        txtcut_prise12=view.findViewById(R.id.txtcut_prise12);


        txtcut_prise.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise2.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise3.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise4.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise5.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise6.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise7.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise8.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise9.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise10.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise11.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        txtcut_prise12.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

 //..end price cut

        viewPager2 = view.findViewById(R.id.viewPagerImageSlider);
//start this code handle offer slider
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.todayofer1));
        sliderItems.add(new SliderItem(R.drawable.todayofer2));
        sliderItems.add(new SliderItem(R.drawable.todayofer3));
        sliderItems.add(new SliderItem(R.drawable.todayofer4));
        sliderItems.add(new SliderItem(R.drawable.todayofer5));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });

//end offer slider


//start first slider handle
       ArrayList<SlideModel> imageList = new ArrayList<>();
       imageList.add(new SlideModel("https://forexmillionersclub.com/appimg/Bannner.jpg",ScaleTypes.FIT));
       imageList.add(new SlideModel("https://forexmillionersclub.com/appimg/Bannner1.jpg",ScaleTypes.FIT));
       imageList.add(new SlideModel("https://forexmillionersclub.com/appimg/Bannner2.jpg",ScaleTypes.FIT));
       imageSlider = view.findViewById(R.id.image_slider);
       imageSlider.setImageList(imageList);
//first slider end


        imageClickMethod();
        return view;
    }

    private void imageClickMethod() {
        card1Hometutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeTutorServiceActivity.class);
                startActivity(intent);
            }
        });

        card2GymTraner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GymTrainnerServiceActivity.class);
                startActivity(intent);
            }
        });

        card3Plumbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PlumbingServiceActivity.class);
                startActivity(intent);
            }
        });

        card4DanceTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        card5Carpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CarpentryServiceActivity.class);
                startActivity(intent);
            }
        });

        card6Cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        card7YogaTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        card8HomeMaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeMaidServiceActivity.class);
                startActivity(intent);
            }
        });


        card_pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.customcard_popup, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("OK", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//                EditText editText = customLayout.findViewById(R.id.editText);
//                sendDialogDataToActivity(editText.getText().toString());
                    Intent intent = new Intent(getContext(), ContactActivity.class);
                    startActivity(intent);

                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();




            }
        });
        //
        card_electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ElectricianServiceActivity.class);
                startActivity(intent);
            }
        });
        card_homepaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomePaintingServiceActivity.class);
                startActivity(intent);
            }
        });
        card_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        card_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        card_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        card_consultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        card_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        card_rowater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RoWaterActivity.class);
                startActivity(intent);
            }
        });




    }
    //handle offer slider
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };


}