package de.dhbw.java.exercise.arrays;

import java.util.Scanner;

public class Arrays_2 {

    public static void main(String[] args) {
        //empty
    }

    //Matrixsubtraction
    public static void runAufgabeA() {

        System.out.println("Enter number of lines");
        int m = new Scanner(System.in).nextInt();
        System.out.println("Enter number of rows");
        int n = new Scanner(System.in).nextInt();

        int[][] matrixA = genMatrix(m, n);
        int[][] matrixB = genMatrix(m, n);

        System.out.println("A - B: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = matrixA[i][j] - matrixB[i][j];
                System.out.printf("%4d", matrixA[i][j]);
            }
            System.out.println();

        }

    }

    private static int[][] genMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        System.out.println("Generating Matrix:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 100) + 1;
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        return matrix;
    }


    //Pascals Dreieck
    public static void runAufgabeB() {
        //cheaty:
        System.out.println("    1");    //1
        System.out.println("   1 1");   //11
        System.out.println("  1 2 1");  //121
        System.out.println(" 1 3 3 1"); //1331
        System.out.println("1 4 6 4 1");//14641

        //real:

        System.out.println("alternativ:");
        System.out.println("Enter number of rows:");
        int rows = new Scanner(System.in).nextInt();
        int[][] triangle = new int[rows][rows];
        triangle[0][0] = 1;
        for (int j = 0; j < rows; j++) {
            System.out.print("  ");
        }

        //1 at the top
        System.out.println("   1");

        //loop through rows
        for (int i = 1; i < rows; i++) {

            //print spaces for formatting
            for (int j = 0; j < rows - i; j++) {
                System.out.print("  ");
            }

            //loop through each element int the row (number of current row + 1
            for (int j = 0; j < i + 1; j++) {
                //element in the row above
                int num = triangle[i - 1][j];

                //element in the row above to the left (if to prevent outOfBoundaryException)
                if (j > 0) {
                    num += triangle[i - 1][j - 1];
                }

                //print stuff
                triangle[i][j] = num;
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

}
