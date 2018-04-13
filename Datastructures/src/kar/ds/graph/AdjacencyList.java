package kar.ds.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdjacencyList implements Graph {

	private HashMap<Object, Vertex> vertices = new HashMap<Object, Vertex>();
	
	@Override
	public void addVertex(Object vertex) {
		vertices.put(vertex, new Vertex(vertex));
	}

	@Override
	public void removeVertext(Object vertex) {
		Vertex v = vertices.remove(vertex);
		Set<Vertex> adjacentVertices = v.getAdjacentVertices();
		for(Vertex adjacentVertex : adjacentVertices) {
			adjacentVertex.removeAdjacentVertex(v);
		}
	}

	@Override
	public void addEdgeBetween(Object vertex1, Object vertex2) {
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		v1.addAdjacentVertex(v2);
		v2.addAdjacentVertex(v1);
	}

	@Override
	public void removeEdgeBetween(Object vertex1, Object vertex2) {
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		v1.removeAdjacentVertex(v2);
		v2.removeAdjacentVertex(v1);
	}

	@Override
	public boolean areAdjacent(Object vertex1, Object vertex2) {
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		return v1.isAdjacentTo(v2) && v2.isAdjacentTo(v1);
	}

	@Override
	public Set getAdjacentVerticesOf(Object vertex) {
		Vertex v = vertices.get(vertex);
		Set<Vertex> adjacentVertices = v.getAdjacentVertices();
		LinkedHashSet neighbours = null;
		if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
			neighbours = new LinkedHashSet();
			for(Vertex adjacentVertex : adjacentVertices) {
				neighbours.add(adjacentVertex.getValue());
			}
		}
		return neighbours;
	}

	@Override
	public int getNumberOfVertices() {
		return vertices.size();
	}

}
