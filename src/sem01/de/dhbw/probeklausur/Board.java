package de.dhbw.probeklausur;

import java.util.Arrays;

public class Board {

    Field[] fields = new Field[64];

    public Board() {
        for (int i = 1; i <= 20; i++) {
            fields[i - 1] = new Field(Integer.toString(i), i);
            fields[i + 19] = new Field("D" + Integer.toString(i), i * 2, true);
            fields[i + 39] = new Field("T" + Integer.toString(i), i * 3);
        }

        fields[60] = new Field("25", 25);
        fields[61] = new Field("BULL", 50, true);
        fields[62] = new Field("X", 0);
        fields[63] = new Field("cheat", 501, true);
    }

    public Field parseField(String label) {
        for (Field field : fields) {
            if (field.equals(label)) {
                return field;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }
}
