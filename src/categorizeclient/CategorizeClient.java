package categorizeclient;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import categorizeinput.UserInputs;
import exceptions.NotDirectoryException;

public class CategorizeClient {

    public CategorizeClient(int port, File directory, String chosenTag) {
	try {
	    Socket socket = new Socket("localhost", port);
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	    
	    DirectoryScanner musicDir = new DirectoryScanner(directory) ;
	    objectOutputStream.writeObject(musicDir.getTagsFromFiles());
	    objectOutputStream.writeObject(chosenTag);
	     
	    
	    objectOutputStream.close();
	    objectInputStream.close();
	    socket.close();
	} catch (IOException | NotDirectoryException e) {
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
	File pathName = UserInputs.getFolderNameCheckIfExist();
	String chosenTag = UserInputs.returnCategoryName();
	new CategorizeClient(1003, pathName, chosenTag);
    }
}
