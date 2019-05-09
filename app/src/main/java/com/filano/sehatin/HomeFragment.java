package com.filano.sehatin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<ActivityItem> itemList2;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);



        recyclerView = rootView.findViewById(R.id.rvhome);
        itemList2 = new ArrayList<>();
        itemList2.add(new ActivityItem(R.drawable.cycle,"Bersepeda","TRAIN","250","20"));
        itemList2.add(new ActivityItem(R.drawable.jogging,"Lari","TRAIN","100","45"));
        itemList2.add(new ActivityItem(R.drawable.situp,"Sit Up","TRAIN","100","10"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rvHomeLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvHomeLayoutManager);

        HomeAdapter adapter = new HomeAdapter(getContext(),itemList2);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
