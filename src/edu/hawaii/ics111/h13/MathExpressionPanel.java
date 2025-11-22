package edu.hawaii.ics111.h13;

import javax.swing.JPanel;
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
      expressions[i] = new MathExpression(operandA, operandB, operator);

    }
  }
}
