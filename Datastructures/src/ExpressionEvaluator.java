import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import kar.expression.parser.Infix;
import kar.expression.parser.MalformedExpressionException;
import kar.expression.parser.Postfix;
import kar.expression.parser.Prefix;

public class ExpressionEvaluator {

	public static void main(String args[]) {
		BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));
		CommandLineParser parser = new DefaultParser();
		
		Options options = new Options();
		options.addOption("infix", true, "Infix expression");
		
		Option postfixOption = new Option("postfix", true, "Postfix expression");
		postfixOption.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(postfixOption);
		
		Option prefixOption = new Option("prefix", true, "Prefix expression");
		prefixOption.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(prefixOption);
		
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
				double result = 0;
				if(command.hasOption("infix")) {
					String infixExpression = command.getOptionValue("infix");
					if(infixExpression != null) {
						result = new Infix(infixExpression).evaluate();
					}else {
						System.out.println("Infix expression missing");
					}
				}else if(command.hasOption("postfix")) {
					String[] values = command.getOptionValues("postfix");
					StringBuilder strBuilder = new StringBuilder();
					for(String val : values) {
						strBuilder.append(val+" ");
					}
					String postfixExpression = strBuilder.toString();
					if(postfixExpression != null) {
						result = new Postfix(postfixExpression).evaluate();
					}else {
						System.out.println("Postfix expression missing");
					}
				}else if(command.hasOption("prefix")) {
					String[] values = command.getOptionValues("prefix");
					StringBuilder strBuilder = new StringBuilder();
					for(String val : values) {
						strBuilder.append(val+" ");
					}
					String prefixExpression = strBuilder.toString();
					if(prefixExpression != null) {
						result = new Prefix(prefixExpression).evaluate();
					}else {
						System.out.println("Prefix expression missing");
					}
				}else {
					System.out.println("Invalid option");
				}
				
				System.out.println("Result: "+result);
			}catch(ParseException e) {
				printHelp();
			} catch (MalformedExpressionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void printHelp() {
		System.out.println("Usage 1: -infix <infix-expression>");
		System.out.println("Usage 2: -postfix <post-expression>");
		System.out.println("Usage 3: -prefix <prefix-expression>");
	}
}
