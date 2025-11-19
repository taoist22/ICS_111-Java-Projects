package edu.hawaii.ics111.h12;

import javax.swing.JFrame;

/**
 * A Drawing Circles program in Java.
 * 
 * @author CT Reatherford.
 */
public class DrawCircles 
{
	/**
	 * Creates and configures the Drawing Circles window.
	 * 
	 * @param args   Not used.
	 */
  public static void main(String[] args)
  {
  	JFrame frame = new JFrame("Drawing Circles");
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	
  	frame.setSize(800, 600);
  	frame.setContentPane(new CirclePanel());
  	
  	frame.setVisible(true);
  	
  }
}
