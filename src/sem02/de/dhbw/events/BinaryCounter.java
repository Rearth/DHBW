package de.dhbw.ui.events;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BinaryCounter extends JFrame {

    private JLabel result;
    private binaryTicker[] tickers;

    public BinaryCounter() {
        super("binarycounter");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 9, 5, 5));

        tickers = new binaryTicker[8];

        for (int i = 0; i < 8; i++) {
            tickers[i] = new binaryTicker(i);
            panel.add(tickers[i]);
        }


        result = new JLabel("0");
        panel.add(result);

        this.add(panel);
        this.setSize(400,120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void setResult(int num) {
        result.setText(String.valueOf(num));
    }

    private void reCalc() {
        System.out.println("recalculating");
        int sum = 0;
        for (binaryTicker ticker : tickers) {
            System.out.println("count | value: " + ticker.getCount() + " | " + ticker.getValue());
            sum += ticker.getValue();
        }

        setResult(sum);
    }

    public static void main(String[] args) {
        JFrame frame = new BinaryCounter();
        frame.setVisible(true);
    }

    private class binaryTicker extends JPanel {

        JToggleButton but;
        JLabel label;
        int count;

        public binaryTicker(int count) {
            super();
            super.setLayout(new BorderLayout());

            ImageIcon imgOff = new ImageIcon("off.png");
            ImageIcon imgOn = new ImageIcon("on.png");

            but.setIcon(imgOff);
            but.setSelectedIcon(imgOn);

            label = new JLabel("2^" + count);
            but = new JToggleButton();
            but.setPreferredSize(new Dimension(100, 40));
            but.addActionListener(ae -> reCalc());

            this.add(label, BorderLayout.SOUTH);
            this.add(but, BorderLayout.NORTH);

            this.count = count;

        }

        public boolean isSelected() {
            return but.isSelected();
        }

        public int getCount() {return count;}

        public int getValue() {
            if (!this.isSelected()) {
                return 0;
            }
            return (int) Math.pow(2d, (double) count);
        }

    }

}
