package hexlet.code;

import hexlet.code.schemas.BaseSchema;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
    }

    public StringSchema required() {
        setRequired(true);
        addCheck("required", element -> element != null && !element.equals(""));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck("minLength", element -> element.length() != 0 && !(element.length() < minLength));
        return this;
    }

    public StringSchema contains(String substr) {
        addCheck("contains", element -> element.contains(substr));
        return this;
    }
}
