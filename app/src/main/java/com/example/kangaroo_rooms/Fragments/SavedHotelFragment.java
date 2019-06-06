package com.example.kangaroo_rooms.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kangaroo_rooms.R;


public class SavedHotelFragment extends Fragment {

    public static SavedHotelFragment newInstance() {
        SavedHotelFragment fragment = new SavedHotelFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_hotel, container, false);
        return view;
    }

}
