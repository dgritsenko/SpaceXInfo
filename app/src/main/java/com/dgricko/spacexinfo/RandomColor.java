package com.dgricko.spacexinfo;

import android.graphics.Color;

import java.util.List;
import java.util.Random;

public class RandomColor {

    public RandomColor() {
    }

    Random random = new Random();


    public Integer[] getRandomColors(int colorsNum) {
        Integer[] arrColors = new Integer[colorsNum];
        for (int i = 0; i<colorsNum;i++){
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            int randomColor = Color.rgb(r,g,b);
            arrColors[i]=randomColor;
        }
        return arrColors;
    }
}
