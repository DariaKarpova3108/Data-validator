package hexlet.code;

public abstract class Schema<T> {

    protected boolean isRequired = false;

    public abstract Schema<T> required();

    public abstract boolean isValid(T element);

    protected void setRequired(boolean required) {
        isRequired = required;
    }

    protected boolean isRequired() {
        return this.isRequired;
    }
}
