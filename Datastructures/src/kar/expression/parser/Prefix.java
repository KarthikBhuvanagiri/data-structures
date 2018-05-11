package kar.expression.parser;

import kar.ds.stack.Stack;

public class Prefix implements Expression {

	private String expression;
	
	public Prefix(String expression) {
		this.expression = expression.trim();
	}
	
	@Override
	public double evaluate() {
		String expressionInReverse = new StringBuilder(expression).reverse().toString();
		Stack<Double> stack = new Stack<Double>();
		String[] expressionTokens = expressionInReverse.split(" ");
		for(int i=0; i<expressionTokens.length; i++) {
			String token = expressionTokens[i];
			char tokenChar = token.charAt(0);
			if(ExpressionParser.isOperand(tokenChar)) {
				stack.push(Double.parseDouble(token));
			}else if (ExpressionParser.isOperator(tokenChar)) {
				double op1 = stack.pop();
				double op2 = stack.pop();
				stack.push(calculate(op1, op2, tokenChar));
			}
		}
		
		return stack.pop();
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
