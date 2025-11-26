package edu.hawaii.ics111.p14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of a room to store Cat objects that will be in current room.
 * User can add, list and remove cats throughout the program.
 *
 * @author CT Reatherford
 */
public class CatRoom {
  /**
   * Data structure to store multiple Cats to represent the room.
   */
  private static ArrayList<Cat> room = new ArrayList<>();
  /**
   * Scanner for receiving user input.
   */
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Main method to run the CatRoom program and handle user operations.
   *
   * @param args Not used
   */
  public static void main(String[] args) {

    boolean isRunning = true;
    int choice;

    System.out.println("This program will represent the cats currently in a room.");

    while (isRunning) {
      System.out.println("Which operation do you want to perform (type in \"1\", \"2\", \"3\", or \"4\")?");
      System.out.println("1: Add a cat");
      System.out.println("2: List all cats");
      System.out.println("3: Remove a cat");
      System.out.println("4: Exit");

      // Input validation: Check if input is an integer
      if (scanner.hasNextInt()) {
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after nextInt()

      } else {
        // Handle non-integer input
        System.out.println("Invalid input; must type in a number 1, 2, 3, or 4"); // Matches sample output
        scanner.nextLine(); // Consume the invalid line input
        continue;
      }

      // Handle the user's choice
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
          // Loop will exit and scanner will be closed below
          break;
        default:
          System.out.println("Invalid input; must type in a number 1, 2, 3, or 4"); // Matches sample output
      }
    }

    scanner.close();
  }

  /**
   * Prompts the user for Cat attributes, creates a Cat object, and adds it to the
   * room.
   * Includes input validation.
   */
  private static void addCat() {
    System.out.println("What is the name of the new cat?"); // Matches sample output
    String name = scanner.nextLine();

    System.out.println("What is the breed of the new cat?"); // Matches sample output
    String breed = scanner.nextLine();

    System.out.println("What is the age of the new cat?"); // Matches sample output

    // Check if the next input is an integer for age
    if (!scanner.hasNextInt()) {
      // Handle non-integer age input
      System.out.println("Invalid input; age must be a whole number.");
      scanner.nextLine(); // consume the invalid line
      return;
    }

    int age = scanner.nextInt();
    scanner.nextLine(); // Consume the newline left after nextInt()

    // Input validation for age is handled by the Cat constructor via exception
    // [cite: 271, 284]
    try {
      // Using the Cat(name, breed, age) constructor (which sets hungry=true)
      Cat newCat = new Cat(name, breed, age);
      room.add(newCat);
      System.out.println(newCat.toString() + " entered the room"); // Matches sample output
    } catch (IllegalArgumentException e) {
      // Catches exception for age < 0
      System.out.println("Age of a cat must be greater than or equal to 0"); // Matches sample output
    }
  }

  /**
   * Lists all Cat objects currently in the room.
   */
  private static void listCats() {
    // Uses the ArrayList's toString() method, which in turn uses Cat's toString()
    // [cite: 41]
    System.out.println(room.toString());
  }

  /**
   * Prompts the user to select a cat by name and removes it from the room if
   * found.
   * Includes input validation.
   */
  private static void removeCat() {
    if (room.isEmpty()) {
      System.out.println("There are no cats to remove"); // Matches sample output
      return;
    }

    // Prepare a list of cat names (Strings) for the prompt [cite: 27]
    ArrayList<String> catNames = new ArrayList<>();
    for (Cat cat : room) {
      // Add the cat's name (a String), wrapped in quotes, to the list.
      catNames.add("\"" + cat.getName() + "\"");
    }

    // Display the list of choices
    System.out.println("Which cat do you want to remove (type in one of [" + String.join(", ", catNames) + "])?");
    String catToRemoveName = scanner.nextLine();

    Cat catToRemove = null;

    // Find the Cat object with the matching name
    for (Cat cat : room) {
      if (cat.getName().equals(catToRemoveName)) {
        catToRemove = cat;
        break; // Cat found, exit loop
      }
    }

    // Remove the cat or display an error [cite: 31, 32]
    if (catToRemove != null) {
      room.remove(catToRemove); // Remove the cat object from the list
      // Display the cat that left, using the object's toString() method
      System.out.println(catToRemove.toString() + " left the room"); // Matches sample output
    } else {
      // Cat not found error
      System.out.println("Did not find a cat named \"" + catToRemoveName + "\" to remove"); // Matches sample output
    }
  }
}
