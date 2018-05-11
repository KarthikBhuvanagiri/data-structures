package kar.ds.graph;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Vertex<T> {
	private T value;
	private Set<Vertex<T>> adjacentVertices = new LinkedHashSet<Vertex<T>>();
	
	public Vertex(T value) {
		this.value = value;
	}
	
	public Vertex(T value, Set<Vertex<T>> adjacentVertices) {
		this.value = value;
		adjacentVertices.addAll(adjacentVertices);
	}
	
	public T getValue() {
		return value;
	}
	
	public boolean isAdjacentTo(Vertex<T> v) {
		return adjacentVertices.contains(v);
	}
	
	public Set<Vertex<T>> getAdjacentVertices() {
		return Collections.unmodifiableSet(adjacentVertices);
	}
	
	public void addAdjacentVertex(Vertex<T> v) {
		adjacentVertices.add(v);
	}
	
	public void removeAdjacentVertex(Vertex<T> v) {
		adjacentVertices.remove(v);
	}
	
	@Override
	public String toString() {
		String adjVertices = "[";
		for(Vertex<T> adjacentVertex : adjacentVertices) {
			adjVertices = adjVertices + " " + adjacentVertex.getValue();
		}
		adjVertices = adjVertices + " ]";
		return value + " -> " + adjVertices;
	}
}
