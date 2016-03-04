package categorizeclient;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.List;
import common.Property;

public class CategorizeClient {

    static Socket socket = null;
    static ObjectInputStream objectInputStream;
    static ObjectOutputStream objectOutputStream;

    public CategorizeClient(String host, int port, File directory, Property chosenTag) {
        try {
            if (socket == null) socket = new Socket(host, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            DirectoryScanner musicDir = new DirectoryScanner(directory);
            objectOutputStream.writeObject(musicDir.getTagsFromFiles());
            objectOutputStream.writeObject(chosenTag);
            Map<String, List<File>> resultMap = (Map<String, List<File>>) objectInputStream.readObject();

            DirectoryCreateMP3Move.createFolders(resultMap.keySet(), directory);
            for (String string : resultMap.keySet()) {
                DirectoryCreateMP3Move.moveFileIntoFolder(resultMap.get(string), directory, string); }
        } catch (Exception e) {e.printStackTrace();} }

    public void exit() {
        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close(); }
        catch (Exception e) {e.printStackTrace();} }



}
