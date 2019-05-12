package com.kamurapi.sehatin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.filano.sehatin.R;

import java.util.ArrayList;
import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private ArrayList<Course> itemList, tempItemList;

    public ExploreAdapter(ArrayList<Course> itemList) {

        this.itemList = itemList;
        this.tempItemList = itemList;
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


    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    itemList = tempItemList;
                } else {
                    ArrayList<Course> filteredList = new ArrayList<>();
                    for (Course row : itemList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    itemList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = itemList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemList = (ArrayList<Course>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
