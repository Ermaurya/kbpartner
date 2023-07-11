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

import digi.coders.koibandaapp.Models.HomeCleanServiceModel;
import digi.coders.koibandaapp.R;

public class HomeCleanAdapter extends RecyclerView.Adapter<HomeCleanAdapter.MyViwHolder>{

    Context context;
    ArrayList<HomeCleanServiceModel> arrayList;

    public HomeCleanAdapter(Context context, ArrayList<HomeCleanServiceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<HomeCleanServiceModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HomeCleanServiceModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViwHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homeclean_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViwHolder holder, int position) {
        HomeCleanServiceModel homeCleanServiceModel = arrayList.get(position);
        holder.txtHomeclean_servicename.setText(homeCleanServiceModel.getMcat_name());
        holder.txtHomeclean_cutprise.setText("₹"+homeCleanServiceModel.getMain_priz());
        holder.txtHomeclean_realprice.setText(homeCleanServiceModel.getDiscount());

        holder.txtHomeclean_cutprise.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  MyViwHolder extends RecyclerView.ViewHolder {

        TextView txtHomeclean_servicename,txtHomeclean_cutprise,txtHomeclean_realprice;
        public MyViwHolder(@NonNull View itemView) {
            super(itemView);

            txtHomeclean_servicename = itemView.findViewById(R.id.txtHomeclean_servicename);
            txtHomeclean_cutprise = itemView.findViewById(R.id.txtHomeclean_cutprise);
            txtHomeclean_realprice = itemView.findViewById(R.id.txtHomeclean_realprice);

        }
    }
}
