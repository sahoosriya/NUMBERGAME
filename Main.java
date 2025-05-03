import java.util.Scanner;


class Game {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game rg = new Game();
        int totalAttempts = 0;
        int wins = 0;

        while (true) {
            System.out.println("Enter the maximum number:");
            int max = sc.nextInt();
            System.out.println("Enter the minimum number:");
            int min = sc.nextInt();
            sc.nextLine(); // consume the newline

            if (min >= max) {
                System.out.println("Minimum should be less than maximum.");
                continue;
            }

            int cnum = rg.generate(max, min);
            int attempts = 0;

            System.out.println("Guess the number:");

            while (true) {
                int gnum = sc.nextInt();
                attempts++;

                if (gnum > cnum) {
                    System.out.println("It's lower.");
                } else if (gnum < cnum) {
                    System.out.println("It's higher.");
                } else {
                    System.out.println("Correct guess!");
                    wins++;
                    break;
                }
            }

            totalAttempts += attempts;
            System.out.println("Attempts this round: " + attempts);
            System.out.println("Total wins: " + wins);

            double winRate = (double) wins / totalAttempts * 100;
            System.out.printf("Your win rate is %.2f%%\n", winRate);

            System.out.println("Do you want to play again (yes/no)?");
            sc.nextLine(); // consume leftover newline
            String playAgain = sc.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        sc.close();
    }
}
