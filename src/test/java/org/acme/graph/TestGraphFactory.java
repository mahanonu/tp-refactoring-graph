package org.acme.graph;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.locationtech.jts.geom.Coordinate;

public class TestGraphFactory {

	/**
	 * d / / a--b--c
	 * 
	 * @return
	 */
	public static Graph createGraph01() {
		Graph graph = new Graph();

		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		graph.getVertices().add(a);

		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");
		graph.getVertices().add(b);

		Vertex c = graph.createVertex(new Coordinate(2.0, 0.0), "c");
		graph.getVertices().add(c);

		Vertex d = graph.createVertex(new Coordinate(1.0, 1.0), "d");
		graph.getVertices().add(d);

		Edge ab = graph.createEdge(a, b,"ab");
		graph.getEdges().add(ab);

		Edge bc = graph.createEdge(b, c,"bc");
		graph.getEdges().add(bc);

		Edge ad = graph.createEdge(a, d,"ad");
		graph.getEdges().add(ad);

		return graph;
	}

}
