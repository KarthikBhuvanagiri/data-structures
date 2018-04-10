package kar.expression.parser;

public class Infix implements Expression {

	private String expression;
	
	public Infix(String expression) throws MalformedExpressionException {
		if(expression == null)
			throw new MalformedExpressionException("Null expression!!");
		
		this.expression = expression.trim();
		int expressionLength = expression.length();
		if(expressionLength == 0)
			throw new MalformedExpressionException("Empty expression!!");
		
		int noOfParanthesis = 0;
		for(int i=0; i<expressionLength; i++) {
			char charAti = expression.charAt(i);
			if(charAti == '(')
				noOfParanthesis++;
			else if(charAti == ')')
				noOfParanthesis--;
		}
		
		if(noOfParanthesis != 0)
			throw new MalformedExpressionException("Paranthesis mismatch!!");
	}
	
	@Override
	public String getExpression() {
		return expression;
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return expression;
	}

}
