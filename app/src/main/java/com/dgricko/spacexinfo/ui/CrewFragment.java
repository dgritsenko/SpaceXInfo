package com.dgricko.spacexinfo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgricko.spacexinfo.MainActivity;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.adapters.CrewCardAdapter;
import com.dgricko.spacexinfo.api.model.CrewDTO;

import java.util.List;

public class CrewFragment extends Fragment {
    private ViewPager viewPager;
    private CrewCardAdapter adapter;
    private List<CrewDTO> crews;



    public CrewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crew, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity mainActivity = (MainActivity) getActivity();
        crews = mainActivity.getCrews();

        adapter = new CrewCardAdapter(crews,getContext());
        viewPager =view.findViewById(R.id.view_pager_crews);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);
    }
}