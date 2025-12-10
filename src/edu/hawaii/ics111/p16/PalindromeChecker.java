package edu.hawaii.ics111.p16;

/**
 * A Palindrome Checker program in Java.
 *
 * @author CT Reatherford.
 */
public class PalindromeChecker
{
  /**
   * Method to check whether a string is a palindrome or not.
   *
   * @return true  If the string is not a palindrome, otherwise false.
   */
  public static boolean isPalindrome(String str)
  {
    if (str.length() <= 1)
    {
      return true;
    }
    if (str.charAt(0) == str.charAt(str.length() - 1))
    {
      return isPalindrome(str.substring(1, str.length() - 1));
    }


  }
}
