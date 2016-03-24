/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Epulapp
 */
public abstract class NodeIterator implements Iterator<Node> {
    
    private IGraph g;
    private Node origin;
    protected LinkedList<Node> nodes;
    private HashMap<Node, Boolean> marquer;

    public NodeIterator(IGraph g, Node origin) {
        this.g = g;
        this.origin = origin;
        this.marquer = new HashMap<>();
        this.nodes = new LinkedList<>();
        this.nodes.add(origin);
        for(Node n : g.getAllNodes()) {
            marquer.put(n, false);
        }
        marquer.put(origin, true);
    }
    
    protected void init() {
        
    }

    @Override
    public boolean hasNext() {
        return nodes.size() > 0;
    }

    @Override
    public Node next() {
        Node n = this.removeNextNode();
        for(Node adj : g.getAdjNodes(n)) {
            if(!marquer.get(adj)) {
                nodes.add(adj);
                marquer.put(adj, true);
            }
        }
        return n;
    }
    
    public abstract Node removeNextNode();

}