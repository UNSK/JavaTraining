package ex16_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.omg.CosNaming._BindingIteratorImplBase;

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
        private static List<Card> pickedCards = new ArrayList<>();
        public static Card randomCard() {
            Card card = CARDS.get(new Random().nextInt(SIZE));
            if (pickedCards.contains(card)) {
                return randomCard();
            } else {
                pickedCards.add(card);
                return card;
            }
        }
        public int score;
        Card(int score) { this.score = score; }
    }
    
    /** player's hand */
    private List<Card> playerHand = new ArrayList<>();
    /** dealer's hand */
    private List<Card> dealerHand = new ArrayList<>();
    
    private int playerScore = 0;
    private boolean isPlayerBusted = false;
    
    /** Construct Blackjack. Dealing the cards */
    public Blackjack() {
        dealerHand.add(Card.randomCard());
        playerHand.add(Card.randomCard());
        dealerHand.add(Card.randomCard());
        playerHand.add(Card.randomCard());
        
        System.out.println("Dealer hand : ??, " + dealerHand.get(1));
        System.out.println("Player hand : "
                + playerHand.get(0) + ", " + playerHand.get(1));
        playerScore += playerHand.get(0).score +
                       playerHand.get(1).score;
        System.out.println("Score: " + playerScore);
    }
    
    /** hit a card from deck */
    @SuppressWarnings("incomplete-switch")
    public void hit() {
        Card card = Card.randomCard();
        System.out.println("hit: " + card);
        playerScore += card.score;
        switch (card) {
        case SA: case HA: case DA: case CA: //if Ace
            if (playerScore > 21) {
                playerScore -= 10;
            }
        }
        if (playerScore > 21) {
            System.out.println("You busted!");
            isPlayerBusted = true;
        }
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
    public boolean getIsPlayerBusted() {
        return isPlayerBusted;
    }
}
