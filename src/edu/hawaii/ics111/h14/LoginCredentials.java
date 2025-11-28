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
  * @param username
  * @param password
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

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
