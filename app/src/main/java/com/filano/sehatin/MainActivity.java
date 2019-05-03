package com.filano.sehatin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ExploreAdapter exploreAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvCourse);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        exploreAdapter = new ExploreAdapter(itemList);
        recyclerView.setAdapter(exploreAdapter);
    }

    private void generateItemList() {
        itemList.add(new Course("Bersepeda", getResources().getDrawable(R.drawable.cycle, getTheme())));
        itemList.add(new Course("Minum Jembut", getResources().getDrawable(R.drawable.cycle, getTheme())));
        itemList.add(new Course("Ericko Jemb", getResources().getDrawable(R.drawable.cycle, getTheme())));
    }
}
