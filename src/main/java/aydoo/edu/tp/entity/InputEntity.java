package aydoo.edu.tp.entity;

import java.util.List;

public class InputEntity {

    private String entityName;
    private String fileDefinition;
    private List<InputFieldEntity> fields;

    public InputEntity(String entityName, String fileDefinition, List<InputFieldEntity> fields) {
        validateFields(entityName, fileDefinition, fields);
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

    public String toJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (InputFieldEntity inputFieldEntity : fields) {
            String field = inputFieldEntity.toJson();
            builder.append(field);
            builder.append(",");
        }
        removeLastCommaAndLineSeparator(builder);
        builder.append("}");
        return builder.toString();
    }


    private void validateFields(String entityName, String fileDefinition, List<InputFieldEntity> fields) {
        FieldValidator.validateNull(entityName, "El nombre de la entidad es requerido.");
        FieldValidator.validateNull(fileDefinition, "El nombre de la definicion de la entidad es requerida.");
        FieldValidator.validateNull(fields, "Los campos de la entidad son requeridos.");
        FieldValidator.validateEmpty(entityName, "El nombre de la entidad no puede ser vacio.");
        FieldValidator.validateEmpty(fileDefinition, "El nombre de la definicion de la entidad no puede ser vacio.");
    }

    private void removeLastCommaAndLineSeparator(StringBuilder builder) {
        builder.deleteCharAt(builder.length() - 1);
    }

}