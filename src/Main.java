import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("Starting a new game...");
            int sum = rollDiceAndGetSum(rand);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled a " + sum + ". That's craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You rolled a " + sum + ". That's a natural! You win!");
            } else {
                int point = sum;
                System.out.println("Your point is now " + point + ". Keep rolling to make the point!");
                boolean gameOver = false;
                while (!gameOver) {
                    sum = rollDiceAndGetSum(rand);
                    if (sum == point) {
                        System.out.println("You rolled your point (" + point + ")! You win!");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        gameOver = true;
                    } else {
                        System.out.println("You rolled a " + sum + ". Keep trying for your point (" + point + ").");
                    }
                }
            }
            keepPlaying = getYNConfirm(in, "Do you want to play again? (Y/N): ");
        }
        System.out.println("Thanks for playing!");
    }
    public static int rollDiceAndGetSum(Random rand) {
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("You rolled a " + die1 + " and a " + die2 + ". Sum is " + sum + ".");
        return sum;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt);
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("y")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (true);
    }
}
