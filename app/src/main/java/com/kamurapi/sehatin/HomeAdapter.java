package com.kamurapi.sehatin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.filano.sehatin.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {



    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private Context mContext;
    private ArrayList<ActivityItem> mlist;

    HomeAdapter(Context context, ArrayList<ActivityItem> list){
        mContext =context;
        mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.home_item,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ActivityItem homeItem = mlist.get(i);
        ImageView image = viewHolder.item_image;
        TextView name = viewHolder.item_name;
        TextView type = viewHolder.item_type;
        TextView calorie = viewHolder.item_calorie;
        TextView time = viewHolder.item_time;




        image.setImageResource(homeItem.getImage());
        name.setText(homeItem.getName());
        type.setText(homeItem.getType());
        calorie.setText(homeItem.getCalorie());
        time.setText(homeItem.getTime());



//        viewHolder.button_mulai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                               Intent intent = new Intent(mContext, LoginActivity.class);
////                mContext.startActivity(intent);
//
//                //mMainNav.setItemBackgroundResource(R.color.colorAccent);
//                FragmentManager manager = ((AppCompatActivity)mContext).getSupportFragmentManager();
//               FragmentTransaction fr =  manager.beginTransaction();
//                fr.replace(R.id.mainFrame,new DetailFragment());
//                fr.commit();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name,item_type,item_calorie,item_time;
        Button button_mulai;

        public ViewHolder(View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.activity_image);
            item_name = itemView.findViewById(R.id.activity_name);
            item_type = itemView.findViewById(R.id.activity_type);
            item_calorie = itemView.findViewById(R.id.value_calorie);
            item_time = itemView.findViewById(R.id.value_time);
            button_mulai = (Button) itemView.findViewById(R.id.mulai_activity);



            button_mulai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();

                    //to do


                    Fragment myFragment = new DetailFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit();

                }
            });
        }
    }
}
