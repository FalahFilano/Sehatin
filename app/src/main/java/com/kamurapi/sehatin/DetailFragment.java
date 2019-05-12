package com.kamurapi.sehatin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.filano.sehatin.R;



public class DetailFragment extends Fragment implements UpdateButtonListener{

    public static UpdateButtonListener updateButton;
    Button button_selesai,button_mulai;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        updateButton = this;



        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        String title = this.getArguments().getString("detail_title");
        String calorie = this.getArguments().getString("detail_calorie");
        String time = this.getArguments().getString("detail_time");
        String description = this.getArguments().getString("detail_desc");
        String tips = this.getArguments().getString("detail_tips");
        int id = this.getArguments().getInt("detail_id");

        ImageView det_image;
        TextView det_title,det_calorie,det_time,det_tips,det_description;
        final Button button_mulai;


        det_image = view.findViewById(R.id.detailimage);
        det_title = view.findViewById(R.id.detailtitle);
        det_calorie = view.findViewById(R.id.detailcalorie);
        det_time = view.findViewById(R.id.detailtime);
        det_description = view.findViewById(R.id.detaildeskripsi);
        det_tips = view.findViewById(R.id.detailtips);


        switch (id){
            case 1:
                det_image.setImageDrawable(getResources().getDrawable(R.drawable.cycle,null));
                break;

            case 2:
                det_image.setImageDrawable(getResources().getDrawable(R.drawable.jogging,null));
                break;

            case 3:
                det_image.setImageDrawable(getResources().getDrawable(R.drawable.situp,null));
                break;
        }

        det_title.setText(title);
        det_calorie.setText(calorie);
        det_time.setText(time);
        det_description.setText(description);
        det_tips.setText(tips);



        button_selesai = view.findViewById(R.id.selesai_activity);
        button_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();



                Fragment myFragment = new HomeFragment();
                //DetailFragment.updateButton.onUpdate(true);
                button_selesai.setBackgroundColor(getResources().getColor(R.color.colorShadow));
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit();

            }
        });





        return view;
    }

    @Override
    public void onUpdate(boolean status) {
        if(status){
            button_selesai.setBackgroundColor(getResources().getColor(R.color.colorShadow));
            button_selesai.setEnabled(true);

        }
    }
}
