package kar.ds.graph;

import java.util.Set;

public interface Graph {

	public void addVertex(Object vertex);
	public void addVertices(Object[] vertices);
	public void removeVertex(Object vertex);
	public void removeVertices(Object[] vertices);
	public int getNumberOfVertices();
	public void addEdgeBetween(Object vertex1, Object vertex2);
	public void addEdgeFrom(Object fromVertex, Object toVertex);
	public void removeEdgeBetween(Object vertex1, Object vertex2);
	public void removeEdgeFrom(Object fromVertex, Object toVertex);
	public boolean areAdjacent(Object vertex1, Object vertex2);
	public Set getAdjacentVerticesOf(Object vertex);
}
