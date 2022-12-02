// Brian Chaput
// 10/11/2022
// CS-145
// Lab 4: Card Game
//
// This program is a card game that allows the user
// to play a game of war against the computer.
// WarDemo.java
package com.WarGameDemo;

import java.util.*;

public class WarDemo {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        String player1;
        String player2;
        String roundwinner = "";
        String gamewinner = "";

        int temp;
        int play = 1;
        while (play != 0) {
            boolean winner = false;
            // creates a deck object and shuffles it
            Deck deck = new Deck();
            deck.shuffle();
            //creates three Array Lists
            ArrayList<Card> Deck1 = new ArrayList<>(56);
            ArrayList<Card> Deck2 = new ArrayList<>(56);

            // Splits the deck into two stacks
            for (int x = 0; x < 26; x++) {
                System.out.println("Shuffled: Position: "+x+", "+(x+26));
                Deck1.add(deck.getFromShuffledDeck(x));
                Deck2.add(deck.getFromShuffledDeck(x+26));
            }
            // Introduce the game to the user
            System.out.println("Welcome to my game of WAR!\n");
            System.out.print("Player 1 name: ");
            player1 = scan.nextLine();
            System.out.print("Player 2 name: ");
            player2 = scan.nextLine();
            // displays header
            System.out.printf("%s\t\t\t#Cards\t\t%s\t\t\t#Cards\t\tWinner%n", player1, player2);
            ArrayList<Card> warDeck = new ArrayList<>(9);
            while (!winner) {
                System.out.printf("%s\t%d\t\t%s\t%d\t\t", Deck1.get(0), Deck1.size(), Deck2.get(0), Deck2.size());
                int x = Deck1.get(0).isGreater(Deck2.get(0));
                if (x == 1) {
                    Deck1.add(Deck2.get(0));//
                    Deck1.add(Deck1.get(0));
                    Deck1.remove(0);
                    Deck2.remove(0);
                    roundwinner = player1;
                }
                if (x == 2) {
                    Deck2.add(Deck1.get(0));
                    Deck2.add(Deck2.get(0));
                    Deck2.remove(Deck2.get(0));
                    Deck1.remove(0);
                    roundwinner = player2;
                }
                if (x == 3)
                    roundwinner = "WAR!";
                    System.out.println(roundwinner);
                if (x == 3) {
                    war();
                    System.out.printf("%s \t%d\t\t%s \t%d\t\t", Deck1.get(0), Deck1.size(), Deck2.get(0), Deck2.size());

                    if (Deck1.size() <= 4) {
                        roundwinner = player2;
                        System.out.println(roundwinner);
                        System.out.printf("\t\t\t%s does not have enough cards to continue playing.%n", player1);
                        endwar();
                        gamewinner = player2;
                        break;
                    } else if (Deck2.size() <= 4) {
                        roundwinner = player1;
                        System.out.println(roundwinner);
                        System.out.printf("\t\t\t%s does not have enough cards to continue playing.%n", player2);
                        System.out.println("End Of Game");
                        gamewinner = player1;
                        break;
                    }
                    // Adds 4 cards
                    for (int y = 0; y < 4 && Deck1.size() < 48; y++) {
                        warDeck.add(Deck1.get(0));
                        Deck1.remove(0);
                    }
                    for (int y = 0; y < 4 && Deck2.size() < 48; y++) {
                        warDeck.add(Deck2.get(0));
                        Deck2.remove(0);
                    }
                    // Compares players cards to determine winner
                    temp = warDeck.get(3).isGreater(warDeck.get(7));
                    if (temp == 1) {
                        while (warDeck.size() != 0) {
                            Deck1.add(warDeck.get(0));
                            warDeck.remove(0);
                            roundwinner = player1;
                        }
                    } else if (temp == 2) {
                        while (warDeck.size() != 0) {
                            Deck2.add(warDeck.get(0));
                            warDeck.remove(0);
                            roundwinner = player2;
                        }
                    } else {


                        shift(warDeck);
                        temp = warDeck.get(3).isGreater(warDeck.get(7));
                        if (temp == 1) {
                            // Cards to player 1
                            while (warDeck.size() != 0) {
                                Deck1.add(warDeck.get(0));
                                warDeck.remove(0);
                                roundwinner = player1;
                            }
                        } else if (temp == 2) {// Cards to player 2
                            while (warDeck.size() != 0) {
                                Deck2.add(warDeck.get(0));
                                warDeck.remove(0);
                                roundwinner = player2;
                            }
                        }
                    }
                    System.out.println(roundwinner);
                    endwar();
                }

                // Ends the game at 52 cards
                if (Deck1.size() == 52) {
                    gamewinner = player1;
                    winner = true;
                }
                if (Deck2.size() == 52) {
                    gamewinner = player2;
                    winner = true;
                }
            }
            // Outro user prompt
            System.out.println(gamewinner + "Wins the Game!");
            System.out.print("Rematch? (y/n)? ");
            String option;
            option = scan.nextLine().toLowerCase();
            option = "" + option.charAt(0);

            // Prevents invalid input from crashing program
            while (!(option.equals("y") || option.equals("n"))) {
                System.out.print("Invalid option. Please enter Y or N: ");
                option = scan.nextLine().toUpperCase();
                option = "" + option.charAt(0);
            }
            if (Objects.equals(option, "y")) {
            } else play = 0;
        }
        System.out.print("Goodbye!");
    }


    public static void war() {
        System.out.println("War!");
    }

    public static void endwar() {
        System.out.println("War!");
    }

    public static void shift(List<Card> warDeck) {
        warDeck.add(warDeck.get(3));
        warDeck.remove(3);
        warDeck.add(2, warDeck.get(7));
        warDeck.remove(7);
    }
}