package main.categorizeclient;

import main.exceptions.NotDirectoryException;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import common.Property;

import java.util.List;

public class CategorizeClient {

    private static Map<String, List<File>> resultMap;
    static Socket socket;
    static ObjectInputStream objectInputStream;
    static ObjectOutputStream objectOutputStream;

    public CategorizeClient(int port, File directory, Property chosenTag) {
        try {

            if (!socket.isConnected()){
                socket = new Socket("192.168.150.50", port);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            }

            DirectoryScanner musicDir = new DirectoryScanner(directory);
            objectOutputStream.writeObject(musicDir.getTagsFromFiles());
            objectOutputStream.writeObject(chosenTag);

            resultMap = (Map<String, List<File>>) objectInputStream.readObject();



            DirectoryCreateMP3Move.createFolders(resultMap.keySet(), directory);
            for (String string : resultMap.keySet()) {
                DirectoryCreateMP3Move.moveFileIntoFolder(resultMap.get(string), directory, string);
            }

        } catch (IOException | NotDirectoryException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void exit() {
        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
