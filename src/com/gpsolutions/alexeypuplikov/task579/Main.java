package com.gpsolutions.alexeypuplikov.task579;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\task579\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\resources\\task579\\output.txt"));
        int positiveSum = 0, negativeSum = 0, countPositiveElem = 0, countNegativeElem = 0;
        int sequenceLength = Integer.parseInt(reader.readLine());
        Deque<Integer> positiveIndex = new ArrayDeque<>();
        Deque<Integer> negativeIndex = new ArrayDeque<>();
        String[] elements = reader.readLine().split("\\s");
        for (int i = 0; i < sequenceLength; i++) {
            int sequenceElement = Integer.parseInt(elements[i]);
            if (sequenceElement > 0) {
                positiveSum += sequenceElement;
                positiveIndex.offer(i + 1);
                countPositiveElem++;
            } else if (sequenceElement < 0) {
                negativeSum += -sequenceElement;
                negativeIndex.offer(i + 1);
                countNegativeElem++;
            }
        }
        if (positiveSum >= negativeSum) {
            writer.write(countPositiveElem + "\n");
            for (int elem : positiveIndex) {
                writer.write(elem + " ");
            }
        } else {
            writer.write(countNegativeElem + "\n");
            for (int elem : negativeIndex) {
                writer.write(elem + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
