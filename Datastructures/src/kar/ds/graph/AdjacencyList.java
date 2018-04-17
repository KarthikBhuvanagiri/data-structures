package kar.ds.graph;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdjacencyList implements Graph {

	private LinkedHashMap<Object, Vertex> vertices = new LinkedHashMap<Object, Vertex>();
	
	private void throwExceptionIfVertexNotExist(Object v) {
		if(!vertices.containsKey(v))
			throw new GraphException("Vertex "+v+" not found");
	}
	
	@Override
	public void addVertex(Object vertex) {
		if(!vertices.containsKey(vertex))
			vertices.put(vertex, new Vertex(vertex));
		else
			throw new GraphException("Vertex "+vertex+" already exist");
	}

	@Override
	public void removeVertex(Object vertex) {
		throwExceptionIfVertexNotExist(vertex);
		Vertex v = vertices.remove(vertex);
		Set<Vertex> adjacentVertices = v.getAdjacentVertices();
		for(Vertex adjacentVertex : adjacentVertices) {
			adjacentVertex.removeAdjacentVertex(v);
		}
	}

	@Override
	public void addEdgeBetween(Object vertex1, Object vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		v1.addAdjacentVertex(v2);
		v2.addAdjacentVertex(v1);
	}

	@Override
	public void removeEdgeBetween(Object vertex1, Object vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		v1.removeAdjacentVertex(v2);
		v2.removeAdjacentVertex(v1);
	}

	@Override
	public boolean areAdjacent(Object vertex1, Object vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex v1 = vertices.get(vertex1);
		Vertex v2 = vertices.get(vertex2);
		return v1.isAdjacentTo(v2) && v2.isAdjacentTo(v1);
	}

	@Override
	public Set getAdjacentVerticesOf(Object vertex) {
		throwExceptionIfVertexNotExist(vertex);
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

	@Override
	public void addVertices(Object[] vertices) {
		if(vertices == null || vertices.length == 0)
			return;
		for(Object vertext : vertices) {
			addVertex(vertext);
		}
	}

	@Override
	public void removeVertices(Object[] vertices) {
		if(vertices == null || vertices.length == 0)
			return;
		for(Object vertex : vertices) {
			removeVertex(vertex);
		}
	}

	@Override
	public void addEdgeFrom(Object fromVertex, Object toVertex) {
		throwExceptionIfVertexNotExist(fromVertex);
		throwExceptionIfVertexNotExist(toVertex);
		Vertex v1 = vertices.get(fromVertex);
		Vertex v2 = vertices.get(toVertex);
		v1.addAdjacentVertex(v2);
	}

	@Override
	public void removeEdgeFrom(Object fromVertex, Object toVertex) {
		throwExceptionIfVertexNotExist(fromVertex);
		throwExceptionIfVertexNotExist(toVertex);
		Vertex v1 = vertices.get(fromVertex);
		Vertex v2 = vertices.get(toVertex);
		v1.removeAdjacentVertex(v2);
	}
	
	@Override
	public String toString() {
		String toString = "";
		Set keys = vertices.keySet();
		for(Object key : keys) {
			toString = toString + vertices.get(key) + "\n";
		}
		return toString;
	}

}
