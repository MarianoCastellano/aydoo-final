package aydoo.edu.tp.exporter;

import aydoo.edu.tp.entity.InputEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonFileExporter implements FileExporter {

    private InputEntity entity;

    public JsonFileExporter(InputEntity entity) {
        this.entity = entity;
    }

    @Override
    public String export() throws IOException {
        File file = new File(filename());
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(entity.toJson());
        printWriter.close();
        fileWriter.close();
        return file.getAbsolutePath();
    }

    private String filename() {
        return this.entity.getFileName();
    }


}
