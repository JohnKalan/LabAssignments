# 3rd Lab Assignment #

This 3rd Lab Assignment focuses on the creation of a module Maven simple project called unittesting. 

* Firstly, the **ArithmeticOperations** class contains a `divide()` method and a `multiply()` method, executing the arithmetic operations of division and multiplication. **ArithmeticOperationsTest** is the corresponding class containing JUnit tests to test whether the above methods produce the expected results or exceptions.
* Seconly, the **MyMath** class contains a `factorial()` method executing the arithmetic operation of factorial. **MyMathTest** is a class containing JUnit tests responsible to test whether the correct Illegal Argument Exception is thrown when a negative input or a number greater than 13 is given as a parameter to the `factorial()` method. The **MyMathParameterizedTest** class is responsible to test whether the `factorial()` method is producing the correct results if specific numbers are given as an input, for example the numbers 0, 1, 2 and 12.  
* Finaly, the **MyMathTestSuite** class contains the tests of the *MyMathTest* and *MyMathParameterizedTest* classes. 

#### Build tools 
This module is part of the project using ***jdk 8*** and ***maven*** in order to be built.

#### Testing tools 
The ***JUnit*** framework is used for the corresponding unit tests.

#### Running the project 
In order to build the project you need to build it first by using this command: 
```
mvn clean package jacoco:report
```
In order to run all the tests of the project use this command:
```
mvn test
```
In order to run individual tests use this command where *nameofclass* is the name of the class you want to run:
```
mvn -Dtest=nameofclass test
```
