package com.dgricko.spacexinfo.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.dgricko.spacexinfo.R;

public class WelcomeFragment extends Fragment implements View.OnClickListener{

    private Button startBtn;
    private ImageView rocketView;
    private NavController navController;


    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        startBtn =view.findViewById(R.id.weclome_btn);
        rocketView = view.findViewById(R.id.welcome_rocket);

        startBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.weclome_btn) {
            Log.d("WELCOME_LOG","Press Btn Start");
            ObjectAnimator rotate_anim = ObjectAnimator.ofFloat(rocketView,"rotation",0f,-42f);
            rotate_anim.setDuration(500);

            ObjectAnimator fly_anim = ObjectAnimator.ofFloat(rocketView,"translationY",0f,-1000f);
            fly_anim.setDuration(1500);

            AnimatorSet set = new AnimatorSet();
            set.play(rotate_anim).before(fly_anim);
            set.start();

            Thread sleepThread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        Log.e("WELCOME_FRAGMENT","sleep",e);
                    }
                    navController.navigate(R.id.action_welcomeFragment_to_menuFragment);

                }
            };
            sleepThread.start();

        }
    }
}