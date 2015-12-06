package aydoo.edu.tp.test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import org.junit.Test;

import java.util.ArrayList;

public class InputEntityTest {

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutFields() {
        new InputEntity("EntityName", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithoutEntityName() {
        new InputEntity(null, new ArrayList<InputFieldEntity>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShouldNotParserInputEntityWithEmptyEntityName() {
        new InputEntity("", new ArrayList<InputFieldEntity>());
    }

}