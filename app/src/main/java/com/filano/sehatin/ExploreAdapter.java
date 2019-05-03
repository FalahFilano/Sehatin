package com.filano.sehatin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private ArrayList<Course> itemList;

    public ExploreAdapter(ArrayList<Course> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreAdapter.ViewHolder viewHolder, int i) {
        Course item = itemList.get(i);

        viewHolder.courseName.setText(item.getName());
        viewHolder.courseImage.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;
        public ImageView courseImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.courseName);
            courseImage = itemView.findViewById(R.id.courseImage);
        }
    }
}
