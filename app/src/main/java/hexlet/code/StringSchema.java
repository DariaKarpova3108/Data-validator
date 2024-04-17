package hexlet.code;

public class StringSchema extends Schema<String> {
    private int length = 0;
    private String substring = null;

    public StringSchema() {
    }

    @Override
    public Schema<String> required() {
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.length = minLength;
        return this;
    }

    public StringSchema contains(String substr) {
        this.substring = substr;
        return this;
    }

    @Override
    public boolean isValid(String element) {
        if (isRequired() && element == null || element.equals("")) {
            return false;
        } else if (element.length() < length) {
            return false;
        } else if (substring != null && !element.contains(substring)) {
            return false;
        }
        return true;
    }
}
