package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.parser.ConsoleParser;
import aydoo.edu.tp.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ConsoleParserTest {

    public static final String ENTITY_NAME = "alumno";

    @Test
    public void parseShouldTransformJsonInputToEmptyJson() {
        Parser jsonParser = new ConsoleParser(ENTITY_NAME);

        String jsonInput = "{\"campos\":[{\"nombre\":\"nombre\",\"tipo\":\"string\"},{\"nombre\":\"apellido\",\"tipo\":\"string\"}]}";
        String jsonOutput = "{\"nombre\":\"\",\"apellido\":\"\"}";
        InputEntity inputEntity = jsonParser.parse(jsonInput);

        Assert.assertEquals(inputEntity.getEntityName(), ENTITY_NAME);
        Assert.assertEquals(jsonOutput, inputEntity.toJson());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldThrowExceptionWhenInputEntityIsNull() {
        String jsonInput = "{\"campos\":[{\"nombre\":\"nombre\",\"tipo\":\"string\"},{\"nombre\":\"apellido\",\"tipo\":\"string\"}]}";
        new ConsoleParser(null).parse(jsonInput);
    }
}