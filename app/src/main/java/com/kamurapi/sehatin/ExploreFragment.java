package com.kamurapi.sehatin;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filano.sehatin.R;

import java.util.ArrayList;


public class ExploreFragment extends Fragment implements OnBackPressed {

    RecyclerView recyclerView, recyclerView2;
    ArrayList<Course> itemList;
    LinearLayoutManager layoutManager, layoutManager2;
    ExploreAdapter exploreAdapter;
    SearchView searchView;

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_explore, container, false);

        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Explore");

        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = rootView.findViewById(R.id.rvPaha);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2 = rootView.findViewById(R.id.rvPernapasan);
        recyclerView2.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(layoutManager2);

        exploreAdapter = new ExploreAdapter(itemList);
        recyclerView.setAdapter(exploreAdapter);
        recyclerView2.setAdapter(exploreAdapter);
        return rootView;

    }

    private void generateItemList() {
        itemList.add(new Course("Bersepeda", getResources().getDrawable(R.drawable.cycle,null)));
        itemList.add(new Course("Jogging ", getResources().getDrawable(R.drawable.jogging,null)));
        itemList.add(new Course("Sit Up", getResources().getDrawable(R.drawable.situp,null)));

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Cari Aktifitas");

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                exploreAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                exploreAdapter.getFilter().filter(query);
                return false;
            }
        });
    }

    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }

    }

}

