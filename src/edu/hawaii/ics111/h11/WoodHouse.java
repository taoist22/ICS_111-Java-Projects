package edu.hawaii.ics111.h11;

/**
 * House made of wood with moderate structural integrity.
 *
 * @author CT Reatherford.
 */
public class WoodHouse extends House
{
  /**
   * Returns the building material for this house.
   *
   * @return   A String containing the building material for a wood house.
   */
  @Override
  public String getBuildingMaterial()
  {
    return "wood";
  }

  /**
   * Wood house construction with structural integrity of 2.0.
   * Inherits structuralStability from House.
   */
  public WoodHouse()
  {
    super(2.0);
  }
}
