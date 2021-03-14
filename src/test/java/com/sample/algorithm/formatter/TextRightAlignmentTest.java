package com.sample.algorithm.formatter;

import com.sample.entity.Line;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TextRightAlignmentTest {

    @Test
    public void testSimpleAlignment(){
        TextRightAlignment textRightAlignment = new TextRightAlignment();
        Line l = new Line(Collections.singletonList("abcdefg"), 7);
        int[] padding = textRightAlignment.pad(l, 10, 1, 0);

        assertNotNull(padding);
        assertEquals(2, padding.length);
        assertEquals(3, padding[0]);
        assertEquals(0, padding[1]);
    }

    @Test
    public void testNoAlignmentNeeded(){
        TextRightAlignment textRightAlignment = new TextRightAlignment();
        Line l = new Line(Collections.singletonList("abcdefg"), 7);
        int[] padding = textRightAlignment.pad(l, 7, 1, 0);

        assertNotNull(padding);
        assertEquals(2, padding.length);
        assertEquals(0, padding[0]);
        assertEquals(0, padding[1]);
    }
}
