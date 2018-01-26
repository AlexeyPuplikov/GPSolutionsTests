package com.gpsolutions.alexeypuplikov.task278;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\task278\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\resources\\task278\\output.txt"));
        char[] initialElements = reader.readLine().toCharArray();
        char[] testElements = reader.readLine().toCharArray();
        int j = 0, i = 0;
        while (i < initialElements.length) {
            while (j < testElements.length) {
                if (testElements[j] == initialElements[i]) {
                    i++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
            if (j == testElements.length) {
                break;
            }
        }
        if (i == initialElements.length) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }
        reader.close();
        writer.close();
    }
}
