package edu.hawaii.ics111.h13;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Random;

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
    questionNumberLabel = new JLabel("Question 0");
    this.add(questionNumberLabel);
    answerField = new JTextField(10);
    this.add(answerField);
    submitButton = new JButton("Submit Answer");
    this.add(submitButton);
    nextButton = new JButton("Next Question");
    this.add(nextButton);
    previousButton = new JButton("Previous Question");
    this.add(previousButton);
    questionLabel = new JLabel(expressions[0].toString());
    this.add(questionLabel);

    currentQuestionIndex = 0;
  }
}
