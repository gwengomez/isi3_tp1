/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Epulapp
 */
public class NodeDFSIterator extends NodeIterator {

    // On appelle le constructeur de la classe parent
    public NodeDFSIterator(IGraph g, Node origin) {
        super(g, origin);
    }

    @Override
    public Node removeNextNode() {
        // Récupère le dernier noeud de la pile et le retire
        return this.nodes.removeLast();
    }

}