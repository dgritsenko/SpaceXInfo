package com.dgricko.spacexinfo.ui;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dgricko.spacexinfo.MainActivity;
import com.dgricko.spacexinfo.R;
import com.dgricko.spacexinfo.RandomColor;
import com.dgricko.spacexinfo.adapters.DragonCardAdapter;
import com.dgricko.spacexinfo.api.model.DragonDTO;

import java.util.List;


public class DragonFragment extends Fragment {

    private ViewPager viewPager;
    private DragonCardAdapter adapter;
    private List<DragonDTO> dragons;

    private NavController navController;

    private ArgbEvaluator argbEvaluator;
    private RandomColor randomColor;
    private Integer[] colors;

    private Button btnOpenPic;

    public DragonFragment() {
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
        return inflater.inflate(R.layout.fragment_dragon, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity mainActivity = (MainActivity) getActivity();
        dragons = mainActivity.getDragons();

        ((MainActivity)getActivity()).setImagesForGallery(dragons.get(0).getFlickr_images());

        argbEvaluator = new ArgbEvaluator();
        randomColor = new RandomColor();

        adapter = new DragonCardAdapter(dragons,getContext());
        viewPager = view.findViewById(R.id.view_pager_dragons);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50,0,50,0);

        navController = Navigation.findNavController(view);



        btnOpenPic = view.findViewById(R.id.btn_open_pic);

        colors = randomColor.getRandomColors(dragons.size());

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
                navController.navigate(R.id.action_dragonFragment_to_galleryImageFragment);
            }
        });
    }
}