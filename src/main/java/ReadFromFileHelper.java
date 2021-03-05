import groovy.grape.GrapeIvy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFromFileHelper {

    public static String readData(String path) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(path)),UTF_8);
        return data;
    }

}
