package com.kamurapi.sehatin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.filano.sehatin.R;

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
        itemList.add(new ActivityItem(getResources().getDrawable(R.drawable.cycle,null),"Bersepeda","TRAIN","250","20"));
        itemList.add(new ActivityItem(getResources().getDrawable(R.drawable.jogging,null),"Lari","TRAIN","100","45"));
        itemList.add(new ActivityItem(getResources().getDrawable(R.drawable.situp,null),"Sit Up","TRAIN","100","10"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvHomeLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvHomeLayoutManager);

        HomeAdapter adapter = new HomeAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
    }
}
