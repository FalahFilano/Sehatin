package com.kamurapi.sehatin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.filano.sehatin.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.kamurapi.sehatin.DetailFragment.updateButton;

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
        TextView id = viewHolder.item_id;
        ImageView image = viewHolder.item_image;
        TextView name = viewHolder.item_name;
        TextView type = viewHolder.item_type;
        TextView calorie = viewHolder.item_calorie;
        TextView time = viewHolder.item_time;
        TextView desc = viewHolder.item_desc;
        TextView tips = viewHolder.item_tips;


        id.setText(homeItem.getId());
        image.setImageDrawable(homeItem.getImage());
        name.setText(homeItem.getName());
        type.setText(homeItem.getType());
        calorie.setText(homeItem.getCalorie());
        time.setText(homeItem.getTime());
        desc.setText(homeItem.getDescription());
        tips.setText(homeItem.getTips());

       // des.setText(homeItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name,item_type,item_calorie,item_time,item_desc,item_tips,item_id;
        Button button_mulai,button_selesai;

        public ViewHolder(final View itemView) {
            super(itemView);


            item_id = itemView.findViewById(R.id.activity_id);
            item_image = itemView.findViewById(R.id.activity_image);
            item_name = itemView.findViewById(R.id.activity_name);
            item_type = itemView.findViewById(R.id.activity_type);
            item_calorie = itemView.findViewById(R.id.value_calorie);
            item_time = itemView.findViewById(R.id.value_time);
            item_desc = itemView.findViewById(R.id.activity_desc);
            item_tips = itemView.findViewById(R.id.activity_tips);
            button_mulai = (Button) itemView.findViewById(R.id.mulai_activity);
            button_selesai =(Button) itemView.findViewById(R.id.selesai_activity);




            button_mulai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();

                    //to do

                    Bundle bundle = new Bundle();
                    String title = item_name.getText().toString();
                    bundle.putString("detail_title", title );
                    String calorie = item_calorie.getText().toString();
                    bundle.putString("detail_calorie", calorie );
                    String time = item_time.getText().toString();
                    bundle.putString("detail_time", time );

                    String desc = item_desc.getText().toString();
                    bundle.putString("detail_desc",desc);
                    String tips = item_tips.getText().toString();
                    bundle.putString("detail_tips",tips);

                    int id = Integer.parseInt(item_id.getText().toString());
                    bundle.putInt("detail_id",id);



                    Fragment myFragment = new DetailFragment();

                    //DetailFragment.updateButton.onUpdate(true);

                    myFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit();




                }
            });
        }
    }
}
