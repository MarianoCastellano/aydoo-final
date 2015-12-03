package aydoo.edu.tp.exporter;

import aydoo.edu.tp.entity.InputEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonFileExporter implements FileExporter {

    private static final String EXTENSION = ".json";
    private InputEntity entity;

    public JsonFileExporter(InputEntity entity) {
        this.entity = entity;
    }

    @Override
    public void export() throws IOException {
        File file = new File(filename().concat(EXTENSION));
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(entity.toJson());
        printWriter.close();
        fileWriter.close();
    }

    private String filename() {
        return this.entity.getEntityName();
    }


}
