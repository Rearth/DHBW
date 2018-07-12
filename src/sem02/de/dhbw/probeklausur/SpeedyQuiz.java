package sem02.de.dhbw.probeklausur;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Speedy Quiz
 */
public class SpeedyQuiz {

    /**
     * Main method, entry point of application
     *
     * @param args CLI arguments
     */
    public static void main(String[] args) {
        // Set cross platform LAF to get colors for sure to work on MacOS
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }

        List<Question> questionPool = loadQuestions();

        try {
            Game game = new Game(questionPool, 10);
            Thread runner = new Thread(game);
            runner.start();

            game.registerClient( new GameTerm("Mia", game) );
            game.registerClient( new GameTerm("Ben", game) );
            game.registerClient( new GameTerm("Karl", game) );

            game.startGame();
        } catch (Game.GameException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Load questions
     *
     * @return questions to load
     */
    public static List<Question> loadQuestions(){
        List<Question> questions = new ArrayList<>();

        try {
            System.out.println(" file path: " + Paths.get("sq/questions.txt").toAbsolutePath());
            List<String> lines = Files.readAllLines(Paths.get("sq/questions.txt"));
            lines.stream().map(l -> parseQuestion(l)).forEach(q -> questions.add(q));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error loading questions", JOptionPane.ERROR_MESSAGE);
        }

        return questions;
    }

    /**
     * Parse a question from input line
     *
     * @param line line to parse
     * @return created question instance
     */
    public static Question parseQuestion( String line ){
        try {
            String[] parts = line.split(";");
            if ( parts.length == 6 ){
                String[] answers = new String[4];
                System.arraycopy(parts, 1, answers, 0, 4);
                return new Question(parts[0], answers, Integer.parseInt(parts[5]));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static class Question {

        private final String questionText;
        private final String[] answers;
        private final int rightAnswer;

        Question(String questionText, String[] answers, int rightAnswer) {
            this.questionText = questionText;
            this.answers = answers;
            this.rightAnswer = rightAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getAnswers() {
            return answers;
        }

        public int getRightAnswer() {
            return rightAnswer;
        }
    }

}
