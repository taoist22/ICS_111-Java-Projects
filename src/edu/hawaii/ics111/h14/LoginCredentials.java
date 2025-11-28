package edu.hawaii.ics111.h14;


public class LoginCredentials
{
  /**
  * Instance variable for username.
  */
  private String username;
  /**
  * Instance variable for password.
  */
  private String password;
  /**
  * Constructor for LoginCredentials.
  * @param username  the username for this credential.
  * @param password  the password for this credential.
  * @throws IllegalArgumentException if username or password are null or empty
  */
  public LoginCredentials(String username, String password)
  {
    if (username == null || username.isEmpty() || password == null || password.isEmpty())
    {
      throw new IllegalArgumentException("Username and password must not be null or empty");
    }
    this.username = username;
    this.password = password;
  }
  /**
   * Gets the username
   * @return   the username.
   */
  public String getUsername()
  {
    return username;
  }
  /**
   * Gets the password
   * @return   the password.
   */
  public String getPassword()
  {
    return password;
  }
  /**
   * Sets the username.
   * @param username.
   * @throws IllegalArgumentException if username is null or empty
   */
  public void setUsername(String username)
  {
    if (username == null || username.isEmpty())
    {
      throw new IllegalArgumentException("Username must not be null or empty");
    }
    this.username = username;
  }
  /**
   * Sets the password.
   * @param password.
   * @throws IllegalArgumentException if password is null or empty
   */
  public void setPassword(String password)
  {
    if (password == null || password.isEmpty())
    {
      throw new IllegalArgumentException("Password must not be null or empty");
    }
    this.password = password;
  }
  /**
   * Compares this object with the specified object for equality.
   * @param obj   the object to compare with this object.
   * @return      true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    LoginCredentials other = (LoginCredentials) obj;
    return username.equals(other.username) && password.equals(other.password);
  }
}
