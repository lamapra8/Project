/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author plama
 */
import java.util.ArrayList;

public class HighCardGame extends Game {
    private Deck deck;

    public HighCardGame(String name) {
        super(name);
        this.deck = new Deck();
    }

    public Card drawCardForPlayer(Player player) {
        if (deck.getCards().size() == 0) {
            deck = new Deck(); // Refill and shuffle the deck if no cards left
        }
        return deck.drawCard();
    }

    public HighCardPlayer determineRoundWinner(Card card1, Card card2) {
        if (((PlayingCard) card1).getRank() > ((PlayingCard) card2).getRank()) {
            return (HighCardPlayer) getPlayers().get(0);
        } else if (((PlayingCard) card1).getRank() < ((PlayingCard) card2).getRank()) {
            return (HighCardPlayer) getPlayers().get(1);
        } else {
            return null; // It's a tie
        }
    }

    @Override
    public void play() {
        // Play logic is handled in Main class for individual card draws
    }

    public void declareWinner(int player1Points, int player2Points) {
        HighCardPlayer player1 = (HighCardPlayer) getPlayers().get(0);
        HighCardPlayer player2 = (HighCardPlayer) getPlayers().get(1);

        System.out.println(player1.getName() + " score points: " + player1Points);
        System.out.println(player2.getName() + " score points: " + player2Points);

        if (player1Points > player2Points) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1Points < player2Points) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}