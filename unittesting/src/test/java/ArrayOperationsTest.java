package math;

import io.FileIO;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

/**
* This class contains JUnit tests for the ArrayOperations class.

* @author  JohnKalan
* @version 1.0
* @since   2023-05-20
*/
public class ArrayOperationsTest {
    /**
    * The testFindPrimesInFile() tests the findPrimesInFile() of the ArrayOperations class. 
    * It uses Mockito to mock the FileIO and MyMath instances and sets up the desired behavior for the mocked methods. 
    * The test verifies that the findPrimesInFile() correctly filters out non-prime numbers and 
    * returns an array of prime numbers.
    */
    @Test
    public void testFindPrimesInFile() {
        // Create mock instances of FileIO and MyMath
        FileIO fileIO = Mockito.mock(FileIO.class);
        MyMath myMath = Mockito.mock(MyMath.class);

        // Mock the behavior of the fileIO.readFile()
        int[] numbers = {4, 7, 12, 13, 16};
        Mockito.when(fileIO.readFile(Mockito.anyString())).thenReturn(numbers);

        // Mock the behavior of the myMath.isPrime()
        Mockito.when(myMath.isPrime(4)).thenReturn(false);
        Mockito.when(myMath.isPrime(7)).thenReturn(true);
        Mockito.when(myMath.isPrime(12)).thenReturn(false);
        Mockito.when(myMath.isPrime(13)).thenReturn(true);
        Mockito.when(myMath.isPrime(16)).thenReturn(false);

        // Creates an array of the prime numbers 
        ArrayOperations arrayOperations = new ArrayOperations();
        int[] primes = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/testnumbers.txt", myMath);

        // Compares the expected prime numbers with the ones found above
        int[] expectedPrimes = {7, 13};
        Assert.assertArrayEquals(expectedPrimes, primes);
    }
}