package sem02.de.dhbw.enums;

import java.util.Calendar;

public class Months {

    private enum month {
        Januar (31, "Hartung, Eismond"),
        Februar (28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
        März (31, "Lenzing, Lenzmond"),
        April (30, "Launing, Ostermond"),
        Mai (31, "Wintermond, Blumenmond"),
        Juni (30, "Brachet, Brachmond"),
        Juli (31, "Heuert, Heumond"),
        August (31, "Ernting, Erntemond, Bisemond"),
        September (30, "Scheiding, Herbstmond"),
        Oktober (31, "Gilbhart, Gilbhard, Weinmond"),
        November (30, "Nebelung, Windmond, Wintermond"),
        Dezember (31, "Julmond, Heilmond, Christmond, Dustermond");

        public int dayOfMonth;
        public String oldName;

        month(int days, String oldName) {
            dayOfMonth = days;
            this.oldName = oldName;
        }

        @Override
        public String toString() {
            return "month{" +
                    "dayOfMonth=" + dayOfMonth +
                    ", oldName='" + oldName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        int date = Calendar.getInstance().get(Calendar.MONTH);
        System.out.println(month.values()[date].name() + " " + month.values()[date]);

    }

}
