package hexlet.code;

public class StringSchema {
    private boolean isRequired = false;
    private int length = 0;
    private String substring = null;

    public StringSchema() {
    }


    public StringSchema required() {
        this.isRequired = true;
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

    public boolean isValid(String text) {
        if (text == null || text.equals("")) {
            return false;
        } else if (text.length() < length) {
            return false;
        } else if (substring != null && !text.contains(substring)) {
            return false;
        }
        return true;
    }
}
