package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTests {
    private StringSchema stringSchema;
    private NumberSchema numberSchema;
    private MapSchema mapSchema;

    /**
     * Initialize stringSchema, numberSchema, and mapSchema using a Validator instance.
     * This method is executed before each test method.
     */

    @BeforeEach
    public void createSchema() {
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

        stringSchema.required();

        var actual = stringSchema.isValid("");
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        var actual2 = stringSchema.isValid("hexlet");
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

        var actualInitially4 = numberSchema.isValid(-3);
        var expectedInitially4 = true;
        assertThat(actualInitially4).isEqualTo(expectedInitially4);

        numberSchema.required();

        var actual = numberSchema.isValid(null);
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        var actual2 = numberSchema.isValid(5);
        var expected2 = true;
        assertThat(actual2).isEqualTo(expected2);

        var actual3 = numberSchema.isValid(-10);
        var expected3 = true;
        assertThat(actual3).isEqualTo(expected3);

        var actual4 = numberSchema.isValid(10);
        var expected4 = true;
        assertThat(actual4).isEqualTo(expected4);

        numberSchema.positive();

        var actualInitiallyPositive = numberSchema.isValid(null);
        var expectedInitiallyPositive = false;
        assertThat(actualInitiallyPositive).isEqualTo(expectedInitiallyPositive);

        var actualPositive2 = numberSchema.isValid(0);
        var expectedPositive2 = false;
        assertThat(actualPositive2).isEqualTo(expectedPositive2);

        var actualPositive3 = numberSchema.isValid(-1);
        var expectedPositive3 = false;
        assertThat(actualPositive3).isEqualTo(expectedPositive3);

        numberSchema.range(5, 10);

        var actual5 = numberSchema.isValid(-10);
        var expected5 = false;
        assertThat(actual5).isEqualTo(expected5);

        var actual6 = numberSchema.isValid(10);
        var expected6 = true;
        assertThat(actual6).isEqualTo(expected6);

        var actual7 = numberSchema.isValid(5);
        var expected7 = true;
        assertThat(actual7).isEqualTo(expected7);

        numberSchema.range(8, null);

        var actual8 = numberSchema.isValid(null);
        var expected8 = false;
        assertThat(actual8).isEqualTo(expected8);
    }

    @Test
    public void mapSchemaTests() {
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

    @Test
    public void mapSchemaShapeTests() {
        Validator val = new Validator();
        Map<String, BaseSchema<String>> dataCheck = new HashMap<>();
        dataCheck.put("firstKey", val.string().required());
        dataCheck.put("secondKey", val.string().required().minLength(4));

        mapSchema.shape(dataCheck);

        Map<String, String> map = new HashMap<>();
        map.put("firstKey", "");
        map.put("secondKey", "");
        var actual = mapSchema.isValid(map);
        var expected = false;
        assertThat(actual).isEqualTo(expected);

        Map<String, String> map2 = new HashMap<>();
        map2.put("firstKey", null);
        map2.put("secondKey", "");
        var actual2 = mapSchema.isValid(map2);
        var expected2 = false;
        assertThat(actual2).isEqualTo(expected2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("firstKey", "key");
        map3.put("secondKey", "val");
        var actual3 = mapSchema.isValid(map3);
        var expected3 = false;
        assertThat(actual3).isEqualTo(expected3);

        Map<String, String> map4 = new HashMap<>();
        map4.put("firstKey", "key");
        map4.put("secondKey", "balu");
        var actual4 = mapSchema.isValid(map4);
        var expected4 = true;
        assertThat(actual4).isEqualTo(expected4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("firstKey", "key");
        map5.put("secondKey", "value");
        var actual5 = mapSchema.isValid(map5);
        var expected5 = true;
        assertThat(actual5).isEqualTo(expected5);
    }
}
