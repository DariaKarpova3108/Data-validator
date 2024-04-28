package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    private Map<K, BaseSchema<V>> schema;

    public MapSchema() {
        this.schema = new HashMap<>();
    }

    public MapSchema<K, V> required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public MapSchema<K, V> sizeof(int count) {
        addCheck("sizeof", element -> {
            if (element == null) {
                return true;
            } else {
                return element.size() == count;
            }
        });
        return this;
    }

    public void shape(Map<K, BaseSchema<V>> schemas) {
        addCheck("shape", element -> {
            if (this.schema != null && element != null) {
                for (var entry : schema.entrySet()) {
                    var key = entry.getKey();
                    BaseSchema<V> check = schemas.get(key);
                    var value = element.get(key);
                    if (!schema.containsKey(key) || !check.isValid(value)) {
                        return false;
                    }
                }
            }
            return true;
        });
        this.schema = schemas;
    }
}
