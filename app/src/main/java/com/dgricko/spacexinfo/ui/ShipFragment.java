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

import com.dgricko.spacexinfo.MainActivity;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.RandomColor;
import com.dgricko.spacexinfo.adapters.ShipCardAdapter;
import com.dgricko.spacexinfo.api.model.ShipDTO;

import java.util.List;


public class ShipFragment extends Fragment {
    private ViewPager viewPager;
    private ShipCardAdapter adapter;
    private List<ShipDTO> ships;

    private ArgbEvaluator argbEvaluator;
    private RandomColor randomColor;
    private Integer[] colors;

    public ShipFragment() {
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
        return inflater.inflate(R.layout.fragment_ship, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity mainActivity = (MainActivity)getActivity();
        ships = mainActivity.getShips();

        argbEvaluator = new ArgbEvaluator();
        randomColor = new RandomColor();

        adapter = new ShipCardAdapter(ships,getContext());
        viewPager = view.findViewById(R.id.view_pager_ships);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);

        colors = randomColor.getRandomColors(ships.size());

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
    }
}