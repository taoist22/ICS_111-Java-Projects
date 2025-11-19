package edu.hawaii.ics111.h12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 * CirclePanel draws circles of random colors based on mouse events.
 * Mouse press defines the center of the circle and mouse release defines a point on the perimeter.
 * This creates a random color filled circle.
 * 
 * @author CT Reatherford.
 */
public class CirclePanel extends JPanel implements MouseListener
{
  /**
   * X coordinate/center of mouse press.
   */
	private int centerX;
	/**
	 * Y coordinate/center of mouse press.
	 */
	private int centerY;
	/**
	 * Calculated radius of circle to be drawn.
	 */
	private double radius;
	/**
	 * Generated random color for the circle.
	 */
	private Color circleColor;
	/**
	 * Boolean to indicate if circle is to be drawn.
	 */
	private boolean drawingStatus;
	
	/**
	 * Initialize CirclePanel. Adds Mouse Listener for input.
	 */
	public CirclePanel() 
	{
		super();
		
		this.centerX = 0;
		this.centerY = 0;
		this.radius = 0;
		this.drawingStatus = false;
		
		this.addMouseListener(this);
		
	}
	/**
	 * Set the coordinates of the mouse press to define circle center. Set drawingStatus to not draw circle.
	 * 
	 * @param e  The MouseEvent object containing the press coordinates.
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		this.centerX = e.getX();
		this.centerY = e.getY();
		
		this.drawingStatus = false;
	}
	/**
	 * Calculates radius, sets color and repaints when mouse release occurs.
	 * 
	 * @param e  The MouseEven object containing the release coordinates.
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		int releaseX = e.getX();
		int releaseY = e.getY();
		
		this.radius = Math.sqrt(Math.pow(releaseX - centerX, 2) + Math.pow(releaseY - centerY, 2));
		
		/**
		 * Generates random color.
		 */
		Random generator = new Random();
    int red = generator.nextInt(256);
    int green = generator.nextInt(256);
    int blue = generator.nextInt(256);
    
    this.circleColor = new Color(red, green, blue);
    
    /**
     * Draw the circle.
     */
    this.drawingStatus = true;
    /**
     * Reset and repaint for next circle.
     */
    repaint();
	}
	/**
	 * Unused MouseListener methods.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
	/**
	 * Draws text string for instructions and then draws the circle.
	 * 
	 * @param g  The Graphics context used for drawing.
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		/**
		 * Displays instructions. Coordinates set as static to reduce hidden text when drawing circles.
		 */
		g.drawString("Press a mouse button to set the center of the circle to draw, ", 10, 15);
		g.drawString("then release the same mouse button to set a point on the"
                 + " perimeter of the circle to draw", 10, 30);
		
		if (drawingStatus)
		{
			g.setColor(circleColor);
			/**
			 * Convert circle center, radius and diameter for setting circle coordinates.
			 */
			int x = (int) (centerX - radius);
			int y = (int) (centerY - radius);
			int diameter = (int) (radius * 2);
			
			/**
			 * Draw filled circle.
			 */
			g.fillOval(x, y, diameter, diameter);
			
		}
	}

}

