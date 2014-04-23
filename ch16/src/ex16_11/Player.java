package ex16_11;

public abstract class Player {
    
    public final void play(Game game) {
        playMyTurn(game);
      //  game.playAITurn();
    }
    
    public abstract void playMyTurn(Game game);
}
