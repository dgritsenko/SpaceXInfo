package com.dgricko.spacexinfo;

import android.graphics.Color;

import java.util.Random;

public class RandomColor {
    Random random = new Random();

    int r = random.nextInt(255);
    int g = random.nextInt(255);
    int b = random.nextInt(255);

    public int getRandomColor(){
        int randomColor = Color.rgb(r,g,b);
        return randomColor;
    }
}
