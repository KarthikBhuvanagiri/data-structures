package kar.graph.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kar.ds.graph.Graph;
import kar.ds.stack.Stack;

public class GraphUtils {

	public static Object[] traverseByRecursiveDFS(Graph graph, Object startingVertex) {
		ArrayList visitedVertices = new ArrayList();
		recursiveDFS(graph, startingVertex, visitedVertices);
		return visitedVertices.toArray();
	}
	
	private static void recursiveDFS(Graph graph, Object vertex, List visitedVertices) {
		visitedVertices.add(vertex);
		Set adjacentVertices = graph.getAdjacentVerticesOf(vertex);
		for(Object adjacentVertex : adjacentVertices) {
			if(!visitedVertices.contains(adjacentVertex))
				recursiveDFS(graph, adjacentVertex, visitedVertices);
		}
	}
	
	public static Object[] traverseByIterativeDFS(Graph graph, Object startingVertex) {
		ArrayList visitedVertices = new ArrayList();
		Stack stack = new Stack();
		stack.push(startingVertex);
		while(!stack.isEmpty()) {
			Object vertex = stack.pop();
			if(!visitedVertices.contains(vertex)) {
				visitedVertices.add(vertex);
				Set adjacentVertices = graph.getAdjacentVerticesOf(vertex);
				for(Object adjacentVertex : adjacentVertices) {
					stack.push(adjacentVertex);
				}
			}
		}
		return visitedVertices.toArray();
	}

}
