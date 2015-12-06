package aydoo.edu.tp.parser;

import aydoo.edu.tp.entity.InputEntity;
import aydoo.edu.tp.entity.InputFieldEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsoleParser implements Parser {

    public static final String CAMPOS = "campos";
    public static final String NOMBRE = "nombre";
    private final String entityName;

    public ConsoleParser(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public InputEntity parse(String jsonContent) {
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray campos = jsonObject.getJSONArray(CAMPOS);

        List<InputFieldEntity> fields = new ArrayList<>();
        for (int i = 0; i < campos.length(); i++) {
            JSONObject object = campos.getJSONObject(i);
            String name = object.getString(NOMBRE);

            InputFieldEntity inputFieldEntity = new InputFieldEntity(name);
            fields.add(inputFieldEntity);
        }

        return new InputEntity(entityName, fields);
    }
}