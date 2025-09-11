import java.util.Random;
import java.util.Scanner;
public class NumberGameTask1{
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int totalScore=0;
    int roundsPlayed=0;
    int roundsWon = 0;
    do {
        roundsPlayed++; // counting the number of rounds played by user
        Random random = new Random();
        int orginalNumber = random.nextInt(100) + 1; // generating random number for each round
        int chances = 5; // total chances for each round
        int score=5;
        while(chances>0){
            System.out.println("Guess the Number (1 - 100) : ");
            int guessNumber = scan.nextInt(); // number guessed by user
            if(guessNumber > orginalNumber){
                System.out.println("Too high");
            }
            else if(guessNumber < orginalNumber){
                System.out.println("Too low");
            }
            else{
                roundsWon++; // calculating number of rounds won by user
                System.out.println("Congratulations you win the Game");
                break;
            }
            chances--;
            score--;
            if(chances>0){
            System.out.println("Only "+chances+ " are left");
            }
            else{
                System.out.println("Game Over ! The correct number is " + orginalNumber);
            }
        }
        totalScore+=score; // calculating total score
        System.out.println("You earned " + score + " points this round.");
        System.out.println("Total Score so far: " + totalScore);
        System.out.println("Do you want to play again ? Enter Yes / No ");
        String choice = scan.next();
        if(choice.equalsIgnoreCase("No")){
            break;
        }
    } while (true);
    scan.close();
    System.out.println("--------------------------------------------");
    System.out.println("Rounds Played: " + roundsPlayed);
    System.out.println("Rounds Won: " + roundsWon);
    System.out.println("Total Score: " + totalScore);
    System.out.println("--------------------------------------------");
    System.out.println("Thanks for playing! ");
    }
}