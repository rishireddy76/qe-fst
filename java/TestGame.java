package Activities;

import java.util.Random;

public class TestGame {
    private  String[] choices = {"rock", "paper", "scissors"};
    private Random random;
    
    public TestGame() {
		random = new Random();
    }
    
    public boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
    
    public String getComputerChoice() {
        int index = random.nextInt(choices.length);
        return choices[index];
    }
    
    public String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        }
        
        switch (userChoice) {
            case "rock":
                return computerChoice.equals("scissors") ? "You win! Rock crushes scissors." : "You lose! Paper covers rock.";
            case "paper":
                return computerChoice.equals("rock") ? "You win! Paper covers rock." : "You lose! Scissors cut paper.";
            case "scissors":
                return computerChoice.equals("paper") ? "You win! Scissors cut paper." : "You lose! Rock crushes scissors.";
        }
            return "Invalid comparison";
        }
     }


