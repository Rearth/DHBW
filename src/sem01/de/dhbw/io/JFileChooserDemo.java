package de.dhbw.java.exercise.io;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class JFileChooserDemo extends JFileChooser {

    public JFileChooserDemo() {

    }

    public static void main(String[] args) throws FileNotFoundException {

        JFileChooser fileChooser = new JFileChooserDemo();
        fileChooser.showOpenDialog(null);

        File file = fileChooser.getSelectedFile();
        List<String> content = IO_01.readfileList(file);
        System.out.println(Arrays.toString(content.toArray()));

        if (content.size() > 10) {
            System.out.println("displaying scroll version");
            scrollingVersion(content, IO_01.readfile(file));
            return;
        }

        JFrame display = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1));

        try {
            for (int i = 0; i < 10; i++) {
                panel.add(new JLabel(content.get(i)), BorderLayout.SOUTH);
            }
        } catch (IndexOutOfBoundsException ex) {}


        display.add(panel);
        display.setSize(400, 300);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);

        if (content.size() > 10) {
            System.out.println("displaying scroll version");
            scrollingVersion(content, IO_01.readfile(file));
        }
        //scrollingVersion(content, IO_01.readfile(file));

    }

    private static void scrollingVersion(List<String> content, String lines) {
        JFrame display = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(content.size(), 1));


        JTextArea area = new JTextArea(lines);

        /*try {
            for (int i = 0; i < content.size(); i++) {
                JLabel label = new JLabel(content.get(i));
                //label.setSize(300, 30);
                panel.add(label);
            }
        } catch (IndexOutOfBoundsException ex) {}*/

        panel.add(area);
        area.setEditable(false);

        JScrollPane scrollPane = new JScrollPane (panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        display.add(scrollPane, BorderLayout.CENTER);
        display.setSize(200, 250);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);
    }

}
