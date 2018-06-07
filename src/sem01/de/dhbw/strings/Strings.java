package de.dhbw.java.exercise.strings;

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        runAufgabeA();
        runAufgabeB();
        runAufgabeC();
    }

    //CrossTool
    public static void runAufgabeA() {
        System.out.println("quersumme: " + getCrossTool(readNum()));

    }

    public static String readNum() {
        System.out.println("Please enter a number");
        return new Scanner(System.in).nextLine();
    }

    public static int getCrossTool(String input) {

        int cross = 0;

        for (int i = 0; i < input.length(); i++) {
            cross += Integer.valueOf(input.substring(i, i+1));
        }

        return cross;
    }


    //palindrom
    private static void runAufgabeB() {
        System.out.println("Wort eingeben");
        String input = new Scanner(System.in).nextLine();

        System.out.println("Palindrom: " + (new StringBuilder(input).reverse().toString().toLowerCase().equals(input.toLowerCase())));
    }

    //römer
    private static void runAufgabeC() {
        System.out.println("Zahl eingeben");
        String input = new Scanner(System.in).nextLine();

        String eingabe = input.toUpperCase();
        eingabe = eingabe.replaceAll("CM", "a");
        eingabe = eingabe.replaceAll("CD", "b");
        eingabe = eingabe.replaceAll("XC", "c");
        eingabe = eingabe.replaceAll("XL", "d");
        eingabe = eingabe.replaceAll("IX", "e");
        eingabe = eingabe.replaceAll("IV", "f");

        int wert = 0;
        for (int i = 0; i < eingabe.length(); i++){
            wert += wert(eingabe.charAt(i));
        }

        System.out.println(wert);

    }

    private static int wert(char c){

        switch (c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            case 'a':
                return 900; // CM
            case 'b':
                return 400; // CD
            case 'c':
                return 90; // XC
            case 'd':
                return 40; // XL
            case 'e':
                return 9; // IX
            case 'f':
                return 4; // IV
            default:
                return 0;
        }
    }
}
