package com.sample.algorithm.formatter;

import com.sample.entity.Line;

import java.util.List;
import java.util.stream.IntStream;

public interface TextAlignment {

    int[] pad(Line line, int width, int totalLines, int lineIdx);

    /**
     * Iterating each Line and call for alignment formatting
     * @param lines the text divided into Line
     * @param width the required line width
     * @return text formatted with required alignment
     */
    default String iterateLines(List<Line> lines, int width){
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, lines.size()).forEach(
                i-> builder
                        .append(lines.get(i).output(pad(lines.get(i), width, lines.size(), i)))
                        .append("\n"));
        return builder.toString();
    }

}
