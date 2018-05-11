package kar.ds.graph;

import java.util.Set;

public interface Graph<T> {

	public void addVertex(T vertex);
	public void addVertices(T[] vertices);
	public void removeVertex(T vertex);
	public void removeVertices(T[] vertices);
	public int getNumberOfVertices();
	public void addEdgeBetween(T vertex1, T vertex2);
	public void addEdgeFrom(T fromVertex, T toVertex);
	public void removeEdgeBetween(T vertex1, T vertex2);
	public void removeEdgeFrom(T fromVertex, T toVertex);
	public boolean areAdjacent(T vertex1, T vertex2);
	public Set<T> getAdjacentVerticesOf(T vertex);
}
