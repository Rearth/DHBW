package sem02.de.dhbw.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Election extends JFrame {

    public Election () {
        super("Election");

        List<party> parties = new ArrayList<>();
        parties.add(new party(Color.black, "Union", 0.33f));
        parties.add(new party(Color.red, "SPD", 0.205f));
        parties.add(new party(Color.blue, "AfD", 0.126f));
        parties.add(new party(Color.yellow, "FDP", 0.107f));
        parties.add(new party(Color.magenta, "Linke", 0.092f));
        parties.add(new party(Color.green, "Grüne", 0.089f));
        parties.add(new party(Color.darkGray, "Andere", 0.051f));

        ElectionPanel panel = new ElectionPanel(this, parties);

        this.add(panel);
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public static void main(String[] args) {
        System.out.println("Starting election thingy");

        JFrame frame = new Election();
        frame.setVisible(true);

    }

    private class ElectionPanel extends JPanel {

        private final JFrame parent;
        private final List<party> parties;

        public ElectionPanel(JFrame parent, List<party> parties) {

            this.parent = parent;
            this.parties = parties;
        }

        @Override
        protected void paintComponent(Graphics g) {

            int width = parent.getWidth();
            int height = parent.getHeight();

            g.setColor(Color.CYAN);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.lightGray);
            g.fillRect(0, height - 200, width, 60);

            drawParties(g);

            g.setColor(Color.blue);
            g.fillRect(0, 0, width, 40);

            g.setColor(Color.white);
            g.drawString("Bundestagswahl 2018", 30, 30);

            g.drawString("in %", width - 50, 30);


        }

        private void drawParties(Graphics g) {

            int width = parent.getWidth() - 30;
            int height = parent.getHeight() - 180 - 50 - 20;
            System.out.println("height: " + height);

            int startX = 20;
            int startY = 70;
            int i = 0;

            int partWidth = width / parties.size();

            g.setColor(Color.white);

            g.fillRect(0, startY + (int) (height * 0.25f), width + 30, 5);
            g.fillRect(0, startY + (int) (height * 0.5f), width + 30, 5);
            g.fillRect(0, startY + (int) (height * 0.75f), width + 30, 5);

            for (party part : parties) {
                int xH = (int) ((float) height * part.percent * (1 / parties.get(0).percent));
                g.setColor(part.color.darker().darker());
                for (int j = 0; j < 300; j++) {
                    g.fillRect(startX + partWidth * i + j, startY + (height - xH) - (int) (j * 1.5f), partWidth - 25, xH);
                }

                g.setColor(part.color);
                g.fillRect(startX + partWidth * i, startY + (height - xH), partWidth - 25, xH);

                g.setColor(Color.black);
                g.drawString(part.name, startX + partWidth * i, height + 100);
                g.drawString(String.format("%2.2f", part.percent * 100) + "%", startX + partWidth * i, height + 140);

                i++;

            }

        }

    }

    private class party {

        public final Color color;
        public final String name;
        public final float percent;

        private party(Color color, String name, float percent) {
            this.color = color;
            this.name = name;
            this.percent = percent;
        }
    }

}
