package com.sample;

import com.sample.processor.Alignment;
import org.junit.Assert;
import org.junit.Test;

import static com.sample.InputDataUtils.getAlignmentFromArgs;
import static org.junit.Assert.assertEquals;

public class InputDataUtilsTest {


    @Test
    public void testConvertToWith(){
        int width = InputDataUtils.getWidthFromArgs("3");
        assertEquals(3, width);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth(){
        InputDataUtils.getWidthFromArgs("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroWidth(){
        InputDataUtils.getWidthFromArgs("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonValidWidth(){
        InputDataUtils.getWidthFromArgs("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullWidth(){
        InputDataUtils.getWidthFromArgs(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoArgsValidation(){
        InputDataUtils.validateArgs(new String[]{});
    }

    @Test
    public void testArgsValidation(){
        InputDataUtils.validateArgs(new String[]{"left", "2"});
    }

    @Test
    public void testGetLeftAlignment(){
        Assert.assertEquals(Alignment.LEFT_ALIGN, getAlignmentFromArgs("left"));
    }

    @Test
    public void testGetRightAlignment(){
        Assert.assertEquals(Alignment.RIGHT_ALIGN, getAlignmentFromArgs("right"));
    }

    @Test
    public void testGetJustifyAlignment(){
        Assert.assertEquals(Alignment.JUSTIFY, getAlignmentFromArgs("justify"));
    }

    @Test
    public void testGetCenterAlignment(){
        Assert.assertEquals(Alignment.CENTER, getAlignmentFromArgs("center"));
    }
}
