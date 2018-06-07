package de.dhbw.java.exercise.classes_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lotto {

    private final int maxKugeln;
    private final int drawAmount;

    private int[] tips;
    private int[] draws;

    public static void main(String[] args) {

        Lotto lotto = new Lotto(49, 6);
        System.out.println(lotto);
        for (int i = 0; i < 6; i++) {
            lotto.tip();
        }
        System.out.println(lotto);
        System.out.println("Ziehe...");
        lotto.ziehen();
        System.out.println(lotto);

    }

    public Lotto(int maxKugeln, int drawAmount) {
        this.maxKugeln = maxKugeln;
        this.drawAmount = drawAmount;

        tips = new int[drawAmount];
        draws = new int[drawAmount];
    }

    public void tip() {

        int curTip = 0;
        for (int i = 0; i < drawAmount; i++) {
            if (tips[i] == 0) {
                curTip = i + 1;
                break;
            }
        }

        System.out.println("Please enter Tip #" + curTip);

        int tipped = new Scanner(System.in).nextInt();
        if (tipped < 1 || tipped > maxKugeln) {
            System.out.println("Tip a number between 0 and " + maxKugeln);
            tip();
            return;
        }

        tips[curTip - 1] = tipped;
    }

    public int[] getTips() {
        return tips;
    }

    public void ziehen() {
        for (int i = 0; i < drawAmount; i++) {
            draws[i] = getNum();
        }

        int right = 0;

        for (int i : getTips()) {
            for (int j : draws) {
                if (i == j) {
                    right++;
                    System.out.println("Found match: " + i);
                }
            }
        }

        System.out.println("Right guessed: " + right);
    }

    private int getNum() {
        int num = (int) (Math.random() * maxKugeln) + 1;
        for (int i : draws) {
            if (i == num) {
                return getNum();
            }
        }
        return num;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "maxKugeln=" + maxKugeln +
                ", drawAmount=" + drawAmount +
                ", tips=" + Arrays.toString(tips) +
                ", draws=" + Arrays.toString(draws) +
                '}';
    }
}
