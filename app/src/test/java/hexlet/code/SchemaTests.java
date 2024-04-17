package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class SchemaTests {
    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;
    private static MapSchema mapSchema;

    @BeforeAll
    public static void createSchema() {
        Validator val = new Validator();
        stringSchema = val.string();
        numberSchema = val.number();
        mapSchema = val.map();
    }

    @Test
    public void stringSchemaTests() {
        var actualInitially = stringSchema.isValid("");
        var expectedInitially = true;
        assertThat(actualInitially).isEqualTo(expectedInitially);

        var actualInitially2 = stringSchema.isValid("hexlet");
        var expectedInitially2 = true;
        assertThat(actualInitially2).isEqualTo(expectedInitially2);

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
        var actualInitially = numberSchema.isValid(null);
        var expectedInitially = true;
        assertThat(actualInitially).isEqualTo(expectedInitially);

        var actualInitially2 = numberSchema.isValid(3);
        var expectedInitially2 = true;
        assertThat(actualInitially2).isEqualTo(expectedInitially2);

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

    @Test
    public void MapSchemaTests() {
        var actualInitially = mapSchema.isValid(null);
        var expectedInitially = true;
        assertThat(actualInitially).isEqualTo(expectedInitially);

        var actualInitially2 = mapSchema.isValid(new HashMap<>());
        var expectedInitially2 = true;
        assertThat(actualInitially2).isEqualTo(expectedInitially2);

        var actual = mapSchema.required().isValid(null);
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        var data = new HashMap<String, String>();
        var actual2 = mapSchema.required().isValid(data);
        var expected2 = true;
        assertThat(actual2).isEqualTo(expected2);

        var data2 = new HashMap<>(Map.of("k1", "v1", "k2", "v2"));
        var actual3 = mapSchema.required().isValid(data2);
        var expected3 = true;
        assertThat(actual3).isEqualTo(expected3);

        var actual4 = mapSchema.sizeof(3).isValid(data2);
        var expected4 = false;
        assertThat(actual4).isEqualTo(expected4);

        var actual5 = mapSchema.sizeof(2).isValid(data2);
        var expected5 = true;
        assertThat(actual5).isEqualTo(expected5);

        var actual6 = mapSchema.sizeof(1).isValid(data2);
        var expected6 = false;
        assertThat(actual6).isEqualTo(expected6);
    }

}
