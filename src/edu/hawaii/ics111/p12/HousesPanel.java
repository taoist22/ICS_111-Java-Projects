package edu.hawaii.ics111.p12;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * A JPanel that draws three houses with roofs, doors, doorknobs, and windows with panes.
 * 
 * HousesPanel paintComponent method to render three houses at specified locations.
 *
 * @author CT Reatherford.
 */
public class HousesPanel extends JPanel
{
  /**
   * Constructs HousePanel that draws three houses.
   */
  public HousesPanel()
  {
    super();
  }
  /**
   * Draws three houses on the panel at different positions.
   *
   * @ param g   The graphics context for rendering.
   */
   
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    drawHouse(g, 50, 100, Color.BLUE);
    
    drawHouse(g, 250, 100, Color.RED);
    
    drawHouse(g, 450, 100, Color.GREEN);
  }
  /**
   * Draws one house with roof, door, doorknob, windows with panes.
   *
   * @param g   The graphics context for rendering.
   * @param x   Left x coordinate of the house.
   * @param y   Top y coordinate of the house.
   */
      
  private void drawHouse(Graphics g, int x, int y, Color houseColor)
  {
    int houseWidth = 150;
    int wallHeight = 100;
    int roofHeight = 50;
    
    /**
     * Draws the walls.
     */
    g.setColor(houseColor);
    g.drawRect(x, y + roofHeight, houseWidth, wallHeight);
    
    
    /** 
     * Array for roof x and y coordinates. Left, center, right. 
     */
    int[] xPoints = {x - 10, x + houseWidth / 2, x + houseWidth + 10};
    int[] yPoints = {y + roofHeight, y, y + roofHeight};

    
    /* Draw the triangle roof. */
    g.setColor(houseColor);
    g.fillPolygon(xPoints, yPoints, 3);
    g.setColor(Color.BLACK);
    g.drawPolygon(xPoints, yPoints, 3);
    
    
    /* Door variables with plot for framing door and doorknob. */
    int doorWidth = 30;
    int doorHeight = 60;
    int doorX = x + (houseWidth / 2) - (doorWidth / 2); 
    int doorY = y + roofHeight + wallHeight - doorHeight; 
    
    g.setColor(houseColor);
    g.drawRect(doorX, doorY, doorWidth, doorHeight);
    g.drawOval(doorX + doorWidth - 8, doorY + (doorHeight * 1 / 2), 5, 5);
    

    /* Window variables size and y position of the window. */
    int windowSize = 25;
    int windowY = y + roofHeight + 30; 


    /* Draws left window and window pane. */
    g.drawRect(x + 15, windowY, windowSize, windowSize);
   
    int leftWinX = x + 15;
    int midX = leftWinX + windowSize / 2;
    int midY = windowY + windowSize / 2;
    
    g.drawLine(midX, windowY, midX, windowY + windowSize);
    g.drawLine(leftWinX, midY, leftWinX + windowSize, midY);
    

    /* Draws right window and window pane. */
    g.drawRect(x + houseWidth - windowSize - 15, windowY, windowSize, windowSize);
    
    int rightWinX = x + houseWidth - windowSize - 15;
    int rightMidX = rightWinX + windowSize / 2;
    int rightMidY = windowY + windowSize / 2;
    
    g.drawLine(rightMidX, windowY, rightMidX, windowY + windowSize);
    g.drawLine(rightWinX, rightMidY, rightWinX + windowSize, rightMidY);
  }
}
