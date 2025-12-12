package edu.hawaii.ics111.finalproject;

/**
 * Connect Four gameboard logic.
 *
 * @author CT Reatherford.
 */
public class GameBoard
{
  /**
   * The game board to store piece positions.
   */
  private int[][] board;
  /**
   * The number of rows in the board.
   */
  private static final int ROWS = 6;
  /**
   * The number of columns in the board.
   */
  private static final int COLS = 7;
  /**
   * Empty state of the board.
   */
  private static final int EMPTY = 0;

  /**
   * Create new empty game board, all positions initialized empty.
   */
  public GameBoard()
  {
    board = new int[ROWS][COLS];

    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col < COLS; col++)
      {
        board[row][col] = EMPTY;
      }
    }
  }

  /**
   * Logic to drop piece in column.
   *
   * @param column  The column to drop the piece.
   * @param playerNumber  The player number.
   * @return The row where the piece was placed or -1 if column is full.
   */
  public int dropPiece(int column, int playerNumber)
  {
    if (column < 0 || column >= COLS)
    {
      return -1;
    }

    if (board[0][column] != EMPTY)
    {
      return -1;
    }

    for (int row = ROWS - 1; row >= 0; row--)
    {
      if (board[row][column] == EMPTY)
      {
        board[row][column] = playerNumber;
        return row;
      }
    }
    return -1;
  }

  /**
   * Checks if current player has 4 in a row.
   *
   * @param playerNumber  The player to check.
   * @return true  If the player has won.
   */
  public boolean checkWin(int playerNumber)
  {
    if (checkHorizontal(playerNumber))
    {
      return true;
    }
    if (checkVertical(playerNumber))
    {
      return true;
    }
    if (checkDiagonalUp(playerNumber))
    {
      return true;
    }
    if (checkDiagonalDown(playerNumber))
    {
      return true;
    }
    return false;
  }

  /**
   * Checks for horizontal win 4 across.
   *
   * @param playerNumber  The player to check.
   * @return true if horizontal win exists.
   */
  private boolean checkHorizontal(int playerNumber)
  {
    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col <= COLS - 4; col++)
      {
        if (board[row][col] == playerNumber && board[row][col + 1] == playerNumber &&
            board[row][col + 2] == playerNumber && board[row][col + 3] == playerNumber)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks for vertical wins (4 in a row down).
   * @param playerNumber the player to check.
   * @return true If vertical win found.
   */
  private boolean checkVertical(int playerNumber)
  {

    for (int col = 0; col < COLS; col++)
    {

      for (int row = 0; row <= ROWS - 4; row++)
      {
        if (board[row][col] == playerNumber &&
            board[row + 1][col] == playerNumber &&
            board[row + 2][col] == playerNumber &&
            board[row + 3][col] == playerNumber)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks for diagonal wins going up to the right.
   * @param playerNumber The player to check.
   * @return true If diagonal win found.
   */
  private boolean checkDiagonalUp(int playerNumber)
  {

    for (int row = ROWS - 1; row >= 3; row--)
    {
      for (int col = 0; col <= COLS - 4; col++)
      {
        if (board[row][col] == playerNumber &&
            board[row - 1][col + 1] == playerNumber &&
            board[row - 2][col + 2] == playerNumber &&
            board[row - 3][col + 3] == playerNumber)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks for diagonal wins going down right.
   * @param playerNumber The player to check.
   * @return true If diagonal win found.
   */
  private boolean checkDiagonalDown(int playerNumber)
  {

    for (int row = 0; row <= ROWS - 4; row++)
    {
      for (int col = 0; col <= COLS - 4; col++)
      {
        if (board[row][col] == playerNumber &&
            board[row + 1][col + 1] == playerNumber &&
            board[row + 2][col + 2] == playerNumber &&
            board[row + 3][col + 3] == playerNumber)
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks if a column is full.
   * @param column The column to check.
   * @return true if column is full.
   */
  public boolean isColumnFull(int column)
  {
    if (column < 0 || column >= COLS)
    {
      return true;
    }
    return board[0][column] != EMPTY;
  }

  /**
   * Checks if the board is full for tie game.
   * @return true If board is full.
   */
  public boolean isBoardFull()
  {
    for (int col = 0; col < COLS; col++)
    {
      if (board[0][col] == EMPTY)
      {
        return false;
      }
    }
    return true;
  }

  /**
   * Gets the current state of the board.
   * @return The board array.
   */
  public int[][] getBoard()
  {
    return board;
  }

  /**
   * Gets the number of rows in the board.
   * @return number of rows.
   */
  public int getRows()
  {
    return ROWS;
  }

  /**
   * Gets the number of columns in the board.
   * @return number of columns.
   */
  public int getCols()
  {
    return COLS;
  }

  /**
   * Resets the board to empty for a new game.
   */
  public void reset()
  {
    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col < COLS; col++)
      {
        board[row][col] = EMPTY;
      }
    }
  }

}
