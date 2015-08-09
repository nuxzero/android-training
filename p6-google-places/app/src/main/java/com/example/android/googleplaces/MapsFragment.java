package com.example.android.googleplaces;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.googleplaces.models.Place;
import com.example.android.googleplaces.webservices.APIManager;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsFragment extends Fragment implements LocationListener, OnMapReadyCallback {

    private GoogleMap googleMap;
    private Map <Marker, Place> placeHashMaps;

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inflate the layout for this fragment
        // TODO: Setup map
       /* SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        // TODO: Setup map UI options

        // Call web service to get place data
        loadPlaces();
    }

    private void loadPlaces() {
        // Call Google Maps API Web Service
        APIManager.getPlaces(getActivity(), new APIManager.PlacesCallback() {
            @Override
            public void success(List<Place> result) {

                updateMapView(result);

            }

            @Override
            public void failure() {

            }
        });
    }

    private void updateMapView(List<Place> placeList) {

        placeHashMaps = new HashMap<Marker, Place>();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Place place : placeList) {
            // TODO: Add markers on Google Map

        }

        // TODO: Zoom in bounds

        // TODO: Set on info window click

    }
}
