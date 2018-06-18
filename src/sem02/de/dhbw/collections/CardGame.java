package sem02.de.dhbw.collections;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    public static void main(String[] args) {

        System.out.println("Starting...");
        Spielkarte harz7 = new Spielkarte("HERZ", "SIEBEN");
        Kartenspiel datSpiel = new Kartenspiel();
        datSpiel.shuffle();
        for (int i = 0; i< 10; i++){
            Spielkarte temp = datSpiel.get();
            System.out.println(i + 1 + "te Karte: " + temp.toString());
            if (temp.compareTo(harz7) == -1){
                System.out.println(" - Karte ist kleiner als Herz 7");
            }
            else {
                System.out.println(" - Karte ist größer als Herz 7");
            }
        }
        datSpiel.sort();
        System.out.println("\n");
        datSpiel.ausgabe();

    }

    public enum Farbe {KARO("Karo"),HERZ("Herz"), PIK("Pik"), KREUZ("Kreuz");
        public String name;
        private Farbe(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }

    public static class Kartenspiel {
        ArrayList<Spielkarte> datStapel = new ArrayList<Spielkarte>();

        public Kartenspiel(){
            for (Farbe wat : Farbe.values()){
                for (Kartenwert dat : Kartenwert.values()){
                    datStapel.add(new Spielkarte(wat.getName(), (dat.name().substring(0,1))+ dat.name().substring(1).toLowerCase()));
                }
            }
        }

        public void ausgabe(){
            for (Spielkarte k : datStapel){
                System.out.println(k.toString());
            }
        }

        public void shuffle(){
            Collections.shuffle(datStapel);
        }

        public void sort(){
            Collections.sort(datStapel);
        }

        public Spielkarte get(){
            Spielkarte top = datStapel.get(datStapel.size()-1);
            datStapel.remove(datStapel.size()-1);
            return top;
        }

        public ArrayList<Spielkarte> all(){
            return datStapel;
        }
    }

    public enum Kartenwert {SIEBEN("7"), ACHT("8"), NEUN("9"), BUBE("Bube"), DAME("Dame"), KÖNIG("König"), ZEHN("10"), ASS("Ass");
        public String wert;
        private Kartenwert(String wert) {
            this.wert = wert;
        }
    }

    public static class Spielkarte implements Comparable<Spielkarte> {
        public String kartenfarbe;
        public String kartenwert;
        public int vergleichswert;

        public Spielkarte(String farbe, String wert){
            this.kartenfarbe = farbe;
            this.kartenwert = wert;
            vergleichswert = (Farbe.valueOf(kartenfarbe.toUpperCase()).ordinal() * 10) + (Kartenwert.valueOf(kartenwert.toUpperCase()).ordinal());
        }
        public Spielkarte(){

        }

        public String toString(){
            return String.format("Die Karte ist %s %s.", kartenfarbe, kartenwert);
        }

        @Override
        public int compareTo(Spielkarte o) {
            if ((this.vergleichswert - o.vergleichswert) >= 0){
                return 1;
            }
            else {
                return -1;
            }
        }
    }

}
