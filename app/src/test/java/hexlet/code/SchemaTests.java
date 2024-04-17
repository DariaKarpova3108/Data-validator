package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SchemaTests {
    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;

    @BeforeAll
    public static void createSchema() {
        Validator val = new Validator();
        stringSchema = val.string();
        numberSchema = val.number();
    }

    @Test
    public void stringSchemaTests() {
        var actual = stringSchema.required().isValid("");
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        var actual2 = stringSchema.required().isValid("hexlet");
        var expected2 = true;
        assertThat(actual2).isEqualTo(expected2);

        var actual3 = stringSchema.minLength(3).isValid("IT");
        var expected3 = false;
        assertThat(actual3).isEqualTo(expected3);


        var actual4 = stringSchema.minLength(3).isValid("hexlet");
        var expected4 = true;
        assertThat(actual4).isEqualTo(expected4);

        var actual5 = stringSchema.contains("ab").isValid("hexlet");
        var expected5 = false;
        assertThat(actual5).isEqualTo(expected5);

        var actual6 = stringSchema.contains("let").isValid("hexlet");
        var expected6 = true;
        assertThat(actual6).isEqualTo(expected6);
    }

    @Test
    public void numberSchemaTests() {
        var actual = numberSchema.required().isValid(null);
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        var actual2 = numberSchema.required().isValid(5);
        var expected2 = true;
        assertThat(actual2).isEqualTo(expected2);

        var actual3 = numberSchema.positive().isValid(-10);
        var expected3 = false;
        assertThat(actual3).isEqualTo(expected3);

        var actual4 = numberSchema.positive().isValid(10);
        var expected4 = true;
        assertThat(actual4).isEqualTo(expected4);

        var actual5 = numberSchema.range(5, 10).isValid(-10);
        var expected5 = false;
        assertThat(actual5).isEqualTo(expected5);

        var actual6 = numberSchema.range(5, 10).isValid(10);
        var expected6 = true;
        assertThat(actual6).isEqualTo(expected6);
    }

}
