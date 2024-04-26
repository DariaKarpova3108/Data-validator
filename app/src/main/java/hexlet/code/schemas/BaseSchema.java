package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks;

    public BaseSchema() {
        this.checks = new LinkedHashMap<>();
    }

    protected final void addCheck(String check, Predicate<T> predicate) {
        this.checks.put(check, predicate);
    }

    public final boolean isValid(T element) {
        for (var entry : this.checks.entrySet()) {
            var check = entry.getValue();
            if (!check.test(element)) {
                return false;
            }
        }
        return true;
    }
}
