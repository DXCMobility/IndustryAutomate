package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import Pojo.Industry;
import Presenter.ConnectionTask;
import Presenter.IClearedDB;
import adapters.FactoryDashboardAdapter;
import example.com.industrialautomation.R;
import models.FactoryDashboard;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment implements IClearedDB {

    private RecyclerView recyclerView;
    private List<FactoryDashboard> factoryDashboards;
    LinearLayout linearDetail,linearRealDevices;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    private View v;


    public Dashboard() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dashboard, container, false);
//        linearDetail= (LinearLayout) v.findViewById(R.id.linearDetails);
//        linearRealDevices= (LinearLayout) v.findViewById(R.id.linearRealDevices);
        recyclerView= (RecyclerView) v.findViewById(R.id.recycler_factory1);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        new ConnectionTask(this,this).execute();
//        initializeData();
//
//        FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
//        recyclerView.setAdapter(factoryDashboardAdapter);



        return v;
    }


        private void initializeData(){
            factoryDashboards = new ArrayList<>();
            ArrayList<Integer> factory1Images=new ArrayList<Integer>();
            ArrayList<String > factory1ImagesText=new ArrayList<>();
            factory1Images.add(R.drawable.assembly_line);
            factory1Images.add(R.drawable.fan);
            factory1Images.add(R.drawable.light_bulb);
            factory1Images.add(R.drawable.cooling);
            factory1ImagesText.add("Assembly Line");
            factory1ImagesText.add("Fan");
            factory1ImagesText.add("Light Bulb");
            factory1ImagesText.add("Cooling System");
            ArrayList<Integer> factory2Images=new ArrayList<Integer>();
            ArrayList<String> factory2ImagesText=new ArrayList<>();
            factory2Images.add(R.drawable.cooling);
            factory2Images.add(R.drawable.alarm);
            factory2Images.add(R.drawable.light_bulb);
            factory2Images.add(R.drawable.assembly_line);
            factory2ImagesText.add("Cooling System");
            factory2ImagesText.add("Alarm");
            factory2ImagesText.add("Light Bulb");
            factory2ImagesText.add("Assembly Line");




            factoryDashboards.add(new FactoryDashboard("Factory 1", "150", "22","23",factory1Images,factory1ImagesText));
            factoryDashboards.add(new FactoryDashboard("Factory 2", "100", "22","23",factory2Images,factory2ImagesText));



        }


    @Override
    public void AutomatedData(ArrayList<Industry> lstIndustry) {
        if(lstIndustry !=null && lstIndustry.size() > 0){

            initializeData();

            FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
//            FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(lstIndustry);
            recyclerView.setAdapter(factoryDashboardAdapter);


        }
    }
}
