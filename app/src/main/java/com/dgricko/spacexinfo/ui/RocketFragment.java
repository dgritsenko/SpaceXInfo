package com.dgricko.spacexinfo.ui;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dgricko.spacexinfo.MainActivity;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.RandomColor;
import com.dgricko.spacexinfo.adapters.RocketCardAdapter;
import com.dgricko.spacexinfo.api.model.RocketDTO;

import java.util.List;


public class RocketFragment extends Fragment {

    private ViewPager viewPager;
    RocketCardAdapter adapter;
    List<RocketDTO> rockets;

    private ArgbEvaluator argbEvaluator;
    private RandomColor randomColor;
    private Integer[] colors;

    private Button btnOpenPic;

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

        argbEvaluator = new ArgbEvaluator();
        randomColor = new RandomColor();

        rockets = mainActivity.getRockets();
        adapter = new RocketCardAdapter(rockets,getContext());

        viewPager = view.findViewById(R.id.view_pager_rockets);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);

        btnOpenPic = view.findViewById(R.id.btn_open_pic);

        colors = randomColor.getRandomColors(rockets.size());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount()-1) && position < (colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position+1]
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnOpenPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("!Press BTN");
            }
        });
    }
}