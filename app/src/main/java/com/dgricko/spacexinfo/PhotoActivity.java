package com.dgricko.spacexinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class PhotoActivity extends AppCompatActivity {

    private static final String EXTRA_URL = "PhotoActivity.EXTRA_URL";
    private SubsamplingScaleImageView imageView;

    private Bitmap photo;

    public static void start(Context caller, String url){
        Intent intent = new Intent(caller, PhotoActivity.class);
        intent.putExtra(EXTRA_URL,url);
        caller.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //full screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_photo);

        imageView = findViewById(R.id.photo_image);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        ImageLoader.getInstance().loadImage(getIntent().getStringExtra(EXTRA_URL),new SimpleImageLoadingListener(){
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (!isFinishing()){
                    photo = loadedImage;
                    imageView.setImage(ImageSource.cachedBitmap(loadedImage));
                    findViewById(R.id.progress).setVisibility(View.GONE);
                }
            }
        });

      /*  imageView.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() != MotionEvent.ACTION_DOWN
                    && motionEvent.getAction() != MotionEvent.ACTION_UP) {

            }
            return false;
        });*/
    }
}