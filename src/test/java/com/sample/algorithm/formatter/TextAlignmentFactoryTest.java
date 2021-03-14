package com.sample.algorithm.formatter;

import com.sample.exception.TextAlignmentException;
import com.sample.processor.Alignment;
import org.junit.Assert;
import org.junit.Test;

public class TextAlignmentFactoryTest {

    @Test
    public void testLeftAlignInstance(){
        TextAlignment textAlignment = TextAlignmentFactory.getTextAlignment(Alignment.LEFT_ALIGN);
        Assert.assertTrue(textAlignment instanceof  TextLeftAlignment);
    }
    @Test
    public void testRightAlignInstance(){
        TextAlignment textAlignment = TextAlignmentFactory.getTextAlignment(Alignment.RIGHT_ALIGN);
        Assert.assertTrue(textAlignment instanceof  TextRightAlignment);
    }
    @Test
    public void testCenterAlignInstance(){
        TextAlignment textAlignment = TextAlignmentFactory.getTextAlignment(Alignment.CENTER);
        Assert.assertTrue(textAlignment instanceof  TextCenterAlignment);
    }

    @Test
    public void testJustifyAlignInstance(){
        TextAlignment textAlignment = TextAlignmentFactory.getTextAlignment(Alignment.JUSTIFY);
        Assert.assertTrue(textAlignment instanceof  TextJustifyAlignment);
    }

    @Test(expected = TextAlignmentException.class)
    public void testMissingImplementation(){
        TextAlignment textAlignment = TextAlignmentFactory.getTextAlignment(Alignment.HARD);
    }


}
