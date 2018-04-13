package kar.ds.graph;

import java.util.Set;

public interface Graph {

	public void addVertex(Object vertex);
	public void removeVertext(Object vertex);
	public int getNumberOfVertices();
	public void addEdgeBetween(Object vertex1, Object vertex2);
	public void removeEdgeBetween(Object vertex1, Object vertex2);
	public boolean areAdjacent(Object vertex1, Object vertex2);
	public Set getAdjacentVerticesOf(Object vertex);
}
