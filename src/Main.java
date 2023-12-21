// Program starts here
public class Main {
	 public static void main(String[] args) {
	        // Create an instance of the Vocabulary class
	        Vocabulary vocabulary = new Vocabulary();

	        // Create an instance of the PickedWord class
	        PickedWord pickedWord = new PickedWord(vocabulary);

	        // Starts the game
	        Game game = new Game(pickedWord);
	        game.startGame();
	    }
}
