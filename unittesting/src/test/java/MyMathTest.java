package math;

import org.junit.Test;
import org.junit.Assert;

/**
* This class contains JUnit tests for the MyMath class.

* @author  JohnKalan
* @version 1.0
* @since   2023-05-20
*/
public class MyMathTest
{
    // Create an instance of MyMath for testing
    MyMath mm = new MyMath();
    
    /**
    * Test the factorial() method of MyMath class with negative input.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        mm.factorial(-1);
    }
    
    /**
    * Test the factorial() method of MyMath class with input greater than 13.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialGreaterThan12() {
        mm.factorial(13);
    }

    /**
    * Test the isPrime() method of MyMath class with input zero.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeZero() {
        mm.isPrime(0);
    }  

    /**
    * Test the isPrime() method of MyMath class with negative input.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testPrimeNegative() {
        mm.isPrime(-1);
    }  

    /**
    * Test the isPrime() method of MyMath class with positive input less than 2.
    * The test passes if an IllegalArgumentException is thrown with the expected message.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testPrimePositiveLessThan2() {
        mm.isPrime(1);
    }  

    /**
    * Test the isPrime() method of MyMath class with input 17.
    * The test passes if the returned value matches the expected value true.
    */
    @Test
    public void testPrimeNumber() {
        boolean result = mm.isPrime(17);
        Assert.assertEquals(true, result);
    }

    /**
    * Test the isPrime() method of MyMath class with input 16.
    * The test passes if the returned value matches the expected value false.
    */
    @Test
    public void testCompositiveNumber() {
        boolean result = mm.isPrime(16);
        Assert.assertEquals(false, result);
    }
}
