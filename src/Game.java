import java.util.Scanner;
// Game class is made from the user perspective, takes care of input/output and the communication with PickedWord 
public class Game {
	private String alphabet;
	private String wordToGuess;
	private int numberOfGuesses;
	private PickedWord pickedWord;
	
	// Constructor
	public Game(PickedWord pickedWord) {
		this.pickedWord = pickedWord;
	}	
	// Sets default values for new game
	public void resetGame() {
		this.alphabet = "abcdefghijklmnopqrstuvwxyz";
		this.numberOfGuesses = 0;
		this.pickedWord.resetRandomWord();
	}	
	// Creates an underscore string as long as inputed length
	public String generateUnderscores(int length) {
		String result = new String();
		
		for (int i = 0; i < length; i++) {
			result += '_';
        }
		return result;
	}
	// Checks if the input from the user is valid and sends a proper error message
	public boolean ValidateLetterInput(String userInput) {     		 
    		
        if (userInput.length() != 1) {
       		System.out.println("Invalid input. Please enter exactly one letter.");   	    		
        }
        else if (!Character.isLetter(userInput.charAt(0))) {
        	System.out.println("Invalid input. Please enter a letter.");
	    }
        else if (alphabet.indexOf(userInput.charAt(0)) == -1) {
        	System.out.println("Invalid input. Please enter a letter that you didnt use yet.");
        	}
       	else {
        	return true;
        }
        return false;
     }
	// Removes the letter that the user picked from the alphabet
	public void removeCharFromAlphabet(String userInput) {		
		alphabet = alphabet.replace(userInput, "");
	}
	// Main function of the game
	public void startGame() {
		resetGame();
		// Game class is made from the user perspective so even the length of the word is only provided by PickedWord
		wordToGuess = generateUnderscores(pickedWord.lenPickedWord());
		Scanner scanner = new Scanner(System.in);
		String userInput;
		
		// As long as '_' exists that means we didn't finish guessing the word        
        while(wordToGuess.indexOf('_') != -1) {  
        	System.out.println("Your word to guess: " + wordToGuess);
        	System.out.println("Letters availably for guessing: " + alphabet);
        	System.out.print("Enter a single letter:");
        	userInput = scanner.nextLine();
        	// Loop to get a valid input from user
        	while (!ValidateLetterInput(userInput)) {
        		userInput = scanner.nextLine();
        		userInput.toLowerCase();
        	}
        	// Updating phase for the next letter guess
        	numberOfGuesses += 1;
        	removeCharFromAlphabet(userInput);
        	wordToGuess = pickedWord.uncoverTheLetter(wordToGuess, userInput);        	         	
        }
        
        // The current game is finished and we ask the user if he wants to play again
        System.out.println("Good job on guessing the word, it took you " + numberOfGuesses + " tries");
        System.out.println("Want to play again? Then press 1");
        userInput = scanner.nextLine();
        if (userInput.equals("1")) {
        	startGame();
        }
        scanner.close();
	}
}
