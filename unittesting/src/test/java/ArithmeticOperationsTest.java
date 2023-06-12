package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
* This class contains JUnit tests for the ArithmeticOperations class.

* @author  JohnKalan
* @version 1.0
* @since   2023-05-13
*/
public class ArithmeticOperationsTest
{
    // Create an instance of ArithmeticOperations for testing
    ArithmeticOperations ao = new ArithmeticOperations();

    /**
    * Test the divide() method of ArithmeticOperations class with valid input.
    * The test passes if the returned value matches the expected value.
    */
    @Test
    public void testDivide() {
        double result = ao.divide(10.0, 2.0);
        Assert.assertEquals(5.0, result, 0.0);
    }
    
    /**
    * Test the divide() method of ArithmeticOperations class with division by zero.
    * The test passes if an ArithmeticException is thrown.
    */
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        ao.divide(10.0, 0.0);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with valid input.
    * The test passes if the returned value matches the expected value.
    */
    @Test
    public void testMultiply() {
        int result = ao.multiply(10, 10);
        Assert.assertEquals(100, result);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with y input value of zero.
    * The test passes if the returned value matches the expected value.
    */
    @Test
    public void testYInputZero() {
        int result = ao.multiply(10, 0);
        Assert.assertEquals(0, result);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with x input value of zero.
    * The test passes if the returned value matches the expected value.
    */
    @Test
    public void testXInputZero() {
        int result = ao.multiply(0, 10);
        Assert.assertEquals(0, result);
    }

    // Create an instance of ExpectedException for expected exceptions
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
    * Test the multiply() method of ArithmeticOperations class with x negative value input.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test
    public void testXNegativeInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        ao.multiply(-10, 10);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with y negative value input.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test
    public void testYNegativeInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        ao.multiply(10, -10);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with negative inputs.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test
    public void testNegativeInputs() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        ao.multiply(-20, -10);
    }

    /**
    * Test the multiply() method of ArithmeticOperations class with large input.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test
    public void testLargeProduct() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        ao.multiply(Integer.MAX_VALUE, 2);
    }
}
