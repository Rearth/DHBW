package de.dhbw.probeklausur;

public class Field {

    private final String label;
    private final int value;
    private final boolean doubleField;

    public Field(String label, int value, boolean doubleField) {
        this.label = label;
        this.value = value;
        this.doubleField = doubleField;
    }

    public Field(String label, int value) {
        this.label = label;
        this.value = value;
        this.doubleField = false;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    public boolean isDoubleField() {
        return doubleField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o.toString().equalsIgnoreCase(label)) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;


        Field field = (Field) o;

        return label != null ? label.equals(field.label) : field.label == null;
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Field{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", doubleField=" + doubleField +
                '}';
    }
}
