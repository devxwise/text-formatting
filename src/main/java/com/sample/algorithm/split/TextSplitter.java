package com.sample.algorithm.split;


import com.sample.entity.Line;

import java.util.List;

/**
 * Split interface - allow different text splitting algorithm implementations
 * As for now - we have only Full Word splitter - meaning, if word can't fit into line, it will be
 * taken to the next line.
 * For future improvements, consider adding word breaker splitter, which break the word according to available
 * space in given line
 */
public interface TextSplitter {

    /**
     * split text into @List of @Line
     * @param text the given text
     * @return List of Lines
     */
    List<Line> split(String text);
}
