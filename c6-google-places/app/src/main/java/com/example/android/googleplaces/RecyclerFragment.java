package com.example.android.googleplaces;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.googleplaces.adapters.PlaceAdapter;
import com.example.android.googleplaces.models.Place;
import com.example.android.googleplaces.webservices.APIManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecyclerFragment extends Fragment {

    public RecyclerFragment() {
    }

    private RecyclerView recyclerView;
    private List<Place> placeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        placeList = new ArrayList<>();

        // Set data for RecyclerView
        String[] placeNames = { "Sydney Picnic Co", "Lampe Imports", "Form Over Function",
                "Haven Licensing PTY Ltd.", "Paddington" };

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        recyclerView.setAdapter(new PlaceAdapter(placeNames));
        recyclerView.setAdapter(new PlaceAdapter(getActivity(), placeList));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Call Google Maps API Web Service
        APIManager.getPlaces(getActivity(), new APIManager.PlacesCallback() {
            @Override
            public void success(List<Place> result) {

                placeList.addAll(result);

                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void failure() {

            }
        });

    }
}
