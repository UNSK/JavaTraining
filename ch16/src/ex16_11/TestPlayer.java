package ex16_11;


public class TestPlayer extends Player {

    @Override
    public void playMyTurn(Game game) {
        System.out.println("I'm test player!");
        for (int i = 0; i < 2; i++)
            ((Blackjack) game).hit();
    }

}
