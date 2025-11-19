package edu.hawaii.ics111.p12;

import javax.swing.JFrame;

/**
 * Frame for displaying three houses drawn by HousePanel.
 *
 * @author CT Reatherford
 */
public class DrawingHouses
{
  /**
   * Sets up the JFrame and renders houses panel.
   *
   * @param args   Not used.
   */
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("Three Houses");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650, 350);

    HousesPanel panel = new HousesPanel();

    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
