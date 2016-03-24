/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Epulapp
 */
public class Graph implements IDirectedGraph{
    
    private List<Node> nodes;
    private Map<Node, List<Arc>> arcs;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.arcs = new HashMap<>();
    }   

    @Override
    public boolean hasArc(Node _n1, Node _n2) {
        List<Arc> outgoing = arcs.get(_n1);
        if(outgoing == null) {
            return false;
        }
        for(Arc c : outgoing) {
            if(c.getDestination() == _n2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addArc(Arc _edge) {
        arcs.get(_edge.getSource()).add(_edge);
    }

    @Override
    public List<Arc> getArc(Node _n) {
        return arcs.get(_n);
    }

    @Override
    public void addNode(Node _node) {
        nodes.add(_node);
        arcs.put(_node, new ArrayList<Arc>());
    }

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }

    @Override
    public int getNbNodes() {
        return nodes.size();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        List<Node> adjacents = new ArrayList<Node>();
        for(List<Arc> lsArcs : arcs.values()) {
            for(Arc c : lsArcs) {
                if(c.getSource() == _n && !adjacents.contains(c.getDestination())) {
                    adjacents.add(c.getDestination());
                } else if(c.getDestination() == _n && !adjacents.contains(c.getSource())) {
                    adjacents.add(c.getSource());
                }
            }
        }
        return adjacents;
    }
    
    @Override
    public String toString() {
        String s = "";
        for(Node n : nodes) {
            s += "[noeud=" + n.getLabel();
            s += this.getArc(n);
            s += "\n";
        }
        return s;
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return new NodeBFSIterator(this, n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return new NodeDFSIterator(this, n);
    }
    
}
