package com.example.piyush0.questionoftheday.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.piyush0.questionoftheday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OOPSFragment extends Fragment {


    public OOPSFragment() {
        // Required empty public constructor
    }

    public static OOPSFragment newInstance() {
        OOPSFragment fragment = new OOPSFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_oops, null);
        return view;
    }

}
