package edu.hawaii.ics111.h11;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the NLittleHouses class and the creation of random houses.
 *
 * @author CT Reatherford.
 */
public class NLittleHousesTest 
{
  /**
   * Initializes the test environment.
   */
  @Before 
  public void setUp() 
  {
  }
   
  /**
   * Tests the createRandomHouse() method to ensure it always returns an object 
   * of the correct type (House) after multiple calls.
   */ 
  @Test
  public void testCreateRandomHouseType()
  {
   
    int testIterations = 100;
    
    for (int i = 0; i < testIterations; i++) {
       
        House house = NLittleHouses.createRandomHouse();
        
        String material = house.getBuildingMaterial();
        
        boolean isValid = material.equals("straw") || material.equals("wood") || material.equals("brick");
        
        assertEquals("Random house created must be a valid type (straw, wood, or brick).", true, isValid);
    }
  }

  /**
   * Tests that the createRandomHouse() method returns an intact object.
   */
  @Test
  public void testRandomHouseIsIntact()
  {
    
    int testIterations = 100;
    
    for (int i = 0; i < testIterations; i++) {
        House house = NLittleHouses.createRandomHouse();
        
        assertEquals("Every newly created random house must be intact.", true, house.isIntact());
    }
  }
}
