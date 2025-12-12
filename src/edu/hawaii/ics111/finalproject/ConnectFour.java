package edu.hawaii.ics111.finalproject;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;


/**
 * Main control for Connect Four game in Java.
 *
 * @author CT Reatherford.
 */
public class ConnectFour implements ActionListener
{
  /**
   * Manages piece positions and win detection.
   */
  private GameBoard gameBoard;
  /**
   * GUI for the game.
   */
  private ConnectFourGUI gui;
  /**
   * First player for the game.
   */
  private Player player1;
  /**
   * Second player for the game.
   */
  private Player player2;
  /**
   * Current turn player.
   */
  private Player currentPlayer;
  /**
   * Prevents double bounce.
   */
  private boolean isDropping = false;

  /**
   * Creates new Connect Four game, initializes board, gets player names,
   * sets up GUI.
   */
  public ConnectFour()
  {

    /**
     * Method to get player names.
     */
    getPlayerNames();

    gameBoard = new GameBoard();
    gui = new ConnectFourGUI(this, new RestartListener());

    gui.setPlayerNames(player1.getName(), player2.getName());

    currentPlayer = player1;
    gui.setStatus(currentPlayer.getName() + "'s turn");
  }

  /**
   * Method to get player names.
   */
  private void getPlayerNames()
  {
    player1 = getPlayer(1);
    player2 = getPlayer(2);
  }

  /**
   * Helper method to get player input and ensure default name if input is invalid.
   *
   * @param playerNumber The player's number (1 or 2).
   * @return The initialized Player object.
   */
  private Player getPlayer(int playerNumber)
  {
    String defaultName = "Player " + playerNumber;
    String name = JOptionPane.showInputDialog(null, "Enter " + defaultName + " name:",
                  defaultName + " setup", JOptionPane.QUESTION_MESSAGE);

    // Use default name if input is null or blank
    if (name == null || name.trim().isEmpty())
    {
      name = defaultName;
    }

    return new Player(name, playerNumber);
  }

  /**
   * Handle column button click event.
   * @param e The action even from a button click.
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    int column = Integer.parseInt(e.getActionCommand());
    handleColumnClick(column);
  }

  /**
   * Processing of player move in chosen column.
   * @param column  The column where player chooses to drop piece.
   */
  private void handleColumnClick(int column)
  {
    if (isDropping)
    {
      return;
    }
    if (gameBoard.isColumnFull(column))
    {
      gui.showColumnFullError();
      return;
    }

    isDropping = true;

    int row = gameBoard.dropPiece(column, currentPlayer.getPlayerNumber());

    if (row == -1)
    {
      gui.showColumnFullError();
      return;
    }

    gui.animateDrop(column, row, currentPlayer.getPlayerNumber(), new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        gui.updateDisplay(gameBoard.getBoard());

        if (gameBoard.checkWin(currentPlayer.getPlayerNumber()))
        {
          gui.showWinner(currentPlayer.getName());
          return;
        }
        if (gameBoard.isBoardFull())
        {
          gui.showTie();
          return;
        }

        switchPlayer();
        gui.setStatus(currentPlayer.getName() + "'s turn");

        gui.enableColumnButtons();

        isDropping = false;
      }
    });
  }

  /**
   * Switch to other player.
   */
  private void switchPlayer()
  {
    if (currentPlayer == player1)
    {
      currentPlayer = player2;
    }
    else
    {
      currentPlayer = player1;
    }
  }

  /**
   * Resets game, starts over.
   */
  private void restartGame()
  {
    gameBoard.reset();

    currentPlayer = player1;

    gui.updateDisplay(gameBoard.getBoard());
    gui.setStatus(currentPlayer.getName() + "'s turn");
    gui.enableColumnButtons();
  }

  /**
   * Handle restart button.
   */
  private class RestartListener implements ActionListener
  {
    /**
     * Restart button click event.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
      restartGame();
    }
  }

  /**
   * Main method to start game.
   *
   * @param args  Not Used.
   */
  public static void main(String[] args)
  {
    new ConnectFour();
  }
}
