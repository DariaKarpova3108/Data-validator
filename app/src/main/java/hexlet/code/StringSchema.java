package hexlet.code;

public class StringSchema extends BaseSchema<String> {
    private int length = 0;
    private String substring = null;

    public StringSchema() {
    }

    @Override
    public BaseSchema<String> required() {
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
        if (isRequired() && (element == null || element.equals(""))) {
            return false;
        }

        if (this.length != 0 && element.length() < length) {
            return false;
        }

        if (substring != null && !element.contains(substring)) {
            return false;
        }
        return true;
    }
}
