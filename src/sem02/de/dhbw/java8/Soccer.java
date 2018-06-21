package sem02.de.dhbw.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Soccer {

    private Soccer () {

        List<Player> players = new ArrayList<>();
        List<String> strings = null;
        try {
            Files.readAllLines(Paths.get("/home/dwaidner/DHBW/Java/playerDat.txt")).stream()
                    .map(s -> s.split(";"))
                    .map(a -> new Player(Integer.valueOf(a[0]), Integer.valueOf(a[5]), Integer.valueOf(a[6]), a[1], a[2], a[3], a[4]))
                    .forEach(players::add);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        new Soccer();

    }

    class Player {

        private int number;
        private int games;
        private int goals;
        private String name;
        private String position;
        private String birthday;
        private String club;

        public Player(int number, int games, int goals, String name, String position, String birthday, String club) {
            this.number = number;
            this.games = games;
            this.goals = goals;
            this.name = name;
            this.position = position;
            this.birthday = birthday;
            this.club = club;
        }

        public int getNumber() {
            return number;
        }

        public int getGames() {
            return games;
        }

        public int getGoals() {
            return goals;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getClub() {
            return club;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "number=" + number +
                    ", games=" + games +
                    ", goals=" + goals +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", club='" + club + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return number == player.number &&
                    games == player.games &&
                    goals == player.goals &&
                    Objects.equals(name, player.name) &&
                    Objects.equals(position, player.position) &&
                    Objects.equals(birthday, player.birthday) &&
                    Objects.equals(club, player.club);
        }

        @Override
        public int hashCode() {

            return Objects.hash(number, games, goals, name, position, birthday, club);
        }
    }

}
