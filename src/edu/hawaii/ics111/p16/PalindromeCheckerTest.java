package edu.hawaii.ics111.p16;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * JUnit tests for PalindromeChecker program.
 *
 * @author CT Reatherford.
 */
public class PalindromeCheckerTest
{
  /**
   * Test to check empty string as palindrome.
  */
  @Test
  public void testEmptyStringIsPalindrome()
  {
    assertTrue("Empty string should be palindrome", PalindromeChecker.isPalindrome(""));
  }


  /**
   * Test to check single character string as palindrome.
  */
  @Test
  public void testSingleCharacterIsPalindrome()
  {
    assertTrue("Single character string should be palindrome", PalindromeChecker.isPalindrome("a"));
  }


  /**
   * Test to check even character length  string and is not a palindrome.
  */
  @Test
  public void testEvenLengthIsNotPalindrome()
  {
    assertFalse("Even length string that is not a palindrome", PalindromeChecker.isPalindrome("code"));
  }

  /**
   * Test to check odd character length  string and is a palindrome.
  */
  @Test
  public void testOddLengthIsPalindrome()
  {
    assertTrue("Odd length string that is a palindrome", PalindromeChecker.isPalindrome("radar"));
  }

  /**
   * Test to check even character length  string and is a palindrome.
  */
  @Test
  public void testEvenLengthIsPalindrome()
  {
    assertTrue("Even length string that is a palindrome", PalindromeChecker.isPalindrome("noon"));
  }

  /**
   * Test to check odd character length  string and is not a palindrome.
  */
  @Test
  public void testOddLengthIsNotPalindrome()
  {
    assertFalse("Odd length string that is not a palindrome", PalindromeChecker.isPalindrome("hello"));
  }

}
