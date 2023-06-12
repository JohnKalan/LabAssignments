package math;

import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

/**
* This class contains JUnit Parameterized tests for the MyMath class.

* @author  JohnKalan
* @version 1.0
* @since   2023-05-13
*/
@RunWith(Parameterized.class)
public class MyMathParameterizedTest
{
    // Create an instance of MyMath for testing
    MyMath mm = new MyMath();

    // Parameters
    @Parameter
    public int n;
    @Parameter(1)
    public int result;
    
    /** 
     * Generates the test data for inputs of 0, 1, 2, 12 and the
     * corresponding return values.
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = { { 0, 1 }, { 1, 1 }, { 2, 2 }, { 12, 479001600 } };
        return Arrays.asList(data);
    }
    
    /**
    * Test the factorial() method of MyMath class with the data above.
    * The test passes if the returned value matches the expected value.
    */
    @Test
    public void testFactorial() {
        Assert.assertEquals(result, mm.factorial(n));
    }
}
