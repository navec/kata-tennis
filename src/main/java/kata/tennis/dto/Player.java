package kata.tennis.dto;

public class Player {

    private final String name;
    private int points;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public boolean pointIsGreaterThan(int points) {
        return this.points > points;
    }

    public void addOnePoint() {
        this.points = this.points + 1;
    }
}
