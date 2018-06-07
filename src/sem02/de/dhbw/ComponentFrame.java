package sem02.de.dhbw;

import javax.swing.*;

public class ComponentFrame extends JFrame {

    private ComponentFrame(String title) {

        super(title);

        JPanel pane = new JPanel();

        JLabel label = new JLabel("JLabel");
        //label.setBounds(0, 0, 100, 50);

        JTextField textfield = new JTextField("JTextField");
        //textfield.setBounds(100, 0, 100, 50);

        JPasswordField passwordField = new JPasswordField("JPasswordfield");
        //passwordField.setBounds(200, 0, 100, 50);

        JButton button = new JButton("button");
        //button.setBounds(100, 0, 100, 50);

        JToggleButton toggleButton = new JToggleButton("togglebutton");
        //toggleButton.setBounds(300, 0, 100, 50);

        JCheckBox checkbox = new JCheckBox("JCheckbox");
        //checkbox.setBounds(400, 0, 100, 50);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Elem1");
        comboBox.addItem("Elem2");
        //comboBox.setBounds(500, 0, 100, 50);

        JRadioButton but1 = new JRadioButton("element 1");
        //but1.setBounds(0, 50, 50, 50);
        JRadioButton but2 = new JRadioButton("element 2");
        //but2.setBounds(50, 50, 50, 50);
        JRadioButton but3 = new JRadioButton("element 3");
        //but3.setBounds(100, 50, 50, 50);

        ButtonGroup group = new ButtonGroup();
        group.add(but1);
        group.add(but2);
        group.add(but3);

        pane.add(label);
        pane.add(textfield);
        pane.add(passwordField);
        pane.add(button);
        pane.add(toggleButton);
        pane.add(comboBox);
        pane.add(checkbox);
        pane.add(but1);
        pane.add(but2);
        pane.add(but3);
        this.add(pane);
        this.setSize(600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(null);
    }

    public static void main(String[] args) {

        System.out.println("Starting...");
        ComponentFrame frame = new ComponentFrame("ComponentFrame");
        frame.setVisible(true);

        //List<JComponent>


    }

}
