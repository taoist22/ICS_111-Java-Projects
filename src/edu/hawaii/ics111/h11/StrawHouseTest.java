package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for StrawHouse class, building material and structural integrity.
 *
 * @author CT Reatherford
 */
public class StrawHouseTest 
{
  /**
   * StrawHouse test variable.
   */
  private StrawHouse testStrawHouse;
  
  /**
   * Initialize testStrawHouse with a new StrawHouse object.
   */
  @Before 
  public void setUp() 
  {
    testStrawHouse = new StrawHouse();
  }
   
  /**
   * Tests the constructor is correctly initialized to be intact.
   */ 
  @Test
  public void testInitialState()
  {
    assertEquals("House should be intact on creation.", true, testStrawHouse.isIntact());
  }

  /**
   * Tests the getBuildingMaterial() method to ensure it returns the correct material.
   */
  @Test
  public void testBuildingMaterial()
  {
    assertEquals("Building material should be 'straw'.", "straw", testStrawHouse.getBuildingMaterial());
  }
}
