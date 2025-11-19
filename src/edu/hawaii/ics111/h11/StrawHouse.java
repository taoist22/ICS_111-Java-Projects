package edu.hawaii.ics111.h11;

/**
 * House made of straw with low structural integrity.
 *
 * @author CT Reatherford.
 */
public class StrawHouse extends House
{
  /**
   * Returns the building material for this House.
   *
   * @return   A String containing the building material for a straw house.
   */
  @Override
  public String getBuildingMaterial()
  {
    return "straw";
  }

  /**
   * Straw house construction with structural integrity of 1.0.
   * Inherits structuralStability from House.
   */
  public StrawHouse()
  {
    super(1.0);
  }
}
