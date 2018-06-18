package sem02.de.dhbw.threads;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class DancingText extends JFrame implements Runnable {

    float time = 0;

    public DancingText() {
        super("Dancethingy");

        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        String text = "David war hier";

        g.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        int i = 0;
        int j = 0;
        for (char c : text.toCharArray()) {
            g.setColor(randomColor());
            g.drawString(String.valueOf(c), 40 + (i+=20), 120-getY(j, time));
            j++;
            time+= 0.08f;
        }

    }

    private int getY(int pos, float t) {

        return (int) (Math.sin(pos * 0.5 + t * 0.75) * 20f);

    }

    private Color randomColor(){
        return new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    public static void main(String[] args) {
        DancingText text = new DancingText();
        text.setVisible(true);
        Thread runner = new Thread(text);
        runner.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
