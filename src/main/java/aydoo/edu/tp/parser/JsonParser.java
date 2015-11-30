package aydoo.edu.tp.parser;

import aydoo.edu.tp.entity.InputEntity;

public class JsonParser implements Parser {

	private InputEntity inputEntity;

	public JsonParser(InputEntity inputEntity) {
		this.inputEntity = inputEntity;
	}

	@Override
	public String parse() {
		return getInputEntity().toString();
	}

	public InputEntity getInputEntity() {
		return inputEntity;
	}
}