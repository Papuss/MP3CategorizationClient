package main;

import java.io.File;

import common.Property;
import main.categorizeclient.CategorizeClient;
import main.categorizeclient.DirectoryCreateMP3Move;
import main.categorizeinput.UserInputs;

public class Main {

    public static void main(String[] args) {
        while (true){
            File pathName = UserInputs.getFolderNameCheckIfExist();
            Property chosenTag = UserInputs.returnCategoryName();
            new CategorizeClient(1003, pathName, chosenTag);
            DirectoryCreateMP3Move.printResults();
        }



        }



    }

