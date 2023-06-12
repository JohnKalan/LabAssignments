package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

/**
* This class contains JUnit tests for the FileIO class.

* @author  JohnKalan
* @version 1.0
* @since   2023-05-20
*/
public class FileIOTest {
    FileIO fileIO = new FileIO();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testReadFileNormalCase() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] actual = fileIO.readFile("src/test/resources/numbers.txt");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFileDoesNotExist() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Input file does not exist");
        fileIO.readFile("src/test/resources/nonexistingfile.txt");
    }

    @Test
    public void testEmptyFile() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Given file is empty");
        fileIO.readFile("src/test/resources/empty.txt");
    }
    
    @Test 
    public void testInvalidNumbers() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] actual = fileIO.readFile("src/test/resources/invalidnumbers.txt");
        Assert.assertArrayEquals(expected, actual);
    }


}