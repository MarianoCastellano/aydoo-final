package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import org.junit.Test;

import java.util.ArrayList;

public class InputEntityTest {

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutFields() {
        new InputEntity("EntityName", "definicion.json", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutOutputFileName() {
        new InputEntity("EntityName", null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutEntityName() {
        new InputEntity(null, "definicion.json", new ArrayList<InputFieldEntity>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithEmptyEntityName() {
        new InputEntity("", "definicion.json", new ArrayList<InputFieldEntity>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithEmptyFileName() {
        new InputEntity("EntityName", "", new ArrayList<InputFieldEntity>());
    }
}