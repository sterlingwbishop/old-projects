import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test ClubStore methods
 * @author Michelle Glatz
 * @author Sterling Bishop
 */
public class ClubStoreTest {
    @Test
    public void testIsValidDateValidOctNonBoundary() {

        assertTrue(ClubStore.isValidDate(10, 23), "ClubStore.isValidDate(10, 23)");

    }
    
    @Test
    public void testIsValidDateInvalidOctBoundary() {

        assertFalse(ClubStore.isValidDate(10, 14), "ClubStore.isValidDate(10, 14)");

    }
    
    @Test
    public void testIsValidDateInvalidMonth() {

        assertFalse(ClubStore.isValidDate(9, 30), "ClubStore.isValidDate(9, 30)");

    } 
    
    @Test
    public void testIsValidDateNovDayNegative() {

        assertFalse(ClubStore.isValidDate(11, -1), "ClubStore.isValidDate(11, -1)");

    }

    @Test
    public void testIsValidDateMonthZero() {

        assertFalse(ClubStore.isValidDate(0, 1), "ClubStore.isValidDate(0, 1)");

    }  


    @Test
    public void testIsValidDateMonthNegative() {

        assertFalse(ClubStore.isValidDate(-10, 1), "ClubStore.isValidDate(-10, 1)");

    }        
    

    @Test
    public void testIsValidDateNov1() {
            
        // TODO: Replace the below code with an appropriate assert statement 

        assertTrue(ClubStore.isValidDate(11, 1), "ClubStore.isValidDate(11, 1)");

    }

    @Test
    public void testIsValidDateOct31() {
        
        // TODO: Replace the below code with an appropriate assert statement 

        assertTrue(ClubStore.isValidDate(10, 31), "ClubStore.isValidDate(10, 31)");

    } 

    @Test
    public void testIsValidDateNov30() {
            
        // TODO: Replace the below code with an appropriate assert statement 
       assertTrue(ClubStore.isValidDate(11, 30), "ClubStore.isValidDate(11, 30)");

    }

    @Test
    public void testIsValidDateNovNonBoundary() {
        
        // TODO: Replace the below code with an appropriate assert statement 
        assertTrue(ClubStore.isValidDate(11, 14), "ClubStore.isValidDate(11, 14)");

    }
     

    @Test
    public void testIsValidDateOctober15() {
        
        // TODO: Replace the below code with an appropriate assert statement 
        assertTrue(ClubStore.isValidDate(10, 15), "ClubStore.isValidDate(10, 15)");

    } 

    @Test
    public void testIsValidDateNovDayZero() {
        
        // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(ClubStore.isValidDate(11, 0), "ClubStore.isValidDate(11, 0)");

    }  


    @Test
    public void testIsValidDateNov31() {
        
        // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(ClubStore.isValidDate(11, 31), "ClubStore.isValidDate(11, 31)");

    }

    @Test
    public void testGetSubtotalOneBottle() {
        
        assertEquals(10, ClubStore.getSubtotal(1, 0, 0),
                     "ClubStore.getSubtotal(1, 0, 0)");
        
    }

    @Test
    public void testGetSubtotalNoItems() {
        
        assertEquals(0, ClubStore.getSubtotal(0, 0, 0), 
                     "ClubStore.getSubtotal(0, 0, 0)");
        
    }
   

    @Test
    public void testGetSubtotalOneMug() {

        assertEquals(12, ClubStore.getSubtotal(0, 1, 0), 
            "ClubStore.getSubtotal(0, 1, 0)");
    }
    
 
    @Test
    public void testGetSubtotalOneToteBag() {

        assertEquals(18, ClubStore.getSubtotal(0, 0, 1), 
        "ClubStore.getSubtotal(0, 0, 1)");
    }  


    @Test
    public void testGetSubtotalOneOfEachItem() {
        assertEquals(40, ClubStore.getSubtotal(1, 1, 1), 
        "ClubStore.getSubtotal(1, 1, 1)");
    }

    @Test
    public void testGetShippingCostSubtotal0() {
        
        assertEquals(0, ClubStore.getShippingCost(0, false, false), 
                     "ClubStore.getShippingCost(0, false, false)");
        
    }

    @Test
    public void testGetShippingCostSubtotal10CouponStandard() {
        
        assertEquals(0, ClubStore.getShippingCost(10, false, true), 
                     "ClubStore.getShippingCost(10, false, true)");       
        
    }
    
    @Test
    public void testGetShippingCostSubtotal25Standard() {
        assertEquals(0, ClubStore.getShippingCost(25, false, false), 
                     "ClubStore.getShippingCost(25, false, false)");
        
    }
    
 
    @Test
    public void testGetShippingCostSubtotal20NoCouponStandard() {
        assertEquals(3, ClubStore.getShippingCost(20, false, false), 
                     "ClubStore.getShippingCost(20, false, false)");
        
    } 

 
    @Test
    public void testGetShippingCostSubTotal15TwoDay() {
        assertEquals(5, ClubStore.getShippingCost(15, true, false), 
                     "ClubStore.getShippingCost(15, true, false)");
    }   
    
    @Test
    public void testGetShippingCostSubTotal45TwoDay() {
        assertEquals(5, ClubStore.getShippingCost(45, true, false), 
                     "ClubStore.getShippingCost(45, true, false)");
    }

    @Test
    public void testGetArrivalDateOct15ThreeDays() {
        
        assertEquals("Tue, 10/18/2022", ClubStore.getArrivalDate(10, 15, 3), 
                     "ClubStore.getArrivalDate(10, 15, 3)");       
   
    }

    @Test
    public void testGetArrivalDateOct30FourDays() {
        
        assertEquals("Thu, 11/3/2022", ClubStore.getArrivalDate(10, 30, 4), 
                     "ClubStore.getArrivalDate(10, 30, 4)");
                
    }
    
    

    @Test
    public void testGetArrivalDateNov30OneDay() {
        assertEquals("Thu, 12/1/2022", ClubStore.getArrivalDate(11, 30, 1), 
                     "ClubStore.getArrivalDate(11, 30, 1)");
            
    }

    @Test
    public void testGetArrivalDateNov25FiveDays() {
        assertEquals("Wed, 11/30/2022", ClubStore.getArrivalDate(11, 25, 5), 
                     "ClubStore.getArrivalDate(11, 25, 5)");
  
    }    
    

    @Test
    public void testGetArrivalDateOct29TwoDays() {
        assertEquals("Mon, 10/31/2022", ClubStore.getArrivalDate(10, 29, 2), 
                     "ClubStore.getArrivalDate(10, 29, 2)");
        
    }

    @Test
    public void testGetArrivalDateNov1FiveDays() {
        assertEquals("Sun, 11/6/2022", ClubStore.getArrivalDate(11, 1, 5), 
                     "ClubStore.getArrivalDate(11, 1, 5)");               
        
    }    
       


    /**
     * Test the ClubStore methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getSubtotal(-1, 0, 0),
                                 "ClubStore.getSubtotal(-1, 0, 0)");
        assertEquals("Invalid number", exception.getMessage(),
                     "Testing ClubStore.getSubtotal(-1, 0, 0) - " +
                     "exception message");
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getSubtotal(1, -1, 0),
                                 "ClubStore.getSubtotal(1, -1, 0)");
        assertEquals("Invalid number", exception.getMessage(),
                     "Testing ClubStore.getSubtotal(1, -1, 0) - " +
                     "exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getSubtotal(1, 1, -1),
                                 "ClubStore.getSubtotal(1, 1, -1)");
        assertEquals("Invalid number", exception.getMessage(),
                     "Testing ClubStore.getSubtotal(1, 1, -1) - " +
                     "exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getShippingCost(-1, false, false),
                                 "ClubStore.getShippingCost(-1, false, false)");
        assertEquals("Invalid subtotal", exception.getMessage(),
                     "Testing ClubStore.getShippingCost(-1, false, false) - " +
                     "exception message");                     
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getArrivalDate(10, 1, 1),
                                           "ClubStore.getArrivalDate(10, 1, 1)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing ClubStore.getArrivalDate(10, 1, 1) - exception message");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getArrivalDate(2, 1, 0),
                                           "ClubStore.getArrivalDate(2, 1, 0)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing ClubStore.getArrivalDate(2, 1, 0) - " + 
                     "exception message");                     
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getArrivalDate(10, 20, 0),
                                           "ClubStore.getArrivalDate(10, 20, 0)");
        assertEquals("Invalid days", exception.getMessage(),
                     "Testing ClubStore.getArrivalDate(10, 20, 0) - exception message"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> ClubStore.getArrivalDate(10, 20, 6),
                                           "ClubStore.getArrivalDate(10, 20, 6)");
        assertEquals("Invalid days", exception.getMessage(),
                     "Testing ClubStore.getArrivalDate(10, 20, 6) - " + 
                     "exception message");                       
    }
}