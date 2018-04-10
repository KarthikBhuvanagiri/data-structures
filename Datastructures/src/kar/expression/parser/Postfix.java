package kar.expression.parser;

public class Postfix implements Expression {

	private String expression;
	
	public Postfix(String expression) {
		this.expression = expression.trim();
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
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
