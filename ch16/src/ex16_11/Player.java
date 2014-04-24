package ex16_11;

public abstract class Player {
    private static final int PLAYCOUNT = 1000;
    
    public final void play(Game game) {
        for (int i = 0; i < PLAYCOUNT ; i++) {
            ((Blackjack) game).init();
            playMyTurn(game);
        }
    }
    
    public abstract void playMyTurn(Game game);
}
