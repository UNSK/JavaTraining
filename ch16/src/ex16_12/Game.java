package ex16_12;




public class Game {
    public static void main(String[] args) {
        String name;
        for (int i = 0; i < args.length; i++) {
            name = args[i];
            try {
                PlayerLoader loader = new PlayerLoader();
                Class<? extends Player> classOf = 
                        loader.loadClass(name).asSubclass(Player.class);
                Player player = classOf.newInstance();
                Blackjack game = new Blackjack();
                player.play(game);
                game.reportScore(name);
            } catch (Exception e) {
                reportException(name, e);
            }
        }
    }

    
    public void playAITurn() {
        System.out.println("I'm AI.");
    }
    
    protected void reportScore(String name) {
        System.out.println("Player: " + name);
        System.out.println("Score : " + 100);
    }
    
    private static void reportException(String name, Exception e) {
        System.err.println(name + " " + e.toString());
    }
    
    

}
