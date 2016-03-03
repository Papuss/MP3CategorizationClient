package categorizeinput;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import id3tag.Properties;

public class UserInputs {

    static String choosenNumber;
    static Properties choosenCategory;

    private static String printCategories() {
        return "\n1. Title\n" + "2. Artist\n" + "3. Album\n" + "4. Year\n" + "5. Genre\n" +
                "\nPlease enter a number for the category you'd like to sort your music accordingly: "; }

    public static String getChosenTagFromUser() {
	boolean validInput = true;
	Scanner input = new Scanner((System.in) );
	String[] answers = new String[]{"1", "2", "3", "4", "5"};
	System.out.print(printCategories());
	do {
	    choosenNumber = input.next();
	    if (Arrays.asList(answers).contains(choosenNumber)) {
		validInput = false;
	    }
	    else {
		System.out.print("Invalid input. Please try again: ");
	    }
		
	} while (validInput);
	input.close();
	return choosenNumber; 
    }

    public static Properties returnCategoryName() {
        choosenNumber = getChosenTagFromUser();
        switch (choosenNumber) {
            case "1": choosenCategory = Properties.TITLE; break;
            case "2": choosenCategory = Properties.ARTIST; break;
            case "3": choosenCategory = Properties.ALBUM; break;
            case "4": choosenCategory = Properties.YEAR; break;
            case "5": choosenCategory = Properties.GENRE; break;
            default: System.out.println("\nYou can only choose a number from 1 to 5!"); break; }
        return choosenCategory; }

    public static File getFolderNameCheckIfExist() {
        System.out.print("Please enter the path to your mp3 folder: ");
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
        String path = null;
        File dir = null;
	try {
	    path = in.readLine();
	    dir = new File(path);
	    while (!dir.exists()){
		System.out.println("The directory you entered does not exist, type the valid path: ");
		path = in.readLine();
		dir = new File(path);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
        return dir;
    }
}
