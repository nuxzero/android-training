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

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
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
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_card_place, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.PlaceViewHolder holder, final int position) {
//        holder.titleText.setText(placeNames[position]);

        final Place place = placeList.get(position);
        holder.titleText.setText(place.getName());
        holder.subtitleText.setText(place.getAddress());

        // Load image
        Glide.with(context)
                .load(place.getImageUrl())
                .centerCrop()
                .into(holder.photoImage);

        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlaceItemClick(place, position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {

//        return placeNames.length;

        if (placeList == null) {
            return 0;
        }
        return placeList.size();
    }

    public void setOnPlaceItemClickListener(OnPlaceItemClickListener listener) {
        this.listener = listener;
    }

}
