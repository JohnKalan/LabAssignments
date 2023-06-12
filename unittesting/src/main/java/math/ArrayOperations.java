package math;

import io.FileIO;

/**
* This class privides a method responsible for reading a given file 
* and producing an array of the prime numbers found.
*
* @author  JohnKalan
* @version 1.0
* @since   2023-05-20
*/
public class ArrayOperations {
    /** 
     * Reads a file, creates a corresponding array with its numbers
     * and returns a new array that contains only its prime numbers.
     * @param fileIo a FileIO type object
	 * @param filepath the path of the file
     * @param myMath an instance of MyMath
     * @return an array of prime numbers
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        // Read the numbers of the file
        int[] numbers = fileIo.readFile(filepath); 
        
        // Count the amount of prime numbers
        int count = 0;
        for (int number : numbers) {
            if (myMath.isPrime(number)) { 
                count++;
            }
        }
        
        // Creates the final array of prime numbers
        int[] primes = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (myMath.isPrime(number)) {
                primes[index++] = number;
            }
        }
        
        //  Returns the prime numbers
        return primes;
    }
}
