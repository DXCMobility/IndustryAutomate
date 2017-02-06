package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceStatus extends Fragment {

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