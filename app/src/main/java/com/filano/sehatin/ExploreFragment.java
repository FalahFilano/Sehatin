package com.filano.sehatin;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Toolbar toolbar;

    private String course ="Explore";


    ArrayList<Course> itemList;

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager, layoutManager2;
    private ExploreAdapter exploreAdapter;


    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView  = inflater.inflate(R.layout.activity_main, container, false);

        //String course = "Explore";

         toolbar = (Toolbar) rootView.findViewById(R.id.main_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout collapsingToolbar = rootView.findViewById(R.id.main_collapsing);
        collapsingToolbar.setTitle(course);

        //Recycler
        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = rootView.findViewById(R.id.rvPaha);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2 = rootView.findViewById(R.id.rvPernapasan);
        recyclerView2.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);

        exploreAdapter = new ExploreAdapter(itemList);
        recyclerView.setAdapter(exploreAdapter);
        recyclerView2.setAdapter(exploreAdapter);

        return rootView;
    }

    private void generateItemList() {
        itemList.add(new Course("Bersepeda", getResources().getDrawable(R.drawable.cycle,null)));
        itemList.add(new Course("Jogging ", getResources().getDrawable(R.drawable.jogging,null)));
        itemList.add(new Course("Sit Up", getResources().getDrawable(R.drawable.situp,null)));

    }


}
