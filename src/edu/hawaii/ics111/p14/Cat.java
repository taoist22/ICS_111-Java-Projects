package edu.hawaii.ics111.p14;

/**
 * A Java example of a Cat class with name, breed, age and hunger status.
 * Includes examples of constructors, getters, setters and increments age
 * method.
 *
 * @author CT Reatherford
 */
class Cat {
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
  Cat(String name, String breed, int age, boolean hungry) {
    this.name = name;
    this.breed = breed;
    if (age < 0) {
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
  Cat(String name, String breed, int age) {
    this.name = name;
    this.breed = breed;
    if (age < 0) {
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
  String getName() {
    return name;
  }

  /**
   * Returns the breed of the cat.
   *
   * @return the cat's breed
   */
  String getBreed() {
    return breed;
  }

  /**
   * Returns the age of the cat.
   *
   * @return the cat's age.
   */
  int getAge() {
    return age;
  }

  /**
   * Returns true if the cat is hungry.
   *
   * @return returns true if hungry, otherwise false.
   */
  boolean isHungry() {
    return hungry;
  }

  /**
   * Sets the name of the cat1.
   *
   * @param name the new name of the cat1.
   */
  void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the hunger state of the cat.
   *
   * @param hungry true if cat is hungry, otherwise false.
   */
  void setHungry(boolean hungry) {
    this.hungry = hungry;
  }

  /**
   * Increments the age of the cat by 1.
   */
  public void increaseAge() {
    this.age++;
  }
}
