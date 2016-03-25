/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class UndirectedGraph implements IUndirectedGraph {    
    
    private Graph g;

    public UndirectedGraph() {
        this.g = new Graph();
    }

    @Override
    public void addEdge(Node _node1, Node _node2) {
        // Ajout de l'arrête dans chaque sens (source -> destination et destination -> source)
        Arc a = new Arc(_node1, _node2, null);
        Arc b = new Arc(_node2, _node1, null);
        this.g.addArc(a);
        this.g.addArc(b);
    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        // On vérifie dans les deux sens au cas où
        return this.g.hasArc(_node1, _node2) || this.g.hasArc(_node2, _node1);
    }
    
    // Les 4 méthodes suivantes utilisent les méthodes de la classe parent
    
    @Override
    public void addNode(Node _node) {
        this.g.addNode(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return this.g.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return this.g.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return this.g.getAdjNodes(_n);
    }   

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return this.g.creerBFSIterator(n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return this.g.creerDFSIterator(n);
    }
}
