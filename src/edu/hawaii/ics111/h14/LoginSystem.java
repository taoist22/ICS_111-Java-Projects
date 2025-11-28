package edu.hawaii.ics111.h14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
                                    "You must specify a file containing user data.", "Missing input file", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    try (Scanner fileInput = new Scanner(new File(args[0])))
    {
      if (fileInput.hasNextLine())
      {
        fileInput.nextLine();
      }
    }
  }

  JFrame frame = new JFrame("Login System");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setContentPane(new LoginPanel());
  frame.pack();
  frame.setVisible(true);

}

}
