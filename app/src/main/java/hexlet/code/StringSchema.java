package hexlet.code;

public class StringSchema extends BaseSchema<String> {
    private boolean isRequired;
    private int length = 0;
    private String substring = null;

    public StringSchema() {
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public StringSchema required() {
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
