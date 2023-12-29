import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Program to test GuessingGame methods
 * @author Suzanne Balik
 * @author Michelle Glatz 
 * @author Sterling Bishop
 */
public class GuessingGameTest {

    // TODO: Javadoc all methods to pass checkstyle tool. Reminder that magic numbers are allowed
    // in test program

 
    @Test
    public void testGetSecretCodeSeed1Length4() {
        int[] expected = {5, 8, 7, 3};
        Random rand = new Random();
        rand.setSeed(1);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 4), 
                          "GuessingGame.getSecretCode(rand, 4)");
    }
    
    @Test
    public void testGetSecretCodeSeed1Length10() {
        int[] expected = {5, 8, 7, 3, 4, 4, 4, 6, 8, 8};
        Random rand = new Random();
        rand.setSeed(1);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 10), 
                          "GuessingGame.getSecretCode(rand, 10)");
    } 

    
    @Test
    public void testGetSecretCodeSeed2Length2() {
        int[] expected = {8, 2};
        Random rand = new Random();
        rand.setSeed(2);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 2), 
                          "GuessingGame.getSecretCode(rand, 2)");
    }      
    
    @Test
    public void testGetCorrectDigits1Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {7, 4, 9, 8};
        assertEquals(1, GuessingGame.getCorrectDigits(code, guess));
    }
       
    @Test
    public void testGetCorrectDigits2Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {7, 4, 2, 8};
        assertEquals(2, GuessingGame.getCorrectDigits(code, guess));
    } 

    @Test
    public void testGetCorrectDigits3Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {5, 4, 2, 8};
        assertEquals(3, GuessingGame.getCorrectDigits(code, guess));
    }    
  
    @Test
    public void testGetCorrectDigits1CorrectLength2() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {2, 3, 4, 5};
        assertEquals(4, GuessingGame.getCorrectDigits(code, guess));
    }
    
    @Test
    public void testGetCorrectDigits4CorrectLength8() {
        int[] code = {1, 2, 6, 9, 0, 5, 8, 4};
        int[] guess = {0, 5, 8, 7, 3, 5, 3, 4};
        assertEquals(5, GuessingGame.getCorrectDigits(code, guess));
    } 

    @Test
    public void testGetCorrectDigits3CorrectDuplicatesInGuessAndCode() {
        int[] code = {1, 1, 2, 3};
        int[] guess = {2, 1, 1, 1};
        assertEquals(6, GuessingGame.getCorrectDigits(code, guess));
    }      

    //TODO:  
    // Create 4 more test methods for getCorrectDigits to test the following:
    //    1.  All digits correct
    //    2.  No digits correct
    //    3.  Guess has duplicate digits that match a code digit, code does not have duplicates
    //    4.  Code has duplicate digits and guess has only one of the duplicate code digits
        
    
    @Test
    public void testGetCorrectDigitsInCorrectPlace2CorrectDigits1CorrectPlace() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {2, 4, 6, 8};
        assertEquals(1, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
    
    
    @Test
    public void testGetCorrectDigitsInCorrectPlace3CorrectDigits3CorrectPlace() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {2, 8, 4, 5};
        assertEquals(3, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
        
    
    @Test
    public void testGetCorrectDigitsInCorrectPlace1CorrectLength2() {
        int[] code = {0, 9};
        int[] guess = {1, 9};
        assertEquals(1, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }    

    @Test
    public void testGetCorrectDigitsInCorrectPlace4CorrectLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {2, 3, 4, 9, 5, 0};
        assertEquals(4, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
    
    
    //TODO:  
    // Create 4 more test methods for getCorrectDigitsInCorrectPlace to test the following:
    //    1.  All digits in correct place
    //    2.  All digits correct but no digits in correct place
    //    3.  Code digits all the same, 2 guess digits in correct place
    //    4.  Guess digits all the same, 3 in correct place
             


    /**
     * Test the GuessingGame methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!


        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(null, 4),
                                 "GuessingGame.getSecretCode(null, 4)");
        assertEquals("Null rand", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(null, 4) - " +
                     "exception message when rand is null");
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(null, 0),
                                 "GuessingGame.getSecretCode(null, 0)");
        assertEquals("Null rand", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(null, 0) - " +
                     "exception message when rand is null and length < 1");
                     
        Random rand = new Random();
        rand.setSeed(1);        
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(rand, 0),
                                 "GuessingGame.getSecretCode(rand, 0)");
        assertEquals("Invalid length", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(rand, 0) - " +
                     "exception message when length < 1");
                    
        int[] guess = new int[4];                    
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(null, guess),
                                 "GuessingGame.getCorrectDigits(null, guess)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(null, guess) - " +
                     "exception message with null code"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(null, guess),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(null, guess)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(null, guess) - " +
                     "exception message with null code");                      
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(null, null),
                                 "GuessingGame.getCorrectDigits(null, null)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(null, null) - " +
                     "exception message with null code and null guess"); 
 
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(null, null),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(null, null)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(null, null) - " +
                     "exception message with null code and null guess"); 
 
        int[] code = new int[5];      
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code, null),
                                 "GuessingGame.getCorrectDigits(code, null)");
        assertEquals("Null guess", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code, null) - " +
                     "exception message with null guess"); 
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code, null),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code, null)");
        assertEquals("Null guess", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code, null) - " +
                     "exception message with null guess");                      
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code, guess),
                                 "GuessingGame.getCorrectDigits(code, guess)");
        assertEquals("Different lengths", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code, guess) - " +
                     "exception message with different lengths"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code, guess),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code, guess)");
        assertEquals("Different lengths", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code, guess) - " +
                     "exception message with different lengths"); 

        int[] code1 = {1, 2, 10, 5};
        int[] guess1 = {1, 2, 9, 5}; 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code1, guess1),
                                 "GuessingGame.getCorrectDigits(code1, guess1)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code1, guess1) - " +
                     "exception message with 10 as a code digit"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1) - " +
                     "exception message with 10 as a code digit"); 
 
        int[] code3 = {1, 2, 8, 5};
        int[] guess3 = {1, -1, 9, 5}; 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code3, guess3),
                                 "GuessingGame.getCorrectDigits(code3, guess3)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code3, guess3) - " +
                     "exception message with -1 as a guess digit"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3) - " +
                     "exception message with -1 as a guess digit"); 
         
                                     
    }
}