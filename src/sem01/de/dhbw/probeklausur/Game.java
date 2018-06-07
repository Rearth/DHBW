package de.dhbw.probeklausur;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    final Board board;
    final Player[] players;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        System.out.println("Starting Game!");

        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        int curPlayer = 0;

        while(!finished) {

            Player player = players[curPlayer];

            System.out.println(" ----------------------------------------");
            System.out.println("Bitte nächsten Wurf eingeben. Spieler: " + player.getName() + ", Remaining Points: " + player.getRemainingPoints() + ", Verbleibende Würfe: " + (10 - player.getCountDartsThrown()));

            if (player.getRemainingPoints() <= 170) {
                printCheckout(player.getRemainingPoints());
            }

            String input = scanner.nextLine();
            String[] hits = input.split(" ");

            Field[] fieldsHit = new Field[hits.length];
            for (int i = 0; i < hits.length; i++) {
                Field curHit = board.parseField(hits[i]);
                if (curHit == null) {
                    continue;
                }
                fieldsHit[i] = curHit;
            }


            /*if (fieldsHit.length > 10 - player.getCountDartsThrown()) {
                System.out.println("zu viele Würfe");
                fieldsHit = new Field[0];
            }*/
            //System.out.println(Arrays.toString(fieldsHit));

            Visit visit = new Visit(fieldsHit);

            System.out.println("Hits: " + fieldsHit.length + " value: " + visit.getValue() + ", gültig: " + player.addVisit(visit));
            System.out.println("Remaining Points: " + player.getRemainingPoints());


            if (isDone(player)) {
                System.out.println(player.getName() + " has won the Game!");
                finished = true;
                saveWinner(player);
            } else if (player.getCountDartsThrown() >= 10) {
                System.out.println("Too many throws, stopping");
                finished = true;
            }
            curPlayer = curPlayer == 0 ? 1 : 0;

        }

        System.out.println("Game Finished");
    }

    private void printCheckout(int remainingPoints) {

        List<String> checkouts = null;

        try {
            checkouts = readfileList(new File("probeklausur/checkouts.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find checkouts file, should be located in: " + new File("probeklausur/checkouts.txt").getAbsolutePath());
            return;
        }

        String text = checkouts.get(remainingPoints - 1);
        if (text.equals("-")) {
            text = "Keine Lösung möglich";
        }

        System.out.println("Lösung: " + text);

    }

    public static List<String> readfileList(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        ArrayList<String> contents = new ArrayList<>();

        while (input.hasNextLine()) {
            contents.add(input.nextLine());
        }

        return contents;
    }

    private static void saveWinner(Player player) {

        String text = player.getName() + " has won with " + player.getCountDartsThrown() + " Darts!";
        writeToFile(new File("probeklausur/winners.dart"), text, true);

    }

    public static void writeToFile(File save, String text, boolean append) {

        if (!save.exists()) {
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
        System.out.println("Stored file: " + save.getAbsolutePath());
    }

    private static boolean isDone(Player player) {
        return player.getRemainingPoints() == 0;
    }
}
