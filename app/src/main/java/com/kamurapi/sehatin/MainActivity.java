package com.kamurapi.sehatin;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.filano.sehatin.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> itemList;

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager, layoutManager2;
    private ExploreAdapter exploreAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CollapsedMenu
        final String course = "Explore";

        final Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.main_collapsing);
        collapsingToolbar.setTitle(course);

        //Recycler
        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvPaha);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2 = findViewById(R.id.rvPernapasan);
        recyclerView2.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);

        exploreAdapter = new ExploreAdapter(itemList);
        recyclerView.setAdapter(exploreAdapter);
        recyclerView2.setAdapter(exploreAdapter);
    }

    private void generateItemList() {
        itemList.add(new Course("Bersepeda", getResources().getDrawable(R.drawable.cycle, getTheme())));
        itemList.add(new Course("Jogging ", getResources().getDrawable(R.drawable.jogging, getTheme())));
        itemList.add(new Course("Sit Up", getResources().getDrawable(R.drawable.situp, getTheme())));
    }
}
