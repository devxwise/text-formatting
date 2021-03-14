package com.sample;

import com.sample.processor.Alignment;

import java.util.Arrays;

public class InputDataUtils {


    /**
     * Validate args are provided
     * @param args the args
     */
    public static void validateArgs(String[] args){
        if (args.length != 2)
            throw new IllegalArgumentException("Formatter consumes only 2 args, alignment mode and max line width");
    }


    /**
     * Validafte and get Width from inout args
     * @param arg the args
     * @return the width
     */
    public static int getWidthFromArgs(String arg) {
        try{
            int width = Integer.parseInt(arg);
            if (width <= 0)
                throw new IllegalArgumentException("Width must be greater than 0");
            return width;
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("problem converting width into number");
        }
    }

    /**
     * Get Alignment from input
     * @param arg the args
     * @return @Alignment object of the required alignment
     */
    public static Alignment getAlignmentFromArgs(String arg) {
        return Arrays.stream(Alignment.values())
                .filter(a -> a.getVal().equalsIgnoreCase(arg))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown alignment format"));
    }
}
