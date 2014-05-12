package ex16_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/** Simple Blackjack */
public class Blackjack extends Game {
    /** A deck that has random picking */
    enum Card {
        SA(11), S2(2), S3(3), S4(4), S5(5), S6(6), S7(7), S8(8), S9(9), S10(10), SJ(10), SQ(10), SK(10),
        HA(11), H2(2), H3(3), H4(4), H5(5), H6(6), H7(7), H8(8), H9(9), H10(10), HJ(10), HQ(10), HK(10),
        DA(11), D2(2), D3(3), D4(4), D5(5), D6(6), D7(7), D8(8), D9(9), D10(10), DJ(10), DQ(10), DK(10),
        CA(11), C2(2), C3(3), C4(4), C5(5), C6(6), C7(7), C8(8), C9(9), C10(10), CJ(10), CQ(10), CK(10);
        
        /** card list */
        private static final List<Card> CARDS = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = CARDS.size();
        private static List<Card> pickedCards;
        public int score;
        
        Card(int score) { this.score = score; }
        
        public static Card randomCard() {
            Card card = CARDS.get(new Random().nextInt(SIZE));
            if (pickedCards.contains(card)) {
                return randomCard();
            } else {
                pickedCards.add(card);
                return card;
            }
        }
        
        public static void init() {
            pickedCards = new ArrayList<>();
        }
    }
    
    /** player's hand */
    private List<Card> playerHand;
    /** dealer's hand */
    private List<Card> dealerHand;
    
    private int playerScore;
    private int dealerScore;
    private boolean isMached;
    
    private int playCount = 0;
    private int playerWonCount = 0;
    
    
    public void init() {
        Card.init();
        
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        
        playerScore = 0;
        dealerScore = 0;
        isMached = false;
        playCount++;
        
        dealerHand.add(Card.randomCard());
        playerHand.add(Card.randomCard());
        dealerHand.add(Card.randomCard());
        playerHand.add(Card.randomCard());
        
        System.out.println("Dealer hand : ??, " + dealerHand.get(1));
        dealerScore += dealerHand.get(0).score +
                       dealerHand.get(1).score;
        if (dealerScore == 22) 
            dealerScore = 12;
        System.out.print("Player hand : "
                + playerHand.get(0) + ", " + playerHand.get(1));
        playerScore += playerHand.get(0).score +
                       playerHand.get(1).score;
        if (playerScore == 22) {
            playerScore = 12;
        }
        System.out.println(". Score: " + playerScore);
    }
    
    /** hit a card from deck */
    @SuppressWarnings("incomplete-switch")
    public void hit() {
        Card card = Card.randomCard();
        System.out.print("hit: " + card);
        playerScore += card.score;
        switch (card) {
        case SA: case HA: case DA: case CA: //if Ace
            if (playerScore > 21) {
                playerScore -= 10;
            }
        }
        System.out.println(", Score: " + playerScore);
        if (playerScore > 21) {
            System.out.println("You busted. You lose...");
            System.out.println();
            isMached = true;
        }
    }
    
    public void stand() {
        if (!isMached) {
            dealerPlay();
        }
    }
    
    @SuppressWarnings("incomplete-switch")
    private void dealerPlay() {
        System.out.print("open Dealer hand " + 
                dealerHand.get(0) + ", " + dealerHand.get(1));
        System.out.println(". Score: " + dealerScore);
        while (dealerScore < 17) {
            Card card = Card.randomCard();
            System.out.print("Dealer hit: " + card);
            dealerScore += card.score;
            switch (card) {
            case SA: case HA: case DA: case CA: //if Ace
                if (dealerScore > 21) {
                    dealerScore -= 10;
                }
            }
            System.out.println(", Score: " + dealerScore);
        }
        
        if (dealerScore > 21) {
            System.out.println("Dealer busted. You win!");
            playerWonCount++;
        } else if (dealerScore < playerScore) {
            System.out.println("You win!");
            playerWonCount++;
        } else if (dealerScore > playerScore) {
            System.out.println("You lose...");
        } else {
            System.out.println("Draw Score.");
        }
        isMached = true;
        System.out.println();
    }
   
    @Override
    protected void reportScore(String name) {
        double winningRate = (double) playerWonCount / (double) playCount;
        System.out.println("-- YOUR SCORE --");
        System.out.println("Player: " + name);
        System.out.println("Winning rate: " + winningRate + 
                " (" + playerWonCount + "/" + playCount + ")");
    }
    /**
     * @return the playerHand
     */
    public List<Card> getPlayerHand() {
        return playerHand;
    }

    /**
     * @return the dealerHand
     */
    public List<Card> getDealerHand() {
        return dealerHand;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }
    
    /**
     * @return the isPlayerBusted
     */
    public boolean getIsMatched() {
        return isMached;
    }
}
