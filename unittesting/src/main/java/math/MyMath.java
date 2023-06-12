package math;

/**
* The MyMath provides the factorial operation
* that serves as hands-on practice on Unit Testing.
* It also provides a function that checks whether a given 
* number is prime or not.
*
* @author  JohnKalan
* @version 2.0
* @since   2023-05-20
*/
public class MyMath {
    /**
	 * Performs the factorial operation.
	 * @param n the input number
	 * @return the result of the factorial operation
	 * @exception IllegalArgumentException when n < 0 or n > 12 
	 */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Input should be between 0 and 12");
        }

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    /**
	 * Checks whether a number is prime.
	 * @param n the input number
	 * @return boolean value true or false
	 * @exception IllegalArgumentException when n < 2
	 */
    public boolean isPrime(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Number must be greater than or equal to 2.");
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
