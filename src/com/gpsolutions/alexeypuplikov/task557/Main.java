package com.gpsolutions.alexeypuplikov.task557;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\task557\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\resources\\task557\\output.txt"));
        int m, n, resultRow, resultColumn, p;
        String line = reader.readLine();
        String[] lineArr = line.split(" ");
        m = Integer.parseInt(lineArr[0]);
        n = Integer.parseInt(lineArr[1]);
        line = reader.readLine();
        lineArr = line.split(" ");
        resultRow = Integer.parseInt(lineArr[0]) - 1;
        resultColumn = Integer.parseInt(lineArr[1]) - 1;
        p = Integer.parseInt(reader.readLine());
        if (m == 1) {
            writer.write(String.valueOf(getMatrixFromFile(reader, n)[resultRow][resultColumn]));
        }
        if (m <= 130 && m > 1 && n <= 130 && n >= 1 && resultRow <= n && resultRow >= 0 && resultColumn <= n && resultColumn >= 0 && p <= 1000) {
            int[] resultArray = multiply(getMatrixFromFile(reader, n)[resultRow], getMatrixFromFile(reader, n), n, p);
            while (m > 2) {
                resultArray = multiply(resultArray, getMatrixFromFile(reader, n), n, p);
                m--;
            }
            writer.write(String.valueOf(resultArray[resultColumn]));
        }
        reader.close();
        writer.close();
    }

    private static int[][] getMatrixFromFile(BufferedReader reader, int matrixSize) throws IOException {
        reader.readLine();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            String line = reader.readLine();
            String[] lineArr = line.split(" ");
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(lineArr[j]);
            }
        }
        return matrix;
    }

    private static int[] multiply(int[] a, int[][] b, int matrixSize, int p) {
        int[] result = new int[matrixSize];
        for (int j = 0; j < matrixSize; j++) {
            for (int k = 0; k < matrixSize; k++) {
                result[j] += a[k] * b[k][j];
                if (result[j] >= p) {
                    result[j] = result[j] % p;
                }
            }
        }
        return result;
    }
}
