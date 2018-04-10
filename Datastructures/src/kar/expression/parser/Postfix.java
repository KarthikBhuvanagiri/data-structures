package kar.expression.parser;

import kar.ds.stack.Stack;

public class Postfix implements Expression {

	private String expression;
	
	public Postfix(String expression) {
		this.expression = expression.trim();
	}
	
	@Override
	public double evaluate() {
		Stack stack = new Stack();
		String[] expressionTokens = expression.split(" ");
		for(int i=0; i<expressionTokens.length; i++) {
			String token = expressionTokens[i];
			char tokenChar = token.charAt(0);
			if(ExpressionParser.isOperand(tokenChar)) {
				stack.push(Double.parseDouble(token));
			}else if (ExpressionParser.isOperator(tokenChar)) {
				double op2 = (double) stack.pop();
				double op1 = (double) stack.pop();
				stack.push(calculate(op1, op2, tokenChar));
			}
		}
		
		return (double) stack.pop();
	}
	
	private double calculate(double op1, double op2, char operator) {
		double result = 0;
		switch(operator) {
		case '+':
			result = op1 + op2;
			break;
		case '-':
			result = op1 - op2;
			break;
		case '*':
			result = op1 * op2;
			break;
		case '/':
			result = op1 / op2;
			break;
		case '^':
			result = Math.pow(op1, op2);
			break;
		}
		return result;
	}

	@Override
	public String getExpression() {
		return expression;
	}
	
	@Override
	public String toString() {
		return expression;
	}

}
