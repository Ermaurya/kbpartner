package digi.coders.koibandaapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import digi.coders.koibandaapp.Activities.AboutActivity;
import digi.coders.koibandaapp.Activities.ContactActivity;
import digi.coders.koibandaapp.Activities.HowWorkActivity;
import digi.coders.koibandaapp.Activities.WhyBestActivity;
import digi.coders.koibandaapp.R;


public class AboutFragment extends Fragment {

MaterialCardView card_aboutbanda,card_howwork,card_whybest,card_ourservicepolicy,card_securitysolution,card_contactus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        card_aboutbanda = view.findViewById(R.id.card_aboutbanda);
        card_howwork = view.findViewById(R.id.card_howwork);
        card_whybest = view.findViewById(R.id.card_whybest);
        card_ourservicepolicy = view.findViewById(R.id.card_ourservicepolicy);
        card_securitysolution = view.findViewById(R.id.card_securitysolution);
        card_contactus = view.findViewById(R.id.card_contactus);

        card_aboutbanda.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AboutActivity.class);
            startActivity(intent);

        });
        card_howwork.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), HowWorkActivity.class);
            startActivity(intent);

        });
        card_whybest.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), WhyBestActivity.class);
            startActivity(intent);

        });
        card_ourservicepolicy.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Now working this activity", Toast.LENGTH_SHORT).show();

        });
        card_securitysolution.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Now working this activity", Toast.LENGTH_SHORT).show();

        });
        card_contactus.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ContactActivity.class);
            startActivity(intent);

        });


        return view;
    }
}