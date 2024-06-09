/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author plama
 */
public class HighCardPlayer extends Player {
    private int score;

    public HighCardPlayer(String name) {
        super(name);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    @Override
    public void play() {
        // Specific play logic will be handled in the game class
    }
}
