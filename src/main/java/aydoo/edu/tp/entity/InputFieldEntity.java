package aydoo.edu.tp.entity;

public class InputFieldEntity {

    private String name;
    private String value;

    public InputFieldEntity(String name, String value) {
        validateFields(name, value);
        this.name = name;
        this.value = value;
    }

    public String toJson() {
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

    private void validateFields(String name, String value) {
        FieldValidator.validateNull(name, "El nombre del campo es requerido.");
        FieldValidator.validateEmpty(name, "El nombre del campo no puede ser vacio.");
        FieldValidator.validateNull(value, "El valor del campo es requerido.");
    }
}