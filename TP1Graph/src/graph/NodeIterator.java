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
    
    // Le graphe parcouru
    private IGraph g;
    // Le noeud de départ du parcours
    private Node origin;
    // La pile ou la file selon l'implémentation : elle se remplit au fur et à mesure du parcours
    protected LinkedList<Node> nodes;
    // La map marquant les noeuds lorsqu'ils sont traités
    private HashMap<Node, Boolean> marquer;

    public NodeIterator(IGraph g, Node origin) {
        this.g = g;
        this.origin = origin;
        this.marquer = new HashMap<>();
        this.nodes = new LinkedList<>();
        // On ajoute le noeud de départ du parcours
        this.nodes.add(origin);
        // On initialise les noeuds à false ...
        for(Node n : g.getAllNodes()) {
            marquer.put(n, false);
        }
        // ... excepté le noeud de départ
        marquer.put(origin, true);
    }

    @Override
    public boolean hasNext() {
        // Vérifie si le parcours est fini
        return nodes.size() > 0;
    }

    @Override
    public Node next() {
        // On récupère le noeud suivant selon l'implémentation de removeNextNode, définie dans les classes filles
        Node n = this.removeNextNode();
        // On récupère les noeuds adjacents au noeud courant
        for(Node adj : g.getAdjNodes(n)) {
            // S'ils ne sont pas encore marqués, on les ajoute puis on les marque
            if(!marquer.get(adj)) {
                nodes.add(adj);
                marquer.put(adj, true);
            }
        }
        return n;
    }
    
    // Implémenté dans les classes filles
    public abstract Node removeNextNode();

}