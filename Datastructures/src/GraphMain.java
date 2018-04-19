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
import kar.ds.graph.GraphException;
import kar.graph.utils.GraphUtils;

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
				if(commandLine.hasOption("c")) {
					handleCreate(commandLine);
				}else if(commandLine.hasOption("r")) {
					handleRemove(commandLine);
				}else if(commandLine.hasOption("ae")) {
					handleAddEdge(commandLine);
				}else if(commandLine.hasOption("re")) {
					handleRemoveEdge(commandLine);
				}else if(commandLine.hasOption("p")) {
					if(commandLine.hasOption("adj")) {
						printAdjacentVertices(commandLine);
					}else if(commandLine.hasOption("size")) {
						printGraphSize();
					}else if(commandLine.hasOption("graph")) {
						printGraph();
					}else {
						System.out.println("Invalid option or arguments to print");
					}
				}else if(commandLine.hasOption("dfs")) {
					handleDFS(commandLine);
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
			} catch (GraphException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void handleDFS(CommandLine cl) {
		String dfsStrategy = cl.getOptionValue("dfs");
		if(dfsStrategy != null && (dfsStrategy = dfsStrategy.trim()).length() != 0) {
			if(dfsStrategy.equals("r")) {
				handleRecursiveDFS(cl);
			}else if(dfsStrategy.equals("i")) {
				handleIterativeDFS(cl);
			}else {
				System.out.println("Invalid argument for option dfs");
			}
		}else {
			System.out.println("Argument missing for option dfs");
		}
	}
	
	private static void handleRecursiveDFS(CommandLine cl) {
		String startingVertex = cl.getOptionValue("f");
		if(startingVertex != null && (startingVertex = startingVertex.trim()).length() != 0) {
			Object[] traversedVertices = GraphUtils.traverseByRecursiveDFS(graph, startingVertex);
			String out = "";
			for(Object traversedVertex : traversedVertices) {
				out = out + " " + traversedVertex;
			}
			System.out.println("Traversed vertices by recursive DFS : "+out);
		}else {
			System.out.println("Starting vertex missing for recursive DFS");
		}
	}
	
	private static void handleIterativeDFS(CommandLine cl) {
		String startingVertex = cl.getOptionValue("f");
		if(startingVertex != null && (startingVertex = startingVertex.trim()).length() != 0) {
			Object[] traversedVertices = GraphUtils.traverseByIterativeDFS(graph, startingVertex);
			String out = "";
			for(Object traversedVertex : traversedVertices) {
				out = out + " " + traversedVertex;
			}
			System.out.println("Traversed vertices by iterative DFS : "+out);
		}else {
			System.out.println("Starting vertex missing for iterative DFS");
		}
	}
	
	private static void handleCreate(CommandLine cl) {
		String[] vertices = cl.getOptionValues("c");
		graph.addVertices(vertices);
	}
	
	private static void handleRemove(CommandLine cl) {
		String[] vertices = cl.getOptionValues("r");
		graph.removeVertices(vertices);
	}
	
	private static void handleAddEdge(CommandLine cl) {
		String[] vertices = cl.getOptionValues("b");
		if(vertices!=null) {
			if(vertices.length < 2) {
				System.out.println("Number of vertices must be two to add an edge between them");
			}else {
				graph.addEdgeBetween(vertices[0], vertices[1]);
			}
		}else {
			String fromVertex = cl.getOptionValue("f");
			if(fromVertex != null && (fromVertex = fromVertex.trim()).length() > 0) {
				String toVertex = cl.getOptionValue("t");
				if(toVertex != null && (toVertex = toVertex.trim()).length() > 0) {
					graph.addEdgeFrom(fromVertex, toVertex);
				}else {
					System.out.println("Argument missing for option -t");
				}
			}else {
				System.out.println("Argument missing for option -f");
			}
		}
	}
	
	private static void handleRemoveEdge(CommandLine cl) {
		String[] vertices = cl.getOptionValues("b");
		if(vertices!=null) {
			if(vertices.length < 2) {
				System.out.println("Number of vertices must be two to remove an edge between them");
			}else {
				graph.removeEdgeBetween(vertices[0], vertices[1]);
			}
		}else {
			String fromVertex = cl.getOptionValue("f");
			if(fromVertex != null && (fromVertex = fromVertex.trim()).length() > 0) {
				String toVertex = cl.getOptionValue("t");
				if(toVertex != null && (toVertex = toVertex.trim()).length() > 0) {
					graph.removeEdgeFrom(fromVertex, toVertex);
				}else {
					System.out.println("Argument missing for option -t");
				}
			}else {
				System.out.println("Argument missing for option -f");
			}
		}
	}
	
	private static Options getOptions() {
		Options options = new Options();
		
		Option create = new Option("c", true, "List of vertices");
		create.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(create);
		
		Option remove = new Option("r", true, "List of vertices");
		remove.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(remove);
		
		Option addEdge = new Option("ae", false, "Add Edge");
		options.addOption(addEdge);
		
		Option removeEdge = new Option("re", false, "Remove Edge");
		options.addOption(removeEdge);
		
		Option between = new Option("b", true, "Between vertices");
		between.setArgs(2);
		options.addOption(between);
		
		options.addOption("f", true, "From vertex");
		options.addOption("t", true, "To vertex");
		options.addOption("p", false, "Print");
		options.addOption("adj", true, "Adjacent");
		options.addOption("size", false, "Size of graph");
		options.addOption("graph", false, "Graph");
		options.addOption("dfs", true, "Depth-First Search");
		options.addOption("h", false, "Help");
		options.addOption("q", false, "Quit");
		
		return options;
	}
	
	private static void printAdjacentVertices(CommandLine cl) {
		String vertex = cl.getOptionValue("adj");
		if(vertex != null && (vertex = vertex.trim()).length() != 0) {
			System.out.println("Adjacent vertices of "+vertex+": "+graph.getAdjacentVerticesOf(vertex));
		} else {
			System.out.println("Argument missing to print adjacent vertices");
		}
	}
	
	private static void printGraphSize() {
		System.out.println("Size of graph: "+graph.getNumberOfVertices());
	}
	
	private static void printGraph() {
		System.out.println(graph.toString());
	}
	
	private static void printHelp() {
		System.out.println("-c v1 v2 v3 ... vn\tCreates graph with given list of vertices");
		System.out.println("-r v1 v2 v3 ... vn\tRemove given list of vertices from graph");
		System.out.println("-ae -b vx vy\t\tAdds an edge between vertices vx & vy");
		System.out.println("-re -b vx vy\t\tAdds an edge between vertices vx & vy");
		System.out.println("-ae -f vx -t vy\t\tAdds directed edge from vertex vx to vertex vy");
		System.out.println("-re -f vx -t vy\t\tAdds directed edge from vertex vx to vertex vy");
		System.out.println("-p -adj vx\t\tPrints adjacent vertices of vx");
		System.out.println("-p -size\t\tPrints size of graph");
		System.out.println("-p -graph\t\tPrints current graph");
		System.out.println("-dfs r -f vx\t\tTraverse by Depth-First Search from given vertex recursively");
		System.out.println("-dfs i -f vx\t\tTraverse by Depth-First Search from given vertex iteratively");
		System.out.println("-h\t\t\tPrints this help");
		System.out.println("-q\t\t\tQuit");
	}

}
