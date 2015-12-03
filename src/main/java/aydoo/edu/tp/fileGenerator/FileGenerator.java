package aydoo.edu.tp.fileGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import aydoo.edu.tp.entity.InputEntity;

public class FileGenerator {
	
	private InputEntity entity;
	
	public FileGenerator(InputEntity entity){
		this.entity = entity;
	}
	
	public void exportJson() throws IOException {
		File file = new File(filename().concat(".json"));				
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);				
		printWriter.write(entity.toString());
		printWriter.close();
		fileWriter.close();
		
	}

	private String filename() {
		String filename = this.entity.getEntityName();
		return filename;
	}
}
