package de.dhbw.java.exercise.arrays;

import java.util.*;

public class Arrays_1 {

    //standardDeviation
    public static void runAufgabeA() {

        final int size = 100;

        int numbers[] = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 11);
            sum += numbers[i];
        }

        float avg = sum / (float) numbers.length;
        System.out.println("Mittelwert: " + avg);

        //varianz
        float sumVar = 0f;
        for (int i : numbers) {
            sumVar += Math.pow(i - avg, 2.0);
        }

        System.out.printf("Standartabweichung: %.3f\n", Math.sqrt((sumVar / size - 1)));

    }

    //fibonacci
    public static void runAufgabeB() {

        long numbers[] = new long[50];
        numbers[0] = 1;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        for (long i : numbers) {
            System.out.println(i);
        }

        System.out.println("Done");

    }


    //primzahlen
    public static void runC() {

        System.out.println("oberlimit eingeben");
        int limit = new Scanner(System.in).nextInt();

        List<Integer> primes = getPrimes(limit);

        for (int i : primes) {
            System.out.println(i);
        }

    }

    public static  List<Integer> getPrimes(int limit) {

        double beginTime = System.currentTimeMillis();

        List<Integer> numbers = new ArrayList<>();
        List<Integer> toRemove = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            numbers.add(i);
        }

        while (numbers.size() > 0) {
            int min = numbers.get(0);
            primes.add(min);
            System.out.println("Found prime: " + min);
            for (int i : numbers) {
                if (i % min == 0) {
                    toRemove.add(i);
                }
            }

            LinkedHashSet<Integer> tmp = new LinkedHashSet<>(numbers);
            //HashSet<Integer> tmp = new HashSet<>(numbers);
            tmp.removeAll(toRemove);
            numbers = new ArrayList<>(tmp);
            toRemove.clear();


            //numbers.removeAll(toRemove);
            //toRemove.clear();
        }

        System.out.println("total time: " + (System.currentTimeMillis() - beginTime) / 1_000.0D);
        return primes;

    }


    //Vektorbetrag
    public static void runD() {

        int numbers[] = getVector();

        int sum = 0;
        for (int i : numbers) {
            sum += i * i;
        }

        System.out.println("Betrag: " + Math.sqrt(sum));

    }


    //skalarprodukt
    public static void runE() {

        System.out.println("länge eingeben");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int numbersA[] = getVector(length);
        int numbersB[] = getVector(length);

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += numbersA[i] * numbersB[i];
        }

        System.out.println("Dot: " + sum);

    }

    private static int[] getVector() {
        System.out.println("Länge eingeben");
        int length = new Scanner(System.in).nextInt();

        return getVector(length);
    }

    private static int[] getVector(int length) {

        System.out.println(length + " Werte eingeben für Zahlenreihe");

        int numbers[] = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = new Scanner(System.in).nextInt();
        }

        return  numbers;
    }

    //Bubblesort
    public static void runF() {

        int numbers[] = getVector();

        while (true) {

            int changes = 0;

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    System.out.println("changing " + numbers[i] + " and " + numbers[i - 1]);
                    changes++;

                    int old = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = old;
                }
            }

            if (changes == 0) {
                System.out.println("done!");
                break;
            }
        }

        System.out.println("numbers: " + java.util.Arrays.toString(numbers));

    }

}
