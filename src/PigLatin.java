import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println();
		UserCont();

	}

	public static void UserCont() {

		Scanner scan = new Scanner(System.in);
		char vCont;

		do {

			// Call Functional Methods

			// Get User Input
			// Calculate
			// Display

			Display(Process(PromptInput()));

			// Ask if User wants to repeat
			System.out.println("Translate another line? (y/n): ");
			String vUserInput = scan.next();
			vCont = vUserInput.charAt(0);
			if (vCont == 'Y') {
				vCont = 'y';
			}
		} while (vCont == 'y');

		scan.close();

	}

	public static String PromptInput() {

		// Initialize
		Scanner scan = new Scanner(System.in);

		System.out.println("What would you like to translate?");
		String vResult = scan.nextLine();

		return vResult;
	}

	public static String Process(String userInput) {

		String vResult = userInput;
		int vSpaces = userInput.indexOf(' ');
		// int i = 0;

		if (vSpaces == -1) {
			vResult = Pigitate(userInput);
		} else {
			String[] vWords = new String[32];
			vWords = userInput.split(" ");
			for (int i = 0; i < vWords.length; i++) {
				if (i == 0) {
					vResult = Pigitate(vWords[i]);
				} else {
					vResult = vResult + " " + Pigitate(vWords[i]);
				}
			}
		}
		return vResult;
	}

	public static String Pigitate(String word) {
		StringBuilder vWord = new StringBuilder(word);
		int vVowelPos = 0;
		// Check which position the first vowel is in.

		// Search for first vowel and then get position.

		Pattern p = Pattern.compile("[aeiouAEIOU]");
		Matcher m = p.matcher(vWord.toString());
		boolean vMatch = m.find();
		
		if (vMatch) { 
			vVowelPos = m.start();
			if (vVowelPos == 0) {
				vWord = vWord.append("way");
			} else {
			StringBuilder vCons = new StringBuilder(word.substring(0, vVowelPos));
			StringBuilder vRoot = new StringBuilder(word.substring(vVowelPos, word.length()));
			vWord = vRoot.append(vCons + "ay");
			}} else {

			// No vowels
			vWord = vWord.append("way");
		}

		return vWord.toString();
	}

	public static void Display(String ProgOutput) {

		System.out.println(ProgOutput.toLowerCase());

	}

}
