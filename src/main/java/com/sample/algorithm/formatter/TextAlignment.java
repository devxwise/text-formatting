package com.sample.algorithm.formatter;

import com.sample.entity.Line;

import java.util.List;
import java.util.stream.IntStream;

public interface TextAlignment {

    /**
     * compute number of spaces before/after/between words executed for each line.
     * the paddimg array should be size of: number of words + 1 , and contain number of spaces in each index
     * @param line the line
     * @param width max line width
     * @param totalLines toal number of text lines
     * @param lineIdx current line index
     * @return the padding array containing fixed number of spaces
     */
    int[] pad(Line line, int width, int totalLines, int lineIdx);

    /**
     * Iterating each Line and call for alignment formatting
     * @param lines the text divided into Lines
     * @param width the required line width
     * @return text formatted with required alignment
     */
    default String iterateLines(List<Line> lines, int width){
        StringBuilder builder = new StringBuilder();

        //for each line:
        //output line bt evaluating padding and width
        IntStream.range(0, lines.size()).forEach(
                i-> builder
                        .append(lines.get(i).output(pad(lines.get(i), width, lines.size(), i)))
                        .append("\n"));
        return builder.toString();
    }

}
