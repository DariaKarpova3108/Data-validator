package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {
    private Integer positive = null;
    private Integer[] diapazon = new Integer[2];

    public NumberSchema() {
    }

    @Override
    public BaseSchema<Integer> required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        this.positive = 0;
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.diapazon[0] = begin;
        this.diapazon[1] = end;
        return this;
    }

    @Override
    public boolean isValid(Integer element) {
        if (isRequired() && element == null) {
            return false;
        }

        if (this.positive != null && element != null && element < this.positive) {
            return false;
        }

        if (element != null && this.diapazon[0] != null && this.diapazon[1] != null) {
            if (element < this.diapazon[0] || element > this.diapazon[1]) {
                return false;
            }
        }

        return true;
    }
}
