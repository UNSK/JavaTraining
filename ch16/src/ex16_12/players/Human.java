package ex16_12.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CosNaming._BindingIteratorImplBase;

import ex16_12.Blackjack;
import ex16_12.Game;
import ex16_12.Player;

/**
 *
 */
public class Human extends Player {

    @Override
    public void playMyTurn(Game game) {
        BufferedReader stdReader = new BufferedReader(new InputStreamReader(
                System.in));
        String line;
        try {
            while (!((Blackjack) game).getIsMatched()) {
                System.out.println("input \"hit\" or \"stand\"");
                line = stdReader.readLine();
                switch (line) {
                case "hit":
                    ((Blackjack) game).hit();
                    break;
                case "stand":
                    ((Blackjack) game).stand();
                    break;
                default:
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
