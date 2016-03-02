package categorizeclient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class DirectoryCreator {

//    List<String> resultList;
//
//    public DirectoryCreator(List<File> musicFiles, String id3Tag) {
//	resultList = new ArrayList<String>();
//	collectTagsFromFiles(musicFiles, id3Tag);
//    }
//
//    public List<String> getID3TagList() {
//	if (resultList.size() == 0) {
//	    System.out.println("No tags in the list.");
//	}
//	return resultList;
//    }
//
//    public void collectTagsFromFiles(List<File> mp3Files, String tagName) {
//	for (File file : mp3Files) {
//	    ID3Tag tag = ID3Tag.parse(file);
//	    if (tagName.equals("title")) {
//		resultList.add(tag.getTitle());
//	    }
//	    if (tagName.equals("artist")) {
//		resultList.add(tag.getArtist());
//	    }
//	    if (tagName.equals("album")) {
//		resultList.add(tag.getAlbum());
//	    }
//	    if (tagName.equals("year")) {
//		resultList.add(tag.getYear() != 0 ? String.valueOf(tag.getYear()) : null);
//	    }
//	    if (tagName.equals("genre")) {
//		resultList.add(GenreMapper.types.get(tag.getGenre()));
//	    }
//	}
//    }
//
//    public static void createFolders(List<String> tagList, File path) {
//        for (String tagValue : tagList) {
//            if ( tagValue != null ) {
//                File currentDir = new File(path + "//" + tagValue);
//		if ( !currentDir.exists() ) {
//		    currentDir.mkdir();
//		}
//            }
//        }
//    }
    
}
