package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    private Integer[] diapazon = new Integer[2];

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

    public NumberSchema range(Integer begin, Integer end) {
        this.diapazon[0] = begin;
        this.diapazon[1] = end;
        addCheck("range", element -> {
            if (element == null) {
                return true;
            } else if (diapazon[0] != null && diapazon[1] != null) {
                return element >= diapazon[0] || element <= diapazon[1];
            } else {
                return false;
            }
        });
        return this;
    }
}
