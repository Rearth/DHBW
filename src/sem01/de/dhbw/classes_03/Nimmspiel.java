package de.dhbw.java.exercise.classes_03;

import java.util.Scanner;

public class Nimmspiel {

    private int haufenA = 0;
    private int haufenB = 0;
    private final String playerA;
    private final String playerB;

    public static void main(String[] args) {
        new Nimmspiel((int) (Math.random() * 20) + 1, (int) (Math.random() * 20) + 1, "Dagobert", "Donald").start();

    }

    public Nimmspiel(int haufenA, int haufenB, String playerA, String playerB) {
        this.haufenA = haufenA;
        this.haufenB = haufenB;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {

        String curPlayer = playerA;

        while (true) {
            //set Next player
            if (curPlayer == playerA) {
                curPlayer = playerB;
            } else {
                curPlayer = playerA;
            }

            System.out.println(curPlayer + ", please choose a stack to draw from! Status: " + this.toString());
            //set stack to draw from
            int drawFrom = 0;

            if (haufenA == 0) {
                drawFrom = 1;
                System.out.println("Drawing from StapelB");
            } else if (haufenB == 0) {
                drawFrom = 0;
                System.out.println("Drawing from StapelA");
            } else {
                drawFrom = getAmount(1, 2) - 1;
            }
            //set draw amount
            System.out.println("Choose amount to draw");

            int drawAmount;
            if (drawFrom == 0) {
                drawAmount = getAmount(1, haufenA);
            } else {
                drawAmount = getAmount(1, haufenB);
            }

            //apply change
            System.out.println("Drawing " + drawAmount + " from stack " + drawFrom + " for player " + curPlayer);
            if (drawFrom == 0) {
                haufenA -= drawAmount;
            } else {
                haufenB -= drawAmount;
            }



            //check if someone has won
            if (haufenA == 0 && haufenB == 0) {
                System.out.println(curPlayer + " has won! Restarting Game");
                break;
            }
        }

        new Nimmspiel((int) (Math.random() * 20) + 1, (int) (Math.random() * 20) + 1, playerA, playerB).start();

    }

    private int getAmount(int from, int to) {
        int num = 0;
        try {
            num = new Scanner(System.in).nextInt();
        } catch (java.util.InputMismatchException ex) {
            System.out.println("Please enter a number between " + from + " and " + to);
            return getAmount(from, to);
        }
        if (num < from || num > to) {
            System.out.println("Please enter a number between " + from + " and " + to);
            return getAmount(from, to);
        } else {
            return num;
        }
    }

    @Override
    public String toString() {
        return "Nimmspiel{" +
                "haufenA=" + haufenA +
                ", haufenB=" + haufenB +
                ", playerA='" + playerA + '\'' +
                ", playerB='" + playerB + '\'' +
                '}';
    }
}
