

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import kar.expression.parser.Expression;
import kar.expression.parser.ExpressionParser;
import kar.expression.parser.Infix;
import kar.expression.parser.MalformedExpressionException;

public class ExpressionParserMain {

	public static void main(String args[]) {
		BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption("i", true, "input expression");
		options.addOption("to", true, "convert input expression to postfix/prefix");
		//options.addOption("eval", true, "evaluate input expression");
		printHelp();
		while(true) {
			try {
				String commandLineString = "";
				try {
					commandLineString = commandLineReader.readLine();
				} catch (IOException e) {
					continue;
				}
				if(commandLineString.trim().length() == 0)
					continue;
				if(commandLineString.equalsIgnoreCase("quit"))
					break;
				String[] commandArgs = commandLineString.split(" ");
				CommandLine command = parser.parse(options, commandArgs);
				if(command.hasOption("i")) {
					String inputExpression = command.getOptionValue("i");
					if(command.hasOption("to")) {
						String conversion = command.getOptionValue("to");
						if(conversion != null) {
							if(conversion.equals("postfix")) {
								convertToPostFix(inputExpression);
							}else if(conversion.equals("prefix")) {
								convertToPreFix(inputExpression);
							}else {
								System.out.println("Invalid value for conversion");
							}
						} else {
							System.out.println("Value for conversion option missing");
						}
					}else {
						System.out.println("Conversion option missing");
					}
				}else {
					System.out.println("Input expression missing");
				}
			} catch (ParseException e) {
				printHelp();
			} catch (MalformedExpressionException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	private static void printHelp() {
		System.out.println("Usage 1: -i <input-expression> -to <postfix/prefix/infix>");
		//System.out.println("Usage 2: -i <input-expression> -eval");
		System.out.println("Usage 2: quit");
	}
	
	private static void convertToPostFix(String inputExpression) throws MalformedExpressionException {
		ExpressionParser expressionParser = new ExpressionParser(new Infix(inputExpression));
		Expression postFixExpression = expressionParser.toPostfix();
		System.out.println(postFixExpression);
	}
	
	private static void convertToPreFix(String inputExpression) throws MalformedExpressionException {
		ExpressionParser expressionParser = new ExpressionParser(new Infix(inputExpression));
		Expression preFixExpression = expressionParser.toPrefix();
		System.out.println(preFixExpression);
	}
}
