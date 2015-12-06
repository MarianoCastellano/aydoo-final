package aydoo.edu.tp.entity;

import java.util.List;

public class InputEntity {

    private String entityName;
    private List<InputFieldEntity> fields;

    public InputEntity(String entityName, List<InputFieldEntity> fields) {
        validateFields(entityName, fields);
        this.entityName = entityName;
        this.fields = fields;
    }

    public String getEntityName() {
        return entityName;
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


    private void validateFields(String entityName, List<InputFieldEntity> fields) {
        FieldValidator.validateNull(entityName, "El nombre de la entidad es requerido.");
        FieldValidator.validateNull(fields, "Los campos de la entidad son requeridos.");
        FieldValidator.validateEmpty(entityName, "El nombre de la entidad no puede ser vacio.");
    }

    private void removeLastCommaAndLineSeparator(StringBuilder builder) {
        builder.deleteCharAt(builder.length() - 1);
    }

}