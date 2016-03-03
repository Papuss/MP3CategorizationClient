package main;

import java.io.File;
import common.Property;
import categorizeclient.CategorizeClient;
import categorizeclient.DirectoryCreateMP3Move;
import categorizeinput.UserInputs;

public class Main {

    public static void main(String[] args) throws Exception {
        while (true){
            File pathName = UserInputs.getFolderNameCheckIfExist();
            Property chosenTag = UserInputs.returnCategoryName();
            new CategorizeClient(1003, pathName, chosenTag);
            DirectoryCreateMP3Move.printResults();
        }
    }
}

