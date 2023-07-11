package digi.coders.koibandaapp.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import digi.coders.koibandaapp.Activities.LoginActivity;
import digi.coders.koibandaapp.Activities.MyAddressActivity;
import digi.coders.koibandaapp.Activities.UpdateProfileActivity;
import digi.coders.koibandaapp.R;


public class MyAccountFragment extends Fragment {

    MaterialCardView card_updateprofile,card_myaddress,card_logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_services, container, false);

        card_updateprofile = view.findViewById(R.id.card_updateprofile);
        card_myaddress = view.findViewById(R.id.card_myaddress);
        card_logout = view.findViewById(R.id.card_logout);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LoginData", Context.MODE_PRIVATE);
        sharedPreferences.getString("email","");
        sharedPreferences.getString("password","");


        card_updateprofile.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), UpdateProfileActivity.class);
            startActivity(intent);
        });
        card_myaddress.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MyAddressActivity.class);
            startActivity(intent);
        });

        card_logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Do you want to logout");
            builder.setTitle("Alert!");
            builder.setCancelable(false);

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("email");
                    editor.remove("password");
                    editor.remove("customerLoginStatus");
                    editor.commit();

                    Intent intent = new Intent(getContext(),LoginActivity.class);
                    startActivity(intent);

                }
            });
            builder.show();

        });


        return view;
    }
}