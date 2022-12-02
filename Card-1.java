// Brian Chaput
// 10/11/2022
// CS-145
// Lab 4: Card Game
//
// This program is a card game that allows the user
// to play a game of war against the computer.
// Card.java
package com.WarGameDemo;

public class Card extends WarDemo {
    protected final String suit;
    protected final String rank;
    protected int value;

    // Gives Card object a suit and value
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;

        // Determines the value of the cards
        switch (rank) {
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            case "10":
                value = 10;
                break;
            case "Jack":
                value = 11;
                break;
            case "Queen":
                value = 12;
                break;
            case "King":
                value = 13;
                break;
            case "Ace":
                value = 14;
                break;
        }
    }

    // Initialize the getter for value
    public int getValue() {
        return value;
    }

    // Initialize the toString method
    public String toString() {
        return rank + " " + suit;
    }

    // Method to compare the values of the two cards and return int temp
    public int isGreater(Card card) {
        int temp;
        if (value > card.getValue()) {
            temp = 1;
        } else if (value < card.getValue()) {
            temp = 2;
        } else {
            temp = 3;
        }
        return temp;
    }
}

