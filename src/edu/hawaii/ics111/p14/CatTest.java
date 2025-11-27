package edu.hawaii.ics111.p14;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Cat class.
 *
 * @author CT Reatherford.
 */
public class CatTest 
{
  /**
   * Testing first cat object.
   */
  private Cat cat1;
  /**
   * Testing second cat object.
   */
  private Cat cat2;

  /** 
   * Fixture initialization (common initialization for all tests). 
   */
  @Before 
  public void setUp() 
  {
    cat1 = new Cat("Tik", "Bengal", 3, false);
    cat2 = new Cat("Tok", "American Shorthair", 2);
  }

 /**
  * Test constructor with all parameters.
  */
  @Test
  public void testConstructorAll()
  {
    assertEquals("Tik", cat1.getName());
    assertEquals("Bengal", cat1.getBreed());
    assertEquals(3, cat1.getAge());
    assertEquals(false, cat1.isHungry());
  }
   
  /**
  * Test constructor with 3 parameters and hungry assumed.
  */
  @Test
  public void testConstructorThree()
  {
    assertEquals("Tok", cat2.getName());
    assertEquals("American Shorthair", cat2.getBreed());
    assertEquals(2, cat2.getAge());
    assertEquals(true, cat2.isHungry());
  }
  
  /**
   * Tests for constructor IllegalArgumentException thrown when age is less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidAge()
  {
    Cat invalidCat = new Cat("Daisy", "Siamese", -1, true);
  }
     
 /**
  * Tests the getter for name.
  */
  @Test
  public void testGetName()
  {
    assertEquals("cat1 should have the name Tik", "Tik", cat1.getName());
    assertEquals("cat2 should have the name Tok", "Tok", cat2.getName());
  }
   
 /**
  * Tests the getter for breed.
  */
  @Test
  public void testGetBreed()
  {
    assertEquals("cat1 should have the breed Bengal", "Bengal", cat1.getBreed());
    assertEquals("cat2 should have the breed American Shorthair", "American Shorthair", cat2.getBreed());
  }

 /**
  * Tests the getter for age.
  */
  @Test
  public void testGetAge()
  {
    assertEquals("cat1 should have the age 3", 3, cat1.getAge());
    assertEquals("cat2 should have the age 2", 2, cat2.getAge());
  }

 /**
  * Tests cat is hungry as true and false.
  */
  @Test
  public void testHungry()
  {
    // cat1 hungry = false.
    assertEquals("cat1 should begin as not hungry", false,  cat1.isHungry());

    // Test setting cat1 hungry = true
    cat1.setHungry(true);
    assertEquals("cat1 should now be hungry", true, cat1.isHungry());

    // Test resetting cat1 hungry = false
    cat1.setHungry(false);
    assertEquals("cat1 should not be hungry again", false, cat1.isHungry());
  }
       
 /**
  * Test incrementing age by one.
  */
  @Test
  public void testIncreaseAge()
  {
    int initialAge = cat1.getAge();
    cat1.increaseAge();
    assertEquals("cat1 age should increase by 1", initialAge + 1, cat1.getAge());
  }

 /**
  * Tests setter for cat1 name.
  */
  @Test
  public void testSetNameCat1()
  {
    String newName = "Tiger";
    cat1.setName(newName);
    assertEquals("cat1 should have the name Tiger", newName, cat1.getName());
  }
  /**
  * Tests setter for cat2 name.
  */
  @Test
  public void testSetNameCat2()
  {
    String newName = "Blackie";
    cat2.setName(newName);
    assertEquals("cat2 should have the name Blackie", newName, cat2.getName());
  }

}

