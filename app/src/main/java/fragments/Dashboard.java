package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapters.FactoryDashboardAdapter;
import example.com.industrialautomation.R;
import models.FactoryDashboard;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<FactoryDashboard> factoryDashboards;
    LinearLayout linearDetail,linearRealDevices;

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
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        initializeData();
        FactoryDashboardAdapter factoryDashboardAdapter=new FactoryDashboardAdapter(factoryDashboards);
        recyclerView.setAdapter(factoryDashboardAdapter);



        return v;
    }


        private void initializeData(){
            factoryDashboards = new ArrayList<>();
            factoryDashboards.add(new FactoryDashboard("true", "50", "30","10"));
            factoryDashboards.add(new FactoryDashboard("false", "90", "20","9"));



        }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearDetails:
                if(linearRealDevices.getVisibility()==View.VISIBLE){
                    linearRealDevices.setVisibility(View.GONE);
                }else {
                    linearRealDevices.setVisibility(View.VISIBLE);
                }

                break;
        }
    }
}
