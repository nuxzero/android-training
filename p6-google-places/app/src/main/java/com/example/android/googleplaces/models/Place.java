package com.example.android.googleplaces.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class Place implements Parcelable {

    private String id;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private String imageUrl;

    public Place() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(imageUrl);
    }

    protected Place(Parcel in) {
        id = in.readString();
        name = in.readString();
        address = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
        imageUrl = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
