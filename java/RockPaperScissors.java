package Activities;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestGame game = new TestGame();
        
        
        
       
            System.out.println("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            
            
            
            if (!game.isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                return;
            }
            
            String computerChoice = game.getComputerChoice();
            System.out.println("Computer chose: " + computerChoice);
            
            String result = game.determineWinner(userChoice, computerChoice);
            System.out.println(result);
        
        
   scanner.close();
    }
    }

