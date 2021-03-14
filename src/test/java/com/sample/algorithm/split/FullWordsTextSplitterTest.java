package com.sample.algorithm.split;

import com.sample.entity.Line;
import com.sample.exception.TextLineSplittingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FullWordsTextSplitterTest {

    @Test
    public void testNoSplitNeeded(){
        FullWordsTextSplitter fullWordsTextSplitter = new FullWordsTextSplitter(5);
        List<Line> res = fullWordsTextSplitter.split("abcd");
        Assert.assertEquals(1, res.size());
        Assert.assertEquals("abcd", res.get(0).getWords().get(0));
    }

    @Test(expected = TextLineSplittingException.class)
    public void expectExceptionWhenWordLongerThanWidth(){
        FullWordsTextSplitter fullWordsTextSplitter = new FullWordsTextSplitter(5);
        fullWordsTextSplitter.split("abcdefghi");
    }

    @Test
    public void testSplitNeeded(){
        FullWordsTextSplitter fullWordsTextSplitter = new FullWordsTextSplitter(5);
        List<Line> res = fullWordsTextSplitter.split("abcd def");
        Assert.assertEquals(2, res.size());
        Assert.assertEquals("abcd", res.get(0).getWords().get(0));
        Assert.assertEquals("def", res.get(1).getWords().get(0));
    }

    @Test
    public void testSplitInto3LinesNeeded(){
        FullWordsTextSplitter fullWordsTextSplitter = new FullWordsTextSplitter(5);
        List<Line> res = fullWordsTextSplitter.split("abcd def ghij");
        Assert.assertEquals(3, res.size());
        Assert.assertEquals("abcd", res.get(0).getWords().get(0));
        Assert.assertEquals("def", res.get(1).getWords().get(0));
        Assert.assertEquals("ghij", res.get(2).getWords().get(0));
    }

    @Test
    public void testSplitInto2Lines2WordsInLineNeeded(){
        FullWordsTextSplitter fullWordsTextSplitter = new FullWordsTextSplitter(10);
        List<Line> res = fullWordsTextSplitter.split("abcd def ghij");
        Assert.assertEquals(2, res.size());
        Assert.assertEquals("abcd", res.get(0).getWords().get(0));
        Assert.assertEquals("def", res.get(0).getWords().get(1));
        Assert.assertEquals("ghij", res.get(1).getWords().get(0));
    }
}
