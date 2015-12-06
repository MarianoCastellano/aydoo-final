package aydoo.edu.tp;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.exporter.FileExporter;
import aydoo.edu.tp.exporter.JsonFileExporter;
import aydoo.edu.tp.parser.ConsoleParser;
import aydoo.edu.tp.parser.Parser;
import aydoo.edu.tp.util.FileUtil;

import java.io.File;
import java.nio.charset.Charset;

public class JSONGen {

    public static final String REGEX_SPLIT = "\\.";

    public static void main(String[] args) throws Exception {
        String filePath = args[0];
        String outputFileName = args[1];
        String entityName = outputFileName.split(REGEX_SPLIT)[0];

        File file = new File(filePath);
        String content = FileUtil.readFile(file.getPath(), Charset.defaultCharset());

        Parser parser = new ConsoleParser(entityName);
        InputEntity inputEntity = parser.parse(content);

        FileExporter fileExporter = new JsonFileExporter(inputEntity, outputFileName);
        String absolutePath = fileExporter.export();

        String message = "[INFO - AyDOO - JSON PATH] Archivo generado en : " + absolutePath;
        System.console().writer().println(message);
    }
}