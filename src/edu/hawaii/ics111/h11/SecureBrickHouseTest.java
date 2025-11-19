package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the SecureBrickHouse class, building material and indestructibility.
 *
 * @author CT Reatherford
 */
public class SecureBrickHouseTest 
{
  /**
   * SecureBrickHouse test variable.
   */
  private SecureBrickHouse testBrickHouse;
  
  /**
   * Initialize testBrickHouse with a new SecureBrickHouse object.
   */
  @Before 
  public void setUp() 
  {
    testBrickHouse = new SecureBrickHouse();
  }
   
  /**
   * Tests the constructor correctly initialized.
   */ 
  @Test
  public void testInitialState()
  {
    assertEquals("House should be intact at creation.", true, testBrickHouse.isIntact());
  }

  /**
   * Tests the getBuildingMaterial() method to ensure it returns the correct material.
   */
  @Test
  public void testBuildingMaterial()
  {
    assertEquals("Building material should be 'brick'.", "brick", testBrickHouse.getBuildingMaterial());
  }
  
  /**
   * Tests the Override inflictDamage() method to ensure the house remains intact 
   * after multiple attacks to verify indestructibility.
   */
  @Test
  public void testIndestructibility() 
  {
    
    testBrickHouse.inflictDamage(10.0);
    testBrickHouse.inflictDamage(10.0);
    testBrickHouse.inflictDamage(10.0);
    
    assertEquals("House should remain intact after multiple attacks.", true, testBrickHouse.isIntact());
  }
}