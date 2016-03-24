/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.List;

/**
 *
 * @author Epulapp
 */
public class UndirectedGraph extends Graph implements IUndirectedGraph {    

    @Override
    public void addEdge(Node _node1, Node _node2) {
        Arc a = new Arc(_node1, _node2, null);
        Arc b = new Arc(_node2, _node1, null);
        this.addArc(a);
        this.addArc(b);
    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return this.hasArc(_node1, _node2) || this.hasArc(_node2, _node1);
    }

    @Override
    public void addNode(Node _node) {
        super.addNode(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return super.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return super.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return super.getAdjNodes(_n);
    }   
}
