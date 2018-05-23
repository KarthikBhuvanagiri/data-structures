import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import kar.ds.tree.BinarySearchTree;
import kar.ds.tree.BinaryTree;
import kar.ds.tree.Tree;

public class TreeMain {
	
	private static final String OPTION_CREATE = "create";
	private static final String OPTION_INSERT = "insert";
	private static final String OPTION_DELETE = "delete";
	private static final String OPTION_DELETE_LEFT_OF = "deleteLeftOf";
	private static final String OPTION_DELETE_RIGHT_OF = "deleteRightOf";
	private static final String OPTION_SEARCH = "search";
	private static final String OPTION_HEIGHT_OF = "heightOf";
	private static final String OPTION_TRAVERSE = "traverse";
	private static final String OPTION_RESET = "reset";
	private static final String OPTION_QUIT = "quit";
	private static final String OPTION_TREE_TYPE = "t";
	private static final String OPTION_NODES = "n";
	private static final String OPTION_LEFT_OF = "l";
	private static final String OPTION_RIGHT_OF = "r";
	
	private static final String LEVEL_ORDER = "lo";
	private static final String IN_ORDER = "io";
	private static final String PRE_ORDER = "preO";
	private static final String POST_ORDER = "postO";
	
	private static final String BINARY_TREE_KIND = "bt";
	private static final String BINARY_SEARCH_TREE_KIND = "bst";
	
	private static final String TYPE_INT = "int";
	private static final String TYPE_DECIMAL = "decimal";
	private static final String TYPE_STRING = "string";
			
	private static Tree tree;
	private static String type = TYPE_STRING;

	public static void main(String[] args) {
		Options options = getOptions();
		BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));
		CommandLineParser parser = new DefaultParser();
		printHelp();
		while(true) {
			String[] commandArgs;
			try {
				commandArgs = commandLineReader.readLine().trim().split(" ");
				CommandLine commandLine = parser.parse(options, commandArgs);
				if(commandLine.hasOption(OPTION_CREATE)) {
					handleCreateOption(commandLine);
				}else if(commandLine.hasOption(OPTION_INSERT)) {
					handleInsertOption(commandLine);
				}else if(commandLine.hasOption(OPTION_DELETE)) {
					handleDeleteOption(commandLine);
				}else if(commandLine.hasOption(OPTION_DELETE_LEFT_OF)) {
					handleDeleteLeftOfOption(commandLine);
				}else if(commandLine.hasOption(OPTION_DELETE_RIGHT_OF)) {
					handleDeleteRightOfOption(commandLine);
				}else if(commandLine.hasOption(OPTION_SEARCH)) {
					handleSearchOption(commandLine);
				}else if(commandLine.hasOption(OPTION_HEIGHT_OF)) {
					handleHeightOfOption(commandLine);
				}else if(commandLine.hasOption(OPTION_TRAVERSE)) {
					handleTraverseOption(commandLine);
				} else if(commandLine.hasOption(OPTION_RESET)) {
					handleResetOption(commandLine);
				}else if(commandLine.hasOption(OPTION_QUIT)){
					break;
				}else {
					System.out.println("Invalid option");
				}
			} catch (IOException | ParseException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void handleHeightOfOption(CommandLine commandLine) {
		String node = commandLine.getOptionValue(OPTION_HEIGHT_OF);
		if(tree != null) {
			int height;
			if(type.equals(TYPE_INT)) {
				height = tree.getHeightOf(Integer.parseInt(node));
			}else if(type.equals(TYPE_DECIMAL)) {
				height = tree.getHeightOf(Double.parseDouble(node));
			}else {
				height = tree.getHeightOf(node);
			}
			System.out.println("Height of node "+node+": "+height);
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}
	
	private static void handleTraverseOption(CommandLine commandLine) {
		String traverse = commandLine.getOptionValue(OPTION_TRAVERSE);
		if(tree != null) {
			Object[] nodes = null;
			if(traverse.equals(LEVEL_ORDER)) {
				nodes = tree.traverseLevelOrder();
				System.out.println("Level Order traversal: "+(nodes != null ? Arrays.asList(nodes) : null));
			}else if(traverse.equals(PRE_ORDER)) {
				nodes = tree.traversePreOrder();
				System.out.println("Pre Order traversal: "+(nodes != null ? Arrays.asList(nodes) : null));
			}else if(traverse.equals(IN_ORDER)) {
				nodes = tree.traverseInOrder();
				System.out.println("In Order traversal: "+(nodes != null ? Arrays.asList(nodes) : null));
			}else if(traverse.equals(POST_ORDER)) {
				nodes = tree.traversePostOrder();
				System.out.println("Post Order traversal: "+(nodes != null ? Arrays.asList(nodes) : null));
			}else {
				System.out.println("Invalid value for option \'"+OPTION_TRAVERSE+"\'");
			}
			
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}

	private static void handleSearchOption(CommandLine commandLine) {
		String nodeToSearch = commandLine.getOptionValue(OPTION_SEARCH);
		if(tree != null) {
			boolean found;
			if(type.equals(TYPE_INT)) {
				found = tree.search(Integer.parseInt(nodeToSearch));
			}else if(type.equals(TYPE_DECIMAL)) {
				found = tree.search(Double.parseDouble(nodeToSearch));
			}else {
				found = tree.search(nodeToSearch);
			}
			System.out.println(found ? "Found" : "Not Found");
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}

	private static void handleDeleteOption(CommandLine commandLine) {
		String nodeToDelete = commandLine.getOptionValue(OPTION_DELETE);
		if(tree != null) {
			if(type.equals(TYPE_INT)) {
				tree.delete(Integer.parseInt(nodeToDelete));
			}else if(type.equals(TYPE_DECIMAL)) {
				tree.delete(Double.parseDouble(nodeToDelete));
			}else {
				tree.delete(nodeToDelete);
			}
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}
	
	private static void handleDeleteLeftOfOption(CommandLine commandLine) {
		String node = commandLine.getOptionValue(OPTION_DELETE_LEFT_OF);
		if(tree != null) {
			if(tree instanceof BinaryTree) {
				((BinaryTree) tree).deleteLeftChildOf(node);
			}else {
				System.out.println("\'"+OPTION_DELETE_LEFT_OF+"\' option is not valid for binary search tree");
			}
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}
	
	private static void handleDeleteRightOfOption(CommandLine commandLine) {
		String node = commandLine.getOptionValue(OPTION_DELETE_RIGHT_OF);
		if(tree != null) {
			if(tree instanceof BinaryTree) {
				((BinaryTree) tree).deleteRightChildOf(node);
			}else {
				System.out.println("\'"+OPTION_DELETE_RIGHT_OF+"\' option is not valid for binary search tree");
			}
		}else {
			System.out.println("Tree is null. Use option \'"+OPTION_CREATE+"\' to build tree");
		}
	}

	private static void handleInsertOption(CommandLine commandLine) {
		String nodeToInsert = commandLine.getOptionValue(OPTION_INSERT);
		if(commandLine.hasOption(OPTION_LEFT_OF)) {
			if(tree instanceof BinaryTree)
				((BinaryTree) tree).insertAsLeftChildOf(commandLine.getOptionValue(OPTION_LEFT_OF), nodeToInsert);
			else
				System.out.println("Option \'"+OPTION_LEFT_OF+"\' is not valid for binary search tree");
		}else if(commandLine.hasOption(OPTION_RIGHT_OF)) {
			if(tree instanceof BinaryTree)
				((BinaryTree) tree).insertAsRightChildOf(commandLine.getOptionValue(OPTION_RIGHT_OF), nodeToInsert);
			else
				System.out.println("Option \'"+OPTION_RIGHT_OF+"\' is not valid for binary search tree");
		}else {
			insertNodes(new String[] {nodeToInsert});
		}
	}
	
	private static void handleCreateOption(CommandLine commandLine) {
		String treeKind = commandLine.getOptionValue(OPTION_CREATE);
		if(treeKind.equals(BINARY_TREE_KIND)) {
			createBinaryTree(commandLine);
		}else if(treeKind.equals(BINARY_SEARCH_TREE_KIND)) {
			createBinarySearchTree(commandLine);
		}else {
			System.out.println("Invalid value for option \'"+OPTION_CREATE+"\'");
		}
	}

	private static void createBinarySearchTree(CommandLine commandLine) {
		setType(commandLine);
		tree = new BinarySearchTree();
		insertNodes(commandLine.getOptionValues(OPTION_NODES));
	}

	private static void createBinaryTree(CommandLine commandLine) {
		tree = new BinaryTree();
		insertNodes(commandLine.getOptionValues(OPTION_NODES));
	}
	
	private static void setType(CommandLine commandLine) {
		type = commandLine.getOptionValue(OPTION_TREE_TYPE, TYPE_STRING);
		if(!type.equals(TYPE_INT) && !type.equals(TYPE_DECIMAL) && !type.equals(TYPE_STRING)) {
			System.out.println("Invalid value for option \'"+OPTION_TREE_TYPE+"\'");
			type = null;
		}
	}
	
	private static void insertNodes(String[] listOfNodes) {
		if(listOfNodes == null)
			return;
		
		for(String node : listOfNodes) {
			if(type.equals(TYPE_INT)) {
				tree.insert(Integer.parseInt(node));
			}else if(type.equals(TYPE_DECIMAL)) {
				tree.insert(Double.parseDouble(node));
			}else {
				tree.insert(node);
			}
		}
	}
	
	private static void handleResetOption(CommandLine commandLine) {
		tree = null;
	}

	private static void printHelp() {
		System.out.println("-create bt \t\t\t\t\t\tCreates empty binary tree");
		System.out.println("-create bst [-t int|decimal|string]\t\t\tCreates empty binary search tree");
		System.out.println("-create bt -n n1 n2 n3 ... \t\t\t\tCreates binary tree with list of nodes added in level order");
		System.out.println("-create bst [-t int|decimal|string] -n n1 n2 n3 ...  \tCreates binary search tree with list of nodes");
		System.out.println("-insert nx\t\t\t\t\t\tInserts node nx. In binary tree it is inserted in level order.");
		System.out.println("-insert nx -l ny\t\t\t\t\tInserts node nx as a left child of ny. Not valid in case of binary search tree");
		System.out.println("-insert nx -r ny\t\t\t\t\tInserts node nx as a right child of ny. Not valid in case of binary search tree");
		System.out.println("-delete nx\t\t\t\t\t\tDeletes node nx");
		System.out.println("-deleteLeftOf nx\t\t\t\t\t\tDeletes left child of node nx. Not valid in case of binary search tree");
		System.out.println("-deleteRightOf nx\t\t\t\t\t\tDeletes right child of node nx. Not valid in case of binary search tree");
		System.out.println("-search nx\t\t\t\t\t\tSearches node nx in the tree");
		System.out.println("-heightOf nx\t\t\t\t\t\tPrints height of node nx. If nx is not found, prints -1.");
		System.out.println("-traverse lo\t\t\t\t\t\tPrints nodes of tree in level order");
		System.out.println("-traverse io\t\t\t\t\t\tPrints nodes of tree in in-order");
		System.out.println("-traverse preO\t\t\t\t\t\tPrints nodes of tree in pre-order");
		System.out.println("-traverse postO\t\t\t\t\t\tPrints nodes of tree in post-order");
		System.out.println("-reset\t\t\t\t\t\t\tReset program");
		System.out.println("-quit\t\t\t\t\t\t\tQuit from program");
	}

	private static Options getOptions() {
		Options options = new Options();
		
		Option create = Option.builder(OPTION_CREATE).hasArg().desc("Create tree").build();
		Option treeDataType = Option.builder(OPTION_TREE_TYPE).hasArg().desc("Data Type of tree").build();
		Option nodes = Option.builder(OPTION_NODES).hasArgs().desc("List of nodes in tree").build();
		options.addOption(create);
		options.addOption(treeDataType);
		options.addOption(nodes);
		
		Option insert = Option.builder(OPTION_INSERT).hasArg().desc("Insert node").build();
		Option leftOf = Option.builder(OPTION_LEFT_OF).hasArg().desc("Left Of").build();
		Option rightOf = Option.builder(OPTION_RIGHT_OF).hasArg().desc("Right Of").build();
		options.addOption(insert);
		options.addOption(leftOf);
		options.addOption(rightOf);
		
		Option delete = Option.builder(OPTION_DELETE).hasArg().desc("Delete node").build();
		options.addOption(delete);
		
		Option deleteLeftOf = Option.builder(OPTION_DELETE_LEFT_OF).hasArg().desc("Delete left of").build();
		options.addOption(deleteLeftOf);
		
		Option deleteRightOf = Option.builder(OPTION_DELETE_RIGHT_OF).hasArg().desc("Delete right of").build();
		options.addOption(deleteRightOf);

		Option search = Option.builder(OPTION_SEARCH).hasArg().desc("Search node").build();
		options.addOption(search);
		
		Option traverse = Option.builder(OPTION_TRAVERSE).hasArg().desc("Traverse").build();
		Option height = Option.builder(OPTION_HEIGHT_OF).hasArg().desc("Height of").build();
		options.addOption(traverse);
		options.addOption(height);
		
		Option quit = Option.builder(OPTION_QUIT).desc("Quit").build();
		options.addOption(quit);
		
		Option reset = Option.builder(OPTION_RESET).desc("Reset program").build();
		options.addOption(reset);
		
		return options;
	}

}
