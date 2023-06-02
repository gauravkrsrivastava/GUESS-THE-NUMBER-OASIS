//Number Guessing Game

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int round = 1;
        int score = 0;
        int totalScore = 0;
        int numberOfRounds = 1;
        int maxNumber = 100;
        int guess;
        int randomNumber;
        int maxAttempts = 5;
        Random random = new Random();
        boolean correctGuess = false;
        String input;

        JOptionPane.showMessageDialog(null, "Welcome to the Guess the Number game!");

        do {
            input = JOptionPane.showInputDialog(null, "Enter the maximum number for round " + round + ":");
            maxNumber = Integer.parseInt(input);
            randomNumber = random.nextInt(maxNumber) + 1;
            score = 0;
            correctGuess = false;

            for (int i = 1; i <= maxAttempts; i++) {
                input = JOptionPane.showInputDialog(null,
                        "Guess the number between 1 and " + maxNumber + ".\nAttempts remaining: "
                                + (maxAttempts - i + 1) + "\nScore: " + score + "\nTotal score: " + totalScore);
                guess = Integer.parseInt(input);
                score += 10;

                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations! You guessed the number.\nYour score for this round is " + score);
                    totalScore += score;
                    correctGuess = true;
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "The number is higher than " + guess + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "The number is lower than " + guess + ".");
                }
            }

            if (!correctGuess) {
                JOptionPane.showMessageDialog(null,
                        "Sorry, you did not guess the number.\nThe number was " + randomNumber + ".");
            }

            input = JOptionPane.showInputDialog(null, "Do you want to play another round? (yes or no)");
            if (input.equalsIgnoreCase("yes")) {
                round++;
                numberOfRounds++;
            } else {
                JOptionPane.showMessageDialog(null, "Thank you for playing!\nYour total score is " + totalScore + " in "
                        + numberOfRounds + " rounds.");
                break;
            }
        } while (true);
    }
}
