package edu.hawaii.ics111.p14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of a room to store Cat objects that will be in current room.
 * User can add, list and remove cats througout the program.
 *
 * @author CT Reatherford.
 */
public class CatRoom {
  /**
   * Main method to create program window and display the CatRoom.
   *
   * @param args Not used
   */
  public static void main(String[] args) {

    boolean isRunning = true;

    System.out.println("This program will represent the cats currently in a room.");

    ArrayList<Cat> room = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (isRunning) {
      System.out.println("Which operation would you like to perform (type in \"1\", \"2\", \"3\", or \"4\")?");
      System.out.println("1: Add a cat");
      System.out.println("2: List all cats");
      System.out.println("3: Remove a cat");
      System.out.println("4: Exit");

    }
  }
}
