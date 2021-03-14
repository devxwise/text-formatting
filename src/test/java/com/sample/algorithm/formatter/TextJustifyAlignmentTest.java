package com.sample.algorithm.formatter;

import com.sample.entity.Line;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TextJustifyAlignmentTest {

    @Test
    public void testNotOneWordOrLastLine(){
        TextJustifyAlignment textJustifyAlignment = new TextJustifyAlignment();
        Line l = new Line(Arrays.asList("abcd", "ef"), 6);
        int[] padding = textJustifyAlignment.pad(l, 10, 4, 1);

        assertNotNull(padding);
        assertEquals(3, padding.length);
        assertEquals(0, padding[0]);
        assertEquals(4, padding[1]);
        assertEquals(0, padding[2]);
    }

    @Test
    public void testLineWithOneWordAlignedToLeft(){
        TextJustifyAlignment textJustifyAlignment = new TextJustifyAlignment();
        Line l = new Line(Collections.singletonList("abcd"), 4);
        int[] padding = textJustifyAlignment.pad(l, 10, 4, 1);

        assertNotNull(padding);
        assertEquals(2, padding.length);
        assertEquals(0, padding[0]);
        assertEquals(6, padding[1]);
    }

    @Test
    public void testLastLineAlignedToLeft(){
        TextJustifyAlignment textJustifyAlignment = new TextJustifyAlignment();
        Line l = new Line(Arrays.asList("ab", "cd"), 4);
        int[] padding = textJustifyAlignment.pad(l, 10, 4, 3);

        assertNotNull(padding);
        assertEquals(3, padding.length);
        assertEquals(0, padding[0]);
        assertEquals(1, padding[1]);
        assertEquals(5, padding[2]);
    }
}
