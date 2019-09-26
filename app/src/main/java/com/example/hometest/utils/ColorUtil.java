package com.example.hometest.utils;

import com.example.hometest.R;

public class ColorUtil {

    private static final int NUM_COLOR = 9;

    public static int getColorItem(int index) {
        int indexColor = index % NUM_COLOR;
        switch (indexColor + 1) {
            case 1:
                return R.color.colorKeyword_1;
            case 2:
                return R.color.colorKeyword_2;
            case 3:
                return R.color.colorKeyword_3;
            case 4:
                return R.color.colorKeyword_4;
            case 5:
                return R.color.colorKeyword_5;
            case 6:
                return R.color.colorKeyword_6;
            case 7:
                return R.color.colorKeyword_7;
            case 8:
                return R.color.colorKeyword_8;
            case 9:
                return R.color.colorKeyword_9;

        }
        return R.color.colorKeyword_1;
    }
}
