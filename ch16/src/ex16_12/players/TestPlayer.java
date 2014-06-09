package ex16_12.players;

import ex16_12.Blackjack;
import ex16_12.Game;
import ex16_12.Player;

public class TestPlayer extends Player {

    @Override
    public void playMyTurn(Game game) {
        System.out.println("I'm a test player!");
        for (int i = 0; i < 1; i++) {
            ((Blackjack) game).hit();
        }
        ((Blackjack) game).stand();
    }

}
