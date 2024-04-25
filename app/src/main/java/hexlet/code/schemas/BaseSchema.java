package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected Map<String, Predicate<T>> checks;

    public BaseSchema() {
        this.checks = new LinkedHashMap<>();
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    protected final void addCheck(String check, Predicate<T> predicate) {
        this.checks.put(check, predicate);
    }

    public final boolean isValid(Object element) {
        for (var entry : this.checks.entrySet()) {
            var check = entry.getValue();
            if (!check.test((T) element)) {
                return false;
            }
        }
        return true;
    }
}
