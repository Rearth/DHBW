package de.dhbw.probeklausur;

import java.util.Arrays;

public class Visit {

    private Field[] fields;

    public Visit(Field[] fields) {
        if (fields.length > 3) {
            throw new IllegalArgumentException("Can't throw more than 3 darts");
        }
        this.fields = fields;
    }

    public Field[] getFields() {
        return fields;
    }

    public int getValue() {
        int sum = 0;
        for(Field field : fields) {
            if (field == null) {
                continue;
            }

            sum += field.getValue();
        }

        return sum;
    }

    public Field getLastField() {
        return fields[fields.length - 1];
    }

    @Override
    public String toString() {
        return "Visit{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }
}
