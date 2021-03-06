package com.sample;

import com.sample.processor.Alignment;
import com.sample.processor.TextFormatterProcessor;

import java.util.Scanner;

import static com.sample.InputDataUtils.*;

public class TextFormatterApplication {

    public static void main(String[] args) {

        validateArgs(args);

        Alignment alignment = getAlignmentFromArgs(args[0]);
        int width = getWidthFromArgs(args[1]);

        //getting text from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        //call text formatter processor
        TextFormatterProcessor textFormatterProcessor = new TextFormatterProcessor(width, alignment);
        //format and print result
        System.out.println("The formatted text:");
        System.out.println(textFormatterProcessor.format(text));
    }

}
