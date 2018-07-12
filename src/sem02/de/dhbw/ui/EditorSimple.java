package sem02.de.dhbw.ui;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class EditorSimple extends JFrame{

    JMenuItem neu = new JMenuItem("Neu...");
    JMenuItem openFile = new JMenuItem("Öffnen...");
    JMenuItem speichern = new JMenuItem("Speichern");
    JMenuItem beenden = new JMenuItem("Beenden");
    JTextPane editPane;

    private File fileOpened = null;
    
    private EditorSimple() {

        super("editor");

        JMenuBar menubar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        neu.setMnemonic('N');
        neu.addActionListener(ae -> {editPane.setText(""); fileOpened = null; speichern.setEnabled(false);});
        openFile.addActionListener(ae -> {
			try {
				loadFile(editPane);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});        

        datei.add(neu);
        datei.add(openFile);
        speichern.setEnabled(false);
        speichern.addActionListener(arg0 -> {
			try {
				saveFile(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        

        JMenuItem schließen = new JMenuItem("Schließen...");
        datei.add(schließen);
        datei.addSeparator();
        datei.add(speichern);
        JMenuItem speichern_unter = new JMenuItem("Speichern unter...");
        datei.add(speichern_unter);
        JMenuItem website = new JMenuItem("Als Webseite speichern...");
        datei.add(website);
        JMenuItem suchen = new JMenuItem("Suchen...");
        datei.add(suchen);
        datei.addSeparator();
        JMenuItem versionen = new JMenuItem("Versionen...");
        datei.add(versionen);
        datei.addSeparator();
        JMenuItem webseitenvorschau = new JMenuItem("Webseitenvorschau");
        datei.add(webseitenvorschau);
        datei.addSeparator();
        JMenuItem einrichten = new JMenuItem("Seite einrichten...");
        datei.add(einrichten);
        JMenuItem seitenansicht = new JMenuItem("Seitenansicht");
        datei.add(seitenansicht);
        JMenuItem drucken = new JMenuItem("Drucken...");
        datei.add(drucken);
        datei.addSeparator();
        JMenu senden = new JMenu("Senden an...");
        datei.add(senden);
        JMenuItem email1 = new JMenuItem("E-Mail-Empfänger");
        senden.add(email1);
        JMenuItem email2 = new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)...");
        senden.add(email2);
        JMenuItem email3 = new JMenuItem("E-Mail-Empfänger (als Anlage)...");
        senden.add(email3);
        JMenuItem verteiler = new JMenuItem("Verteilerempfänger...");
        senden.add(verteiler);
        JMenuItem online = new JMenuItem("Onlinebesprechungswat");
        senden.add(online);
        JMenuItem exchange = new JMenuItem("Exchange-Ordner...");
        senden.add(exchange);
        JMenuItem fax = new JMenuItem("Fax-Empfänger...");
        senden.add(fax);
        senden.addSeparator();
        JMenuItem powerpoint = new JMenuItem("Microsoft Powerpoint");
        senden.add(powerpoint);
        JMenuItem eigenschaften = new JMenuItem("Eigenschaften");
        datei.add(eigenschaften);
        datei.addSeparator();
        datei.add(beenden);

        beenden.addActionListener(ae -> {JOptionPane.showMessageDialog(null, "Beenden?", "Soll das Programm wirklich beendet werden?", JOptionPane.WARNING_MESSAGE); System.exit(0);});
//        JMenuItem = new JMenuItem();
//        JMenuItem = new JMenuItem();
//        JMenuItem = new JMenuItem();
        menubar.add(datei);
        JMenuItem rückgängig = new JMenuItem("Rückgängig: nicht möglich");
        bearbeiten.add(rückgängig);
        JMenuItem widerholen = new JMenuItem("Wiederholen: nicht möglich");
        bearbeiten.add(widerholen);
        bearbeiten.addSeparator();
        JMenuItem ausschneiden = new JMenuItem("Ausschneiden");
        bearbeiten.add(ausschneiden);
        JMenuItem kopieren = new JMenuItem("Kopieren");
        bearbeiten.add(kopieren);
        JMenuItem office = new JMenuItem("Office-Zwischenablage");
        bearbeiten.add(office);
        bearbeiten.addSeparator();
        JMenuItem einfügen = new JMenuItem("Einfügen");
        bearbeiten.add(einfügen);
        JMenuItem inhalt = new JMenuItem("Inhalt einfügen");
        bearbeiten.add(inhalt);
        JMenuItem hyperlink = new JMenuItem("Als Hyperlink einfügen");
        bearbeiten.add(hyperlink);
        bearbeiten.addSeparator();
        JMenuItem löschen = new JMenuItem("Löschen");
        bearbeiten.add(löschen);
        JMenuItem markieren = new JMenuItem("Alles markieren");
        bearbeiten.add(markieren);
        bearbeiten.addSeparator();
        JMenuItem suche = new JMenuItem("Suchen...");
        bearbeiten.add(suche);
        JMenuItem ersetzen = new JMenuItem("Ersetzen...");
        bearbeiten.add(ersetzen);
        JMenuItem gehezu = new JMenuItem("Gehe zu...");
        bearbeiten.add(gehezu);
        bearbeiten.addSeparator();
        JMenuItem verknüpfung = new JMenuItem("Verknüpfungen...");
        bearbeiten.add(verknüpfung);
        JMenuItem objekt = new JMenuItem("Objekt");
        bearbeiten.add(objekt);
        menubar.add(bearbeiten);
        this.setJMenuBar(menubar);

        editPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(editPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);

        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void loadFile(JTextPane editPane) throws FileNotFoundException {

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        System.out.println("File chosen: " + file.getName());

        editPane.setText("");
        fileOpened = file;
        speichern.setEnabled(true);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine())
                editPane.setText(editPane.getText() + scanner.nextLine() + System.lineSeparator());
        }

    }

    private void saveFile(ActionEvent ev) throws IOException {

        String content = editPane.getText();
        String[] parts = content.split(System.lineSeparator());

        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileOpened))) {
            for (String part : parts)
                br.append(part + System.lineSeparator());
        }

        System.out.println("wrote file!");

    }

    public static void main(String[] args) {
        JFrame frame = new EditorSimple();
        frame.setVisible(true);
        System.out.println("started!");
    }
}
