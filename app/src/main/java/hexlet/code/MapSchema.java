package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    private boolean isRequired;
    private Integer size = null;
    private Map<String, BaseSchema<String>> schema;

    public MapSchema() {
        this.schema = new HashMap<>();
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int count) {
        this.size = count;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> element) {
        if (isRequired() && element == null) {
            return false;
        }

        if (this.size != null && element != null && element.size() != this.size) {
            return false;
        }

        if (this.schema != null && element != null) {
            for (var entry : schema.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> check = schema.get(key);
                String value = element.get(key);
                if (!check.isValid(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        this.schema = schemas;
    }
}
