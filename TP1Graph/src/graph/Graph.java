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
    
    // Liste des noeuds inclus dans le graphe
    private List<Node> nodes;
    // Map associant chaque noeud à tous les arcs partant de celui-ci
    private Map<Node, List<Arc>> arcs;

    public Graph() {
        // Instanciation de la liste et de la map
        this.nodes = new ArrayList<>();
        this.arcs = new HashMap<>();
    }   

    @Override
    public boolean hasArc(Node _n1, Node _n2) {
        // Récupération de tous les arcs partant de _n1
        List<Arc> outgoing = arcs.get(_n1);
        // Pour chaque arc de cette liste
        for(Arc c : outgoing) {
            // Si la destination correspond à _n2 on retourne true
            if(c.getDestination() == _n2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addArc(Arc _edge) {
        // Ajout de l'arc à la liste correspondante
        arcs.get(_edge.getSource()).add(_edge);
    }

    @Override
    public List<Arc> getArc(Node _n) {
        // Retourne la liste des arcs partant de _n
        return arcs.get(_n);
    }

    @Override
    public void addNode(Node _node) {
        // Ajoute un noeud et crée sa liste vide correspondante dans la map
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
        // On ignore l'orientation des arcs
        List<Node> adjacents = new ArrayList<Node>();
        // Pour chaque liste d'arcs correspondant aux noeuds
        for(List<Arc> lsArcs : arcs.values()) {
            // Pour chaque arc dans la liste
            for(Arc c : lsArcs) {
                // Si l'arc est une source, il prend la destination comme adjacent et vice versa en testant s'il n'a pas déjà été ajouté
                if(c.getSource() == _n && !adjacents.contains(c.getDestination())) {
                    adjacents.add(c.getDestination());
                } else if(c.getDestination() == _n && !adjacents.contains(c.getSource())) {
                    adjacents.add(c.getSource());
                }
            }
        }
        // Retourne la liste des adjacents trouvés
        return adjacents;
    }
    
    @Override
    public String toString() {
        // Affichage pour chaque noeud
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
        // Création de l'iterateur correspondant au parcours en largeur
        return new NodeBFSIterator(this, n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        // Création de l'iterateur correspondant au parcours en profondeur
        return new NodeDFSIterator(this, n);
    }
    
}
