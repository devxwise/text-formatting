package com.sample.entity;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Class for holding words in individual text line
 */
public class Line {

    //words in line
    private final List<String> words;

    //number of chard in all line's words (not including spaces)
    private final int numChars;

    public Line (List<String> words, int numChars){
        this.words = words;
        this.numChars = numChars;
    }

    public List<String> getWords() {
        return words;
    }

    public int getNumChars() {
        return numChars;
    }

    /**
     * output line presentation
     * @param spaces the allowed spaces
     * @return String representation of line after formatting
     */
    public String output(int[] spaces){
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, spaces.length).forEach(si-> {
            IntStream.range(0, spaces[si]).forEach(sn -> builder.append(" "));
            if (si < words.size()){
                builder.append(words.get(si));
            }
        });

        return builder.toString();
    }
}
