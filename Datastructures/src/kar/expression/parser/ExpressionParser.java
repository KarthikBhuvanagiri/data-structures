package kar.expression.parser;

import kar.ds.stack.Stack;

public class ExpressionParser {
	
	private Infix infixExpression;
	
	public ExpressionParser(Infix infixExpression) {
		this.infixExpression = infixExpression;
	}

	static boolean isOperand(char c) {
		boolean isOperand = true;
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '(':
		case ')':
			isOperand = false;
		}
		return isOperand;
	}
	
	static boolean isOperator(char c) {
		boolean isOperator = false;
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			isOperator = true;
		}
		return isOperator;
	}
	
	private int checkOperatorPrecendence(Character op1, Character op2) {
		int precendence = 0;
		if(op1 == '^') {
			switch(op2) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '(':
			case ')':
				precendence = 1;
				break;
			}
		}else if(op1 == '*' || op1 == '/') {
			switch(op2) {
			case '^':
				precendence = -1;
				break;
			case '+':
			case '-':
			case '(':
			case ')':
				precendence = 1;
				break;
			}
		}else if(op1 == '+' || op1 == '-') {
			switch(op2) {
			case '^':
			case '*':
			case '/':
				precendence = -1;
				break;
			case '(':
			case ')':
				precendence = 1;
				break;
			}
		}
		return precendence;
	}
	
	public Expression toPostfix() {
		String postFixExpression = "";
		String expression = infixExpression.getExpression();
		int noOfChars = expression.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<noOfChars; i++) {
			char c = expression.charAt(i);
			if(isOperand(c)) {
				postFixExpression = postFixExpression + c + " ";
			}else if(isOperator(c)){
				if(stack.isEmpty()) {
					stack.push(c);
				}else {
					int scannedOperatorPrecedence = checkOperatorPrecendence(c, (Character) stack.peek());
					if(scannedOperatorPrecedence == 1) {
						stack.push(c);
					}else {
						while(!stack.isEmpty() && checkOperatorPrecendence(c, (Character) stack.peek()) < 1) {
							char operatorInStack = stack.pop();
//							if(operatorInStack == '(')
//								break;
							postFixExpression = postFixExpression + operatorInStack + " ";
						}
						stack.push(c);
					}
				}
			}else if(c == '(') {
				stack.push(c);
			}else if(c == ')') {
				while(!stack.isEmpty()) {
					char operatorInStack = stack.pop();
					if(operatorInStack == '(') {
						break;
					}else {
						postFixExpression = postFixExpression + operatorInStack + " ";
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			char itemInStack = stack.pop();
			postFixExpression = postFixExpression + itemInStack + " ";
		}
		
		return new Postfix(postFixExpression);
	}
	
	public Expression toPrefix() throws MalformedExpressionException {
		String expression = infixExpression.getExpression();
		StringBuilder expressionInReverse = new StringBuilder(expression).reverse();
		int noOfChars = expressionInReverse.length();
		for(int i=0; i<noOfChars; i++) {
			char charAti = expressionInReverse.charAt(i);
			if(charAti == '(') {
				expressionInReverse.setCharAt(i, ')');
			}else if(charAti == ')') {
				expressionInReverse.setCharAt(i, '(');
			}
		}
		String reverseExpression = expressionInReverse.toString();
		ExpressionParser expressionParser = new ExpressionParser(new Infix(reverseExpression));
		String postfixExpression = expressionParser.toPostfix().getExpression();
		String prefixExpression = new StringBuilder(postfixExpression).reverse().toString();
		return new Prefix(prefixExpression);
	}
}
