package kar.expression.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ExpressionParserMain {

	public static void main(String args[]) {
		BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption("i", true, "input expression");
		options.addOption("to", true, "convert input expression to postfix/prefix/infix");
		options.addOption("eval", true, "evaluate input expression");
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
						if(conversion != null && conversion.equals("postfix")) {
							convertToPostFix(inputExpression);
						}else {
							System.out.println("Invalid value for conversion");
						}
					}else {
						System.out.println("Conversion option missing");
					}
				}else {
					System.out.println("Input expression missing");
				}
			} catch (ParseException e) {
				printHelp();
			}
		}
		
	}
	
	private static void printHelp() {
		System.out.println("Usage 1: -i <input-expression> -to <postfix/prefix/infix>");
		System.out.println("Usage 2: -i <input-expression> -eval");
		System.out.println("Usage 3: quit");
	}
	
	private static void convertToPostFix(String inputExpression) {
		ExpressionParser expressionParser = new ExpressionParser(inputExpression);
		String postFixExpression = expressionParser.toPostFix();
		System.out.println(postFixExpression);
	}
}
