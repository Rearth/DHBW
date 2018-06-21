package sem02.de.dhbw.collections;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    public static void main(String[] args) {

        System.out.println("Starting...");
        gameCard heart6 = new gameCard("HERZ", "SIEBEN");
        Game game = new Game();
        game.shuffle();
        for (int i = 0; i< 10; i++){
            gameCard temp = game.get();
            System.out.println(i + 1 + "te Karte: " + temp.toString());
            if (temp.compareTo(heart6) == -1){
                System.out.println(" - Karte ist kleiner als Herz 7");
            }
            else {
                System.out.println(" - Karte ist größer als Herz 7");
            }
        }
        game.sort();
        System.out.println("\n");
        game.print();

    }

    public enum Color {KARO("Karo"),HERZ("Herz"), PIK("Pik"), KREUZ("Kreuz");
        public String name;
        Color(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    public static class Game {
        ArrayList<gameCard> cardStack = new ArrayList<gameCard>();

        public Game(){
            for (Color col : Color.values()){
                for (cardValue dat : cardValue.values()){
                    cardStack.add(new gameCard(col.getName(), (dat.name().substring(0,1))+ dat.name().substring(1).toLowerCase()));
                }
            }
        }

        public void print(){
            for (gameCard k : cardStack){
                System.out.println(k.toString());
            }
        }

        public void shuffle(){
            Collections.shuffle(cardStack);
        }

        public void sort(){
            Collections.sort(cardStack);
        }

        public gameCard get(){
            gameCard top = cardStack.get(cardStack.size()-1);
            cardStack.remove(cardStack.size()-1);
            return top;
        }

        public ArrayList<gameCard> all(){
            return cardStack;
        }
    }

    public enum cardValue {SIEBEN("7"), ACHT("8"), NEUN("9"), BUBE("Bube"), DAME("Dame"), KÖNIG("König"), ZEHN("10"), ASS("Ass");
        public String wert;
        cardValue(String wert) {
            this.wert = wert;
        }
    }

    public static class gameCard implements Comparable<gameCard> {
        public String kartenfarbe;
        public String kartenwert;
        public int vergleichswert;

        public gameCard(String farbe, String wert){
            this.kartenfarbe = farbe;
            this.kartenwert = wert;
            vergleichswert = (Color.valueOf(kartenfarbe.toUpperCase()).ordinal() * 10) + (cardValue.valueOf(kartenwert.toUpperCase()).ordinal());
        }

        public String toString(){
            return String.format("Die Karte ist %s %s.", kartenfarbe, kartenwert);
        }

        @Override
        public int compareTo(gameCard o) {
            if ((this.vergleichswert - o.vergleichswert) >= 0){
                return 1;
            }
            else {
                return -1;
            }
        }
    }

}
