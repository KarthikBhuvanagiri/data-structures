package kar.ds.graph.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import kar.ds.graph.AdjacencyList;
import kar.ds.graph.Graph;

class AdjacencyListTest {


	@Test
	void testEmptyGraph() {
		Graph<String> graph = new AdjacencyList<String>();
		assertEquals(0, graph.getNumberOfVertices());
	}
	
	@Test
	void testAddVertex() {
		Graph<String> graph = new AdjacencyList<String>();
		graph.addVertex("A");
		assertEquals(1, graph.getNumberOfVertices());
		graph.addVertex("B");
		assertEquals(2, graph.getNumberOfVertices());
		graph.addVertex("C");
		assertEquals(3, graph.getNumberOfVertices());
	}

	@Test
	void testRemoveVertext() {
		Graph<String> graph = new AdjacencyList<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		
		graph.removeVertex("B");
		assertEquals(2, graph.getNumberOfVertices());
		
		graph.removeVertex("A");
		assertEquals(1, graph.getNumberOfVertices());
		
		graph.removeVertex("C");
		assertEquals(0, graph.getNumberOfVertices());
	}

	@Test
	void testAddEdgeBetween() {
		Graph<String> graph = new AdjacencyList<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		
		graph.addEdgeBetween("A", "B");
		graph.addEdgeBetween("A", "E");
		graph.addEdgeBetween("B", "A");
		graph.addEdgeBetween("B", "C");
		graph.addEdgeBetween("B", "D");
		graph.addEdgeBetween("B", "E");
		graph.addEdgeBetween("C", "B");
		graph.addEdgeBetween("D", "B");
		graph.addEdgeBetween("D", "E");
		graph.addEdgeBetween("D", "F");
		graph.addEdgeBetween("E", "A");
		graph.addEdgeBetween("E", "B");
		graph.addEdgeBetween("E", "D");
		graph.addEdgeBetween("F", "D");
		
		assertAdjacencyBetween("A", "B", graph, true);
		assertAdjacencyBetween("A", "E", graph, true);
		assertAdjacencyBetween("B", "A", graph, true);
		assertAdjacencyBetween("B", "C", graph, true);
		assertAdjacencyBetween("B", "D", graph, true);
		assertAdjacencyBetween("B", "E", graph, true);
		assertAdjacencyBetween("C", "B", graph, true);
		assertAdjacencyBetween("D", "B", graph, true);
		assertAdjacencyBetween("D", "E", graph, true);
		assertAdjacencyBetween("D", "F", graph, true);
		assertAdjacencyBetween("E", "A", graph, true);
		assertAdjacencyBetween("E", "B", graph, true);
		assertAdjacencyBetween("E", "D", graph, true);
		assertAdjacencyBetween("F", "D", graph, true);
		
		assertAdjacencyBetween("A", "C", graph, false);
		assertAdjacencyBetween("A", "D", graph, false);
		assertAdjacencyBetween("A", "F", graph, false);
		assertAdjacencyBetween("B", "F", graph, false);
		assertAdjacencyBetween("C", "A", graph, false);
		assertAdjacencyBetween("C", "E", graph, false);
		assertAdjacencyBetween("C", "D", graph, false);
		assertAdjacencyBetween("C", "F", graph, false);
		assertAdjacencyBetween("D", "A", graph, false);
		assertAdjacencyBetween("D", "C", graph, false);
		assertAdjacencyBetween("E", "C", graph, false);
		assertAdjacencyBetween("E", "F", graph, false);
		assertAdjacencyBetween("F", "A", graph, false);
		assertAdjacencyBetween("F", "B", graph, false);
		assertAdjacencyBetween("F", "C", graph, false);
		assertAdjacencyBetween("F", "E", graph, false);
		
		assertAdjacentVerticesOf("A", new String[]{"B", "E"}, graph);
		assertAdjacentVerticesOf("B", new String[]{"A", "C", "D", "E"}, graph);
		assertAdjacentVerticesOf("C", new String[]{"B"}, graph);
		assertAdjacentVerticesOf("D", new String[]{"B", "E", "F"}, graph);
		assertAdjacentVerticesOf("E", new String[]{"A", "B", "D"}, graph);
		assertAdjacentVerticesOf("F", new String[]{"D"}, graph);
	}

	@Test
	void testRemoveEdgeBetween() {
		Graph<String> graph = new AdjacencyList<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		
		graph.addEdgeBetween("A", "B");
		graph.addEdgeBetween("A", "E");
		graph.addEdgeBetween("B", "A");
		graph.addEdgeBetween("B", "C");
		graph.addEdgeBetween("B", "D");
		graph.addEdgeBetween("B", "E");
		graph.addEdgeBetween("C", "B");
		graph.addEdgeBetween("D", "B");
		graph.addEdgeBetween("D", "E");
		graph.addEdgeBetween("D", "F");
		graph.addEdgeBetween("E", "A");
		graph.addEdgeBetween("E", "B");
		graph.addEdgeBetween("E", "D");
		graph.addEdgeBetween("F", "D");
		
		graph.removeEdgeBetween("A", "B");
		assertAdjacencyBetween("A", "B", graph, false);
		assertAdjacentVerticesOf("A", new String[]{"E"}, graph);
		
		graph.removeEdgeBetween("A", "E");
		assertAdjacencyBetween("A", "E", graph, false);
		assertAdjacentVerticesOf("A", null, graph);
		
		graph.removeEdgeBetween("B", "E");
		assertAdjacencyBetween("B", "E", graph, false);
		assertAdjacentVerticesOf("B", new String[] {"C", "D"}, graph);
		
		graph.removeEdgeBetween("B", "C");
		assertAdjacencyBetween("B", "C", graph, false);
		assertAdjacentVerticesOf("B", new String[] {"D"}, graph);
		
		graph.removeEdgeBetween("B", "D");
		assertAdjacencyBetween("B", "D", graph, false);
		assertAdjacentVerticesOf("B", null, graph);
		
		assertAdjacentVerticesOf("C", null, graph);
		
		graph.removeEdgeBetween("D", "F");
		assertAdjacencyBetween("D", "F", graph, false);
		assertAdjacentVerticesOf("D", new String[] {"E"}, graph);
		
		graph.removeEdgeBetween("D", "E");
		assertAdjacencyBetween("D", "E", graph, false);
		assertAdjacentVerticesOf("D", null, graph);
		
		assertAdjacentVerticesOf("E", null, graph);
		
		assertAdjacentVerticesOf("F", null, graph);
	}

	void assertAdjacencyBetween(String v1, String v2, Graph<String> graph, boolean expected) {
		if(expected) {
			assertTrue(graph.areAdjacent(v1, v2));
		}else {
			assertFalse(graph.areAdjacent(v1, v2));
		}
	}
	
	void assertAdjacentVerticesOf(String v1, String[] expected, Graph<String> graph) {
		Set<String> actual = graph.getAdjacentVerticesOf(v1);
		if(expected != null)
			assertEquals(new LinkedHashSet<>(Arrays.asList(expected)), actual);
		else
			assertNull(actual);
	}

}
