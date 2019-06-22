package kata.tennis;


import kata.tennis.dto.Player;
import kata.tennis.service.TennisGameBetweenTwoPlayer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameBetweenTwoPlayerTest {


    @Test
    public void should_return_the_winning_player_1_when_he_has_4_points_and_the_player_2_has_2_points() {
        // Given
        Player playerOne = new Player("Player one", 4);
        Player playerTwo = new Player("Player two", 2);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo(String.format("%s wins the game", playerOne.getName()));
    }

    @Test
    public void should_return_the_winning_player_2_when_he_has_4_points_and_the_player_1_has_0_points() {
        // Given
        Player playerOne = new Player("Player one", 0);
        Player playerTwo = new Player("Player two", 4);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo(String.format("%s wins the game", playerTwo.getName()));
    }

    @Test
    public void should_return_for_score_love_fifteen_when_the_player_1_has_no_points_and_the_player_2_has_1_point() {
        // Given
        Player playerOne = new Player("Player one", 0);
        Player playerTwo = new Player("Player two", 1);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Love - Fifteen");
    }

    @Test
    public void should_return_for_score_thirty_forty_when_the_player_1_has_2_points_and_the_player_2_has_3_points() {
        // Given
        Player playerOne = new Player("Player one", 2);
        Player playerTwo = new Player("Player two", 3);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Thirty - Forty");
    }

    @Test
    public void should_return_for_score_thirty_thirty_when_the_player_1_has_2_points_and_the_player_2_has_2_points() {
        // Given
        Player playerOne = new Player("Player one", 2);
        Player playerTwo = new Player("Player two", 2);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Thirty - Thirty");
    }

    @Test
    public void should_return_for_score_deuce_when_the_player_1_has_5_points_and_the_player_2_has_5_points() {
        // Given
        Player playerOne = new Player("Player one", 5);
        Player playerTwo = new Player("Player two", 5);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Deuce");
    }

    @Test
    public void should_return_for_score_deuce_when_the_player_1_has_3_points_and_the_player_2_has_3_points() {
        // Given
        Player playerOne = new Player("Player one", 3);
        Player playerTwo = new Player("Player two", 3);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Deuce");
    }

    @Test
    public void should_return_for_score_advantage_for_player_2_when_the_player_1_has_3_points_and_the_player_2_has_4_points() {
        // Given
        Player playerOne = new Player("Player one", 3);
        Player playerTwo = new Player("Player two", 4);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.getScoreGame();

        // Then
        assertThat(scoreGame).isEqualTo("Advantage for %s", playerTwo.getName());
    }

    @Test
    public void should_return_for_score_advantage_for_player_1_when_the_player_1_has_3_points_the_player_2_has_3_points_and_the_player_1_score_a_point() {
        // Given
        Player playerOne = new Player("Player one", 3);
        Player playerTwo = new Player("Player two", 3);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.addOnePointForPlayerOne();

        // Then
        assertThat(scoreGame).isEqualTo("Advantage for %s", playerOne.getName());
    }

    @Test
    public void should_return_for_score_fifteen_fifteen_when_the_player_1_has_1_points_the_player_2_has_0_points_and_the_player_2_score_a_point() {
        // Given
        Player playerOne = new Player("Player one", 1);
        Player playerTwo = new Player("Player two", 0);
        TennisGameBetweenTwoPlayer game = new TennisGameBetweenTwoPlayer(playerOne, playerTwo);

        // When
        String scoreGame = game.addOnePointForPlayerTwo();

        // Then
        assertThat(scoreGame).isEqualTo("Fifteen - Fifteen");
    }
}
