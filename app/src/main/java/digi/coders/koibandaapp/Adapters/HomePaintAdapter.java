package digi.coders.koibandaapp.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import digi.coders.koibandaapp.Models.PaintServiceModel;
import digi.coders.koibandaapp.R;

public class HomePaintAdapter extends RecyclerView.Adapter<HomePaintAdapter.MyViewHolder>{

    Context context;
    ArrayList<PaintServiceModel> arrayList;

    public HomePaintAdapter(Context context, ArrayList<PaintServiceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homepaintservice_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PaintServiceModel paintServiceModel = arrayList.get(position);
        holder.txtpaint_servicename.setText(paintServiceModel.getMcat_name());
        holder.txtpaint_cutPrise.setText(paintServiceModel.getDiscount());
        holder.txtpaint_realprise.setText(paintServiceModel.getMain_priz());

        holder.txtpaint_cutPrise.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtpaint_servicename,txtpaint_cutPrise,txtpaint_realprise;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtpaint_servicename=itemView.findViewById(R.id.txtpaint_servicename);
            txtpaint_cutPrise=itemView.findViewById(R.id.txtpaint_cutPrise);
            txtpaint_realprise=itemView.findViewById(R.id.txtpaint_realprise);
        }
    }
}
