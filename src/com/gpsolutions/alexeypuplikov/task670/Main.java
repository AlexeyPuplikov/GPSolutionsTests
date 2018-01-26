package com.gpsolutions.alexeypuplikov.task670;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\task670\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\resources\\task670\\output.txt"));
        int n = Integer.parseInt(reader.readLine());
        Set<Character> characters = new HashSet<>();
        int i = 0;
        int z = 0;
        String number;
        while (i != n) {
            z++;
            number = String.valueOf(z);
            for (Character digit : number.toCharArray()) {
                characters.add(digit);
            }
            if (number.length() == characters.size()) {
                i++;
            }
            characters.clear();
        }
        writer.write(String.valueOf(z));
        reader.close();
        writer.close();
    }
}
