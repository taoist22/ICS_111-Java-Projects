package edu.hawaii.ics111.h13;

/**
 * A Flash Card program in Java.
 *
 * @author CT Reatherford.
 */
public class MathExpression {
  /**
   * Instance variable for the first operand of the expression.
   */
  private int operandA;

  /**
   * Instance variable for the second operand of the expression.
   */
  private int operandB;

  /**
   * Instance variable for the operator of the expression.
   */
  private String operator;

  /**
   * Constructor for the MathExpression class.
   * 
   * @param operandA The first operand of the expression.
   * @param operandB The second operand of the expression.
   * @param operator The operator of the expression.
   */
  public MathExpression(int operandA, int operandB, String operator) {
    this.operandA = operandA;
    this.operandB = operandB;
    this.operator = operator;
  }

  /**
   * Getter for the first operand of the expression.
   *
   * @return The first operand of the expression.
   */
  public int getOperandA() {
    return this.operandA;
  }

  /**
   * Getter for the second operand of the expression.
   *
   * @return The second operand of the expression.
   */
  public int getOperandB() {
    return this.operandB;
  }

  /**
   * Getter for the operator of the expression.
   *
   * @return The operator of the expression.
   */
  public String getOperator() {
    return this.operator;
  }

  /**
   * Method to calculate the result of the expression.
   * 
   * @return The result of the expression.
   * @throws IllegalArgumentException If the operator is not supported.
   */
  public int calculate() {
    switch (operator) {
      case "+":
        return operandA + operandB;
      case "-":
        return operandA - operandB;
      case "*":
        return operandA * operandB;
      case "/":
        return operandA / operandB;
      case "%":
        return operandA % operandB;
      default:
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }
}
