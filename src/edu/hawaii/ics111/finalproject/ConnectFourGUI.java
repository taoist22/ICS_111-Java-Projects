package edu.hawaii.ics111.finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

/**
 * Creates and manages the gui for Connect Four game.
 * Displays game board and handles user interaction.
 *
 * @author CT Reatherford
 */
public class ConnectFourGUI
{
  /**
   * Main game window frame.
   */
  private JFrame frame;
  /**
   * Panel containing the game board display.
   */
  private JPanel boardPanel;
  /**
   * Panel containing the column selection buttons.
   */
  private JPanel buttonPanel;
  /**
   * Panel containing status label and restart button.
   */
  private JPanel statusPanel;
  /**
   * Array of buttons for column selection.
   */
  private JButton[] columnButtons;
  /**
   * 2D array of labels representing board spaces.
   */
  private JLabel[][] boardLabels;
  /**
   * Current player turn/game status label.
   */
  private JLabel player1Label;
  private JLabel player2Label;
  /**
   * Tracks the current player turn for the arrow color.
   */
  private int currentTurn = 1;

  /**
   * Name of Player 1.
   */
  private String p1Name = "Player 1";
  /**
   * Name of Player 2.
   */
  private String p2Name = "Player 2";
  /**
   * Number of rows in the board.
   */
  private static final int ROWS = 6;
  /**
   * Number of columns in the board.
   */
  private static final int COLS = 7;

  /**
   * Create game board and gui components.
   *
   * @param columnClickListener Listener for column button clicks.
   * @param restartListener  Listener for restart button click.
   */
  public ConnectFourGUI(ActionListener columnClickListener, ActionListener restartListener)
  {
    createFrame();
    createMenuBar(restartListener);
    createButtonPanel(columnClickListener);
    createBoardPanel();
    createStatusPanel();

    JPanel headerPanel = new JPanel(new BorderLayout());
    headerPanel.add(statusPanel, BorderLayout.NORTH);
    headerPanel.add(buttonPanel, BorderLayout.CENTER);
    frame.add(headerPanel, BorderLayout.NORTH);

    frame.setVisible(true);
  }

  /**
   * Creates main window for game.
   */
  private void createFrame()
  {
    frame = new JFrame("Connect Four");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setSize(800, 700);
  }

  /**
   * Creates Menu bar with Help Menu.
   */
  private void createMenuBar(ActionListener restartListener)
  {

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem restartItem = new JMenuItem("Restart Game");
    JMenuItem aboutItem = new JMenuItem("About");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem helpItem = new JMenuItem("How to Play");

    fileMenu.add(restartItem);
    fileMenu.add(aboutItem);
    menuBar.add(fileMenu);


    restartItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to restart?", "Restart Game", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION)
        {
          restartListener.actionPerformed(e);
        }
      }
    });


    helpItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        showHelp();
      }
    });
    helpMenu.add(helpItem);
    menuBar.add(helpMenu);
    frame.setJMenuBar(menuBar);

    aboutItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        showAbout();
      }
    });
  }

  private void showAbout()
  {
    String aboutText = "A Connect Four Game in Java. Author CT Reatherford.";

    JOptionPane.showMessageDialog(frame, aboutText, "Connect Four - About", JOptionPane.INFORMATION_MESSAGE);

  }

  /**
   * Game instructions display.
   */
  private void showHelp()
  {
    String helpText =
      "How To Play Connect Four\n\n" +
      "Objective: Get 4 of your pieces in a row\n\n" +
      "Rules:\n" +
      "- Click a column button to drop your piece\n" +
      "- Pieces fall to the lowest available space\n" +
      "- Players alternate turns\n" +
      "- First to get 4 in a row wins!\n" +
      "  (horizontal, vertical, or diagonal)\n" +
      "- If the board fills with no winner, it's a tie\n\n" +
      "Player 1: RED\n" +
      "Player 2: YELLOW";

    JOptionPane.showMessageDialog(frame, helpText, "Connect Four - Help", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Creates column buttons for selection at top of columns.
   *
   * @param listener  The action listener for column button clicks.
   */
  private void createButtonPanel(ActionListener listener)
  {
    buttonPanel = new JPanel(new GridLayout(1, COLS));
    columnButtons = new JButton[COLS];

    for (int i = 0; i < COLS; i++)
    {
      columnButtons[i] = new JButton()
      {
        @Override
        protected void paintComponent(Graphics g)
        {
          if (getForeground().getAlpha() == 0)
          {
            return;
          }

          int w = getWidth();
          int h = getHeight();

          int[] xPoints = {10, w - 10, w / 2};
          int[] yPoints = {15, 15, h - 15};

          g.setColor(getForeground());
          g.fillPolygon(xPoints, yPoints, 3);

          g.setColor(Color.BLACK);
          g.drawPolygon(xPoints, yPoints, 3);
        }
      };

      columnButtons[i].setPreferredSize(new java.awt.Dimension(50, 50));

      columnButtons[i].setForeground(new Color(0, 0, 0, 0));

      columnButtons[i].setContentAreaFilled(false);
      columnButtons[i].setBorderPainted(false);
      columnButtons[i].setFocusPainted(false);
      columnButtons[i].setFont(new Font("Arial", Font.BOLD, 40));

      columnButtons[i].addMouseListener(new java.awt.event.MouseAdapter()
      {
        public void mouseEntered(java.awt.event.MouseEvent evt)
        {
          if (currentTurn == 1)
          {
            ((JButton)evt.getSource()).setForeground(Color.RED);
          }
          else
          {
            ((JButton)evt.getSource()).setForeground(Color.YELLOW);
          }

        }
        public void mouseExited(java.awt.event.MouseEvent evt)
        {
          // On Exit: Make the arrow TRANSPARENT (Invisible)
          ((JButton)evt.getSource()).setForeground(new Color(0, 0, 0, 0));
        }
      });
      columnButtons[i].setActionCommand(String.valueOf(i));
      columnButtons[i].addActionListener(listener);
      buttonPanel.add(columnButtons[i]);
    }
  }

  /**
   * Creates the game board display.
   */
  private void createBoardPanel()
  {
    boardPanel = new JPanel(new GridLayout(ROWS, COLS, 5, 5));
    boardPanel.setBackground(Color.BLUE);
    boardLabels = new JLabel[ROWS][COLS];

    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col < COLS; col++)
      {
        boardLabels[row][col] = new JLabel();
        boardLabels[row][col].setOpaque(true);
        boardLabels[row][col].setBackground(Color.WHITE);
        boardLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        boardPanel.add(boardLabels[row][col]);
      }
    }
    frame.add(boardPanel, BorderLayout.CENTER);
  }

  /**
   * Create status panel.
   *
   * @param restartListener  The listener for the restart button click.
   */
  private void createStatusPanel()
  {
    statusPanel = new JPanel(new GridLayout(1, 2));

    player1Label = new JLabel("Player 1", JLabel.CENTER);
    player1Label.setFont(new Font("Arial", Font.BOLD, 20));
    player1Label.setOpaque(true);
    player1Label.setBackground(Color.RED);

    player2Label = new JLabel("Player 2", JLabel.CENTER);
    player2Label.setFont(new Font("Arial", Font.PLAIN, 20));
    player2Label.setOpaque(true);
    player2Label.setBackground(Color.LIGHT_GRAY);

    statusPanel.add(player1Label);
    statusPanel.add(player2Label);

  }

  /**
   * Sets the player names on the status labels.
   *
   * @param name1  Name of player 1.
   * @param name2  Name of player 2.
   */
  public void setPlayerNames(String name1, String name2)
  {
    this.p1Name = name1;
    this.p2Name = name2;

    player1Label.setText("Player 1: " + name1);
    player2Label.setText("Player 2: " + name2);

    setTurn(1);
  }

  /**
   * Update current board state.
   *
   * @param board  The current game board.
   */
  public void updateDisplay(int[][] board)
  {
    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col < COLS; col++)
      {
        if (board[row][col] == 1)
        {
          boardLabels[row][col].setBackground(Color.RED);
        }
        else if (board[row][col] == 2)
        {
          boardLabels[row][col].setBackground(Color.YELLOW);
        }
        else
        {
          boardLabels[row][col].setBackground(Color.WHITE);
        }
      }
    }
  }

  /**
   * Updates the player labels to show which player turn it is.
   *
   * @param player  The player whose turn it is.
   */
  public void setTurn(int player)
  {
    this.currentTurn = player;

    Font boldFont = new Font("Arial", Font.BOLD, 20);
    Font plainFont = new Font("Arial", Font.PLAIN, 20);

    if (player == 1)
    {
      player1Label.setBackground(Color.RED);
      player1Label.setFont(boldFont);

      player2Label.setBackground(Color.LIGHT_GRAY);
      player2Label.setFont(plainFont);
    }
    else
    {
      player1Label.setBackground(Color.LIGHT_GRAY);
      player1Label.setFont(plainFont);

      player2Label.setBackground(Color.YELLOW);
      player2Label.setFont(boldFont);
    }
    for (int i = 0; i < COLS; i++)
    {
      if (columnButtons[i].getForeground().getAlpha() != 0)
      {
        if (player == 1)
        {
          columnButtons[i].setForeground(Color.RED);
        }
        else
        {
          columnButtons[i].setForeground(Color.YELLOW);
        }
      }
    }
  }

  /**
   * Update status message.
   *
   * @param message  The message to display.
   */
  public void setStatus(String message)
  {
    if (message.contains(p1Name))
    {
      setTurn(1);
    }
    else if (message.contains(p2Name))
    {
      setTurn(2);
    }
  }

  /**
   * Display winner message.
   *
   * @param playerName  The name of the player who wins.
   */
  public void showWinner(String playerName)
  {
    disableColumnButtons();
    JOptionPane.showMessageDialog(frame, playerName + " wins!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Display tie message.
   */
  public void showTie()
  {
    disableColumnButtons();
    JOptionPane.showMessageDialog(frame, "It's a Tie!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Animate a piece falling down the column.
   *
   * @param col  The column index.
   * @param targetRow  The row where the piece lands.
   * @param player  The player number.
   * @param onComplete  Runs when animation finishes.
   */
  public void animateDrop(int col, int targetRow, int player, ActionListener onComplete)
  {
    disableColumnButtons();

    Timer timer = new Timer(40, new ActionListener()
    {
      int currentRow = 0;

      @Override
      public void actionPerformed(ActionEvent e)
      {
        if (currentRow > 0)
        {
          boardLabels[currentRow - 1][col].setBackground(Color.WHITE);
        }
        if (player == 1)
        {
          boardLabels[currentRow][col].setBackground(Color.RED);
        }
        else
        {
          boardLabels[currentRow][col].setBackground(Color.YELLOW);
        }
        if (currentRow == targetRow)
        {
          ((Timer)e.getSource()).stop();
          onComplete.actionPerformed(null);
        }
        else
        {
          currentRow++;
        }
      }
    });
    timer.start();
  }

  /**
   * Disable all column buttons when game is over.
   */
  private void disableColumnButtons()
  {
    for (int i = 0; i < COLS; i++)
    {
      columnButtons[i].setEnabled(false);
    }
  }

  /**
   * New game, enables all column buttons.
   */
  public void enableColumnButtons()
  {
    for (int i = 0; i < COLS; i++)
    {
      columnButtons[i].setEnabled(true);
    }
  }

  /**
   * Error message for full column.
   */
  public void showColumnFullError()
  {
    JOptionPane.showMessageDialog(frame, "Column is full, choose another column",
                                  "Invalid move", JOptionPane.WARNING_MESSAGE);
  }
}

