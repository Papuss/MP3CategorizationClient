package categorizeclient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileMover {

//    public static String returnChoosenCategory(String categoryName, ID3Tag mp3Tag){
//        String retName = "";
//        if (categoryName == "album"){
//            retName = mp3Tag.getAlbum();
//        }
//        else if (categoryName == "artist"){
//            retName = mp3Tag.getArtist();
//        }
//        else if (categoryName == "title"){
//            retName = mp3Tag.getTitle();
//        }
//        else if (categoryName == "year"){
//            retName = String.valueOf(mp3Tag.getYear());
//        }
//        else if (categoryName == "genre"){
//            retName = GenreMapper.types.get(mp3Tag.getGenre());
//        }
//        return retName;
//    }

//    public static void moveFileIntoFolder(List<File> mp3files, File path,String categoryName){
//        int counter = 0;
//        List<String> mp3sNotMoved = new ArrayList<>();
//        for (File file : mp3files){
//            ID3Tag tag = ID3Tag.parse(file);
//            File destination = new File(path + "\\" + returnChoosenCategory(categoryName,tag) + "\\" + file.getName());
//            if (destination.exists()){
//                destination.delete();
//            }
//            if (file.renameTo(destination)){
//                counter +=1;
//            } else {
//                mp3sNotMoved.add(file.getName());
//            }
//        }
//        System.out.println("\nProcess is done: ");
//        System.out.println("The program moved: " + counter + " files");
//        if (!mp3sNotMoved.isEmpty()) {
//            System.out.println("\nThese files have wrong or empty tag values, so they cannot be arranged: \n");
//            for (String List : mp3sNotMoved) {
//                System.out.println(List);
//            }
//        }
//    }
}