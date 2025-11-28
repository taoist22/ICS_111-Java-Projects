package edu.hawaii.ics111.h14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Main entry point for the expanded Login System program.
 *
 * @author CT Reatherford.
 */
public class LoginSystem
{
  /**
   * Main method to create program window and display the login panel.
   *
   * @param args Command line arguments; args[0] path to the user data file.
   */
  public static void main(String[] args)
  {
    if (args.length == 0)
    {
      JOptionPane.showMessageDialog(null,
                                    "Must provide login credentials file as a command line argument", "Missing Input File", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    ArrayList<LoginCredentials> validCredentials = new ArrayList<LoginCredentials>();

    try (Scanner fileInput = new Scanner(new File(args[0])))
    {
      if (fileInput.hasNextLine())
      {
        fileInput.nextLine();
      }
      while (fileInput.hasNextLine())
      {
        String[] credentials = fileInput.nextLine().split(",");

        if (credentials.length == 2)
        {
          String user = credentials[0].trim();
          String pass = credentials[1].trim();

          try
          {
            LoginCredentials credential = new LoginCredentials(user, pass);
            validCredentials.add(credential);
          }
          catch (IllegalArgumentException e)
          {

          }
        }
      }
    }
    catch (FileNotFoundException e)
    {
      JOptionPane.showMessageDialog(null,
                                    "Cannot find login credentials file", "Invalid Input File", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    JFrame frame = new JFrame("Login System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new LoginPanel(validCredentials));

    frame.pack();
    frame.setVisible(true);
  }


}
