package kar.ds.graph;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdjacencyList<T> implements Graph<T> {

	private LinkedHashMap<T, Vertex<T>> vertices = new LinkedHashMap<T, Vertex<T>>();
	
	private void throwExceptionIfVertexNotExist(T v) {
		if(!vertices.containsKey(v))
			throw new GraphException("Vertex "+v+" not found");
	}
	
	@Override
	public void addVertex(T vertex) {
		if(!vertices.containsKey(vertex))
			vertices.put(vertex, new Vertex<T>(vertex));
		else
			throw new GraphException("Vertex "+vertex+" already exist");
	}

	@Override
	public void removeVertex(T vertex) {
		throwExceptionIfVertexNotExist(vertex);
		Vertex<T> v = vertices.remove(vertex);
		Set<Vertex<T>> adjacentVertices = v.getAdjacentVertices();
		for(Vertex<T> adjacentVertex : adjacentVertices) {
			adjacentVertex.removeAdjacentVertex(v);
		}
	}

	@Override
	public void addEdgeBetween(T vertex1, T vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex<T> v1 = vertices.get(vertex1);
		Vertex<T> v2 = vertices.get(vertex2);
		v1.addAdjacentVertex(v2);
		v2.addAdjacentVertex(v1);
	}

	@Override
	public void removeEdgeBetween(T vertex1, T vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex<T> v1 = vertices.get(vertex1);
		Vertex<T> v2 = vertices.get(vertex2);
		v1.removeAdjacentVertex(v2);
		v2.removeAdjacentVertex(v1);
	}

	@Override
	public boolean areAdjacent(T vertex1, T vertex2) {
		throwExceptionIfVertexNotExist(vertex1);
		throwExceptionIfVertexNotExist(vertex2);
		Vertex<T> v1 = vertices.get(vertex1);
		Vertex<T> v2 = vertices.get(vertex2);
		return v1.isAdjacentTo(v2) && v2.isAdjacentTo(v1);
	}

	@Override
	public Set<T> getAdjacentVerticesOf(T vertex) {
		throwExceptionIfVertexNotExist(vertex);
		Vertex<T> v = vertices.get(vertex);
		Set<Vertex<T>> adjacentVertices = v.getAdjacentVertices();
		LinkedHashSet<T> neighbours = null;
		if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
			neighbours = new LinkedHashSet<T>();
			for(Vertex<T> adjacentVertex : adjacentVertices) {
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
	public void addVertices(T[] vertices) {
		if(vertices == null || vertices.length == 0)
			return;
		for(T vertext : vertices) {
			addVertex(vertext);
		}
	}

	@Override
	public void removeVertices(T[] vertices) {
		if(vertices == null || vertices.length == 0)
			return;
		for(T vertex : vertices) {
			removeVertex(vertex);
		}
	}

	@Override
	public void addEdgeFrom(T fromVertex, T toVertex) {
		throwExceptionIfVertexNotExist(fromVertex);
		throwExceptionIfVertexNotExist(toVertex);
		Vertex<T> v1 = vertices.get(fromVertex);
		Vertex<T> v2 = vertices.get(toVertex);
		v1.addAdjacentVertex(v2);
	}

	@Override
	public void removeEdgeFrom(T fromVertex, T toVertex) {
		throwExceptionIfVertexNotExist(fromVertex);
		throwExceptionIfVertexNotExist(toVertex);
		Vertex<T> v1 = vertices.get(fromVertex);
		Vertex<T> v2 = vertices.get(toVertex);
		v1.removeAdjacentVertex(v2);
	}
	
	@Override
	public String toString() {
		String toString = "";
		Set<T> keys = vertices.keySet();
		for(T key : keys) {
			toString = toString + vertices.get(key) + "\n";
		}
		return toString;
	}

}
