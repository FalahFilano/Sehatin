package com.kamurapi.sehatin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.filano.sehatin.R;



public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        String title = this.getArguments().getString("detail_title");
        int image = this.getArguments().getInt("detail_image");

        ImageView det_image;
        TextView det_title,det_calorie,det_time,det_tips,det_description;
        Button button_mulai;


        det_image = view.findViewById(R.id.detailimage);
        det_title = view.findViewById(R.id.detailtitle);


        det_title.setText(title);
        //det_image.setImageDrawable(getResources().getDrawable(image,null));




        return view;
    }

}
