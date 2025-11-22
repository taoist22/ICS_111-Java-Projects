package edu.hawaii.ics111.h13;

import javax.swing.JFrame;

/**
 * Main entry point for the Flash Card Game program.
 *
 * @author CT Reatherford.
 */
public class FlashCardGame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Flash Card Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new MathExpressionPanel());
    frame.pack();
    frame.setVisible(true);
  }
}
