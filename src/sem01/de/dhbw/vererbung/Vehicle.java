package de.dhbw.java.exercise.vererbung;

public abstract class Vehicle {

    public int Wheels = 0;
    public double VMax = 0.0f;
    public int curPos = 0;
    public double curSpeed = 0.0f;

    public static void main(String[] args) {
        System.out.println("Starting...");
    }

    public void setSpeed(double speed) {
        if (speed > this.VMax) {
            this.curSpeed = VMax;
        } else {
            this.curSpeed = speed;
        }
    }

    public void drive(double minutes) {
        this.curPos +=  (int) (minutes * (1f / 60f) * curSpeed);
    }

    public Vehicle(int wheels, double VMax, double speed) {
        Wheels = wheels;
        this.VMax = VMax;
        this.curSpeed = speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Wheels=" + Wheels +
                ", VMax=" + VMax +
                ", curPos=" + curPos +
                ", curSpeed=" + curSpeed +
                ", type=" + this.getClass().getSimpleName() +
                '}';
    }

    public static class Bicycle extends Vehicle {

        public Bicycle(double speed) {
            super(2, 30, speed);
        }

        @Override
        public void info() {
            System.out.println(this);
        }
    }

    public static class Car extends Vehicle {
        @Override
        public void info() {
            System.out.println(this);
        }

        public Car(double speed) {
            super(4, 140, speed);
        }

        public Car(int wheels, double VMax, double speed) {
            super(wheels, VMax, speed);
        }
    }

    public static class RacingCar extends Car {

        public RacingCar(double speed) {
            super(4, 220, speed);
        }
    }

    public static class Ambulance extends Car {

        private boolean blueLight = false;

        public Ambulance(double speed, boolean blueLight) {
            super(speed);
            this.blueLight = blueLight;
        }

        public boolean isBlueLight() {
            return blueLight;
        }

        public void setBlueLight(boolean blueLight) {
            this.blueLight = blueLight;
        }

        @Override
        public String toString() {
            return "Ambulance{" +
                    "Wheels=" + Wheels +
                    ", VMax=" + VMax +
                    ", curPos=" + curPos +
                    ", curSpeed=" + curSpeed +
                    ", blueLight=" + blueLight +
                    "type= " + this.getClass().getSimpleName() +
                    '}';
        }
    }

    public abstract void info();
}
