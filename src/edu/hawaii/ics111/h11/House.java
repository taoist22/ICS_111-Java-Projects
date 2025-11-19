package edu.hawaii.ics111.h11;

/**
 * Three Little Pigs Java game.
 * Blueprint class for all house types used in the game.
 *
 * @author CT Reatherford.
 */
abstract class House
{
  /**
   * Current structural integrity of the house.
   */
  private double structuralStability;

  /**
   * Initialize the House object
   * Constructor called by House subclasses.
   *
   * @param structuralStability   The starting structural integrity of the house.
   */
  House(double structuralStability)
  {
    this.structuralStability = structuralStability;
  }

  /**
   * Returns the building material for each house.
   *
   * @return   The String representing the building material.
   */
  @Override
  public String toString()
  {
    return getBuildingMaterial();
  }

  /**
   * Returns the building material when creating the House.
   *
   * @return   A String containing the type of material used to build the House.
   */
  public abstract String getBuildingMaterial();

  /**
   * Update to the structural integrity of House when decrementing after damage.
   *
   * @param damage   The amount of damage inflicted as a non-negative number.
   * @throws IllegalArgumentException   If the damage parameter is negative.
   */
  public void inflictDamage(double damage)
  {
    if (damage < 0)
    {
      throw new IllegalArgumentException("Damage cannot be negative.");
    }
    structuralStability = structuralStability - damage;
  }

  /**
   * Checks structural integrity of House.
   *
   * @return   True if structural integrity is greater than 0.0, else false.
   */
  public boolean isIntact()
  {
    return this.structuralStability > 0.0;
  }
}
