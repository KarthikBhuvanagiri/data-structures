package kar.graph.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kar.ds.graph.Graph;
import kar.ds.queue.Queue;
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
		if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
			for(Object adjacentVertex : adjacentVertices) {
				if(!visitedVertices.contains(adjacentVertex))
					recursiveDFS(graph, adjacentVertex, visitedVertices);
			}
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
				if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
					for(Object adjacentVertex : adjacentVertices) {
						stack.push(adjacentVertex);
					}
				}
			}
		}
		return visitedVertices.toArray();
	}
	
	public static Object[] traverseByIterativeBFS(Graph graph, Object startingVertex) {
		ArrayList visitedVertices = new ArrayList();
		Queue queue = new Queue();
		queue.enqueue(startingVertex);
		while(!queue.isEmpty()) {
			Object vertex = queue.dequeue();
			if(!visitedVertices.contains(vertex)) {
				visitedVertices.add(vertex);
				Set adjacentVertices = graph.getAdjacentVerticesOf(vertex);
				if(adjacentVertices !=null && !adjacentVertices.isEmpty()) {
					for(Object adjacentVertex : adjacentVertices) {
						queue.enqueue(adjacentVertex);
					}
				}
			}
		}
		return visitedVertices.toArray();
	}
	
	public static Object[] traverseByRecursiveBFS(Graph graph, Object startingVertex) {
		ArrayList visitedVertices = new ArrayList();
		recursiveBFS(graph, startingVertex, visitedVertices);
		return visitedVertices.toArray();
	}
	
	private static void recursiveBFS(Graph graph, Object vertex, List visitedVertices) {
		/*if(!visitedVertices.contains(vertex))
			visitedVertices.add(vertex);
		Set adjacentVertices = graph.getAdjacentVerticesOf(vertex);
		for(Object adjacentVertex : adjacentVertices) {
			recursiveBFS(graph, adjacentVertex, visitedVertices);
		}*/
	}

}
