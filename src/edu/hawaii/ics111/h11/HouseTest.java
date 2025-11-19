package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for methods defined in abstract House class.
 *
 * @author CT Reatherford.
 */
public class HouseTest 
{
  /**
   * House test variable.
   */
  private House testHouse;

  /**
   * Initialize testHouse with a new StrawHosue object.
   */
  @Before 
  public void setUp() 
  {
    testHouse = new StrawHouse();
  }
   
  /**
   * Tests the constructor to ensure the house starts with structural integrity > 0.0.
   * Tests that the isIntact() method returns true at start.
   */ 
  @Test
  public void testConstructorAndIsIntact()
  {
    assertEquals("House should be intact after creation.", true, testHouse.isIntact());
  }

  /**
   * Tests that the inflictDamage() method successfully destroys the house 
   * when the stability is reduced to 0.0 or less.
   */
  @Test
  public void testDestruction() 
  {
    
    testHouse.inflictDamage(1.0);
    assertEquals("House should be destroyed after receiving 1.0 damage.", false, testHouse.isIntact());
  }
   
  /**
   * Tests that the inflictDamage() method throws an IllegalArgumentException
   * if receiving a negative damage value.
   */
  @Test
  public void testInflictDamageException()
  {
    final String expectedMessage = "Damage cannot be negative.";
    String actualResult = "";
    
    try
    {
      testHouse.inflictDamage(-0.5);
      actualResult = "Exception was not thrown.";
    }
    catch (IllegalArgumentException exception)
    {
      actualResult = exception.getMessage();
    }
    assertEquals("The test should fail if the exception message doesn't match or no exception is thrown.", 
      expectedMessage, actualResult);
  }

}
