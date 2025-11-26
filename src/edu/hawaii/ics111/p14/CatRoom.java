package edu.hawaii.ics111.p14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of a room to store Cat objects that will be in current room.
 * User can add, list and remove cats throughout the program.
 *
 * @author CT Reatherford.
 */
public class CatRoom {
  /**
   * Main method to create program window and display the CatRoom.
   *
   * @param args Not used
   */

  private static ArrayList<Cat> room = new ArrayList<>();

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    boolean isRunning = true;

    int choice;

    System.out.println("This program will represent the cats currently in a room.");

    while (isRunning) {
      System.out.println("Which operation would you like to perform (type in \"1\", \"2\", \"3\", or \"4\")?");
      System.out.println("1: Add a cat");
      System.out.println("2: List all cats");
      System.out.println("3: Remove a cat");
      System.out.println("4: Exit");

      if (scanner.hasNextInt()) {
        choice = scanner.nextInt();
        scanner.nextLine();

      } else {
        System.out.println("Invalid input. Please try again.");
        scanner.nextLine();
        continue;
      }
      switch (choice) {
        case 1:
          addCat();
          break;
        case 2:
          listCats();
          break;
        case 3:
          removeCat();
          break;
        case 4:
          isRunning = false;
          break;
        default:
          System.out.println("Invalid input. Please try again.");
      }
      scanner.close();
      System.out.println("Program exiting...");
    }
  }

  private static void addCat() {
    System.out.println("Enter the name of the cat to add:");
    String name = scanner.nextLine();
    System.out.println("Enter the breed of the cat to add:");
    String breed = scanner.nextLine();
    System.out.println("Enter the age of the cat to add:");

    if (!scanner.hasNextInt()) {
      System.out.println("Invalid input; must type in a number 1, 2, 3, or 4.");
      scanner.nextLine();
      return;
    }
    int age = scanner.nextInt();
    scanner.nextLine();

    try {
      Cat newCat = new Cat(name, breed, age);
      room.add(newCat);
      System.out.println(newCat.toString() + " entered the room");
    } catch (IllegalArgumentException e) {
      System.out.println("Age of cat must be greater than or equal to zero.");
    }
    // room.add(new Cat());
    // System.out.println("Cat added successfully.");
  }

  private static void removeCat() {
    // TODO Auto-generated method stub

  }

  private static void listCats() {
    // TODO Auto-generated method stub

  }
}
