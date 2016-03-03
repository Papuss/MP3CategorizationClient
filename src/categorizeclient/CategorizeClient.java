package categorizeclient;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.List;

import categorizeinput.UserInputs;
import exceptions.NotDirectoryException;
import id3tag.Properties;

public class CategorizeClient {

    private static Map<String, List<File>> resultMap = null;

    public CategorizeClient(int port, File directory, Properties chosenTag) {
	try {
	    Socket socket = new Socket("192.168.150.50", port);
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

	    DirectoryScanner musicDir = new DirectoryScanner(directory) ;
	    objectOutputStream.writeObject(musicDir.getTagsFromFiles());
	    objectOutputStream.writeObject(chosenTag);

	    resultMap = (Map<String, List<File>>) objectInputStream.readObject();

	    
	    DirectoryCreateMP3Move.createFolders(resultMap.keySet(), directory);
	    for (String string : resultMap.keySet()) {
		DirectoryCreateMP3Move.moveFileIntoFolder(resultMap.get(string), directory, string);
	    }
	    

	    objectOutputStream.close();
	    objectInputStream.close();
	    socket.close();
	} catch (IOException | NotDirectoryException | ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	File pathName = UserInputs.getFolderNameCheckIfExist();
	Properties chosenTag = UserInputs.returnCategoryName();
	new CategorizeClient(1003, pathName, chosenTag);
	
    }
}
