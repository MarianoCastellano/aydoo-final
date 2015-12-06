package aydoo.edu.tp.exporter;

import aydoo.edu.tp.entity.FieldValidator;
import aydoo.edu.tp.entity.InputEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonFileExporter implements FileExporter {

    private InputEntity entity;
    private String outputFileName;

    public JsonFileExporter(InputEntity entity, String outputFileName) {
        FieldValidator.validateNull(outputFileName, "El nombre del archivo de salida no puede ser nulo");
        FieldValidator.validateNull(entity, "La entidad a exportar no puede ser nulo");
        FieldValidator.validateEmpty(outputFileName, "El nombre del archivo de salida no puede ser vacio");
        this.entity = entity;
        this.outputFileName = outputFileName;
    }

    @Override
    public String export() throws IOException {
        File file = new File(outputFileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(entity.toJson());
        printWriter.close();
        fileWriter.close();
        return file.getAbsolutePath();
    }

}
