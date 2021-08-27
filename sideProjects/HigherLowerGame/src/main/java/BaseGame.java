import java.util.Random;
import java.util.Scanner;

public class BaseGame {
    public static void main (String[] args){
    Random r = new Random();
    int randomInt = r.nextInt(100)+1;
    Scanner input = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100");
    String guess = input.nextLine();
    int guessAsInt = Integer.parseInt(guess);
        while (guessAsInt!=randomInt){
        if (guessAsInt<randomInt){
            System.out.println("Please guess higher");
        }else {
            System.out.println("Please guess lower");
        }
        guess = input.nextLine();
        guessAsInt = Integer.parseInt(guess);



    }
        System.out.println("Great game! You Win!");
}
}
