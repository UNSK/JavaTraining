package ex16_11.players;

import ex16_11.Blackjack;
import ex16_11.Game;
import ex16_11.Player;

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
