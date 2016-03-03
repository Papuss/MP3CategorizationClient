package main;

import main.categorizeclient.CategorizeClient;
import main.categorizeclient.DirectoryCreateMP3Move;
import main.categorizeinput.UserInputs;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        while (true){
            File pathName = UserInputs.getFolderNameCheckIfExist();
            Properties chosenTag = UserInputs.returnCategoryName();
            new CategorizeClient(1003, pathName, chosenTag);
            DirectoryCreateMP3Move.printResults();
        }



        }



    }

