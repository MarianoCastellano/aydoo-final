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
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (InputFieldEntity inputFieldEntity : fields) {
			String field = inputFieldEntity.toString();
			builder.append(field);
			builder.append(",");
		}
		removeLastComma(builder);
		builder.append("}");
		return builder.toString();
	}

	private void removeLastComma(StringBuilder builder) {
		builder.deleteCharAt(builder.length() - 1);
	}

}