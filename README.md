### Hexlet tests and linter status:
## **Data validator is a library that can be used to check the correctness of any data.**
_The presented code describes the operation of a data validator, whose task is to check the correctness of the user's entered data._
_The result of the check is displayed in Boolean format, where "true" indicates that the entered data is correct, "false" indicates the opposite._
_**First of all, we are talking about data from forms filled out by users.**_


_To work with the application, the user must enter the following data into the console using the Jshell utility:_

⋅⋅ 1) First of all, a data validator is created

⋅⋅ 2) Next, depending on the type of data that needs to be checked, you need to create an appropriate data validator: using the "string" method - a validator is created to check string values, using the "number" method - a validator is created to check the correctness of integer values, using the "map" method " a validator is created to check the correctness of objects of the Map type

⋅⋅ 3) After creating a specific type of validator, you need to fill it with the appropriate rules that determine the correctness of the entered data

⋅⋅ 4) And finally we call the isValid() method, in the parameters of which we enter data to check it with our previously created validator

[![Actions Status](https://github.com/DariaKarpova3108/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DariaKarpova3108/java-project-78/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/eb9a8fcddbe7ccfbbe68/maintainability)](https://codeclimate.com/github/DariaKarpova3108/java-project-78/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/eb9a8fcddbe7ccfbbe68/test_coverage)](https://codeclimate.com/github/DariaKarpova3108/java-project-78/test_coverage)

## **Below are the askinems demonstrating the operation of the application:**
_**String data validator**_
_The string data validator contains 3 methods for checking the validity of user-entered values:_

⋅⋅ required() - makes the data required to be filled in. In other words, it adds a constraint to the schema that does not allow null or an empty string to be used as a value.

⋅⋅ minLength() - adds a minimum length constraint for a string to the schema. The string must be equal to or longer than the specified number

⋅⋅ contains() - adds a string content constraint to the schema. The string must contain a specific substring

_All these methods are demonstrated in the presented asciinema_
_Once the validation scheme has been configured, you can begin validating the data. To do this, you need to call the isValid() method on the configured schema and pass it the data that needs to be validated. The result of the work will be the logical value true if the data matches all the rules specified in the scheme, or false if it does not match_

[![asciicast](https://asciinema.org/a/xHKlErInlqnCYrbvwjqLL0uPl.svg)](https://asciinema.org/a/xHKlErInlqnCYrbvwjqLL0uPl)

_**Number validator work**_
_Calling the number() method defines the NumberSchema. This schema is used to validate numbers._
The schema contains the following set of methods:
⋅⋅ required() - adds a constraint to the schema that prevents null from being used as a value

⋅⋅ positive() - adds a constraint on the sign of a number. The number must be positive

⋅⋅ range() - adds a valid range that the number value must fall within, including boundaries

_The work of all the above methods is demonstrated in the presented asciinema_

[![asciicast](https://asciinema.org/a/ot6QMuksVCQ41zhQWHsZRLH1e.svg)](https://asciinema.org/a/ot6QMuksVCQ41zhQWHsZRLH1e)

_**Validation of Map objects**_
_Calling the map() method defines a MapSchema. This schema is used to validate Map objects._
The schema contains the following methods:
⋅⋅ required() - Adds a constraint to the schema that prevents null from being used as a value. Map data type required

⋅⋅ sizeof() - adds a limit on the size of the map. The number of key-value pairs in the Map object must be equal to the specified number

⋅⋅ The shape() method is used to define the properties of a Map object and create a schema to validate their values. Each property of a Map object has its own set of constraints
(its own schema), which allows more precise control over the data:
_The work of all the above methods is demonstrated in the presented asciinema_

[![asciicast](https://asciinema.org/a/HKuTiqRma4WQyB7XjHemhUwKE.svg)](https://asciinema.org/a/HKuTiqRma4WQyB7XjHemhUwKE)
