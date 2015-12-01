package aydoo.edu.tp.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import aydoo.edu.tp.fileGenerator.FileGenerator;

public class FileGeneratorTest {
	
	
	
	@After
	public void clean() {
		File file = new File("alumno".concat(".json"));
		file.delete();
	}

	@Test
	public void generateFileJsonTest() throws Exception {
		List<InputFieldEntity> fields = new ArrayList<>();
		InputEntity entity = new InputEntity("alumno", "definicion-alumno.json", fields);
		FileGenerator fileGenerator= new FileGenerator(entity);
		fileGenerator.export();

		File file = new File("alumno".concat(".json"));
		Assert.assertTrue(file.exists());
	}
	
}
