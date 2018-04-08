package kar.expression.parser;

import kar.ds.stack.Stack;

public class ExpressionParser {
	
	private String expression;
	
	public ExpressionParser(String expression) {
		this.expression = expression.trim();
	}

	private boolean isOperand(char c) {
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
	
	private boolean isOperator(char c) {
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
	
	public String toPostFix() {
		String postFixExpression = "";
		int noOfChars = expression.length();
		Stack stack = new Stack();
		for(int i=0; i<noOfChars; i++) {
			char c = expression.charAt(i);
			if(isOperand(c)) {
				postFixExpression = postFixExpression + c;
			}else if(isOperator(c)){
				if(stack.isEmpty()) {
					stack.push(c);
				}else {
					int scannedOperatorPrecedence = checkOperatorPrecendence(c, (Character) stack.peek());
					if(scannedOperatorPrecedence == 1) {
						stack.push(c);
					}else {
						while(!stack.isEmpty() && checkOperatorPrecendence(c, (Character) stack.peek()) < 1) {
							char operatorInStack = (char) stack.pop();
//							if(operatorInStack == '(')
//								break;
							postFixExpression = postFixExpression + operatorInStack;
						}
						stack.push(c);
					}
				}
			}else if(c == '(') {
				stack.push(c);
			}else if(c == ')') {
				while(!stack.isEmpty()) {
					char operatorInStack = (char) stack.pop();
					if(operatorInStack == '(') {
						break;
					}else {
						postFixExpression = postFixExpression + operatorInStack;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			char itemInStack = (char) stack.pop();
			if(itemInStack == '(' || itemInStack == ')') {
				postFixExpression = "Parenthesis mismatch!!";
				break;
			}else {
				postFixExpression = postFixExpression + itemInStack;
			}
		}
		
		return postFixExpression;
	}
}
