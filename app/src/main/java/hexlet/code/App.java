package hexlet.code;

public class App {
    public static void main(String[] args) {
        Validator val = new Validator();
        StringSchema schem = val.string();
        System.out.println(schem.isValid("hexlet"));
        System.out.println(schem.isValid(""));
        System.out.println(schem.isValid(null));

        schem.required();
        System.out.println("================");
        System.out.println(schem.isValid("hexlet"));
        System.out.println(schem.isValid(""));
        System.out.println(schem.isValid(null));

        System.out.println("================");

        boolean result = schem.minLength(3).contains("ma").isValid("mama");
        System.out.println("1) " + result);

    }
}
