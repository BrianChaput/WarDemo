// Brian Chaput
// 10/11/2022
// CS-145
// Lab 4: Card Game
//
// This program is a card game that allows the user
// to play a game of war against the computer.
// Deck.java
package com.WarGameDemo;

import java.util.*;

public class Deck extends WarDemo {
    Random random = new Random();
    
    protected final ArrayList<Card> Deck;
    protected final ArrayList<Card> Shuffled = new ArrayList<>(52);
    
    public Deck() {

        String rank;

        // Creates the deck of cards with suits and values
        String suit;
        Deck = new ArrayList<>(52);
        for (int x = 0; x < 4; x++) {
            if (x == 0) {
                suit = "Clubs";
            } else if (x == 1) {
                suit = "Hearts";
            } else if (x == 2) {
                suit = "Spades";
            } else {
                suit = "Diamonds";
            }
            for (int y = 1; y <= 13; y++) {
                if (y == 1) {
                    rank = "Ace";
                } else if (y < 11) {
                    rank = "" + y;
                } else if (y == 11) {
                    rank = "Jack";
                } else if (y == 12) {
                    rank = "Queen";
                } else {
                    rank = "King";
                }
                Card card = new Card(suit, rank);
                Deck.add(card);
            }
        }
    }
    // Initialize method to shuffle the deck and return null
    public Card getFromShuffledDeck(int x) {
        if(!Shuffled.isEmpty())
            return Shuffled.get(x);
        return null;
    }
    // Method for shuffling the deck
    public void shuffle() {
        ArrayList<Integer> usednums = new ArrayList<>(52);
        System.out.println("Deck Size: "+Deck.size());
        int x=0;
        while(x<52) {
            int cardnum = random.nextInt((51) + 1);
            System.out.println("Card Number: "+cardnum);
            while (!usednums.contains(cardnum)) {
                usednums.add(x,cardnum);
                Shuffled.add(x,Deck.get(cardnum));
                x++;
            }
        }
    }
}