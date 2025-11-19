package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Wolf class, constructor, air management, 
 * and huffPuff functionality and exceptions.
 *
 * @author CT Reatherford
 */
public class WolfTest 
{
  /**
   * Wolf test variable.
   */
  private Wolf testWolf;
  
  /**
   * House variable target for the Wolf huffPuff method.
   */
  private House testHouse;


  /**
   * Initialize testWolf with a new Wolf object and testHouse with a new StrawHouse.
   */
  @Before 
  public void setUp() 
  {
    testWolf = new Wolf();
    testHouse = new StrawHouse();
  }
   
  /**
   * Tests the Wolf constructor to ensure the air supply starts at 1.0.
   */ 
  @Test
  public void testInitialAirSupply()
  {
    assertEquals("Wolf's air supply should be 1.0 at creation.", 1.0, testWolf.getAmountAir(), 0.0001);
  }

  /**
   * Tests the rest() method to ensure the air supply is fully restored to 1.0.
   */
  @Test
  public void testRest()
  {
    
    testWolf.huffPuff(testHouse); 
    
    testWolf.rest();
    assertEquals("Wolf air supply should be 1.0 after resting.", 1.0, testWolf.getAmountAir(), 0.0001);
  }
   
  /**
   * Tests the huffPuff() method to ensure air is decremented appropriately.
   */
  @Test
  public void testAirConsumption()
  {
    
    testWolf.huffPuff(testHouse); 
    
    assertEquals("Air supply should be 0.75 after one huffPuff.", 0.75, testWolf.getAmountAir(), 0.0001);
  }
   
  /**
   * Tests the huffPuff() method throws an IllegalStateException 
   * when huff and puff does not have enough air.
   */
  @Test
  public void testHuffPuffException()
  {
   
    testWolf.huffPuff(testHouse);
    testWolf.huffPuff(testHouse);
    testWolf.huffPuff(testHouse);
    
    final String expectedMessage = "The Wolf is hyperventilating.";
    String actualResult = "";
    
    try
    {
      
      testWolf.huffPuff(testHouse);
      actualResult = "Exception was not thrown.";
    }
    catch (IllegalStateException exception)
    {
      actualResult = exception.getMessage();
    }
    
    
    assertEquals("The test fails if the exception message doesn't match or no exception is thrown.", 
      expectedMessage, actualResult);
  }
}