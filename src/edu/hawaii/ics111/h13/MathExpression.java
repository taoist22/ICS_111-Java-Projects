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

  public getOperandA()
  {
    return operandA;
  }

  public getOperandB()
  {
    return operandB;
  }

  public getOperator()
  {
    return operator;
  }
}
