package main.categorizeclient;

import main.ID3Tag;
import main.exceptions.NotDirectoryException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class DirectoryScanner {

    private Map<File, ID3Tag> tagsFromFiles;

    public DirectoryScanner(File directory) throws FileNotFoundException, NotDirectoryException {

        if (!directory.exists()) {
            throw new FileNotFoundException();
        }
        if (directory.isFile()) {
            throw new NotDirectoryException();
        }
        if (directory.isDirectory()) {
            tagsFromFiles = new HashMap<File, ID3Tag>();
            collect(directory);
        }
    }

    public Map<File, ID3Tag> getTagsFromFiles() {
        if (tagsFromFiles.size() == 0) {
            System.out.println("No mp3 files in directory.");
        }
        return tagsFromFiles;
    }
    /*get mp3 files visszater File[] tombel */
    public void collect(File directory) {
        File[] fileList = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    String extension;
                    int lastPointIndex = pathname.getName().lastIndexOf('.');
                    if (lastPointIndex > -1) {
                        extension = pathname.getName().substring(lastPointIndex + 1);
                        return extension.toLowerCase().equals("mp3");
                    }
                }
                return false;
            }
        });

        if (fileList != null) {
            for (File file : fileList) {
                tagsFromFiles.put(file, ID3Tag.parse(file));
            }
        }
    }
    /*ide metodus ami osszeciganykodja a mapet prv*/

}
