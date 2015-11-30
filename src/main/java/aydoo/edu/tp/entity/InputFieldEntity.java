package aydoo.edu.tp.entity;

public class InputFieldEntity {

	private String name;
	private String value;

	public InputFieldEntity(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\"");
		builder.append(name);
		builder.append("\"");
		builder.append(":");
		builder.append("\"");
		builder.append(value);
		builder.append("\"");
		return builder.toString();
	}
}