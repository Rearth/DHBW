package de.dhbw.java.exercise.io;

import de.dhbw.java.exercise.arrays.Arrays_1;
import de.dhbw.java.exercise.strings.Strings;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IO_01 {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting IO_01");
        runAufgabeA();
        System.out.println("Aufgabe A Done");
        runAufgabeB();
        System.out.println("Aufgabe B Done");
        runAufgabeC();
        System.out.println("Aufgabe C Done");
        runAufgabeD();
        System.out.println("Aufgabe D Done");
    }

    //Aufgabe A, "arbeiten mit dateien"
    public static void runAufgabeA() throws IOException {
        File fileA = new File("myDir");
        File fileB = new File("myDir/foo1");
        File fileC = new File("myDir/foo2");
        File fileD = new File("myDir/foo3");

        if (!fileA.exists()) {
            fileA.mkdirs();
        }

        fileB.createNewFile();
        fileC.createNewFile();
        fileD.createNewFile();

        System.out.println("Files are stored in: " + fileA.getAbsolutePath() + " content: " + Arrays.toString(fileA.listFiles()));

        fileB.delete();
        fileC.delete();
        fileD.delete();
        fileA.delete();
    }

    //crosTool stored to file
    public static void runAufgabeB() {
        System.out.println("Aufgabe B");

        String input = Strings.readNum();
        int cross = Strings.getCrossTool(input);

        System.out.println("Quersumme: " + cross);

        File save = new File("io/crossData.alkjsdakbfdasdgajfa");
        writeToFile(save, "Quersumme von " + input + " ist " + cross, false);
        try {
            System.out.println(readfile(save));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(File save, String text, boolean append) {

        /*if (!save.exists()) {
            save.getParentFile().mkdirs();
            try {
                save.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(save.toString(), append));
             PrintWriter out = new PrintWriter(bw); ) {
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Stored file: " + save.getAbsolutePath());*/
    }

    public static List<String> readfileList(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        ArrayList<String> contents = new ArrayList<>();

        while (input.hasNextLine()) {
            contents.add(input.nextLine());
        }

        return contents;
    }

    public static String readfile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        StringBuilder str = new StringBuilder();

        while (input.hasNextLine()) {
            str.append(input.nextLine());
            str.append(System.lineSeparator());
        }

        return str.toString();
    }

    //palindrome to file
    public static void runAufgabeC() throws IOException {
        System.out.println("Please enter a word");

        String input = new Scanner(System.in).nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        File save = new File("io/Palindroms");

        if (reversed.toLowerCase().equals(input.toLowerCase())) {
            System.out.println(input + " ist ein palindrom");
            writeToFile(save, input + "=" + reversed, false);
        }

        System.out.println(readfile(save));
    }

    //TextFileLines, read external file
    public static void runAufgabeD() throws FileNotFoundException {

        File file = new File("io/other.creativeEnding");
        System.out.println("Reading file: " + file.getAbsolutePath());

        List<String> input = readfileList(file);

        String combination = "";

        for (int i = 1; i < 5; i++) {
            System.out.println(input.get(i));
            combination += input.get(i);
        }

        System.out.println("Zeile 2-5: " + combination);

    }

    //primzahlen
    public static void runAufgabeE() throws FileNotFoundException {
        System.out.println("Generating primes to 100000");

        List<Integer> primes = Arrays_1.getPrimes(100_000);
        System.out.println("Got primes");

        File save = new File("io/primes");
        StringBuilder toSave = new StringBuilder("");
        System.out.println("Found primes: " + primes.size());
        System.out.println();
        for (int i : primes) {
            System.out.print(i + ",");
            toSave.append(i + System.lineSeparator());
        }

        writeToFile(save, toSave.toString(), false);
        System.out.println("File written");

    }

    //find primes in file
    public static void runAufgabeF() {
        System.out.println("Please enter a prime number");
        int tocheck = new Scanner(System.in).nextInt();

        File save = new File("io/primes");
        List<String> primes = null;
        try {
            primes = readfileList(save);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (String line : primes) {
            try {
                primeNumbers.add(Integer.valueOf(line));
            } catch (NumberFormatException ex) {
                continue;
            }
        }

        if (primeNumbers.contains(tocheck)) {
            System.out.println(tocheck + " is a prime number");
        } else {
            System.out.println("no");
        }
    }

}
