package aydoo.edu.tp.parser;

import aydoo.edu.tp.entity.FieldValidator;
import aydoo.edu.tp.entity.InputEntity;

public class JsonParser implements Parser {

    private InputEntity inputEntity;

    public JsonParser(InputEntity inputEntity) {
        FieldValidator.validateNull(inputEntity, "InputEntity is null.");
        this.inputEntity = inputEntity;
    }

    @Override
    public String parse() {
        return inputEntity.toJson();
    }

}