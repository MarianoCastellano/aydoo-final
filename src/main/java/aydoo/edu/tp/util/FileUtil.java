package aydoo.edu.tp.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static String readFile(String path, Charset encoding) {
        String content = null;
        try {
            URL url = FileUtil.class.getResource(path);
            Path resPath = Paths.get(url.toURI());
            content = new String(Files.readAllBytes(resPath), encoding);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return content;
    }
}