package com.ollie.androidrestaurant;

import android.app.DownloadManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BackendListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackendListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = BackendListFragment.class.getSimpleName();

    public BackendListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackendListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackendListFragment newInstance(String param1, String param2) {
        BackendListFragment fragment = new BackendListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_backend_list, container, false);
        getNearbyRestaurantThroughBackend();
        return view;
    }

    public void getNearbyRestaurantThroughBackend() {
        final String tag = "just testing";
        Log.i(tag, "getNearbyExecuted");
        String urlSearch = "http://localhost:8080/Roro/search?lat=37.386051&lon=-122.083855";
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET,
                urlSearch, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
                Log.i(tag, "getNearbyonResponseExecuted");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(tag, "onErrorResponse");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}