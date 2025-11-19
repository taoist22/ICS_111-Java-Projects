package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for WoodHouse class, building material and moderate structural integrity.
 *
 * @author CT Reatherford
 */
public class WoodHouseTest 
{
  /**
   * WoodHouse test variable.
   */
  private WoodHouse testWoodHouse;
  
  /**
   * Initialize testWoodHouse with a new WoodHouse object.
   */
  @Before 
  public void setUp() 
  {
    testWoodHouse = new WoodHouse();
  }
   
  /**
   * Tests the constructor correctly initialized.
   */ 
  @Test
  public void testInitialState()
  {
    assertEquals("House should be intact at creation.", true, testWoodHouse.isIntact());
  }

  /**
   * Tests the getBuildingMaterial() method to ensure it returns the correct material.
   */
  @Test
  public void testBuildingMaterial()
  {
    assertEquals("Building material should be 'wood'.", "wood", testWoodHouse.getBuildingMaterial());
  }
  
  /**
   * Tests that the WoodHouse takes > 1 attack and < 3 attacks.
   */
  @Test
  public void testDurability() 
  {
    
    testWoodHouse.inflictDamage(1.0);
    assertEquals("House should be intact after first 1.0 damage attack.", true, testWoodHouse.isIntact());
    
    testWoodHouse.inflictDamage(1.0);
    assertEquals("House should be destroyed after second 1.0 damage attack.", false, testWoodHouse.isIntact());
  }
}