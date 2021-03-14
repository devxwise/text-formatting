package com.sample.processor;

import com.sample.algorithm.formatter.TextAlignment;
import com.sample.algorithm.formatter.TextAlignmentFactory;
import com.sample.algorithm.split.FullWordsTextSplitter;
import com.sample.algorithm.split.TextSplitter;

public class TextFormatterProcessor {

    private final TextAlignment textAlignment;

    private final TextSplitter textSplitter;

    private final int width;

    public TextFormatterProcessor(int width, Alignment alignment){
       this.width = width;
       this.textSplitter = new FullWordsTextSplitter(this.width);
       this.textAlignment = TextAlignmentFactory.getTextAlignment(alignment);
    }

    public String format(String text){
        return textAlignment.iterateLines(textSplitter.split(text), width);
    }
}
