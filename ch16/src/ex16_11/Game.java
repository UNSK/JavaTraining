package ex16_11;


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
                Game game = new Game();
                player.play(name);
                game.reportScore(name);
            } catch (Exception e) {
                reportException(name, e);
            }
        }

    }

    
    private void reportScore(String name) {
        System.out.println("Player: " + name);
        System.out.println("Score : " + 100);
    }
    
    private static void reportException(String name, Exception e) {
        //TODO
    }

}
