package com.example.android.googleplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.googleplaces.R;
import com.example.android.googleplaces.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    public interface OnPlaceItemClickListener {
        void onPlaceItemClick(Place place, int position);
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {

        public ImageView photoImage;
        public TextView titleText;
        public TextView subtitleText;

        public PlaceViewHolder(View itemView) {
            super(itemView);

            photoImage = (ImageView) itemView.findViewById(R.id.image_photo);
            titleText = (TextView) itemView.findViewById(R.id.text_title);
            subtitleText = (TextView) itemView.findViewById(R.id.text_subtitle);
        }

    }

    private Context context;
    private String[] placeNames;
    private List<Place> placeList;
    private OnPlaceItemClickListener listener;

    public PlaceAdapter(String[] placeNames) {
        this.placeNames = placeNames;
    }

    public PlaceAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @Override
    public PlaceAdapter.PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // TODO: Create PlaceVIewHolder object

        return null;
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.PlaceViewHolder holder, final int position) {

        Place place = placeList.get(position);
        // TODO: Bind views

        // TODO: Load image with Glide

        // TODO: Set on click listener
        /*if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlaceItemClick(place, position);
                }
            });
        }*/
    }

    @Override
    public int getItemCount() {

        // TODO: Recycler view rows
        return 0;
    }

    public void setOnPlaceItemClickListener(OnPlaceItemClickListener listener) {
        this.listener = listener;
    }

}
