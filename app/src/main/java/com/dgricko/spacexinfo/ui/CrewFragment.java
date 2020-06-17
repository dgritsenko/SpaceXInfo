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
import com.dgricko.spacexinfo.adapters.CrewCardAdapter;
import com.dgricko.spacexinfo.api.model.CrewDTO;

import java.util.Arrays;
import java.util.List;

public class CrewFragment extends Fragment {
    private ViewPager viewPager;
    private CrewCardAdapter adapter;
    private List<CrewDTO> crews;

    private ArgbEvaluator argbEvaluator;
    private RandomColor randomColor;
    private Integer[] colors;

    private Button btnOpenPic;

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
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity mainActivity = (MainActivity) getActivity();
        crews = mainActivity.getCrews();


        argbEvaluator = new ArgbEvaluator();
        randomColor = new RandomColor();


        adapter = new CrewCardAdapter(crews,getContext());
        viewPager =view.findViewById(R.id.view_pager_crews);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);

        btnOpenPic = view.findViewById(R.id.btn_open_pic);
        colors = randomColor.getRandomColors(crews.size());
        System.out.println("!COLORS" + colors);


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