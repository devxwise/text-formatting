package com.sample.algorithm.formatter;

import com.sample.entity.Line;

/**
 * Center alignment
 */
public class TextCenterAlignment implements TextAlignment {

    @Override
    public int[] pad(Line line, int width, int totalLines, int lineIdx) {

        int[] padding = new int[line.getWords().size() + 1];
        //padding equally from both sides
        int pad = (width - line.getNumChars() + line.getWords().size() -1) / 2;

        for (int i = 0; i < padding.length; i++){
            if (i == 0) {
                padding[i] = pad;
            }else if (i == padding.length - 1) {
                padding[i] = pad;
            }else{
                padding[i] = 1;
            }
        }
        return padding;
    }
}
