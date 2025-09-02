import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10; 
        int round = 0;
        int score = 0;
        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("You have to guess a number between 1 and 100.");
        System.out.println("You will get " + maxAttempts + " attempts per round.\n");

        boolean playAgain = true;

        while (playAgain) {
            round++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("----- Round " + round + " -----");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1–100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1); 
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }
            System.out.println("Your current score: " + score);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\nGame Over! Final Score: " + score);
        scanner.close();
    }
}
