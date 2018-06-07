package de.dhbw.java.exercise.classes_02;

import java.util.Arrays;

public class Horner {

    private final Float[] numbers;

    public static void main(String[] args) {
        //Horner horner = new Horner(11f, 7f, -5f, -4f, 2);
        Horner horner = new Horner(1f, -2f, 3f, 4.5f, 8f, -10f, 3f, 4f, 2f, -3f, 0.5f);
        System.out.println(horner);
        System.out.println(horner.getFX(1.5f));
    }

    public Horner(float ... floats) {
        //numbers = floats; cant cast float[] to java.lang.float[] ????
        numbers = new Float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            numbers[i] = floats[i];
        }
    }

    public float getFX(float x) {
        float res = numbers[numbers.length - 1];

        for (int i = numbers.length - 2; i >= 0; i--) {
            //System.out.println("calculating: x=" + x + " res=" + res + " numbers[i]=" + numbers[i] + " i=" + i);
            res = x * res + numbers[i];
        }

        return res;
    }

    @Override
    public String toString() {
        String toReturn = "";

        for (int i = 0; i < numbers.length; i++) {
            toReturn += numbers[i] + "*x^" + i + " + ";
        }

        return toReturn;
    }
}
