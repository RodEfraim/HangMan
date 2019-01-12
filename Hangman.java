import java.util.Scanner;
import java.util.Random;

/**
 *  One-player game of Hangman. 6 incorrect inputs makes the user loose.
 */
public class Hangman
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		String wordList[] = {"water", "shield", "attack", "flower", "ground", "elephant", "coffee", "sniper", "bullet", "fighter"};
		String misses = "";
		char guess;
		int missCount = 0;

		System.out.println("HANGMAN");

		String randomWord = wordList[r.nextInt(wordList.length)];

		char process[] = new char[randomWord.length()];
		String wordProcess = "";
		for(int count = 0; count < randomWord.length(); count++)
		{
			process[count] = '_';
		}
		System.out.println();

		for(int count = 0; /*!wordProcess.equals(randomWord)*/; count++)
		{
			boolean equalLetter = false;
			wordProcess = "";
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("Word:\t\t");
			for(int count1 = 0; count1 < randomWord.length(); count1++)
			{
				wordProcess += process[count1];
				System.out.print(process[count1]);
			}
			System.out.println("\n");
			System.out.println("Misses: " + misses + "\n");
			printImage(missCount);
			if(wordProcess.equals(randomWord))
			{
				System.out.println("CONGRATULATIONS, YOU WIN!");
				break;
			}
			if(missCount == 6)
			{
				System.out.println("YOU LOOSE!");
				System.out.println("The word you missed was " + randomWord + ".");
				break;
			}
			System.out.print("Guess: ");
			guess = keyboard.next().charAt(0);

			for(int count1 = 0; count1 < randomWord.length(); count1++)
			{
				if(guess == randomWord.charAt(count1))
				{
					equalLetter = true;
					process[count1] = guess;
				}
				else if(count1 == (randomWord.length() - 1))
				{
					if(equalLetter == true)
						break;
					else
					{
						missCount++;
						misses += guess;
					}
				}
			}
		}//end of loop
		System.out.println("Ending...");
	}

  /**
   *  Displays the current status of the game. Displays the visual
   *  representation of the number of incorrect letters.
   *
   *  @param num: The current number of misses/incorrect letters
   *  inputted by the user.
   */
	public static void printImage(int num)
	{
		if(num == 1)
		{
			System.out.println("O\n");
		}
		else if(num == 2)
		{
			System.out.println(" O ");
			System.out.println(" | ");
			System.out.println(" | \n");
		}
		else if(num == 3)
		{
			System.out.println(" O ");
			System.out.println("\\| ");
			System.out.println(" | \n");
		}
		else if(num == 4)
		{
			System.out.println(" O ");
			System.out.println("\\|/");
			System.out.println(" | \n");
		}
		else if(num == 5)
		{
			System.out.println(" O ");
			System.out.println("\\|/");
			System.out.println(" | ");
			System.out.println("/  \n");
		}
		else if(num == 6)
		{
			System.out.println(" O ");
			System.out.println("\\|/");
			System.out.println(" | ");
			System.out.println("/ \\ \n");
		}
	}
}
