package categorizeclient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DirectoryCreateMP3Move {

    public static void createFolders(Set<String> tagList, File path) {
        for (String tagValue : tagList) {
            if (tagValue != null) {
                File currentDir = new File(path + "//" + tagValue);
                if (!currentDir.exists()) {
                    currentDir.mkdir();
                }
            }
        }
    }

    public static void moveFileIntoFolder(List<File> mp3files, File path, String foldername) {
        int counter = 0;
        List<String> mp3sNotMoved = new ArrayList<>();
        for (File file : mp3files) {
            File destination = new File(path + "\\" + foldername + "\\" + file.getName());
            if (destination.exists()) {
                destination.delete();
            }
            if (file.renameTo(destination)) {
                counter += 1;
            } else {
                mp3sNotMoved.add(file.getName());
            }
        }
        System.out.println("\nProcess is done: ");
        System.out.println("The program moved: " + counter + " files");
        if (!mp3sNotMoved.isEmpty()) {
            System.out.println("\nThese files have wrong or empty tag values, so they cannot be arranged: \n");
            for (String List : mp3sNotMoved) {
                System.out.println(List);
            }
        }
    }


}
