package de.dhbw.java.exercise.vererbung;

public class race {

    public static void main(String[] args) {
        Vehicle vehicles[] = new Vehicle[4];

        vehicles[0] = new Vehicle.Bicycle(20.0);
        vehicles[1] = new Vehicle.Car(150.0);
        vehicles[2] = new Vehicle.RacingCar(200.0);
        vehicles[3] = new Vehicle.Ambulance(80.0, true);
        // 4 hours lead for the bike

        vehicles[0].drive(240.0);
        // 1 hour of driving for everyone

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].drive(60);
        }

        // Output Race
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].toString());
            vehicles[i].info();
        }

    }

}
