package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Edge> edges;

    public Path(){
        this.edges = new ArrayList<>();
    }

    public double getLength(){
        double length = 0.0;
        for (Edge edge : edges) {
            length+= edge.getCost();
        }
        return length;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }
}
