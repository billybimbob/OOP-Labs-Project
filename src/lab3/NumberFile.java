package lab3;

import java.util.Scanner;
import java.io.*;

public class NumberFile {

	public static void main(String[] args) throws IOException{
		Scanner kboard = new Scanner(System.in);
		String accumulate = "";
		
		while (true) { //is while true with a break so that the accumulator is skipped
			System.out.print("Enter in \"Done\" when finished\nEnter in a number: ");
			String input = kboard.nextLine(); //doesn't check if the string is a number
			if (input.equals("Done") || input.equals("done"))
				break; // breaks out of the loop when "done" is entered
					   // accounts for "done" being lowercase
			accumulate = accumulate + input + " "; //accumulator for all the numbers
			System.out.println("");
		}
		System.out.print("\nEnter a name for the numbers to be\nWritten to a file: ");
		String name = kboard.nextLine() + ".txt"; //makes the file name a text file
		System.out.println("");
		FileWriter outFile = new FileWriter("C:\\Users\\funte\\eclipse-workspace\\CS201\\src\\lab3\\" + name); //sets the file location
		//file location specific to my computer, may have to change
		
		BufferedWriter output = new BufferedWriter(outFile);
        output.write(accumulate); //writes accumulated string to file
        
        output.close();
		kboard.close();
		System.out.println("Your numbers have been written to a text file");
	}

}
