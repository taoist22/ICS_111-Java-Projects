package edu.hawaii.ics111.p13;

import javax.swing.JFrame;

/**
 * Main entry point for the Login System program. 
 * 
 * @author CT Reatherford.
 */
public class LoginSystem
{
	/**
	 * Main method to create program window and display the login panel.
	 * 
	 * @param args   Not used.
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Login System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new LoginPanel());
		frame.pack();
		frame.setVisible(true);
		
	}

}
