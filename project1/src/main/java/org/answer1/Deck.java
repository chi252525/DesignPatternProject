package org.answer1;

import java.util.Collections;
import java.util.Stack;
import org.project1.Card;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Deck {
    private final Stack<Card> cardStack = new Stack<>();

    public static Deck standard52Cards() {
        Deck deck = new Deck();
        tw.waterballsa.designpattern.c1m1h1.Card.Suit[] suits = tw.waterballsa.designpattern.c1m1h1.Card.Suit.values();
        tw.waterballsa.designpattern.c1m1h1.Card.Rank[] ranks = tw.waterballsa.designpattern.c1m1h1.Card.Rank.values();
        for (tw.waterballsa.designpattern.c1m1h1.Card.Suit suit : suits) {
            for (tw.waterballsa.designpattern.c1m1h1.Card.Rank rank : ranks) {
                deck.push(new Card(suit, rank));
            }
        }
        return deck;
    }

    public void push(Card card) {
        cardStack.push(card);
    }

    public Card draw() {
        return cardStack.pop();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public int size() {
        return cardStack.size();
    }
}
