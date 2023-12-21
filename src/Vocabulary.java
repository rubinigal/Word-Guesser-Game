// Vocabulary class will hold the array of words as well as the function to get those words
public class Vocabulary {
	 private String[] words;
	 
	// Constructor to initialize the array with default words
	public Vocabulary() {
		words = new String[]{"apple", "banana", "carrot", "dog", "elephant", "flower", "guitar", "house", "internet", "jungle"};
	}
	
	// Getter
	public String[] getWords() {
		return words;
	}
}
