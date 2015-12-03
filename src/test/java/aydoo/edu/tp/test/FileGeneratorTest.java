package aydoo.edu.tp.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		fileGenerator.exportJson();
		File file = new File("alumno".concat(".json"));
		
		Assert.assertTrue(file.exists());
	}	
	
	@Test
	public void fileMustContentNombreSebastianApellidoRoldanTest() throws Exception {
		List<InputFieldEntity> fields = new ArrayList<>();
		InputFieldEntity input1 = new InputFieldEntity("nombre","sebastian");
		InputFieldEntity input2 = new InputFieldEntity("apellido","roldan");
		fields.add(input1);
		fields.add(input2);
		InputEntity entity = new InputEntity("alumno", "definicion-alumno.json", fields);
		FileGenerator fileGenerator= new FileGenerator(entity);
		fileGenerator.exportJson();
		File file = new File("alumno".concat(".json"));		
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);		
		String linea = br.readLine();		
		br.close();
		String expected = "{\"nombre\":\"sebastian\",\"apellido\":\"roldan\"}";
		
		Assert.assertEquals(expected, linea);
	}

}