package sem02.de.dhbw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurrencyCalculator extends JFrame {

    JButton EURtoUSD;
    JButton USDtoEUR;
    JButton cancel;
    JTextField enterArea;

    public CurrencyCalculator(String title) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        enterArea = new JTextField();
        //enterArea.setSize(450, 50);

        EURtoUSD  = new JButton("€ to $");
        //EURtoUSD.setSize(150, 50);
        USDtoEUR = new JButton("$ to €");
        //USDtoEUR.setSize(150, 50);
        cancel = new JButton("cancel");
        //cancel.setSize(100, 50);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        bottom.add(EURtoUSD, BorderLayout.WEST);
        bottom.add(USDtoEUR, BorderLayout.CENTER);
        bottom.add(cancel, BorderLayout.EAST);

        EURtoUSD.addActionListener(this::EUtoUS);
        USDtoEUR.addActionListener(this::UsToEU);
        cancel.addActionListener(ae -> System.exit(0));

        panel.add(enterArea, BorderLayout.NORTH);
        panel.add(bottom, BorderLayout.CENTER);
        this.add(panel);
        this.setSize(300,90);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void UsToEU(ActionEvent actionEvent) {
        System.out.println("converting " + this.enterArea.getText() + " to Euro");
        String input = enterArea.getText();

        if (isValid(input)) {
            enterArea.setText(String.valueOf(Float.valueOf(enterArea.getText()) / 1.14f));
        }

    }

    private void EUtoUS(ActionEvent actionEvent) {
        System.out.println("converting " + this.enterArea.getText() + " to USD");
        String input = enterArea.getText();

        if (isValid(input)) {
            enterArea.setText(String.valueOf(Float.valueOf(enterArea.getText()) * 1.14f));
        }

    }

    private boolean isValid(String input) {
        try {
            Float.valueOf(input);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("caught exception!");
            JOptionPane.showMessageDialog(this, "Ungültige Eingabe");
            return false;
        }
    }


    public static void main(String[] args) {
        JFrame frame = new CurrencyCalculator("CurrencyCalculator");
        frame.setVisible(true);
    }

}
