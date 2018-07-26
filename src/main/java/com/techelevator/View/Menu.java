package com.techelevator.View;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class Menu {
	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	
	public void displayList(List<String> list) {
		out.println();
		for(String s : list) {
			out.println(s);
		}
		out.flush();
	}

	public void displayUserMessage(String message, boolean isError) {
		if (isError) {
			out.println("*** " + message + " ***");
		} else {
			out.println(message);
		}
		out.flush();
	}
	
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
	public int getDimensionsFromUser() {
		boolean isPositiveNumber = false;
		int dimension = 0;
		
		while(!isPositiveNumber) {
			try {
				String userInput = in.nextLine();
				dimension = Integer.valueOf(userInput);
				
				if(dimension < 1 || dimension > 15) {
					System.out.println("Sorry that is an invalid number - try again!");
				} else {
					isPositiveNumber = true;
				}
			} catch(Exception e) {
				System.out.println("Sorry that is an invalid number - try again!");
			}
		}
		return dimension;
	}

}
