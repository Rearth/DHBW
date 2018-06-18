package sem02.de.dhbw.collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Archive extends Buch implements ActionListener {

    JFrame f;
    JTextField autor = new JTextField("", 20);
    JTextField titel = new JTextField("", 20);
    JTextField jahr = new JTextField("", 20);
    JTextField verlag = new JTextField("", 20);
    JButton speichern = new JButton("Eintrag speichern");
    JButton autorButton = new JButton("Autor");
    JButton titelButton = new JButton("Titel");
    JButton jahrButton = new JButton("Jahr");
    JButton verlagButton = new JButton("Verlag");
    ArrayList<Buch> alleBücher = new ArrayList<Buch>();
    // 0 = nach Autor, 1 = nach Titel, 2 = nach Jahr, 3 = nach Verlag
    int sortierung = 0;


    public Archive(){
        try (BufferedReader br = new BufferedReader(new FileReader("Bücherregal.txt"));) {

            while(br.ready()){
                String[] temp = br.readLine().split(";");
                alleBücher.add(new Buch(temp[0], temp[1], temp[2], temp[3]));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.f = new JFrame();
        f.setLayout(new GridLayout(6,1));

        JPanel row1 = new JPanel();
        row1.add(new JLabel("Autor "));
        row1.add(autor);
        f.add(row1);

        JPanel row2 = new JPanel();
        row2.add((new JLabel("Titel ")));
        row2.add(titel);
        f.add(row2);

        JPanel row3 = new JPanel();
        row3.add((new JLabel("Jahr ")));
        row3.add(jahr);
        f.add(row3);

        JPanel row4 = new JPanel();
        row4.add((new JLabel("Verlag ")));
        row4.add(verlag);
        f.add(row4);

        JPanel row5 = new JPanel();
        row5.add(speichern);
        speichern.addActionListener(this);
        f.add(row5);

        JPanel row6 = new JPanel();
        row6.add((new JLabel("Ausgabe sortiert nach: ")));
        row6.add(autorButton);
        autorButton.addActionListener(this);
        row6.add(titelButton);
        titelButton.addActionListener(this);
        row6.add(jahrButton);
        jahrButton.addActionListener(this);
        row6.add(verlagButton);
        verlagButton.addActionListener(this);
        f.add(row6);

        f.pack();
        f.setTitle("Buecherverwaltung");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == speichern){
            Buch neuesBuch = new Buch(autor.getText(), titel.getText(), jahr.getText(), verlag.getText());
            alleBücher.add(neuesBuch);
            try {
                File test = new File("Bücherregal.txt");
                test.createNewFile();

                FileWriter fw = new FileWriter(test, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(autor.getText()+";"+titel.getText()+";"+jahr.getText()+";"+verlag.getText());
                bw.newLine();
                bw.flush();
            } catch (IOException e1){
                System.out.println("exception");
                e1.getMessage();
            }
            titel.setText("");
            jahr.setText("");
            autor.setText("");
            verlag.setText("");
        }
        else if (e.getSource() == autorButton){
            Collections.sort(alleBücher, new Comparator<Buch>() {
                @Override
                public int compare(Buch buch1, Buch buch2) {

                    return buch1.autor.compareTo(buch2.autor);
                }
            });
            String bücherString = "";
            for (Buch b : alleBücher){
                bücherString = bücherString.concat(b.autor + ", " + b.titel + ", " + b.erscheinungsjahr + ", " + b.verlag +"\n" );
            }
            JFrame byAutor = new JFrame();
            JTextArea textByAutor = new JTextArea(bücherString);
            byAutor.add(textByAutor);
            byAutor.pack();
            byAutor.setVisible(true);
        }
        else if (e.getSource() == titelButton){
            Collections.sort(alleBücher, new Comparator<Buch>() {
                @Override
                public int compare(Buch buch1, Buch buch2) {

                    return buch1.titel.compareTo(buch2.titel);
                }
            });
            String bücherString = "";
            for (Buch b : alleBücher){
                bücherString = bücherString.concat(b.titel + ", " + b.autor + ", " + b.erscheinungsjahr + ", " + b.verlag +"\n" );
            }
            JFrame byTitel = new JFrame();
            JTextArea textByTitel = new JTextArea(bücherString);
            byTitel.add(textByTitel);
            byTitel.pack();
            byTitel.setVisible(true);
        }
        else if (e.getSource() == jahrButton){
            Collections.sort(alleBücher, new Comparator<Buch>() {
                @Override
                public int compare(Buch buch1, Buch buch2) {

                    return buch1.erscheinungsjahr.compareTo(buch2.erscheinungsjahr);
                }
            });
            String bücherString = "";
            for (Buch b : alleBücher){
                bücherString = bücherString.concat(b.erscheinungsjahr + ", " + b.autor + ", " + b.titel + ", " + b.verlag +"\n" );
            }
            JFrame byJahr = new JFrame();
            JTextArea textByJahr = new JTextArea(bücherString);
            byJahr.add(textByJahr);
            byJahr.pack();
            byJahr.setVisible(true);
        }
        else if (e.getSource() == verlagButton){
            Collections.sort(alleBücher, new Comparator<Buch>() {
                @Override
                public int compare(Buch buch1, Buch buch2) {

                    return buch1.verlag.compareTo(buch2.verlag);
                }
            });
            String bücherString = "";
            for (Buch b : alleBücher){
                bücherString = bücherString.concat(b.verlag + ", " + b.autor + ", " + b.titel + ", " + b.erscheinungsjahr +"\n" );
            }
            JFrame byVerlag = new JFrame();
            JTextArea textByVerlag = new JTextArea(bücherString);
            byVerlag.add(textByVerlag);
            byVerlag.pack();
            byVerlag.setVisible(true);
        }

    }

    public static void main(String[] args) {
        Archive archive = new Archive();
    }
}

class Buch {
    String autor, titel, erscheinungsjahr, verlag;

    public Buch(String autor, String titel, String erscheinungsjahr, String verlag){
        this.autor = autor;
        this.titel = titel;
        this.erscheinungsjahr = erscheinungsjahr;
        this.verlag = verlag;
    }

    public Buch(){

    }
}