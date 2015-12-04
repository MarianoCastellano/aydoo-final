package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.parser.JsonParser;
import aydoo.edu.tp.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @Test
    public void parseShouldTransformInputEntityToJson() {
        List<InputFieldEntity> fields = new ArrayList<>();
        fields.add(new InputFieldEntity("nombre", "Mariano"));
        fields.add(new InputFieldEntity("apellido", "Castellano"));
        fields.add(new InputFieldEntity("legajo", "26495"));
        InputEntity inputEntity = new InputEntity("alumno","alumno.json", fields);
        Parser jsonParser = new JsonParser(inputEntity);
        String json = jsonParser.parse();
        String expected = "{\"nombre\":\"Mariano\",\"apellido\":\"Castellano\",\"legajo\":\"26495\"}";

        Assert.assertEquals(expected, json);
    }

    @Test
    public void parseShouldTransformInputEntityWithFieldEmptyToJson() {
        List<InputFieldEntity> fields = new ArrayList<>();
        fields.add(new InputFieldEntity("nombre", "Mariano"));
        fields.add(new InputFieldEntity("apellido", ""));
        InputEntity inputEntity = new InputEntity("alumno","alumno.json", fields);
        Parser jsonParser = new JsonParser(inputEntity);
        String json = jsonParser.parse();
        String expected = "{\"nombre\":\"Mariano\",\"apellido\":\"\"}";

        Assert.assertEquals(expected, json);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldThrowExceptionWhenInputEntityIsNull() {
        new JsonParser(null);
    }
}