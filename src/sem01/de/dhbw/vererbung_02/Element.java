package de.dhbw.java.exercise.vererbung_02;

/**
 * Created by rearth on 02.03.2018.
 */
public class Element {
    protected String Name, Symbol;
    protected int Ordnungszahl, Aggregatszustand;
    protected char Schale;
    protected boolean Hauptgruppe;

    public Element(String name, String symbol, int ordnungszahl, int aggregatszustand, char schale, boolean hauptgruppe) {
        Name = name;
        Symbol = symbol;
        Ordnungszahl = ordnungszahl;
        Aggregatszustand = aggregatszustand;
        Schale = schale;
        Hauptgruppe = hauptgruppe;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getOrdnungszahl() {
        return Ordnungszahl;
    }

    public void setOrdnungszahl(int ordnungszahl) {
        Ordnungszahl = ordnungszahl;
    }

    public int getAggregatszustand() {
        return Aggregatszustand;
    }

    public void setAggregatszustand(int aggregatszustand) {
        if (aggregatszustand >= 0 && aggregatszustand < 4){
            Aggregatszustand = aggregatszustand;
        }
    }

    public char getSchale() {
        return Schale;
    }

    public void setSchale(char schale) {
        Schale = schale;
    }

    public boolean isHauptgruppe() {
        return Hauptgruppe;
    }

    public void setHauptgruppe(boolean hauptgruppe) {
        Hauptgruppe = hauptgruppe;
    }

    @Override
    public String toString() {
        return "Element{" +
                "Name='" + Name + '\'' +
                ", Symbol='" + Symbol + '\'' +
                ", Ordnungszahl=" + Ordnungszahl +
                ", Aggregatszustand=" + Aggregatszustand +
                ", Schale=" + Schale +
                ", Hauptgruppe=" + Hauptgruppe +
                '}';
    }

    public boolean equals(Object o){
        if (o instanceof Element && this.getOrdnungszahl() == ((Element) o).getOrdnungszahl()){
            return true;
        }
        else{
            return false;
        }
    }

    public static class Metal extends Element {

        public boolean metalloid = true;
        public float inductity = 0.0f;

        public Metal(String name, String symbol, int ordnungszahl, int aggregatszustand, char schale, boolean hauptgruppe, boolean metalloid, float inductity) {
            super(name, symbol, ordnungszahl, aggregatszustand, schale, hauptgruppe);
            this.metalloid = metalloid;
            this.inductity = inductity;
        }

        public boolean isMetalloid() {
            return metalloid;
        }

        public void setMetalloid(boolean metalloid) {
            this.metalloid = metalloid;
        }

        public float getInductity() {
            return inductity;
        }

        public void setInductity(float inductity) {
            this.inductity = inductity;
        }

        @Override
        public String toString() {
            return "Metal{" +
                    "Name='" + Name + '\'' +
                    ", Symbol='" + Symbol + '\'' +
                    ", Ordnungszahl=" + Ordnungszahl +
                    ", Aggregatszustand=" + Aggregatszustand +
                    ", Schale=" + Schale +
                    ", Hauptgruppe=" + Hauptgruppe +
                    ", metalloid=" + metalloid +
                    ", inductity=" + inductity + "\uF073" +
                    '}';
        }
    }




}