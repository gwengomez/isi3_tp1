/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbrebinaire;

/**
 *
 * @author Epulapp
 */
public class ArbreVisitorHauteur implements ArbreVisitor{
    
    // Visite l'arbre et calcule sa hauteur en remontant
    
    private int hauteur;

    @Override
    public void visitNegation(Negation n) {
        // Traite le noeud fils
        n.getOpG().accept(this);
        // Ajoute +1 à la hauteur du fils
        this.hauteur += 1;
        
    }

    @Override
    public void visitAddition(Addition n) {
        parcoursHauteurBinaire(n);
    }

    @Override
    public void visitMultiplication(Multiplication n) {
        parcoursHauteurBinaire(n);
    }

    @Override
    public void visitConstante(Constante n) {
        // Initialise la hauteur à 1
        this.hauteur = 1;
    }

    public int getHauteur() {
        return hauteur;
    }
    
    private void parcoursHauteurBinaire(OperateurBinaire n) {
        // Met de côté la hauteur courante
        int _hauteur = this.hauteur;
        // Traite le noeud gauche
        n.getOpG().accept(this);
        // Met de côté la hauteur du noeud de gauche
        int hauteurG = this.hauteur;
        // Réinitialise la hauteur courante
        this.hauteur = _hauteur;
        // Traite le noeud de droite
        n.getOpD().accept(this);
        // Met de côté la hauteur du noeud de droite
        int hauteurD = this.hauteur;
        
        // Conserve la hauteur maximum entre celles des noeuds droit et gauche
        if(hauteurG > hauteurD) {
            this.hauteur = hauteurG + 1;
        } else {
            this.hauteur = hauteurD + 1;
        }
    }
}
