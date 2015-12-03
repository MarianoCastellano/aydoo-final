package aydoo.edu.tp.entity;

public class FieldValidator {

    public static void validateNull(Object field, String message) {
        if (field == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateEmpty(String field, String message) {
        if (field.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

}