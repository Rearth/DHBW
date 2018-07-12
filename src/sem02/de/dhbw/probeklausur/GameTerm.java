package sem02.de.dhbw.probeklausur;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

//GameTerminal
public class GameTerm extends JFrame implements GameClient  {

    private final String name;
    private final Game game;
    private final QuestionNumberLabel[] labels;
    private final JButton buttons[] = new JButton[4];
    private final JLabel countdown;
    private final JLabel questionLabel;

    public GameTerm(String name, Game game) {
        super(name);
        this.name = name;
        this.game = game;

        System.out.println("creating gameterm for " + game.getQuestionsCount());

        labels = new QuestionNumberLabel[game.getQuestionsCount()];

        final int center = JLabel.CENTER;

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(4, 1));

        JPanel questionDisplay = new JPanel();
        questionDisplay.setLayout(new GridLayout(1, game.getQuestionsCount()));

        for (int i = 0; i < game.getQuestionsCount(); i++) {
            System.out.println("creating label #" + i);
            labels[i] = new QuestionNumberLabel(Status.PENDING, String.valueOf(i + 1));
            questionDisplay.add(labels[i]);
        }

        pane.add(questionDisplay);

        questionLabel = new JLabel("Frage hier!");
        pane.add(questionLabel);
        questionLabel.setHorizontalAlignment(center);

        countdown = new JLabel("10");
        pane.add(countdown);
        countdown.setHorizontalAlignment(center);

        JPanel answerGrid = new JPanel();
        answerGrid.setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(i + ": Text");
            final int index = i;
            buttons[i].addActionListener(actionEvent -> onButClick(index));
            answerGrid.add(buttons[i]);
        }

        pane.add(answerGrid);

        this.add(pane);
        this.setSize(1200, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    private void onButClick(int bIndex) {
        game.answerSelected(this, bIndex);
    }

    public static void main(String[] args) {
        JFrame display = new GameTerm("Karl", null);
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public int getPoints() {
        return Arrays.stream(labels).mapToInt(l -> l.state.getPoints()).sum();
    }

    @Override
    public void setQuestion(int qIndex, SpeedyQuiz.Question q) {
        this.questionLabel.setText(q.getQuestionText());
        this.labels[qIndex].setState(Status.ACTIVE);

        for (int i = 0; i < 4; i++) {
            buttons[i].setText(q.getAnswers()[i]);
        }
    }

    @Override
    public void setRemainingSeconds(int seconds) {
        this.countdown.setText(String.valueOf(seconds));
    }

    @Override
    public void GameIsOver() {
        Arrays.stream(buttons).forEach(b -> b.setEnabled(false));
    }

    @Override
    public void setAnswerState(int qIndex, Status status) {
        this.labels[qIndex].setState(status);
    }

    public static class QuestionNumberLabel extends JLabel {

        private Status state;
        private final String message;

        public QuestionNumberLabel(Status state, String message) {
            super(message);
            this.state = state;
            this.message = message;

            this.setBackground(state.getOwnColor());
            this.setOpaque(true);
            this.setHorizontalAlignment(0);
        }

        public Status getState() {
            return state;
        }

        public String getMessage() {
            return message;
        }

        public void setState(Status state) {
            this.state = state;
            this.setBackground(state.getOwnColor());
        }
    }
}
