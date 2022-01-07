package org.acme.graph.routing;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;
import org.acme.graph.model.Vertex;
import org.acme.graph.model.Edge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathTree {

    private static final Logger log = LogManager.getLogger(DijkstraPathFinder.class);

	private Map<Vertex,PathNode> nodes;

    /**
	 * Prépare le graphe pour le calcul du plus court chemin
	 * 
	 * @param source
	 */
	PathTree(Graph graph, Vertex origin) {
        this.nodes = new HashMap<Vertex,PathNode>();
		log.trace("initGraph({})", origin);
		for (Vertex vertex : graph.getVertices()) {
			PathNode pathNode = new PathNode();
			pathNode.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathNode.setReachingEdge(null);
			pathNode.setVisited(false);
			this.nodes.put(vertex,pathNode);
		}
	}

    /**
	 * Construit le chemin en remontant les relations incoming edge
	 * 
	 * @param target
	 * @return
	 */
	public Path getPath(Vertex target) {
		Path result = new Path();
		Edge current = this.getNode(target).getReachingEdge();
		do {
			result.getEdges().add(current);
			current = this.getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result.getEdges());
		return result;
	}


	public PathNode getNode(Vertex vertex){
		return this.nodes.get(vertex);		
	}
}
