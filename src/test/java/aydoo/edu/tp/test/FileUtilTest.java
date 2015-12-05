package aydoo.edu.tp.test;

import aydoo.edu.tp.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class FileUtilTest {

    @Test
    public void readFileShouldParserPath() {
        String json = FileUtil.readFile("/definition-alumno.json", Charset.defaultCharset());
        String fileContent = "{\"campos\":[{\"nombre\":\"nombre\", \"tipo\":\"string\"},{\"nombre\":\"apellido\", \"tipo\":\"string\"}]}".trim();
        Assert.assertEquals(json, fileContent);
    }

    @Test
    public void readFileShouldNotParserEmptyContent() {
        String json = FileUtil.readFile("/definition-alumno.json", Charset.defaultCharset());
        String fileContent = "".trim();
        Assert.assertFalse(json.equalsIgnoreCase(fileContent));
    }
}