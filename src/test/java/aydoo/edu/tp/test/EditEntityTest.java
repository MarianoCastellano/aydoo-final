package aydoo.edu.tp.test;

import org.junit.Assert;
import org.junit.Test;

import aydoo.edu.tp.ui.EditEntity;

public class EditEntityTest {
	
	@Test
	public void ouputFileNameMustBeAlumnoTest(){
		String inputFileName = "definicion-profesor.json";
		String content = "{\"campos\":[{\"nombre\":\"nombre\",\"tipo\":\"string\"},{\"nombre\":\"direccion\",\"tipo\":\"string\"}]}";
		EditEntity editEntity = new EditEntity(content, inputFileName);
		String expected = "profesor";		
		
		Assert.assertEquals(expected, editEntity.getOuputFileName());
	}
	
}
