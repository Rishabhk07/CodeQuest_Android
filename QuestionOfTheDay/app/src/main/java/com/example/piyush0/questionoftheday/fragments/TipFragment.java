package com.example.piyush0.questionoftheday.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.piyush0.questionoftheday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipFragment extends Fragment {


    public TipFragment() {
        // Required empty public constructor
    }

    public static TipFragment newInstance() {
        return new TipFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip, container, false);
    }

}
