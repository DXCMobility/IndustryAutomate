package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.industrialautomation.R;
import models.FactoryDashboard;

/**
 * Created by kumardev on 2/3/2017.
 */

public class FactoryDashboardAdapter extends RecyclerView.Adapter<FactoryDashboardAdapter.FactoryViewHolder>  {

    private LinearLayout layoutOne,layoutTwo;

    List<FactoryDashboard> factoryDashboards;
    public FactoryDashboardAdapter(List<FactoryDashboard> factoryDashboards) {
                this.factoryDashboards=factoryDashboards;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public FactoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.factory_card, parent, false);
        FactoryViewHolder factoryView = new FactoryViewHolder(v);
        return factoryView;

    }

    @Override
    public void onBindViewHolder(final FactoryViewHolder holder, int position) {
        holder.factory.setText(factoryDashboards.get(position).getFactory());
        holder.power_consumption.setText(factoryDashboards.get(position).getPower_consumption());
        holder.temp.setText(factoryDashboards.get(position).getTemp());
        holder.humidity.setText(factoryDashboards.get(position).getHumidity());
        layoutOne=holder.linearDetail;
        layoutTwo=holder.linearRealDevices;
        ArrayList<Integer> images=factoryDashboards.get(position).getImages();
        holder.image1.setImageResource(images.get(0));
        holder.image2.setImageResource(images.get(1));
        holder.image3.setImageResource(images.get(2));
        if(3<images.size()) {
            holder.image4.setImageResource(images.get(3));
        }



    }



    @Override
    public int getItemCount() {
        return factoryDashboards.size();
    }

    public static class FactoryViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView status,power_consumption,temp,humidity,factory;
        ImageView image1,image2,image3,image4;
        LinearLayout linearDetail,linearRealDevices;

        FactoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.factoryCard);
            factory=(TextView)itemView.findViewById(R.id.cardFactory);
            power_consumption = (TextView)itemView.findViewById(R.id.tvPowerConsumption);
            temp = (TextView)itemView.findViewById(R.id.tvTemp);
            humidity = (TextView)itemView.findViewById(R.id.tvHumidity);
            image1=(ImageView)itemView.findViewById(R.id.image1);
            image2=(ImageView)itemView.findViewById(R.id.image2);
            image3=(ImageView)itemView.findViewById(R.id.image3);
            image4=(ImageView)itemView.findViewById(R.id.image4);
        }
    }
}
