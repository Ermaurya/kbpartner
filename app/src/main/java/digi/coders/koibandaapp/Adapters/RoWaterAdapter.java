package digi.coders.koibandaapp.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import digi.coders.koibandaapp.Activities.DeliverDetailActivity;
import digi.coders.koibandaapp.Models.RoWaterModel;
import digi.coders.koibandaapp.R;

public class RoWaterAdapter extends RecyclerView.Adapter<RoWaterAdapter.MyViewHolder>{
Context context;
List<RoWaterModel> roWaterModelList;

    public RoWaterAdapter(Context context, List<RoWaterModel> roWaterModelList) {
        this.context = context;
        this.roWaterModelList = roWaterModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rowater_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RoWaterModel roWaterModel = roWaterModelList.get(position);
        holder.robottlelImg.setImageResource(roWaterModel.getWaterImg());
        holder.robottlelName.setText(roWaterModel.getWaterName());
        holder.robottleLtr.setText(roWaterModel.getWaterLitter());
        holder.robottlelPise.setText(roWaterModel.getWaterPrice());

        holder.linearWaterAddCart.setOnClickListener(v -> {
            Intent intent = new Intent(context, DeliverDetailActivity.class);
            context.startActivity(intent);

            SharedPreferences prefs = context.getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nameWater",roWaterModel.getWaterName());
        editor.putString("LtrWater",roWaterModel.getWaterLitter());
        editor.putString("priceWater",roWaterModel.getWaterPrice());
        editor.apply();




        });

    }

    @Override
    public int getItemCount() {
        return roWaterModelList.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        ImageView robottlelImg;
        TextView robottlelName,robottleLtr,robottlelPise;
        LinearLayout linearWaterAddCart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            robottlelImg = itemView.findViewById(R.id.robottlelImg);
            robottlelName = itemView.findViewById(R.id.robottlelName);
            robottleLtr = itemView.findViewById(R.id.robottleLtr);
            robottlelPise = itemView.findViewById(R.id.robottlelPise);
            linearWaterAddCart = itemView.findViewById(R.id.linearWaterAddCart);
        }
    }
}
