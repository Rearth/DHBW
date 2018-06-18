package sem02.de.dhbw.threads;

import javax.swing.*;

import java.awt.*;

import static java.lang.Thread.sleep;

public class TrafficLight extends JFrame implements Runnable {

    int activelight = 0;
    int[] values = {0, 1, 2, 3};
    int i = 0;

    public TrafficLight() {
        super("Ampel");

        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(30, 60, 150, 400);

        for (int i = 0; i < 4; i++) {
            g.setColor(Color.gray);
            if ( i < 3)
                g.fillOval(30 + 25, 90 + 110 * i, 100, 100);

            if (i == activelight) {
                switch (i) {
                    case 0:
                        g.setColor(Color.red);
                        break;
                    case 1:
                        g.setColor(Color.red);
                        g.fillOval(30 + 25 + 3, 90 + 3, 94, 94);
                        g.setColor(Color.orange);
                        break;
                    case 2:
                        g.setColor(Color.green);
                        break;
                    case 3:
                        g.setColor(Color.orange);
                        g.fillOval(30 + 25 + 3, 90 + 110 * 1 + 3, 94, 94);
                        return;
                }
                g.fillOval(30 + 25 + 3, 90 + 110 * i + 3, 94, 94);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                activelight = values[i % 4];
                this.repaint();
                i++;
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TrafficLight text = new TrafficLight();
        text.setVisible(true);
        Thread runner = new Thread(text);
        runner.start();
    }

}
