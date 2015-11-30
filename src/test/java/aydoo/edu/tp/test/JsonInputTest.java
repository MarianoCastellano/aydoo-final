package aydoo.edu.tp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.parser.JsonParser;
import aydoo.edu.tp.parser.Parser;

public class JsonInputTest {

	@Test
	public void parseShouldParserInputEntityToJson() {
		String expected = "{\"identificador\":\"XS-3344\",\"descripción\":\"Conector interno XS\",\"precio\":\"756,03\"}";
		List<InputFieldEntity> fields = new ArrayList<>();
		fields.add(new InputFieldEntity("identificador", "XS-3344"));
		fields.add(new InputFieldEntity("descripción", "Conector interno XS"));
		fields.add(new InputFieldEntity("precio", "756,03"));
		InputEntity inputEntity = new InputEntity("EntityName", "FileDefinition", fields);
		Parser parser = new JsonParser(inputEntity);
		String actual = parser.parse();
		Assert.assertEquals(expected, actual);
	}
}