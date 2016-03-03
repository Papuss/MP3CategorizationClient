package main;

import main.categorizeclient.CategorizeClient;
import main.categorizeinput.UserInputs;
import main.id3tag.Properties;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File pathName = UserInputs.getFolderNameCheckIfExist();
        Properties chosenTag = UserInputs.returnCategoryName();
        new CategorizeClient(1003, pathName, chosenTag);


    }
}
