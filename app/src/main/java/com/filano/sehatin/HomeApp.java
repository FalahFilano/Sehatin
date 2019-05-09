package com.filano.sehatin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeApp extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ActivityItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);


        recyclerView = findViewById(R.id.rvhome);
        itemList = new ArrayList<>();
        itemList.add(new ActivityItem(R.drawable.cycle,"Bersepeda","TRAIN","250","20"));
        itemList.add(new ActivityItem(R.drawable.jogging,"Lari","TRAIN","100","45"));
        itemList.add(new ActivityItem(R.drawable.situp,"Sit Up","TRAIN","100","10"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvHomeLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvHomeLayoutManager);

        HomeAdapter adapter = new HomeAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
    }
}
