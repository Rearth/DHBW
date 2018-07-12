package sem02.de.dhbw.ui;

import javax.swing.*;
import java.io.File;

public class TextFrame extends JFrame {

    public TextFrame(String file, int width, int height) {

        super(new  File(file).getName());

        String content = null;
        /*try {
            content = IO_01.readfile(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        JTextArea field = new JTextArea(content);
        field.setEditable(false);

        this.add(field);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(null);

    }

    public static void main(String[] args) {


        //"/home/dwaidner/DHBW/Java/01/textfile"
        int width = 0;
        int height = 0;

        try {
            if (!new File(args[0]).exists()) {
                throw new Exception();
            }

            width = Integer.valueOf(args[1]);
            height = Integer.valueOf(args[2]);
        } catch (Exception ex) {
            System.err.println("Ungültige eingabe: Path width height");
            return;
        }

        JFrame frame = new TextFrame(args[0], width, height);
        frame.setVisible(true);
    }

}
