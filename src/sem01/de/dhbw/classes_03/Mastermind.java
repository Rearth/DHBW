package de.dhbw.java.exercise.classes_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args) {
        char[] toGuess = new char[5];
        for (int i = 0; i < toGuess.length; i++) {
            toGuess[i] = (char) ((char) (Math.random() * 8) + 'A');
        }
        System.out.println("toGuess= " + Arrays.toString(toGuess));

        int curDraw = 0;

        while(true) {
            curDraw++;

            if (curDraw > 20) {
                System.out.println("Too many wrong attempts, restarting...");
                main(null);
            }

            System.out.println("Enter your tip! Round " + curDraw);
            char[] tipped = getTip();

            int rightPos = 0;
            int rightColor = 0;

            List<Character> guess = new ArrayList<>();

            for (int i = 0; i < tipped.length; i++) {
                if (tipped[i] == toGuess[i]) {
                    rightPos++;
                } else {
                    guess.add(toGuess[i]);
                }

            }

            for (int i = 0; i < tipped.length; i++) {
                if (guess.contains(tipped[i]) && tipped[i]!=toGuess[i]) {
                    rightColor++;
                    guess.remove((Object) tipped[i]);
                }
            }



            if (rightPos == 5) {
                System.out.println("You won! Solution: " + Arrays.toString(toGuess));
                System.out.println("Restarting...");
                main(null);
            }

            System.out.println("Right Positions: " + rightPos);
            System.out.println("Right colors: " + rightColor);

        }
    }

    private static char[] getTip() {
        String tipped = new Scanner(System.in).next();
        if (tipped.length() != 5) {
            System.out.println("Please Enter 5 numbers");
            return getTip();
        }

        char guessed[] = new char[5];

        for (int i = 0; i < 5; i++) {
            guessed[i] = tipped.toUpperCase().charAt(i);
            if (guessed[i] < 'A' || guessed[i] > 'H') {
                System.out.println("Please enter only numbers between A - H");
                return getTip();
            }
        }

        System.out.println("Entered " + Arrays.toString(guessed));
        return guessed;
    }

}
