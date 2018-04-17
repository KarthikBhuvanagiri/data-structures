package kar.ds.graph;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Vertex {
	private Object value;
	private Set<Vertex> adjacentVertices = new LinkedHashSet<Vertex>();
	
	public Vertex(Object value) {
		this.value = value;
	}
	
	public Vertex(Object value, Set<Vertex> adjacentVertices) {
		this.value = value;
		adjacentVertices.addAll(adjacentVertices);
	}
	
	public Object getValue() {
		return value;
	}
	
	public boolean isAdjacentTo(Vertex v) {
		return adjacentVertices.contains(v);
	}
	
	public Set<Vertex> getAdjacentVertices() {
		return Collections.unmodifiableSet(adjacentVertices);
	}
	
	public void addAdjacentVertex(Vertex v) {
		adjacentVertices.add(v);
	}
	
	public void removeAdjacentVertex(Vertex v) {
		adjacentVertices.remove(v);
	}
	
	@Override
	public String toString() {
		String adjVertices = "[";
		for(Vertex adjacentVertex : adjacentVertices) {
			adjVertices = adjVertices + " " + adjacentVertex.getValue();
		}
		adjVertices = adjVertices + " ]";
		return value + " -> " + adjVertices;
	}
}
