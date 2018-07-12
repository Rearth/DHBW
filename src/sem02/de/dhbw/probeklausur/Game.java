package sem02.de.dhbw.probeklausur;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Game implements Runnable {

    private List<SpeedyQuiz.Question> questions = new ArrayList<>();
    private List<GameClient> clients = new ArrayList<>();
    private boolean started = false;
    private int curIndex = 0;
    private final long startTime = System.currentTimeMillis();
    private static int countdown = 10;
    private static boolean countdownActive = false;

    public Game(List<SpeedyQuiz.Question> questions, int qCount) throws GameException {

        System.out.println("initialzing game... questions: " + questions.size() + " limit: " + qCount);
        if (questions.size() < qCount) throw new GameException("Too few questions avalaibale");

        while (this.questions.size() < qCount) {
            int index = (int) (Math.random() * questions.size());
            System.out.println("cur index: " + index);

            if (this.questions.contains(questions.get(index))) continue;
            this.questions.add(questions.get(index));

        }
    }

    public void registerClient(GameClient client) {
        if (started) {
            System.out.println("Game already started, cannot add client");
            return;
        }

        clients.add(client);
    }

    public int getQuestionsCount() {
        return questions.size();
    }

    public void startGame() {
        this.started = true;
        updateQuestions();
        countdownActive = true;

    }

    public void answerSelected(GameClient client, int index) {

        countdown = 10;
        clients.stream().forEach(c -> c.setRemainingSeconds(countdown));

        System.out.println("Answer selected: " + index);

        clients.stream().forEach(c -> c.setAnswerState(curIndex, GameClient.Status.NO_ANSWER));

        if (questions.get(curIndex).getRightAnswer() == index) {
            client.setAnswerState(curIndex, GameClient.Status.CORRECT);
        } else {
            client.setAnswerState(curIndex, GameClient.Status.WRONG);
        }

        curIndex++;
        if (onStateUpdate()) return;
        updateQuestions();
    }

    private void gameDone() {
        countdownActive = false;
        float timePassed = (System.currentTimeMillis() - startTime) / 1000f;
        System.out.println("Game done! " + timePassed);

        String message = "Game finished after " + timePassed + " seconds, score: ";
        for (int i = 0; i < clients.size(); i++) {
            message += clients.get(i).getPlayerName() + " " + clients.get(i).getPoints();
            if (i < clients.size() - 1) message += ", ";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("highscore.txt"), true)))  {
            writer.append(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }


        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
    }

    private void updateQuestions() {
        clients.stream().forEach(c -> c.setQuestion(curIndex, questions.get(curIndex)));
    }

    @Override
    public void run() {
        System.out.println("Starting runner!");
        while (true) {
            while (countdownActive) {
                System.out.println("executing loop");
                try {
                    countdown--;
                    clients.stream().forEach(c -> c.setRemainingSeconds(countdown));
                    if (countdown <= 0) {
                        clients.stream().forEach(c -> c.setAnswerState(curIndex, GameClient.Status.NO_ANSWER));

                        curIndex++;
                        if (onStateUpdate()) return;
                        updateQuestions();
                        countdown = 10;
                        clients.stream().forEach(c -> c.setRemainingSeconds(countdown));
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean onStateUpdate() {
        if (curIndex >= questions.size()) {
            System.out.println("all questions done! Ending game");
            clients.stream().forEach(c -> c.GameIsOver());
            gameDone();
            return true;
        }
        return false;
    }

    public static class GameException extends Exception {

        public GameException() {super();}

        public GameException(String message) {
            super(message);
        }

    }
}
