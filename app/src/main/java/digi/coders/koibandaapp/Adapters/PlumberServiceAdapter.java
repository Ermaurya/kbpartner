package digi.coders.koibandaapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import digi.coders.koibandaapp.Models.PlumberServiceModel;
import digi.coders.koibandaapp.R;

public class PlumberServiceAdapter extends RecyclerView.Adapter<PlumberServiceAdapter.MyViewHolder>{

    Context context;
    ArrayList<PlumberServiceModel> arrayList;

    public PlumberServiceAdapter(Context context, ArrayList<PlumberServiceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.plumbingservice_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlumberServiceModel plumberServiceModel = arrayList.get(position);
        holder.serviceName.setText(plumberServiceModel.getMcat_name());
        holder.cutPrice.setText(plumberServiceModel.getMain_priz());
        holder.realPrice.setText("₹"+plumberServiceModel.getDiscount());

        holder.linear_aad.setOnClickListener(v -> {
            Toast.makeText(context, "under working next page", Toast.LENGTH_SHORT).show();
        });

        holder.realPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView serviceName,cutPrice,realPrice;
        LinearLayout linear_aad;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceName =itemView.findViewById(R.id.txt_servicename);
            cutPrice =itemView.findViewById(R.id.txt_discountprice);
            realPrice =itemView.findViewById(R.id.txt_maiprise);
            linear_aad =itemView.findViewById(R.id.linear_add);
        }
    }

}
