package edu.hawaii.ics111.h11;

/**
 * House made of brick with high structural integrity.
 *
 * @author CT Reatherford.
 */
public class SecureBrickHouse extends House
{
  /**
   * Returns the building material for this house.
   *
   * @return   A String containing the building material for a brick house.
   */
  @Override
  public String getBuildingMaterial()
  {
    return "brick";
  }

  /**
   * Constructs a SecureBrickHouse that is indestructible.
   * double value chosen for structuralStability is overridden to manage indestructible status.
   */
  public SecureBrickHouse()
  {
    super(1.0);
  }

  /**
   * Override for inherited House inflictDamage method to prevent structural damage.
   * @param damage   The amount of damage inflicted as a non-negative number.
   */
  @Override
  public void inflictDamage(double damage)
  {
  }
}
