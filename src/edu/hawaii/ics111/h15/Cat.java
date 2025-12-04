package edu.hawaii.ics111.h15;

/**
 * A Java example of a Cat class with name, breed, age and hunger status.
 * Includes examples of constructors, getters, setters and increments age
 * method.
 *
 * @author CT Reatherford
 */
public class Cat implements Comparable<Cat>
{
  /**
   * The cat's name.
   */
  private String name;
  /**
   * The cat's breed.
   */
  private String breed;
  /**
   * The cat's age.
   */
  private int age;
  /**
   * If the cat is hungry.
   */
  private boolean hungry;

  /**
   * Construction of cat object with name, breed, age and hunger status.
   *
   * @param name   the name of the cat.
   * @param breed  the breed of the cat.
   * @param age    the age of the cat.
   * @param hungry boolean for determination of hunger status of cat.
   * @throws IllegalArgumentException if age is less than 0.
   */
  public Cat(String name, String breed, int age, boolean hungry)
  {
    this.name = name;
    this.breed = breed;
    if (age < 0)
    {
      throw new IllegalArgumentException("Age must be greater than 0.");
    }
    this.age = age;
    this.hungry = hungry;
  }

  /**
   * Construction of cat object always hungry status and includes name, breed, and
   * age.
   *
   * @param name  the name of the cat.
   * @param breed the breed of the cat.
   * @param age   the age of the cat.
   * @throws IllegalArgumentException if age is less than 0.
   */
  public Cat(String name, String breed, int age)
  {
    this.name = name;
    this.breed = breed;
    if (age < 0)
    {
      throw new IllegalArgumentException("Age must be greater than 0.");
    }
    this.age = age;
    hungry = true;
  }

  /**
   * Returns the name of the cat.
   *
   * @return the cat's name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns the breed of the cat.
   *
   * @return the cat's breed
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * Returns the age of the cat.
   *
   * @return the cat's age.
   */
  public int getAge()
  {
    return age;
  }

  /**
   * Returns true if the cat is hungry.
   *
   * @return returns true if hungry, otherwise false.
   */
  public boolean isHungry()
  {
    return hungry;
  }

  /**
   * Sets the name of the cat1.
   *
   * @param name the new name of the cat1.
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the hunger state of the cat.
   *
   * @param hungry true if cat is hungry, otherwise false.
   */
  public void setHungry(boolean hungry)
  {
    this.hungry = hungry;
  }

  /**
   * Increments the age of the cat by 1.
   */
  public void increaseAge()
  {
    this.age++;
  }

  /**
   * Returns the string representation of the cat.
   *
   * @return the string representation of the cat.
   */
  @Override
  public String toString()
  {
    return name + " (" + breed + ", " + age + " years old)";
  }

  /**
   * Compares Cat object with other Cat object for alphabetical order sorting.
   *
   * @param otherCat The Cat to be compared.
   * @return An integer corresponding to order placement of the cat.
   */
  @Override
  public int compareTo(Cat otherCat)
  {
    return this.name.compareTo(otherCat.name);
  }
}
