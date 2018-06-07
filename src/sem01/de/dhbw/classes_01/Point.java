package de.dhbw.java.exercise.classes_01;

import java.awt.geom.Point2D;

public class Point {

    private float x;
    private float y;

    public static void main(String[] args) {
        Point point = new Point(5, 5);
        System.out.println(point);
        System.out.println(point.distToZero());
        System.out.println(point.mirrorX());

    }

    public double distToPoint(Point p) {
        return new Point2D.Float(x, y).distance(p.x, p.y);
    }

    public double distToZero() {
        return distToPoint(new Point(0,0));
    }

    public Point mirrorX() {
        return new Point(-x, y);
    }

    public Point mirrorY() {
        return new Point(x, -y);
    }

    public Point mirrorZero() {
        return new Point(-x, -y);
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
