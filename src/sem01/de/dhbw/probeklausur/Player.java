package de.dhbw.probeklausur;

import java.util.Arrays;

public class Player {

    private final String name;
    private int countDartsThrown = 0;
    private int remainingPoints = 501;
    private Visit[] visits = new Visit[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }

    public Visit[] getVisits() {
        return visits;
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }

    public boolean addVisit(Visit visit) {

        countDartsThrown += visit.getFields().length;

        if (remainingPoints - visit.getValue() < 0 || remainingPoints - visit.getValue() == 1 || remainingPoints - visit.getValue() == 0 && !visit.getLastField().isDoubleField()) {
            return false;
        }


        for (int i = 0; i < 10; i++) {
            if (visits[i] == null) {
                visits[i] = visit;
                break;
            }
        }

        remainingPoints -= visit.getValue();
        return true;

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", countDartsThrown=" + countDartsThrown +
                ", visits=" + Arrays.toString(visits) +
                ", remainingPoints=" + remainingPoints +
                '}';
    }
}
