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
        // Ajoute +1 à la hauteur du fils
        n.getOpG().accept(this);
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
        this.hauteur = 1;
    }

    public int getHauteur() {
        return hauteur;
    }
    
    private void parcoursHauteurBinaire(OperateurBinaire n) {
        int _hauteur = this.hauteur;
        n.getOpG().accept(this);
        int hauteurG = this.hauteur;
        this.hauteur = _hauteur;
        n.getOpD().accept(this);
        int hauteurD = this.hauteur;
        
        if(hauteurG > hauteurD) {
            this.hauteur = hauteurG + 1;
        } else {
            this.hauteur = hauteurD + 1;
        }
    }
}
