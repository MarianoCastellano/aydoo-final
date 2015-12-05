package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.exporter.FileExporter;
import aydoo.edu.tp.exporter.JsonFileExporter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileExporterTest {

    public static final String ENTITY_NAME = "alumno";
    public static final String FILE_NAME = "alumno.json";
    private File file;

    @After
    public void clean() {
        file.deleteOnExit();
    }

    @Test
    public void generateFileJsonTest() throws Exception {
        List<InputFieldEntity> fields = new ArrayList<>();
        InputEntity entity = new InputEntity(ENTITY_NAME, FILE_NAME, fields);
        FileExporter jsonFileExporter = new JsonFileExporter(entity);
        jsonFileExporter.export();
        createFile();

        Assert.assertTrue(file.exists());
    }

    private void createFile() {
        file = new File(FILE_NAME);
    }

    @Test
    public void fileMustContentNombreSebastianApellidoRoldanTest() throws Exception {
        List<InputFieldEntity> fields = new ArrayList<>();
        InputFieldEntity input1 = new InputFieldEntity("nombre", "sebastian");
        InputFieldEntity input2 = new InputFieldEntity("apellido", "roldan");
        fields.add(input1);
        fields.add(input2);
        InputEntity entity = new InputEntity(ENTITY_NAME, FILE_NAME, fields);
        FileExporter jsonFileExporter = new JsonFileExporter(entity);
        jsonFileExporter.export();
        createFile();

        String actual = getContentToFile();
        String expected = "{\"nombre\":\"sebastian\",\"apellido\":\"roldan\"}";

        Assert.assertEquals(expected, actual);
    }

    private String getContentToFile() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String linea = br.readLine();
        br.close();
        return linea;
    }


}