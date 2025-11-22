package edu.hawaii.ics111.h13;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Create a panel for MathExpression class.
 *
 * @author CT Reatherford.
 */
public class MathExpressionPanel extends JPanel {
  /**
   * Array of MathExpression objects to hold the expressions.
   */
  private MathExpression[] expressions;
  /**
   * Array to hold the user's answers to the expressions.
   */
  private int[] userAnswers;
  /**
   * Instance variable to track the current question index.
   */
  private int currentQuestionIndex;
  /**
   * Constant for the number of questions to ask.
   */
  private static final int NUM_QUESTIONS = 10;
  /**
   * Label to display the current question.
   */
  private JLabel questionLabel;
  /**
   * Label to display the question number.
   */
  private JLabel questionNumberLabel;
  /**
   * TextField to enter the user's answer.
   */
  private JTextField answerField;

  /**
   * Button to submit the user's answer.
   */
  private JButton submitButton;
  /**
   * Button to move to the next question.
   */
  private JButton nextButton;
  /**
   * Button to move to the previous question.
   */
  private JButton previousButton;

  /**
   * Constructor for the MathExpressionPanel class.
   */
  public MathExpressionPanel() {
    super();

    userAnswers = new int[NUM_QUESTIONS];

    Random generator = new Random();

    expressions = new MathExpression[NUM_QUESTIONS];

    for (int i = 0; i < NUM_QUESTIONS; i++) {
      String[] operators = { "+", "-", "*", "/", "%" };

      int operandA = generator.nextInt(20);
      int operandB = generator.nextInt(20);
      String operator = operators[generator.nextInt(5)];

      if ((operator.equals("%") || operator.equals("/")) && operandB == 0) {
        operandB = generator.nextInt(20) + 1;
      }
      expressions[i] = new MathExpression(operandA, operandB, operator);

    }
    /**
     * Initialize the GUI components.
     */
    questionNumberLabel = new JLabel("Question 0");
    questionLabel = new JLabel(expressions[0].toString());
    answerField = new JTextField(10);

    submitButton = new JButton("Submit Answer");
    nextButton = new JButton("Next Question");
    previousButton = new JButton("Previous Question");
    /**
     * Create a subpanel for buttons.
     */
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(previousButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(submitButton);

    /**
     * Set up the GridBagLayout.
     */
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(10, 10, 10, 10);
    c.gridx = 0;

    /**
     * Add components
     */
    c.gridx = 0;
    this.add(questionNumberLabel, c);

    c.gridy = 1;
    this.add(questionLabel, c);

    c.gridy = 2;
    this.add(answerField, c);

    c.gridy = 3;
    this.add(buttonPanel, c);

    currentQuestionIndex = 0;
  }

  /**
   * Method to update labels and text fields based on the current question index.
   * This method uses answerField.requestFocus to automatically place the cursor
   * in the input box.
   * Reference: https://docs.oracle.com/javase/tutorial/uiswing/misc/focus.html.
   */
  private void updateDisplay() {
    questionNumberLabel.setText("Question " + currentQuestionIndex);

    questionLabel.setText(expressions[currentQuestionIndex].toString());

    if (userAnswers[currentQuestionIndex] != 0) {
      answerField.setText(Integer.toString(userAnswers[currentQuestionIndex]));
    } else {
      answerField.setText("");
    }

    answerField.requestFocus();
  }

  private void saveAnswer() {
    try {
      userAnswers[currentQuestionIndex] = Integer.parseInt(answerField.getText());
    } catch (NumberFormatException e) {
      userAnswers[currentQuestionIndex] = 0;
    }

    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        saveAnswer();
        currentQuestionIndex++;
        if (currentQuestionIndex >= NUM_QUESTIONS) {
          currentQuestionIndex = 0;
        }
        updateDisplay();
      }
    });

    previousButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        saveAnswer();
        currentQuestionIndex--;
        if (currentQuestionIndex < 0) {
          currentQuestionIndex = NUM_QUESTIONS - 1;
        }
        updateDisplay();
      }
    });
  }
}
