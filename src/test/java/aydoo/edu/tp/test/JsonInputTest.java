package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.parser.JsonParser;
import aydoo.edu.tp.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonInputTest {

    @Test
    public void parseShouldParserInputEntityToJson() {
        String expected = "{\"identificador\":\"XS-3344\",\"descripción\":\"Conector interno XS\",\"precio\":\"756,03\"}";

        List<InputFieldEntity> fields = new ArrayList<>();
        fields.add(new InputFieldEntity("identificador", "XS-3344"));
        fields.add(new InputFieldEntity("descripción", "Conector interno XS"));
        fields.add(new InputFieldEntity("precio", "756,03"));
        InputEntity inputEntity = new InputEntity("EntityName","producto.json", fields);
        Parser parser = new JsonParser(inputEntity);
        String actual = parser.parse();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutFields() {
        new InputEntity("EntityName", "definicion.json",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutEntityName() {
        new InputEntity(null, null ,new ArrayList<InputFieldEntity>());
    }
}