package de.dhbw.java.exercise.classes_02;

import java.util.Arrays;

public class Complex implements Comparable<Complex> {

    private float real;
    private float imag;

    public static void main(String[] args) {

        Complex A = new Complex(1, 2);
        Complex B = new Complex(2, 4);
        System.out.println("A + B " + A.clone().add(B));
        System.out.println("A - B " + A.clone().sub(B));
        System.out.println("A * B " + A.clone().multiply(B));
        System.out.println("A / B " + A.clone().div(B));
        System.out.println("A < B " + A.compareTo(B));

        Complex[] numbers = new Complex[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Complex((float) Math.random() * 100f, (float ) Math.random() * 100f);
            System.out.println("Generated number: " + numbers[i]);
        }

        System.out.println("Sorting...");
        Arrays.sort(numbers);
        for (Complex number : numbers) {
            System.out.println(number);
        }

    }

    public Complex(float real, float imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex toAdd) {
        real += toAdd.real;
        imag += toAdd.imag;

        return this;
    }

    public Complex sub(Complex toAdd) {
        real -= toAdd.real;
        imag -= toAdd.imag;

        return this;
    }

    public Complex multiply(Complex toAdd) {
        this.real = real * toAdd.real - imag * toAdd.imag;
        this.imag = real + toAdd.imag + imag * toAdd.real;

        return this;
    }

    public Complex div(Complex toDiv) {
        this.real = (real * toDiv.real + imag * toDiv.imag) / (toDiv.real * toDiv.real + toDiv.imag * toDiv.imag);
        this.imag = (imag * toDiv.real - real * toDiv.imag) / (toDiv.real * toDiv.real + toDiv.imag * toDiv.imag);
        return this;
    }

    public double getMagnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public float getReal() {
        return real;
    }

    public float getImag() {
        return imag;
    }

    public Complex clone() {
        return new Complex(real, imag);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }


    @Override
    public int compareTo(Complex o) {
        return Double.compare(this.getMagnitude(), o.getMagnitude());
    }
}
