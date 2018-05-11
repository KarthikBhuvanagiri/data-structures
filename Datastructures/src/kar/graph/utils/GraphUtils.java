package kar.graph.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kar.ds.graph.Graph;
import kar.ds.queue.Queue;
import kar.ds.stack.Stack;

public class GraphUtils {

	public static <T> T[] traverseByRecursiveDFS(Graph<T> graph, T startingVertex) {
		ArrayList<T> visitedVertices = new ArrayList<T>();
		recursiveDFS(graph, startingVertex, visitedVertices);
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(startingVertex.getClass(), visitedVertices.size());
		return visitedVertices.toArray(out);
	}
	
	private static <T> void recursiveDFS(Graph<T> graph, T vertex, List<T> visitedVertices) {
		visitedVertices.add(vertex);
		Set<T> adjacentVertices = graph.getAdjacentVerticesOf(vertex);
		if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
			for(T adjacentVertex : adjacentVertices) {
				if(!visitedVertices.contains(adjacentVertex))
					recursiveDFS(graph, adjacentVertex, visitedVertices);
			}
		}
	}
	
	public static <T> T[] traverseByIterativeDFS(Graph<T> graph, T startingVertex) {
		ArrayList<T> visitedVertices = new ArrayList<T>();
		Stack<T> stack = new Stack<T>();
		stack.push(startingVertex);
		while(!stack.isEmpty()) {
			T vertex = stack.pop();
			if(!visitedVertices.contains(vertex)) {
				visitedVertices.add(vertex);
				Set<T> adjacentVertices = graph.getAdjacentVerticesOf(vertex);
				if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
					for(T adjacentVertex : adjacentVertices) {
						stack.push(adjacentVertex);
					}
				}
			}
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(startingVertex.getClass(), visitedVertices.size());
		return visitedVertices.toArray(out);
	}
	
	public static <T> T[] traverseByIterativeBFS(Graph<T> graph, T startingVertex) {
		ArrayList<T> visitedVertices = new ArrayList<T>();
		Queue<T> queue = new Queue<T>();
		queue.enqueue(startingVertex);
		while(!queue.isEmpty()) {
			T vertex = queue.dequeue();
			if(!visitedVertices.contains(vertex)) {
				visitedVertices.add(vertex);
				Set<T> adjacentVertices = graph.getAdjacentVerticesOf(vertex);
				if(adjacentVertices !=null && !adjacentVertices.isEmpty()) {
					for(T adjacentVertex : adjacentVertices) {
						queue.enqueue(adjacentVertex);
					}
				}
			}
		}
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(startingVertex.getClass(), visitedVertices.size());
		return visitedVertices.toArray(out);
	}
	
	public static <T> T[] traverseByRecursiveBFS(Graph<T> graph, T startingVertex) {
		ArrayList<T> visitedVertices = new ArrayList<T>();
		recursiveBFS(graph, startingVertex, visitedVertices);
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(startingVertex.getClass(), visitedVertices.size());
		return visitedVertices.toArray(out);
	}
	
	private static <T> void recursiveBFS(Graph<T> graph, T vertex, List<T> visitedVertices) {
		/*if(!visitedVertices.contains(vertex))
			visitedVertices.add(vertex);
		Set adjacentVertices = graph.getAdjacentVerticesOf(vertex);
		for(Object adjacentVertex : adjacentVertices) {
			recursiveBFS(graph, adjacentVertex, visitedVertices);
		}*/
	}

}
