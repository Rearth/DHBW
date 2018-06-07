package de.dhbw.java.exercise.classes_02;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    private float a;
    private float b;
    private float c;

    public static void main(String[] args) {
        Polynomial A = new Polynomial(2, 1, -15);
        Polynomial B = new Polynomial(0, -4, 1);
        System.out.println(A);
        System.out.println(B);
        System.out.println(A.add(B));
        System.out.println(A.scale(2));
        System.out.println(A.getZeros());
    }

    public Polynomial(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float getFX(float x) {
        return a * x * x + b * x + c;
    }

    public List<Float> getZeros() {
        List<Float> Zeroes = new ArrayList<>();

        //mit mitternachtsformel
        float D = b * b - 4 * a * c;
        if (D < 0) {
            return Zeroes;
        }

        if (D == 0) {
            Zeroes.add(-b / (2 * a));
            return Zeroes;
        } else {
            Zeroes.add((-b + (float) Math.sqrt(D)) / (2 * a) );
            Zeroes.add((-b - (float) Math.sqrt(D)) / (2 * a) );
            return Zeroes;
        }

    }

    public Polynomial scale(float scale) {
        return new Polynomial(a * scale, b * scale, c * scale);
    }

    public Polynomial add(Polynomial toAdd) {
        return new Polynomial(a + toAdd.a, b + toAdd.b, c + toAdd.c);
    }

    public Polynomial sub(Polynomial toSub) {
        return add(toSub.invert());
    }

    private Polynomial invert() {
        return new Polynomial(-a, -b, -c);
    }

    @Override
    public String toString() {
        return a + "x² + " + b + "x " + c;
    }
}
