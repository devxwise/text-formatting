package com.sample.algorithm.split;

import com.sample.entity.Line;
import com.sample.exception.TextLineSplittingException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Keep full words, bring words to next line in case word can't fit in the existing line.
 **/
public class FullWordsTextSplitter implements TextSplitter{

    private final int width;

    public FullWordsTextSplitter(int width){
        this.width = width;
    }

    @Override
    public List<Line> split(String text) {

        List<Line> result = new ArrayList<>();
        List<String> wordsList = new LinkedList<>();
        int numChars = 0;

        String [] words = text.trim().split(" ");
        for (String word : words){

            if (word.length() > width) {
                throw new TextLineSplittingException("word is longer than permitted with, consider increasing width " +
                        "or changing line splitter algorithm");
            }

            if (numChars + word.length() > width) { //when reaching to Line max width
                result.add(new Line(wordsList, numChars - wordsList.size()));
                wordsList = new LinkedList<>();
                numChars = 0;
            }
            numChars += word.length() + 1; //1 for space
            wordsList.add(word);
        }

        if (!wordsList.isEmpty()){
            result.add(new Line(wordsList, numChars - wordsList.size()));
        }
        return result;
    }
}
