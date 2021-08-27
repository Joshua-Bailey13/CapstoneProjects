import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class GameFile {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Please pick an upper number to guess between (eg 100 to pick between 1 and 100)");
        String upperBoundAsString = input.nextLine();
        int upperBoundAsInt = Integer.parseInt(upperBoundAsString);
        int randomInt = r.nextInt(upperBoundAsInt)+1;
        int maxGuesses = (int)Math.log ((double) upperBoundAsInt);
        System.out.println("Guess a number between 1 and "+upperBoundAsString +
                " Try to get it in less than "+ maxGuesses + " guesses");
        String guess = input.nextLine();
        int guessAsInt = Integer.parseInt(guess);
        int totalGuesses = 0;
        while (guessAsInt!=randomInt){
            if (guessAsInt<randomInt){
                totalGuesses+=1;
                System.out.println("Please guess higher\n" + "Total guesses: "+ totalGuesses);
            }else {
                totalGuesses+=1;
                System.out.println("Please guess lower\n"+ "Total guesses: "+ totalGuesses);
            }
            guess = input.nextLine();
            guessAsInt = Integer.parseInt(guess);



        }
        totalGuesses +=1;
        System.out.println("Great game! You Win!\n" + "Total guesses: " + totalGuesses );
    }
}
