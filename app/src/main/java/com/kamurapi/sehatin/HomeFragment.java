package com.kamurapi.sehatin;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.filano.sehatin.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button button_mulai;
    RecyclerView recyclerView;
    ArrayList<ActivityItem> itemList2;
    private BottomNavigationView mMainNav;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);

        button_mulai = (Button) rootView.findViewById(R.id.mulai_activity);
        mMainNav = (BottomNavigationView) rootView.findViewById(R.id.mainNav);

        recyclerView = rootView.findViewById(R.id.rvhome);
        itemList2 = new ArrayList<>();
        itemList2.add(new ActivityItem(getResources().getDrawable(R.drawable.cycle,null),"Bersepeda","TRAIN","250","20"));
        itemList2.add(new ActivityItem(getResources().getDrawable(R.drawable.jogging,null),"Lari","TRAIN","100","45"));
        itemList2.add(new ActivityItem(getResources().getDrawable(R.drawable.situp,null),"Sit Up","TRAIN","100","10"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rvHomeLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvHomeLayoutManager);

        HomeAdapter adapter = new HomeAdapter(getContext(),itemList2);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
