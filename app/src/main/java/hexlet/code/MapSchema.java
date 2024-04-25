package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    private Map<String, BaseSchema<String>> schema;

    public MapSchema() {
        this.schema = new HashMap<>();
    }

    public MapSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int count) {
        addCheck("sizeof", element -> {
            if (element == null) {
                return true;
            } else {
                return element.size() == count;
            }
        });
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        addCheck("shape", element -> {
            if (this.schema != null && element != null) {
                for (var entry : schema.entrySet()) {
                    String key = entry.getKey();
                    BaseSchema<String> check = schemas.get(key);
                    var value = element.get(key);
                    if (!schema.containsKey(key) || !check.isValid((String) value)) {
                        return false;
                    }
                }
            }
            return true;
        });
        this.schema = schemas;
    }
}
