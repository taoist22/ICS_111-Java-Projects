package edu.hawaii.ics111.p14;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Representation of a room to store Cat objects that will be in current room.
 * User can add, list and remove cats throughout the program.
 *
 * @author CT Reatherford
 */
public class CatRoom 
{
  /**
   * Data structure to store multiple Cats to represent the room.
   */
  private static ArrayList<Cat> room = new ArrayList<Cat>();
  /**
   * Scanner for receiving user input.
   */
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Main method to run the CatRoom program and handle user operations.
   *
   * @param args Not used
   */
  public static void main(String[] args) 
  {

    boolean isRunning = true;
    int choice;

    System.out.println("This program will represent the cats currently in a room.");

    while (isRunning) 
    {
      System.out.println("Which operation do you want to perform (type in \"1\", \"2\", \"3\", or \"4\")?");
      System.out.println("1: Add a cat");
      System.out.println("2: List all cats");
      System.out.println("3: Remove a cat");
      System.out.println("4: Exit");

      if (scanner.hasNextInt()) 
      {
        choice = scanner.nextInt();
        scanner.nextLine();

      } 
      else 
      {
        
        System.out.println("Invalid input; must type in a number 1, 2, 3, or 4");
        scanner.nextLine();
        System.out.println();
        continue;
      }

      switch (choice) 
      {
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
          System.out.println("Invalid input; must type in a number 1, 2, 3, or 4");
      }
      System.out.println();
    }

    scanner.close();
  }

  /**
   * Prompts the user for Cat attributes, creates a Cat object, and adds it to the
   * room.
   */
  private static void addCat() 
  {
    System.out.println("What is the name of the new cat?");
    String name = scanner.nextLine();

    System.out.println("What is the breed of the new cat?");
    String breed = scanner.nextLine();

    System.out.println("What is the age of the new cat?");

    if (!scanner.hasNextInt()) 
    {
      System.out.println("Age of the cat must be greater than or equal to 0.");
      scanner.nextLine();
      return;
    }

    int age = scanner.nextInt();
    scanner.nextLine();

    try 
    {
      Cat newCat = new Cat(name, breed, age);
      room.add(newCat);
      System.out.println(newCat.toString() + " entered the room");
    } 
    catch (IllegalArgumentException e) 
    {
      System.out.println("Age of a cat must be greater than or equal to 0");
    }
  }

  /**
   * Lists all Cat objects currently in the room.
   */ 
  private static void listCats() 
  {
    Collections.sort(room);
    System.out.println(room.toString());
  }

  /**
   * Prompts the user to select a cat by name and removes it from the room if
   * found.
   */
  private static void removeCat() 
  {
    if (room.isEmpty()) 
    {
      System.out.println("There are no cats to remove");
      return;
    }

    ArrayList<String> catNames = new ArrayList<>();
    for (Cat cat : room) 
    {
      catNames.add("\"" + cat.getName() + "\"");
    }
    
    System.out.println("Which cat do you want to remove (type in one of [" + String.join(", ", catNames) + "])?");
    String catToRemoveName = scanner.nextLine();

    Cat catToRemove = null;

    for (Cat cat : room) 
    {
      if (cat.getName().equals(catToRemoveName)) 
      {
        catToRemove = cat;
        break;
      }
    }

    if (catToRemove != null) 
    {
      room.remove(catToRemove);
      System.out.println(catToRemove.toString() + " left the room");
    } 
    else 
    {
      System.out.println("Did not find a cat named \"" + catToRemoveName + "\" to remove");
    }
  }
}
