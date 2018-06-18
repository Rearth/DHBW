package sem02.de.dhbw.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {

    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>();
        int sNumber = (int) (Math.random() * 49 + 1);
        for (int i = 0; i < 6; i++) {
            boolean add = numbers.add((int) (Math.random() * 49 + 1));
            if (!add) {
                i--;
            }
        }

        System.out.println(numbers + " superzahl=" + sNumber);

    }

}
