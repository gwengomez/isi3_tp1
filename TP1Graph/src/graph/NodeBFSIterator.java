/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author Epulapp
 */
public class NodeBFSIterator extends NodeIterator {

    // On appelle le constructeur de la classe parent
    public NodeBFSIterator(IGraph g, Node origin) {
        super(g, origin);
    }

    @Override
    public Node removeNextNode() {
        // Récupère le premier noeud de la file et le retire
        return ((LinkedList<Node>)this.nodes).removeFirst();
    }

}
