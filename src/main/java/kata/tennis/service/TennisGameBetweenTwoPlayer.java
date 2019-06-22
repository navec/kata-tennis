package kata.tennis.service;

import kata.tennis.dto.Player;
import kata.tennis.dto.Score;

import static java.lang.Math.abs;

public class TennisGameBetweenTwoPlayer {

    private final Player playerOne;
    private final Player playerTwo;

    public TennisGameBetweenTwoPlayer(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String addOnePointForPlayerOne() {
        playerOne.addOnePoint();
        return getScoreGame();
    }

    public String addOnePointForPlayerTwo() {
        playerTwo.addOnePoint();
        return getScoreGame();
    }

    public String getScoreGame() {
        if (isWinner()) {
            return String.format("%s wins the game", getTheNameOfTheBestPlayer());
        }
        if (isDeuce()) {
            return "Deuce";
        }
        if (isAdvantage()) {
            return String.format("Advantage for %s", getTheNameOfTheBestPlayer());
        }

        return String.format("%s - %s", getScoreName(playerOne), getScoreName(playerTwo));
    }

    private String getScoreName(Player player) {
        return Score.of(player.getPoints()).getName();
    }

    private boolean isWinner() {
        return abs(playerOne.getPoints() - playerTwo.getPoints()) > 1 &&
                (playerOne.pointIsGreaterThan(3) || playerTwo.pointIsGreaterThan(3));
    }

    private String getTheNameOfTheBestPlayer() {
        return playerOne.getPoints() > playerTwo.getPoints() ? playerOne.getName() : playerTwo.getName();
    }

    private boolean isAdvantage() {
        return playerOne.pointIsGreaterThan(2) && playerTwo.pointIsGreaterThan(2);
    }

    private boolean isDeuce() {
        return playerOne.getPoints() == playerTwo.getPoints() && playerOne.pointIsGreaterThan(2);
    }

}
