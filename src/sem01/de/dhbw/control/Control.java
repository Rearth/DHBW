package de.dhbw.java.exercise.control;

import java.util.Scanner;

public class Control {

    public static void main(String[] args) {
        System.out.println("Starting");
        runAufgabeA();
        pause();
        runAufgabeB();
        pause();
        runAufgabeC();
        pause();
        runAufgabeD();
        pause();
        runAufgabeE();
        pause();
        runAufgabeF();
        pause();
        runAufgabeG();
        pause();
        runAufgabeH();
    }

    private static void pause() {
        System.out.println("---------------------------");
        new Scanner(System.in).nextLine();
    }

    //leap year aufgabe
    public static void runAufgabeA() {
        System.out.println("Enter year");
        int year = new Scanner(System.in).nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("is a Leap Year");
            return;
        }

        System.out.println("no leap year");
    }

    //temperatureTable
    public static void runAufgabeB() {

        System.out.println("Fahrenheit | Celsius");
        System.out.println("----------------------");

        for(int i=0; i <= 300; i += 20) {
            float celsius = getCelsius(i);
            System.out.printf("%3d        | %.1f\n", i, celsius);
        }

    }

    public static float getCelsius(int temp) {

        return Math.round(((5f / 9f) * (temp - 32)) * 10) / 10f;

    }

    //Deers, rekursiv
    public static void runAufgabeC() {

        System.out.println("Rehbestand:");
        int deers = 200;
        nextYear(deers, 1);

    }

    public static void nextYear(int deers, int year) {

        if (deers > 300) {
            return;
        }
        deers *= 1.1f;
        deers = (int) deers;
        deers -=15;

        System.out.printf("%2d. deers: %3d\n", year, deers);

        nextYear(deers, ++year);

    }

    //Muliplikationtable
    public static void runAufgabeD() {

        for (int i=1; i <= 10; i++) {
            for(int j=1; j <= 10; j++) {

                int curRes = j * i;
                System.out.printf("%4d", curRes);

            }
            System.out.println("");
        }

    }

    //Addup
    public static void runAufgabeE() {
        System.out.println("Zahlen eingeben, neg. zum abbrechen");

        int num = 0;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int input = scanner.nextInt();
            if (input >= 0) {
                num += input;
            } else {
                break;
            }
        }

        System.out.println("Summe " + num);
        System.out.println("now with do-while");

        num = 0;
        boolean done = false;

        do {
            int input = scanner.nextInt();
            if (input >= 0) {
                num += input;
            } else {
                done = true;
            }
        } while (!done);

        System.out.println("Summe " + num);

    }

    public static float round(float toRound) {
        return Math.round(toRound * 100) / 100f;
    }

    //ShoeSize
    public static void runAufgabeF() {
        //float begin = 19.33f;
        float steps = 0.67f;

        System.out.println(" Zentimeter | Größe");
        System.out.println("-------------------");

        for (int i = 30; i < 50; i++) {

            //float curNum = begin + steps * i;
            //curNum = round(curNum);
            float to = round(i / 1.5f);
            float from = round(to - steps);

            System.out.printf("%2.2f - %2.2f     |  %2d\n", from, to, i);
        }
    }

    //Babylon
    public static void runAufgabeG() {
        System.out.println("Bitte zahl zum teilen eingeben");
        int nextNum = new Scanner(System.in).nextInt();

        int i = 0;
        int begin = nextNum;

        float x = 1;
        while(true) {

            System.out.println(i + ": " + x);
            i++;

            float num = x;
            x = (x + begin / x) / 2f;


            if (Math.abs(num - x) < Math.pow(10f, -6f)) {
                break;
            }

        }
        System.out.println("done, result: " + round(x));
        //printWurzel(nextNum, nextNum);
    }


    //numberGuess
    public static void runAufgabeH() {

        int toGuess = (int) (Math.random() * 100) + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte namen eingeben");
        String name = scanner.nextLine();

        while (true) {

            System.out.println("Nächster Tipp: ");
            int tip = scanner.nextInt();

            if (tip > toGuess) {
                System.out.println("zu hoch");
            } else if (tip < toGuess) {
                System.out.println("zu tief");
            } else {
                System.out.println(name + " hat gewonnen");
                break;
            }
        }

        System.out.println("fortsetzen? 1=ja, 0=nein");
        int goOn = scanner.nextInt();

        if (goOn == 1) {
            runAufgabeH();
        } else {
            System.out.println("Danke fürs spielen " + name);
        }
    }

}
