import java.util.Random;

// PickedWord class will pick a random word from an array of strings
public class PickedWord {
    private String[] words;
    private String word;
    private Random random;

    // Constructor that gets the words from the Vocabulary class
    public PickedWord(Vocabulary vocabulary) {       
        this.words = vocabulary.getWords();
        this.random = new Random();
    }

    // Method to reset a random word
    public void resetRandomWord() {
        int randomIndex = random.nextInt(words.length);
        this.word = words[randomIndex];
    }    
    // Returns the length of the picked word
    public int lenPickedWord() {
    	return word.length();
    }
    // Will replace '_' with the provided letter if exists in the picked word
    public String uncoverTheLetter(String wordToGuess, String userInput) {
    	char[] charArray = wordToGuess.toCharArray();
    	int index = -1;
    	// We loop to find the right place for the input letter, might be more then one such index
    	while((index = word.indexOf(userInput, index + 1)) != -1) {
    		charArray[index] = userInput.charAt(0);
    	}
    	return new String(charArray);
    }
}