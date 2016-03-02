package categorizeinput;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputs {

    static String choosenNumber;
    static String choosenCategory;

    static String printCategories() {
        return "\n1. Title\n" + "2. Artist\n" + "3. Album\n" + "4. Year\n" + "5. Genre\n" +
                "\nPlease enter a number for the category you'd like to sort your music accordingly: "; }

    static void getCategoryNumber() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(printCategories());
        choosenNumber = input.readLine();
        input.close(); }

    static String returnCategoryName() throws IOException {
        getCategoryNumber();
        switch (choosenNumber) {
            case "1": choosenCategory = "title"; break;
            case "2": choosenCategory = "artist"; break;
            case "3": choosenCategory = "album"; break;
            case "4": choosenCategory = "year"; break;
            case "5": choosenCategory = "genre"; break;
            default: System.out.println("\nYou can only choose a number from 1 to 5!"); break; }
        return choosenCategory; }

    static public File getFolderNameCheckIfExist() throws IOException{
        System.out.print("Please enter the path to your mp3 folder: ");
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
        String path = in.readLine();
        File dir = new File(path);
        while (!dir.exists()){
            System.out.println("The directory you entered does not exist, type the valid path: ");
            path = in.readLine();
            dir = new File(path);
        }
        return dir;
    }
}
