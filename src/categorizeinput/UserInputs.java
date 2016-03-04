package categorizeinput;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import common.Property;

public class UserInputs {

	static String choosenNumber;
	static Property choosenCategory;

	private static String printCategories() {
		return "\n1. Title\n" + "2. Artist\n" + "3. Album\n" + "4. Year\n" + "5. Genre\n" +
				"\nPlease enter a number for the category you'd like to sort your music accordingly: ";	}

	public static String getChosenTagFromUser() {
		boolean validInput = true;
		Scanner input = new Scanner(System.in);
		String[] answers = new String[]{"1", "2", "3", "4", "5"};
		System.out.print(printCategories());
		do {
			choosenNumber = input.nextLine();
			if (Arrays.asList(answers).contains(choosenNumber)) {
				validInput = false;
			} else {
				System.out.print("Invalid input. Please try again: ");
			}
		} while (validInput);
		return choosenNumber; }

	public static Property returnCategoryName() {
		choosenNumber = getChosenTagFromUser();
		switch (choosenNumber) {
			case "1" : choosenCategory = Property.TITLE; break;
			case "2" : choosenCategory = Property.ARTIST; break;
			case "3" : choosenCategory = Property.ALBUM; break;
			case "4" : choosenCategory = Property.YEAR; break;
			case "5" : choosenCategory = Property.GENRE; break;
			default : System.out.println("\nYou can only choose a number from 1 to 5!"); break; }
		return choosenCategory;	}

	static public File getFolderNameCheckIfExist() throws Exception {
		File dir= null;
		do {
			System.out.print("Please enter the path to your mp3 folder (such as c:/music) or (exit) to exit: ");
			Scanner scanner = new Scanner(System.in);
			String dirPath = scanner.nextLine();
			if (dirPath.equals("exit")){
				System.exit(1);
			}
			dir = new File(dirPath); }
		while (!dir.exists());
		return dir; }
}