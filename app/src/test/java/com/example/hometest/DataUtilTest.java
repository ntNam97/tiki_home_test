package com.example.hometest;

import com.example.hometest.utils.DataUtil;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

    @Test
    public void formatStringTest() {
        Assert.assertEquals("ipad", DataUtil.formatString("ipad"));
        Assert.assertEquals("bitis\nhunter", DataUtil.formatString("bitis hunter"));
        Assert.assertEquals("đắc\nnhân tâm", DataUtil.formatString("đắc nhân tâm"));
        Assert.assertEquals("anh chính là\nthanh xuân của em", DataUtil.formatString("anh chính là thanh xuân của em"));
    }
}
