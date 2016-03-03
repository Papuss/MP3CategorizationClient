package categorizeclient;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import common.ID3Tag;

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
            collectFilesFromDir(directory);
        }
    }

    public Map<File, ID3Tag> getTagsFromFiles() {
	if (tagsFromFiles.size() == 0) {
            System.out.println("No mp3 files in directory.");
        }
        return tagsFromFiles;
    }
    
    private void collectFilesFromDir(File directory) {
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

}
