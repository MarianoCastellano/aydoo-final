package aydoo.edu.tp.entity;

import java.util.List;

public class InputEntity {

	private String entityName;
	private String fileDefinition;
	private List<InputFieldEntity> fields;

	public InputEntity(String entityName, String fileDefinition, List<InputFieldEntity> fields) {
		this.entityName = entityName;
		this.fileDefinition = fileDefinition;
		this.fields = fields;
	}

	public String getEntityName() {
		return entityName;
	}

	public String getFileDefinition() {
		return fileDefinition;
	}

	public List<InputFieldEntity> getFields() {
		return fields;
	}

	@Override
	public String toString() {
		String ln = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append(ln);
		for (InputFieldEntity inputFieldEntity : fields) {
			String field = inputFieldEntity.toString();
			builder.append(field);
			builder.append(",");
			builder.append(ln);
		}
		removeLastCommaAndLineSeparator(builder);		
		builder.append(ln);
		builder.append("}");		
		return builder.toString();
	}

	private void removeLastCommaAndLineSeparator(StringBuilder builder) {
		builder.deleteCharAt(builder.length() - 1);		
		builder.deleteCharAt(builder.length() - 1);
		builder.deleteCharAt(builder.length() - 1);
	}

}