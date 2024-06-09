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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display instructions
        System.out.println("This is a Card Game where if your card has the highest value, you win!!");
        System.out.println("Good Luck >_<; Pray and Draw Your Card HAHA!");

        // Get player names
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        HighCardPlayer player1 = new HighCardPlayer(player1Name);

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();
        HighCardPlayer player2 = new HighCardPlayer(player2Name);

        // Set up players
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        HighCardGame game = new HighCardGame("High Card");
        game.setPlayers(players);

        // Best of five rounds
        int roundsToWin = 3; // Best of five
        int player1Points = 0;
        int player2Points = 0;

        while (player1Points < roundsToWin && player2Points < roundsToWin) {
            System.out.println("Round starts!");

            // Player 1 draws a card
            System.out.print(player1.getName() + ", press Enter to draw your card...");
            scanner.nextLine();
            Card card1 = game.drawCardForPlayer(player1);
            System.out.println(player1.getName() + " draws " + card1);

            // Player 2 draws a card
            System.out.print(player2.getName() + ", press Enter to draw your card...");
            scanner.nextLine();
            Card card2 = game.drawCardForPlayer(player2);
            System.out.println(player2.getName() + " draws " + card2);

            // Determine the winner of the round
            HighCardPlayer winner = game.determineRoundWinner(card1, card2);
            if (winner != null) {
                if (winner == player1) {
                    player1Points++;
                } else {
                    player2Points++;
                }
                System.out.println(winner.getName() + " wins the round.");
            } else {
                System.out.println("The round is a tie.");
            }

            System.out.println(player1.getName() + " score points: " + player1Points);
            System.out.println(player2.getName() + " score points: " + player2Points);
            System.out.println("Round ends!\n");
        }

        // Declare overall winner
        game.declareWinner(player1Points, player2Points);
        scanner.close();
    }
}