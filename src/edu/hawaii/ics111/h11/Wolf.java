package edu.hawaii.ics111.h11;

/**
 * Wolf character for The Three Little Pigs game.
 * Wolf causes damage to houses through huff and puff action which costs air.
 * Can recover air through rest action.
 *
 * @author CT Reatherford.
 */
public class Wolf
{
  /**
   * The current amount of air available to be used.
   */
  private double amountAir = 1.0;

  /**
   * Constructs a new Wolf object. Initializes air supply.
   */
  public Wolf()
  {

  }

  /**
   * Gets the current amount of air available to the wolf.
   *
   * @return   The current air supply as a double.
   */
  public double getAmountAir()
  {
    return amountAir;
  }

  /**
   * The fixed amount of air used by the wolf for one huff and puff attempt.
   */
  public static final double AIR_COST = 0.25;
  
  public static final double DAMAGE_PER_HIT = 1.0;

  /**
   * Simulates the huff and puff action, inflicting damage and decreasing air supply.
   *
   * @param targetHouse   The House object attacked by the wolf.
   * @throws IllegalStateException   If the wolf does not have enough air to huff and puff.
   */
  public void huffPuff(House targetHouse)
  {
    if (amountAir <= AIR_COST)
    {
      throw new IllegalStateException("The Wolf is hyperventilating.");
    }

    targetHouse.inflictDamage(DAMAGE_PER_HIT);
    amountAir = amountAir - AIR_COST;

  }

  /**
   * Simulates recovery state for the wolf, restoring air supply.
   */
  public void rest()
  {
    amountAir = 1.0;
  }

}

