package edu.hawaii.ics111.h15;

import java.util.ArrayList;
import java.util.Scanner;

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
      System.out.println("4. Retrieve a cat");
      System.out.println("5: Exit");

      if (scanner.hasNextInt())
      {
        choice = scanner.nextInt();
        scanner.nextLine();

      }
      else
      {

        System.out.println("Invalid input; must type in a number 1, 2, 3, 4 or 5");
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
          retrieveCat();
          break;
        case 5:
          isRunning = false;
          break;
        default:
          System.out.println("Invalid input; must type in a number 1, 2, 3, 4 or 5");
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
      System.out.println("Age of the cat must be an integer.");
      scanner.nextLine();
      return;
    }

    int age = scanner.nextInt();
    scanner.nextLine();

    try
    {
      Cat newCat = new Cat(name, breed, age);
      int insertIndex = room.size();

      for (int i = 0; i < room.size(); i++)
      {
        Cat existingCat = room.get(i);

        if (newCat.getName().compareToIgnoreCase(existingCat.getName()) < 0)
        {
          insertIndex = i;
          break;
        }
      }
      room.add(insertIndex, newCat);
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
    if (room.isEmpty())
    {
      System.out.println("The room is currently empty.");
      return;
    }
    for (Cat cat : room)
    {
      System.out.println(cat);
    }
  }
  /**
   * Prompts user to select attribute to search by, then calls the
   * appropriate search method.
   */
  private static void retrieveCat()
  {
    if (room.isEmpty())
    {
      System.out.println("There are no cats in the room to retrieve");
      return;
    }

    System.out.println("How do you want to find the cat? (type in \"1\", \"2\", or \"3\")");
    System.out.println("1: By name");
    System.out.println("2: By breed");
    System.out.println("3: By age");

    if (!scanner.hasNextInt())
    {
      System.out.println("Invalid input; must type in a number 1, 2, or 3 to select how to find the cat.");
      scanner.nextLine();
      return;
    }
    int searchType = scanner.nextInt();
    scanner.nextLine();

    switch (searchType)
    {
    
      case 1:

        System.out.println("What is the name of the cat to find?");
        String nameToFind = scanner.nextLine();

        Cat foundCat = binarySearchCatByName(nameToFind);

        if (foundCat != null)
        {
          System.out.println("Found " + foundCat.toString());
        }
        else
        {
          System.out.println("Did not find a cat named \"" + nameToFind + "\"");
        }
        break;

      case 2:

        System.out.println("What is the breed of the cat to find?");
        String breedToFind = scanner.nextLine();

        ArrayList<Cat> breedMatches = linearSearchCatByBreed(breedToFind);

        if (!breedMatches.isEmpty())
        {
          System.out.println("The cats of the \"" + breedToFind + "\" breed are: " + breedMatches.toString());
        }
        else
        {
          System.out.println("Did not find any cats with breed \"" + breedToFind + "\"");
        }
        break;

      case 3:
        System.out.println("What is the age of the cat to find?");
        if (!scanner.hasNextInt())
        {
          System.out.println("Age of the cat must be an integer.");
          scanner.nextLine();
          return;
        }

        int ageToFind = scanner.nextInt();
        scanner.nextLine();

        if (ageToFind < 0)
        {
          System.out.println("Did not find a cat with age \"" + ageToFind + "\"");
          return;
        }

        ArrayList<Cat> ageMatches = linearSearchCatByAge(ageToFind);

        if (!ageMatches.isEmpty())
        {
          System.out.println("The cats of the \"" + ageToFind + "\" years old are: " + ageMatches.toString());
        }
        else
        {
          System.out.println("Did not find any cats with age \"" + ageToFind + "\"");
        }
        break;

      default:
        System.out.println("Invalid input; must type in a number 1, 2, or 3");
    }
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

    Cat catToRemove = binarySearchCatByName(catToRemoveName);

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
  /**
    * Search for a Cat in the room by the Cat's name using binary search.
    *
    * @param targetName  The name of the Cat to find.
    * @return The Cat object if found, null otherwise.
    */
  private static Cat binarySearchCatByName(String targetName)
  {
    int low = 0;
    int high = room.size() - 1;

    while (low <= high)
    {
      int mid = low + (high - low) / 2;

      String midCatName = room.get(mid).getName();
      int comparison = targetName.compareToIgnoreCase(midCatName);

      if (comparison == 0)
      {
        return room.get(mid);
      }
      else if (comparison < 0)
      {
        high = mid - 1;
      }
      else
      {
        low = mid + 1;
      }
    }
    return null;
  }
  /**
   * Searches for all Cats in the room that match the specified breed using linear search.
   *
   * @param targetBreed  The breed to search for.
   * @return A list of Cat objects that match the specified breed.
   */
  private static ArrayList<Cat> linearSearchCatByBreed(String targetBreed)
  {
    ArrayList<Cat> matchingCats = new ArrayList<>();
    for (Cat cat : room)
    {
      if (cat.getBreed().equalsIgnoreCase(targetBreed))
      {
        matchingCats.add(cat);
      }
    }
    return matchingCats;
  }
  /**
   * Searches for all cats in the room that match the specified age using linear search.
   *
   * @param targetAge  The age to search for.
   * @return Am list of Cat objects that match the specified age.
   */
  private static ArrayList<Cat> linearSearchCatByAge(int targetAge)
  {
    ArrayList<Cat> matchingCats = new ArrayList<>();
    for (Cat cat : room)
    {
      if (cat.getAge() == targetAge)
      {
        matchingCats.add(cat);
      }
    }
    return matchingCats;
  }
}
