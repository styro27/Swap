import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WriteToFileHelper {

    public static void writeData(String path, String message) throws IOException {
        Path file = Paths.get(path);
        Files.write(file, Collections.singleton(message),UTF_8);
    }

}
