package main;

import main.categorizeclient.CategorizeClient;
import main.categorizeinput.UserInputs;

import java.io.File;

import common.Properties;

public class Main {

    public static void main(String[] args) {
        File pathName = UserInputs.getFolderNameCheckIfExist();
        Properties chosenTag = UserInputs.returnCategoryName();
        new CategorizeClient(1003, pathName, chosenTag);


    }
}
