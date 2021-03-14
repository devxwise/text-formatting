package com.sample.algorithm.formatter;

import com.sample.entity.Line;
import com.sample.processor.Alignment;

/**
 * Justify alignment
 */
public class TextJustifyAlignment implements TextAlignment {

    //when needed, align to the left
    private final TextAlignment lastLineTextAlignment;

    public TextJustifyAlignment(){
        this.lastLineTextAlignment = TextAlignmentFactory.getTextAlignment(Alignment.LEFT_ALIGN);
    }

    @Override
    public int[] pad(Line line, int width, int totalLines, int lineIdx) {
        //last line or one word only, align to left
        if (lineIdx == totalLines - 1 || line.getWords().size() == 1){ //last line or one word only, align to left
            return lastLineTextAlignment.pad(line, width, totalLines, lineIdx);
        }
        int[] padding = new int[line.getWords().size() + 1];

        int permitSpaces = width - line.getNumChars();
        while (permitSpaces > 0) { //reducing spaces each line
            for (int i = 0; i < padding.length & permitSpaces > 0; i++){
                if (i==0 || i == padding.length -1){ //align to left and right
                    padding[i] = 0;
                }else {
                    padding[i] = padding[i] + 1;
                    permitSpaces--;
                }
            }
        }
        return padding;
    }
}
