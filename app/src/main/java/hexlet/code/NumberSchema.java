package hexlet.code;

import hexlet.code.schemas.BaseSchema;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isRequired;
    private Integer positive = null;
    private Integer[] diapazon = new Integer[2];

    public NumberSchema() {
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        this.positive = 1;
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.diapazon[0] = begin;
        this.diapazon[1] = end;
        return this;
    }

    @Override
    public boolean isValid(Integer element) {
        if (element == null) {
            return !isRequired();
        }

        if (isRequired() && element <= 0) {
            return false;
        }

        if (this.positive != null && element <= 0) {
            return false;
        }

        if (this.diapazon[0] != null && this.diapazon[1] != null) {
            return element >= this.diapazon[0] && element <= this.diapazon[1];
        }

        return true;
    }
}
