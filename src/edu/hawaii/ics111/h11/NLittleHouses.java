package edu.hawaii.ics111.h11;

import java.util.Random;
import java.util.Scanner;

/**
 * Class containing the main game loop, handles user input, and randomly creates houses for game.
 *
 * @author CT Reatherford.
 */
public class NLittleHouses
{
  /**
   * Sets up the Wolf and the initial House, then runs the game loop, handles user commands.
   *
   * @param args   not used.
   */
  public static void main(String[] args)
  {
    /**
     * Creates new scanner and wolf objects.
     * Creates and initializes first random House object.
     */
    Scanner scanner = new Scanner(System.in);
    Wolf wolf = new Wolf();
    House currentHouse = createRandomHouse();

    /**
     * Initializes the counter for houses destroyed.
     */
    int housesDestroyed = 0;

    boolean continueGame = true;

    /**
     * Main gain loop beginning with menu and ending with exit choice by user.
     */
    while (continueGame)
    {
      System.out.println("A wolf is in front of a " + currentHouse + " house.");
      System.out.println("What should the wolf do (type in \"1\", \"2\", \"3\", or \"4\"):");
      System.out.println("1: Huff and puff");
      System.out.println("2: Rest");
      System.out.println("3: Move on to another house");
      System.out.println("4: Exit");

      String inputCommand = scanner.nextLine();
      try
      {
        /**
         * Convert String input into integer for use in switch statement.
         * Reference for Integer.parseInt():.
         * https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#parseInt-java.lang.String-int-.
         */
        int choice = Integer.parseInt(inputCommand);
        /**
         * Execute user choice from menu items.
         * Handles invalid input.
         */
        switch (choice)
        {
          case 1:
            try
            {
              wolf.huffPuff(currentHouse);
              if (!currentHouse.isIntact())
              {
                System.out.println("The wolf has managed to blow the house down.");
                housesDestroyed++;
                currentHouse = createRandomHouse();
              }
            }
            catch (IllegalStateException exception)
            {
              System.out.println("The wolf is hyperventilating and cannot huff or puff at the moment.");
            }
            break;
          case 2:
            wolf.rest();
            break;
          case 3:
            currentHouse = createRandomHouse();
            break;
          case 4:
            continueGame = false;
            break;
          default:
            System.out.println("Must type in an option listed in the menu items.");
        }
      } 
      catch (NumberFormatException exception)
      {
        System.out.println("Must type in an option listed in the menu items.");
      }

    }
    /**
     * Close scanner and report number of houses destroyed.
     */
    scanner.close();
    System.out.println("The wolf has destroyed " + housesDestroyed + " houses.");

  }

  /**
   * Selects random house and creates House subclass.
   *
   * @return   A randomly generated House object.
   */
  public static House createRandomHouse()
  {
    /**
     * Creates a new Random number generator.
     */
    Random random = new Random();
    /**
     * Generates the random integer to determine house type.
     */
    int houseChoice = random.nextInt(3);
    /**
     * Maps the random number to the correct House constructor.
     */
    switch (houseChoice)
    {
      case 0:
        return new StrawHouse();
      case 1:
        return new WoodHouse();
      case 2:
        return new SecureBrickHouse();
      default:
        return new SecureBrickHouse();
    }

  }
}
