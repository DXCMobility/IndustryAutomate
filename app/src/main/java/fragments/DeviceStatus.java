package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import config.Endpoint;
import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceStatus extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private RecyclerView recyclerView;
    LinearLayout linearDetail,linearRealDevices;
    Switch swchAssembly,swchLoads,swchCooling;


    Firebase ref;

    private View v;

    public DeviceStatus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_device_status, container, false);
        swchAssembly=(Switch)v.findViewById(R.id.switch_assembly);
        swchCooling=(Switch)v.findViewById(R.id.switch_cooling);
        swchLoads=(Switch)v.findViewById(R.id.switch_loads);




        swchAssembly.setOnCheckedChangeListener(this);
        swchLoads.setOnCheckedChangeListener(this);
        swchCooling.setOnCheckedChangeListener(this);



        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        Firebase.setAndroidContext(getActivity());
        ref=new Firebase(Endpoint.FIREBASE_SWITCH_URL);
        System.out.print("");


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.switch_assembly:
                Toast.makeText(getActivity(), ""+b, Toast.LENGTH_SHORT).show();
//                ToggleAssembly(b);
                ref.child("assembly_line").child("status").setValue(b);
                break;
            case R.id.switch_cooling:
                Toast.makeText(getActivity(), ""+b, Toast.LENGTH_SHORT).show();
                ref.child("assembly_cooling_fan").child("status").setValue(b);
                break;
            case R.id.switch_loads:
                Toast.makeText(getActivity(), ""+b, Toast.LENGTH_SHORT).show();
                ref.child("generic_fan").child("status").setValue(b);
                break;
        }
    }

    private void ToggleAssembly(boolean b) {
        //ref.child("status").setValue("vallup");

    }
}
