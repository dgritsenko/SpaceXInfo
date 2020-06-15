package com.dgricko.spacexinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.dgricko.spacexinfo.api.model.RocketDTO;

import java.util.List;


public class RocketFragment extends Fragment {

    private ViewPager viewPager;
    RocketCardAdapter adapter;
    List<RocketDTO> rockets;


    public RocketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rocket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("!In RocketFragment");

        MainActivity mainActivity =(MainActivity) getActivity();
        System.out.println(mainActivity.getRockets());

        rockets = mainActivity.getRockets();
        adapter = new RocketCardAdapter(rockets,getContext());

        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);
    }
}