import java.util.Scanner;

class NumberGenerator {
    public int getRandomNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new NumberGenerator();
        int totalGuesses = 0;
        int correctGuesses = 0;

        while (true) {
            System.out.println("Enter the maximum number:");
            int max = scanner.nextInt();
            System.out.println("Enter the minimum number:");
            int min = scanner.nextInt();
            scanner.nextLine();

            if (min >= max) {
                System.out.println("Minimum number should be less than maximum number.");
                continue;
            }

            int targetNumber = generator.getRandomNumber(max, min);
            int attempts = 0;

            System.out.println("Guess the number between " + min + " and " + max + ":");

            while (true) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed it right.");
                    correctGuesses++;
                    break;
                }
            }

            totalGuesses += attempts;
            System.out.println("You took " + attempts + " guesses this round.");
            System.out.println("Total correct guesses so far: " + correctGuesses);

            double successRate = (double) correctGuesses / totalGuesses * 100;
            System.out.printf("Success rate: %.2f%%\n", successRate);

            System.out.println("Do you want to play again? (yes/no)");
            scanner.nextLine();
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! See you next time.");
                break;
            }
        }

        scanner.close();
    }
}
