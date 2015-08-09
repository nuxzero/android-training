package com.example.android.googleplaces.webservices;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.googleplaces.models.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class APIManager {

    private static final String GOOGLE_MAPS_API_WEB_SERVICE_KEY = "AIzaSyAfHGePCi7imfnwdIHFjBxvKhwd2nMw4OM";
    private static final String HOST = "https://maps.googleapis.com/maps/api/place/";
    private static final String API_SEARCH = "search/json";
    private static final String API_NEARBY_SEARCH = "textsearch/json";
    private static final String API_PLACE_PHOTO = "photo";
    private static final String PHOTO_MAX_WIDTH = "640";

    private static APIManager instance;
    private Context context;
    private RequestQueue requestQueue;

    public interface PlacesCallback {
        void success(List<Place> result);
        void failure();
    }

    private APIManager(Context context) {
        this.context = context;
    }

    public static synchronized APIManager getInstance(Context context) {
        if (instance == null) {
            instance = new APIManager(context);
        }

        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequest(Request<T> request) {
        if (requestQueue == null) {
            requestQueue = getRequestQueue();
        }
        requestQueue.add(request);
    }

    public static void getPlaces(Context context, final PlacesCallback callback) {
        String url = String.format("%s%s?query=restaurants+in+Sydney&key=%s", HOST, API_NEARBY_SEARCH, GOOGLE_MAPS_API_WEB_SERVICE_KEY);
        Log.d("Url", url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        List<Place> placeList = new ArrayList<>();

                        try {

                            JSONArray jsonResults = response.getJSONArray("results");

                            for (int i = 0; i < jsonResults.length(); i++) {
                                JSONObject jsonPlace = jsonResults.getJSONObject(i);

                                Place place = new Place();
                                place.setId(jsonPlace.getString("id"));
                                place.setName(jsonPlace.getString("name"));
                                place.setAddress(jsonPlace.getString("formatted_address"));
                                JSONObject jsonLocation = jsonPlace.getJSONObject("geometry").getJSONObject("location");
                                place.setLat(jsonLocation.getDouble("lat"));
                                place.setLng(jsonLocation.getDouble("lng"));

                                if (jsonPlace.has("photos")) {
                                    JSONObject jsonPhoto = jsonPlace.getJSONArray("photos").getJSONObject(0);
                                    place.setImageUrl(createImageUrl(jsonPhoto.getString("photo_reference")));
                                }

                                placeList.add(place);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            callback.failure();
                        }

                        callback.success(placeList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        callback.failure();
                    }
                }
        );

        APIManager.getInstance(context).addToRequest(request);

    }

    private static String createImageUrl(String photoReference) {
        return String.format("%s%s?maxwidth=%s&photoreference=%s&key=%s", HOST, API_PLACE_PHOTO, PHOTO_MAX_WIDTH, photoReference, GOOGLE_MAPS_API_WEB_SERVICE_KEY);
    }

}
