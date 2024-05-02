package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
    }

    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", element -> {
            if (element == null) {
                return true;
            } else {
                return element > 0;
            }
        });
        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        addCheck("range", element -> {
            if (element == null) {
                return true;
            } else {
                return element >= min && element <= max;
            }
        });
        return this;
    }
}
