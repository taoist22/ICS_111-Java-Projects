package edu.hawaii.ics111.h15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the Cat class.
 *
 * @author CT Reatherford.
 */
public class CatTest
{
  /**
   * Instance variable for testing first cat object.
   */
  private Cat cat1;
  /**
   * Instance variable for testing second cat object.
   */
  private Cat cat2;
  /**
   * Instance variable for testing third cat object.
   */
  private Cat cat3;
  /**
   * Instance variable for testing fourth cat object.
   */
  private Cat cat4;
  /**
   * Initialization for all tests.
   */
  @Before
  public void setUp()
  {
    cat1 = new Cat("Tik", "Bengal", 3);
    cat2 = new Cat("Tok", "American Shorthair", 2);
    cat3 = new Cat("Alpha", "Siamese", 5);
    cat4 = new Cat("Beta", "Persian", 4);
  }

  /**
   * Test the primary 3 parameter constructor.
   */
  @Test
  public void testConstructorOne()
  {
    assertEquals("Tik", cat1.getName());
    assertEquals("Bengal", cat1.getBreed());
    assertEquals(3, cat1.getAge());
  }
  /**
   * Test the second instance of the 3 parameter constructor.
   */
  @Test
  public void testConstructorTwo()
  {
    assertEquals("Tok", cat2.getName());
    assertEquals("American Shorthair", cat2.getBreed());
    assertEquals(2, cat2.getAge());
  }

  /**
   * Tests for constructor IllegalArgumentException thrown when age is less than 0.
   */
  @Test
  public void testConstructorThrowsInvalidAge()
  {
    try
    {
      Cat invalidCat = new Cat("Daisy", "Siamese", -1);

      fail("There should be an IllegalArgumentException thrown for negative age.");
    }
    catch (IllegalArgumentException e)
    {

    }
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
  /**
   * Test the compareTo method for correct sorting alphabetically by name.
   */
  @Test
  public void testcompareTo()
  {
    int result1 = cat3.compareTo(cat4);
    assertTrue("Alpha should be alphabetically before Beta", result1 < 0);

    int result2 = cat4.compareTo(cat3);
    assertTrue("Beta should be alphabetically after Alpha", result2 > 0);

    assertEquals("Exact name matches should return 0", 0, cat1.compareTo(cat1));
  }
}

