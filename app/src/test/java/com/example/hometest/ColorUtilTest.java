package com.example.hometest;


import com.example.hometest.utils.ColorUtil;

import org.junit.Assert;
import org.junit.Test;

public class ColorUtilTest {

    @Test
    public void getColorItemTest() {
        Assert.assertEquals(R.color.colorKeyword_1, ColorUtil.getColorItem(0));
        Assert.assertEquals(R.color.colorKeyword_1, ColorUtil.getColorItem(9));
    }
}
