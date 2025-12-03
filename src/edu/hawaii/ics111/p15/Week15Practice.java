package edu.hawaii.ics111.p15;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A program in Java to compare the performance of insertion sort and binary search on a list of integers
 * against the Java List methods for sorthing and searching.
 *
 * @author CT Reatherford
 */
public class Week15Practice
{
  /**
   * The number of trials to run for each list size in calculating the average runtime.
   */
  private static final int NUM_TRIALS = 100;
  /**
   * The random number generator used to generate random lists of integers.
   */
  private static final Random RANDOM = new Random();
  /**
   * Method to sort a list of integers using insertion sort.
   *
   * @param list  The list of integers to sort.
   */
  public static void insertionSort(List<Integer> list)
  {
    for (int i = 1; i < list.size(); i++)
    {
      int temp = list.get(i);
      int j = i - 1;

      while (j >= 0 && list.get(j) > temp)
      {
        list.set(j + 1, list.get(j));
        j--;
      }
      list.set(j + 1, temp);
    }

  }
  /**
   * Method to perform a binary search on a sorted list of integers.
   *
   * @param list  The sorted list of integers to search.
   * @param target  The integer to search for.
   * @return  The index of the target integer in the list or returns  -1 if not found.
   */
  public static int binarySearch(List<Integer> list, int target)
  {
    int low = 0;
    int high = list.size() - 1;

    while (low <= high)
    {
      int middle = low + (high - low) / 2;
      int middleValue = list.get(middle);

      if (middleValue == target)
      {
        return middle;
      }
      else if (middleValue < target)
      {
        low = middle + 1;
      }
      else
      {
        high = middle - 1;
      }
    }
    return -1;
  }
  /**
   * Method to generate a random list of integers.
   *
   * @param size The number of elements to add to the list.
   * @return A List<Integer> of randomly generated numbers.
   */
  private static List<Integer> makeRandomList(int size)
  {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < size; i++)
    {
      int value = RANDOM.nextInt(100);
      list.add(value);
    }
    return list;
  }
  /**
   * Method to compare the performance of insertion sort and binary search on a list of integers
   * against built in List methods.
   * @param n  The number of elements in the list.
   */
  public static void comparePerformance(int n)
  {
    long ownSortTimeTotal = 0;
    long javaSortTimeTotal = 0;
    long ownSearchTimeTotal = 0;
    long javaSearchTimeTotal = 0;

    final int TARGET_VALUE = -1;

    for (int i = 0; i < NUM_TRIALS; i++)
    {
      List<Integer> originalList = makeRandomList(n);

      List<Integer> copiedList = new ArrayList<>(originalList);

      long startTime, endTime;

      startTime = System.nanoTime();
      insertionSort(originalList);
      endTime = System.nanoTime();
      ownSortTimeTotal += endTime - startTime;

      startTime = System.nanoTime();

      copiedList.sort(null);
      endTime = System.nanoTime();
      javaSortTimeTotal += (endTime - startTime);

      startTime = System.nanoTime();
      binarySearch(originalList, TARGET_VALUE);
      endTime = System.nanoTime();
      ownSearchTimeTotal += (endTime - startTime);

      startTime = System.nanoTime();
      copiedList.indexOf(TARGET_VALUE);
      endTime = System.nanoTime();
      javaSearchTimeTotal += (endTime - startTime);

      long ownSortTimeAvg = ownSortTimeTotal / NUM_TRIALS;
      long javaSortTimeAvg = javaSortTimeTotal / NUM_TRIALS;
      long ownSearchTimeAvg = ownSearchTimeTotal / NUM_TRIALS;
      long javaSearchTimeAvg = javaSearchTimeTotal / NUM_TRIALS;

      System.out.println("$n==" + n +"$:");
      System.out.println("Own Implementation:");
      System.out.println("Average Sort Time: " + ownSortTimeAvg + " nanoseconds");
      System.out.println("Average Search Time: " + ownSearchTimeAvg + " nanoseconds");
      System.out.println("Java Implementation:");
      System.out.println("Average Sort Time: " + javaSortTimeAvg + " nanoseconds");
      System.out.println("Average Search Time: " + javaSearchTimeAvg + " nanoseconds");

    }
  }
  /**
   * Main method to run the program and compare performance.
   *
   * @parm args  Not used.
   */
  public static void main(String[] args)
  {
    comparePerformance(10);
    comparePerformance(100);
    comparePerformance(1000);
    comparePerformance(10000);
    comparePerformance(100000);
  }
}
