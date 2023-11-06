/*TASK 1

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
*/

import java.util.*; 
import java.io.*;
class Task01{ 
	public static void main(String args[]) throws IOException 
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int answer, guess,count = 0 ; 
		
		final int MAX = 100; 
		
	    Random rand = new Random();
	    
	    boolean correct = false;
	    
	    answer = rand.nextInt(MAX) + 1; 

		while (!correct) { 
		        ++count;
		
			System.out.println( 
				"Guess a number between 1 and 100: "); 

			guess = Integer.parseInt(br.readLine()); 

			if (guess > answer) { 
				System.out.println("Too high, try again"); 
			} 

			else if (guess < answer) { 
				System.out.println("Too low, try again"); 
			} 

			else { 

				System.out.println( 
					"Yes, you guessed the number."); 

				correct = true; 
			} 

    
		} 
    System.out.println("Number of total attempt: " + count);
		System.exit(0); 
	} 
}

