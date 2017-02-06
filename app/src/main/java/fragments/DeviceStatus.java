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

import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceStatus extends Fragment {
    private RecyclerView recyclerView;
    LinearLayout linearDetail,linearRealDevices;

    private View v;

    public DeviceStatus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_device_status, container, false);

        return v;
    }


}
