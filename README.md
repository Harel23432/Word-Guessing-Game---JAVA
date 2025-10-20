# Word-Guessing-Game---JAVA
[Project2.java](https://github.com/user-attachments/files/23006410/Project2.java)
package project2;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This program makes a puzzle game
 * the game takes in letters and solutions from a text file
 * shows them to a user using a GUI
 *
 * @author Harel Nahmany
 */

public class Project2 {
	private static final String words = "P1input.txt";

	public static UnsortedWordList unsortedList; 
	static SortedWordList sortedList;

	public static void main(String[] args) {
		TextFileInput in = new TextFileInput(words);
		String letters = readLetters(in);
		//	            String[] solutions = readSolutions(in);
		unsortedList = new UnsortedWordList();
		readSolutions(in, unsortedList);

		PuzzleGUI puzzleGUI = new PuzzleGUI();
		puzzleGUI.showData(letters);
		playGame(puzzleGUI, letters, unsortedList);

	}


	// read each line
	private static String readLetters(TextFileInput in) {
		return in.readLine();
	}


	// read the solution and put it in array
	public static void readSolutions(TextFileInput in, UnsortedWordList unsortedList) {
		String line = in.readLine();
		while (line != null) {
			Word w = new Word(line);
			unsortedList.add(w);
			line = in.readLine();
		}
	}


	//	        private static String[] readSolutions(TextFileInput in) {
	//	            List<String> solutionsList = new ArrayList<>();
	//	            String line = in.readLine();
	//	            while (line != null) {
	//	                solutionsList.add(line);
	//	                line = in.readLine();
	//	            }
	//	            return solutionsList.toArray(new String[0]);
	//	        }


	private static boolean isValidGuess(String guess, String letters) {
		// Check if the guess contains only letters from the given set
		for (char c : guess.toCharArray()) {
			if (letters.indexOf(c) == -1) {
				return false;
			}
		}
		return true;
	}

	private static void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	// Start the game ask the user and play the game
	private static void playGame(PuzzleGUI puzzleGUI, String letters, UnsortedWordList solutions) {
		int score = 0;
		while (score < solutions.length) {
			String input = (JOptionPane.showInputDialog("Enter your guess:")).toLowerCase();
			if (input == null) {
				break;// User clicked cancel, oh no
			}
			if (input.length() < 5) {
				displayErrorMessage("Your guess is less than 5 letters long!");

			}
			boolean ok = false;
			for (int i = 0; i < input.length(); i++) {
				if (letters.charAt(0) == input.charAt(i)) {
					ok = true;
					break;
				}
			}
			if (ok == false) {
				displayErrorMessage("User failed to use first letter in the letters assigned");
			}
			ok = false;
			for (int i = 0; i < letters.length(); i++) {
				for (int j = 0; j < input.length(); j++) {
					if (letters.charAt(i) == input.charAt(j)) {
						ok = true;
					}
				}
				if (ok == false) {
					break;
				}
				ok = false;
				if (i == letters.length() - 1) {
					ok = true;
					score += 3;
				}
			}
			if (ok == true) {
				continue;
			}

			if (!isValidGuess(input, letters)) {

				displayErrorMessage("Your guess contains letters that are not in the given set!");
			} else if (!contains(solutions, input)) {
				displayErrorMessage("Your guess is not in the solutions list.");
			} else {
				score++;

				puzzleGUI.updateScoreSolution(score, input, sortedList );
				JOptionPane.showMessageDialog(null, "Your guess is correct!");
			}
		}
	}


	private static boolean contains(UnsortedWordList words, String input) {
		WordNode curr = words.first.next;
		while (curr != null) {
			if (curr.data.data.equals(input)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
}
