package com.sample.processor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TextFormatterProcessorTest {

    @Test
    public void testTextAlignmentToLeftWith10(){
        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(10, Alignment.LEFT_ALIGN);
        String res = textFormatterProcessor.format( "This text should be left aligned");
        assertEquals("This text \n" +
                        "should be \n" +
                        "left      \n" +
                        "aligned   \n",
                res);
    }


    @Test
    public void testTextAlignmentToRightWidth10(){
        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(10, Alignment.RIGHT_ALIGN);
        String res = textFormatterProcessor.format("This text should be right aligned ");
        assertEquals(" This text\n" +
                        " should be\n" +
                        "     right\n" +
                        "   aligned\n",
                res);

    }

    @Test
    public void testTextAlignmentToRightWidth20(){
        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(20, Alignment.RIGHT_ALIGN);
        String res = textFormatterProcessor.format("This text should be right aligned ");
        assertEquals(" This text should be\n" +
                        "       right aligned\n",
                res);
    }

    @Test
    public void testTextCenterAlignmentWith20(){
        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(20, Alignment.CENTER);
        String res = textFormatterProcessor.format( "This text should be center aligned");
        assertEquals("   This text should be   \n" +
                        "    center aligned    \n",
                res);
    }
}
