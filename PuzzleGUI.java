package project2;
import javax.swing.*;
import java.awt.*;

/**
 * the game prints on the right side the words and the score that the user gets
 * the joptionpane asks the user to input words and prints them on a contentpane
 *
 * @author Harel Nahmany
 *
 */

public class PuzzleGUI extends JFrame {

	private Container box;
	private TextArea letter;
	private TextArea words;

	public PuzzleGUI() {
		// make the simple gui to show data

		setSize(800, 400);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		setVisible(true);
		box = getContentPane();
		letter = new TextArea();
		words = new TextArea();
		box.add(letter);
		box.add(words);
	}


	// showing the necessary data

	public void showData(String letters) {
		letter.append(letters);
		words.append("User Score: 0");
	}

	// showing the necessary data

	public void updateScoreSolution(int score, String solution, SortedWordList l) {

		// append the solution and update score
		words.replaceRange(Integer.toString(score), 12, 13);
		
		l.add(new Word(solution));
		//words.append("\n" + solution);
	}

}
