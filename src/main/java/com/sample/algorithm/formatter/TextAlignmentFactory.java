package com.sample.algorithm.formatter;

import com.sample.exception.TextAlignmentException;
import com.sample.processor.Alignment;

/**
 * Text Alignment algorithm factory to initiate required alignment algorithm
 */
public class TextAlignmentFactory {

    private TextAlignmentFactory(){ }

    public static TextAlignment getTextAlignment(Alignment alignment){
        switch (alignment){
            case LEFT_ALIGN:
                return new TextLeftAlignment();
            case RIGHT_ALIGN:
                return  new TextRightAlignment();
            case CENTER:
                return new TextCenterAlignment();
            case JUSTIFY:
                return new TextJustifyAlignment();
            case HARD:
            default:
                throw new TextAlignmentException("Unsupported text alignment algorithm");
        }
    }
}
