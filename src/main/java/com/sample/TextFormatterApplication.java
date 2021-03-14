package com.sample;

import com.sample.processor.Alignment;
import com.sample.processor.TextFormatterProcessor;

import java.util.Arrays;
import java.util.Scanner;

public class TextFormatterApplication {

    public static void main(String[] args) {

        if (args.length != 2)
            throw new IllegalArgumentException("Formatter consumes only 2 args, alignment mode and max line width");

        Alignment alignment = getAlignmentFromArgs(args[0]);
        int width = getWidthFromArgs(args[1]);

        //getting text from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(width, alignment);
        System.out.println(textFormatterProcessor.format(text));

    }

    /**
     * Validafte and get Width from inout args
     * @param arg the args
     * @return the width
     */
    private static int getWidthFromArgs(String arg) {
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
    private static Alignment getAlignmentFromArgs(String arg) {
        return Arrays.stream(Alignment.values())
                .filter(a -> a.getVal().equalsIgnoreCase(arg))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown alignment format"));
    }
}
