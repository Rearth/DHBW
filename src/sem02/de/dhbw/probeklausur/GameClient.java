package sem02.de.dhbw.probeklausur;

import java.awt.*;

public interface GameClient {

    public String getPlayerName();
    public int getPoints();
    public void setQuestion(int qIndex, SpeedyQuiz.Question q);
    public void setRemainingSeconds(int seconds);
    public void GameIsOver();
    public void setAnswerState(int qIndex, Status status);

    public enum Status {

        ACTIVE(Color.orange, 0),
        CORRECT(Color.green, 1),
        WRONG(Color.red, -1),
        PENDING(Color.white, 0),
        NO_ANSWER(Color.gray, 0);


        private final Color ownColor;
        private int points;

        Status(Color ownColor, int points) {
            this.ownColor = ownColor;
            this.points = points;
        }

        public Color getOwnColor() {
            return ownColor;
        }

        public int getPoints() {
            return points;
        }
    }

}
