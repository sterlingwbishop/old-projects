import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Symbol class
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Sterling Bishop
 */
public class SymbolTest { 

    /** Symbol giraffe for testing */
    private Symbol giraffe;

    private Symbol dog;

    /**
     * Create Symbols for testing
     */
    @BeforeEach
    public void setUp() {
        giraffe = new Symbol("giraffe", 25);
        dog = new Symbol("dog", 500);
    }


    @Test
    public void testGetNameGiraffe() {
        assertEquals("giraffe", giraffe.getName(), "giraffe name");
    }
    @Test
    public void testGetNameDog() {
        assertEquals("dog", dog.getName(), "dog name");
    }   
    @Test
    public void testGetPointsGiraffe() {
        assertEquals(25, giraffe.getPoints(), "giraffe points");
    }
    @Test
    public void testGetPointsDog() {
        assertEquals(500, dog.getPoints(), "dog points");
    }  

    @Test
    public void testToStringGiraffe() {
        assertEquals("giraffe 25 false", giraffe.toString(), "giraffe toString");        
    }

    @Test
    public void testToStringDog() {
        assertEquals("dog 500 false", dog.toString(), "dog toString");        
    }

    @Test
    public void testHasBeenClickedOnGiraffe() {
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe hasBeenClickedOn");
    }

    @Test
    public void testHasBeenClickedOnDDog() {
        assertFalse(dog.hasBeenClickedOn(), "dog hasBeenClickedOn");
    }

    @Test
    public void testSetHasBeenClickedOnGiraffe() {
        giraffe.setHasBeenClickedOn(true);
        assertTrue(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn true");
        giraffe.setHasBeenClickedOn(false);
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn false");
    }
    
    @Test
    public void testSetHasBeenClickedOnDog() {
        dog.setHasBeenClickedOn(true);
        assertTrue(dog.hasBeenClickedOn(), "dog setHasBeenClickedOn true");
        dog.setHasBeenClickedOn(false);
        assertFalse(dog.hasBeenClickedOn(), "dog setHasBeenClickedOn false");
    }

    @Test
    public void testEqualsGiraffe() {
        assertTrue(giraffe.equals(giraffe), "giraffe equals with same instance");
        assertTrue(giraffe.equals(new Symbol("giraffe", 25)), 
                   "giraffe equals with different instances");
        assertFalse(giraffe.equals(new Symbol("cow", 25)), "giraffe with different name");
        assertFalse(giraffe.equals(new Symbol("giraffe", 4)), "giraffe with different points");
        assertFalse(giraffe.equals(new Symbol("horse", 5)), 
                    "giraffe with different name and points");
        assertFalse(giraffe.equals(null), "giraffe compared to null object");
        assertFalse(giraffe.equals("giraffe"), "giraffe compared to String");
    }
   
    @Test
    public void testEqualsDog() {
        assertTrue(dog.equals(dog), "dog equals with same instance");
        assertTrue(dog.equals(new Symbol("dog", 500)), 
                   "dog equals with different instances");
        assertFalse(dog.equals(new Symbol("cow", 25)), "dog with different name");
        assertFalse(dog.equals(new Symbol("dog", 4)), "dog with different points");
        assertFalse(dog.equals(new Symbol("horse", 5)), 
                    "giraffe with different name and points");
        assertFalse(dog.equals(null), "dog compared to null object");
        assertFalse(giraffe.equals(dog), "giraffe compared to String");
    }
    

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        
        // Testing constructor with null name
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol(null, 1), "Constructor name null");
        assertEquals("Null name", exception.getMessage(),
                "Testing null name message");
                
        // Testing constructor with 0 points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("snake", 0), "Constructor points 0");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing points 0 message");
                
        // Testing constructor with negative points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("frog", -5), "Constructor points -5");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing negative points message");
                
    }

}