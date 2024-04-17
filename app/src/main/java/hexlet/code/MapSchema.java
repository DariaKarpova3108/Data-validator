package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {
    private Integer size = null;

    public MapSchema() {
    }

    @Override
    public BaseSchema<Map> required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int count) {
        this.size = count;
        return this;
    }

    @Override
    public boolean isValid(Map element) {
        if (isRequired() && element == null) {
            return false;
        }

        if (this.size != null && element != null && element.size() != this.size) {
            return false;
        }

        return true;
    }

}
