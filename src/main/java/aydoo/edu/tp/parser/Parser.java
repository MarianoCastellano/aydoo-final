package aydoo.edu.tp.parser;

import aydoo.edu.tp.entity.InputEntity;

public interface Parser {

    InputEntity parse(String jsonContent);
}