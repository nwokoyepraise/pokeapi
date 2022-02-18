package com.nwokoyepraise.pokeapi.data;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainRepository {
    private static String url = "https://pokeapi.co/api/v2/pokemon/ditto";
    private Context context;


    public MainRepository(Context context) {
        this.context = context;
    }

    public void getData( VolleyCallback callback) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject data) {
                        callback.onSuccessResponse(data.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e("ERROR", "onErrorResponse: " + error);
                    }
                });
        queue.add(jsonObjectRequest);
    }

    public interface VolleyCallback {
        void onSuccessResponse(String result);
    }

    public void setData(String data) {

    }
}
