import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

public static void serializeToFile(String filePath, Object o) throws Exception{
    FileOutputStream outputStream = new FileOutputStream(filePath);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    objectOutputStream.writeObject(o);
    objectOutputStream.close();
}
public static Object deserializeFromFile(String filePath) throws Exception{
    FileInputStream fileInputStream = new FileInputStream(filePath);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    return objectInputStream.readObject();
}
}
