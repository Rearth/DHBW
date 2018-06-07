package de.dhbw.ui.events;

import javax.swing.*;
import java.awt.*;

public class BMICalculator extends JFrame {

    public BMICalculator() {

        super("BMI-Calculator");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel weight = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField("100");
        weightField.setPreferredSize(new Dimension(200, 30));
        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new FlowLayout());
        weightPanel.add(weight);
        weightPanel.add(weightField);

        panel.add(weightPanel);

        JLabel height = new JLabel("Body Height (m):");
        JTextField heightField = new JTextField("1.00");
        heightField.setPreferredSize(new Dimension(200, 30));
        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new FlowLayout());
        heightPanel.add(height);
        heightPanel.add(heightField);

        panel.add(heightPanel);

        JRadioButton maleSelector = new JRadioButton("Male");
        maleSelector.setSelected(true);
        JRadioButton femaleSelector = new JRadioButton("feMale");
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleSelector);
        genderPanel.add(femaleSelector);
        ButtonGroup group = new ButtonGroup();
        group.add(maleSelector);
        group.add(femaleSelector);

        panel.add(genderPanel);

        JButton calc = new JButton("calculate");
        panel.add(calc);

        JLabel bmi = new JLabel("BMI:");
        JTextField bmiField = new JTextField("");
        bmiField.setPreferredSize(new Dimension(200, 30));
        JPanel bmiPanel = new JPanel();
        bmiPanel.setLayout(new FlowLayout());
        bmiPanel.add(bmi);
        bmiPanel.add(bmiField);

        panel.add(bmiPanel);

        JTextField output = new JTextField();
        panel.add(output);
        output.setPreferredSize(new Dimension(200, 30));

        calc.addActionListener(ae -> this.addResult(bmiField, output, Integer.valueOf(weightField.getText()), Float.valueOf(heightField.getText()), maleSelector.isSelected()));

        this.add(panel);
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void addResult(JTextField result, JTextField desc, int weight, float height, boolean male) {

        System.out.println("adding result: " + weight + " " + height + " " + male);

        float bmi = weight / (height * height);
        result.setText(String.valueOf(bmi));

        desc.setText(getDesc(bmi, male));

    }

    private String getDesc(float bmi, boolean male) {
        if (male) {
            if (bmi < 20) return "short weight";
            if (bmi <= 25) return "normal weight";
            if (bmi <= 30) return "Overweight";
            if (bmi <= 40) return "Adiposity";
            return "Massive Adiposity";

        } else {

            if (bmi < 19) return "short weight";
            if (bmi <= 24) return "normal weight";
            if (bmi <= 30) return "Overweight";
            if (bmi <= 40) return "Adiposity";
            return "Massive Adiposity";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new BMICalculator();
        frame.setVisible(true);
    }

}
