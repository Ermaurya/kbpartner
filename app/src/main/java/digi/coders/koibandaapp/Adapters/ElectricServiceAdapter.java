package digi.coders.koibandaapp.Adapters;

import android.content.Context;
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

import digi.coders.koibandaapp.Models.ElectricServiceModel;
import digi.coders.koibandaapp.R;

public class ElectricServiceAdapter extends RecyclerView.Adapter<ElectricServiceAdapter.MyViewHolder>{

    Context context;
    ArrayList<ElectricServiceModel> arrayList;

    public ElectricServiceAdapter(Context context, ArrayList<ElectricServiceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.electricianservice_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ElectricServiceModel electricServiceModel = arrayList.get(position);
        holder.txtele_serviceName.setText(electricServiceModel.getMcat_name());
        holder.txtele_cutPrise.setText("₹"+electricServiceModel.getDiscount());
        holder.txtele_realPrise.setText(electricServiceModel.getMain_priz());

        holder.linear_eleAdd.setOnClickListener(v -> {
            Toast.makeText(context, "Under working next page", Toast.LENGTH_SHORT).show();
        });
        holder.txtele_cutPrise.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtele_serviceName,txtele_cutPrise,txtele_realPrise;
        LinearLayout linear_eleAdd;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtele_serviceName = itemView.findViewById(R.id.txtele_serviceName);
            txtele_cutPrise = itemView.findViewById(R.id.txtele_cutPrise);
            txtele_realPrise = itemView.findViewById(R.id.txtele_realPrise);
            linear_eleAdd = itemView.findViewById(R.id.linear_eleAdd);
        }
    }

}
