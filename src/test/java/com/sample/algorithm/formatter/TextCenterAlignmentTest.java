package com.sample.algorithm.formatter;

import com.sample.entity.Line;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.Collections;

public class TextCenterAlignmentTest {

    @Test
    public void testSimpleAlignment(){
        TextCenterAlignment textCenterAlignment = new TextCenterAlignment();
        Line l = new Line(Collections.singletonList("abcd"), 4);
        int[] padding = textCenterAlignment.pad(l, 6, 1,0);
        assertNotNull(padding);
        assertEquals(2, padding.length);
        assertEquals(1, padding[0]);
        assertEquals(1, padding[1]);
    }

}
