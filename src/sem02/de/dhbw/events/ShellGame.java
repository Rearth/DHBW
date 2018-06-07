package de.dhbw.ui.events;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.*;

public class ShellGame extends JFrame {
    
    private int attempts = 0;
    private JLabel output;
    private JTextField textField;

    private ShellGame(String name) {
        super(name);

        JPanel panel =  new JPanel();
        panel.setLayout(new FlowLayout());

        textField = new JTextField("Player name here");
        textField.setSize(new Dimension(300, 30));
        panel.add(textField);

        JButton[] buttons = new JButton[3];
        for (int i = 0; i < 3; i++) {
            final int j = i;
            buttons[i] = new JButton("Shell" + Integer.toString(i));
            panel.add(buttons[i]);
            buttons[i].addActionListener(ae -> onClick(ae, j));
        }

        output = new JLabel("Results here");
        panel.add(output);

        this.add(panel);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void onClick(ActionEvent ae, final int count) {

        System.out.println("Pressed button: " + count);
        int targetNum = (int) (Math.random() * 3);

        if (count == targetNum) {
            output.setText("Right! attempts: " + attempts + " guess: " + count + " right: " + targetNum);
            attempts++;

            try (BufferedWriter br = new BufferedWriter(new FileWriter("ShellResults"))){
                br.append(textField.getText() + ";" + attempts);
            } catch (Exception e) {
                //TODO: handle exception
            }

        } else {
            output.setText("Wrong! attempts: " + attempts + " guess: " + count + " right: " + targetNum);
            attempts = 0;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new ShellGame("Shell Game");
        frame.setVisible(true);
    }
}
