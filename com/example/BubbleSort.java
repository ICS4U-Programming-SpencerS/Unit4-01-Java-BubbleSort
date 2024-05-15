package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * BubbleSort program but in Java
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-05-13
 */

// BubbleSort class
public final class BubbleSort {

    /** Private constructor to prevent instantiation. */
    private BubbleSort() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        // Input and output file paths
        final String inputFile = "input.txt";
        final String outputFile = "output.txt";

        try {
            final Scanner sc = new Scanner(inputFile);
            final FileWriter fW = new FileWriter(outputFile);
            final PrintWriter write = new PrintWriter(fW);

            // Read each line from input file and perform bubble sort
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();

                // Split the input line into tokens
                String[] tokens = inputLine.split(" ");

                // Convert tokens to integers
                int[] arrayNum = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    arrayNum[i] = Integer.parseInt(tokens[i]);
                }

                // Perform bubble sort
                bubbleSort(arrayNum);

                // Write sorted array to output file
                for (int num : arrayNum) {
                    write.print(num + " ");
                }
                write.println();
            }

            System.out.println("Done program");

        } catch (IOException error) { // For when no input file is found.
            System.out.println("An error occurred: " + error.getMessage());
        } catch (NumberFormatException error) {
            System.out.println("Error: Invalid input (whole numbers only).");
        } catch (NoSuchElementException error) {
            System.out.println("Error: Input file is empty.");
        }
    }

    public static void bubbleSort(int[] arrayNum) {
        for (int i = 0; i < arrayNum.length - 1; i++) {
            for (int j = 0; j < arrayNum.length - i - 1; j++) {
                if (arrayNum[j] > arrayNum[j + 1]) {
                    int temp = arrayNum[j];
                    arrayNum[j] = arrayNum[j + 1];
                    arrayNum[j + 1] = temp;

                }
            }
        }
    }
}
