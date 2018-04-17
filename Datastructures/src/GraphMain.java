import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import kar.ds.graph.AdjacencyList;
import kar.ds.graph.Graph;

public class GraphMain {

	private static Graph graph = new AdjacencyList();
	
	public static void main(String[] args) {
		Options options = getOptions();
		BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));
		CommandLineParser parser = new DefaultParser();
		printHelp();
		while(true) {
			try {
				String[] commandArgs = commandLineReader.readLine().trim().split(" ");
				CommandLine commandLine = parser.parse(options, commandArgs);
				if(commandLine.hasOption("-c")) {
					
				}else if(commandLine.hasOption("-r")) {
					
				}else if(commandLine.hasOption("ae")) {
					
				}else if(commandLine.hasOption("re")) {
					
				}else if(commandLine.hasOption("p")) {
					
				}else if(commandLine.hasOption("h")) {
					printHelp();
				}else if(commandLine.hasOption("q")) {
					break;
				}else {
					System.out.println("Invalid option");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void handleCreate(CommandLine cl) {
		
	}
	
	public static void handleRemove(CommandLine cl) {
		
	}
	
	public static void handleAddEdge(CommandLine cl) {
		
	}
	
	public static void handleRemoveEdge(CommandLine cl) {
		
	}
	
	public static void handlePrint(CommandLine cl) {
		
	}
	
	public static Options getOptions() {
		Options options = new Options();
		
		Option create = new Option("c", true, "List of vertices");
		create.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(create);
		
		Option remove = new Option("r", true, "List of vertices");
		remove.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(remove);
		
		options.addOption("ae", false, "Add edge");
		options.addOption("re", false, "Remove edge");
		
		Option betweenVertices = new Option("b", true, "Between vertices");
		betweenVertices.setArgs(2);
		options.addOption(betweenVertices);
		
		options.addOption("f", true, "From vertex");
		options.addOption("t", true, "To vertex");
		options.addOption("p", false, "Print");
		options.addOption("adj", true, "Adjacent");
		options.addOption("size", false, "Size of graph");
		options.addOption("graph", false, "Graph");
		options.addOption("h", false, "Help");
		options.addOption("q", false, "Quit");
		
		return options;
	}
	
	public static void printHelp() {
		System.out.println("-c -v v1 v2 v3 ... vn\tCreates graph with given list of vertices");
		System.out.println("-r -v v1 v2 v3 ... vn\tRemove given list of vertices from graph");
		System.out.println("-ae -b vx vy\t\tAdds an edge between vertices vx & vy");
		System.out.println("-re -b vx vy\t\tAdds an edge between vertices vx & vy");
		System.out.println("-ae -f vx -t vy\t\tAdds directed edge from vertex vx to vertex vy");
		System.out.println("-re -f vx -t vy\t\tAdds directed edge from vertex vx to vertex vy");
		System.out.println("-p -adj vx\t\tPrints adjacent vertices of vx");
		System.out.println("-p -size\t\tPrints size of graph");
		System.out.println("-p -graph\t\tPrints current graph");
		System.out.println("-h\t\t\tPrints this help");
		System.out.println("-q\t\t\tQuit");
	}

}
