package de.dhbw.java.exercise.methods;

import java.util.Arrays;
import java.util.Scanner;

public class methods {

    public static void main(String[] args) {
        runAufgabeA();
    }

    //Exponentiation
    public static void runAufgabeA() {

        float x;
        int n;

        try {
            System.out.println("please enter \'x\' and \'n\'");

            Scanner scanner = new Scanner(System.in);
            x = scanner.nextFloat();
            n = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Eingabefehler");
            runAufgabeA();
            return;
        }

        System.out.println("Result: " + xPowerN(x, n));

    }

    private static float xPowerN(float x, int n) {


        if (n == 0) {
            return 1f;
        }


        float res = x * xPowerN(x, n-1);
        //System.out.println("partial result: " + res);
        return res;

    }

    //fibonacci
    public static void runAufgabeB() {

        int n;

        try {
            System.out.println("please enter number of fibonacci numbers");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Eingabefehler");
            runAufgabeB();
            return;
        }


        System.out.println("Result: " + nextFibonacci(0, 1, 1, n));
    }

    private static long nextFibonacci(long lastNumber, long curNumber, int count, int limit) {


        System.out.println("F" + count +":" + curNumber);
        if (count >= limit) {
            return curNumber;
        }
        return nextFibonacci(curNumber, curNumber + lastNumber, ++count, limit);

    }

    //quicksort
    public static void runAufgabeC() {

        int count = 1024;

        int[] numbers = new int[1024];
        for (int i = 0; i < 1024; i++) {
            numbers[i] = (int) (Math.random() * 1024);
        }

        System.out.println("Unsorted: " + Arrays.toString(numbers));

        quicksort(0, numbers.length - 1, numbers);
        System.out.println("sorted: " + Arrays.toString(numbers));

    }

    private static void quicksort(int left, int right, int[] numbers) {

        if (left < right) {
            int teiler = split(left, right, numbers);
            quicksort(left, teiler - 1, numbers);
            quicksort(teiler + 1, right, numbers);
        }

    }

    private static int split(int left, int right, int[] numbers) {

        int i = left;
        int j = right;
        int pivot = numbers[right];

        do {

            while (numbers[i] <= pivot && i < right) {
                i++;
            }

            while (numbers[j] >= pivot && j > left) {
                j--;
            }

            if (i < j) {
                int part = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = part;
            }

        } while (i < j);

        if (numbers[i] > pivot) {
            int part = numbers[i];
            numbers[i] = numbers[right];
            numbers[right] = part;
        }

        return i;

    }

}
