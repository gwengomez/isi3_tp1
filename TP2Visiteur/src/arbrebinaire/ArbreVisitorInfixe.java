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
public class ArbreVisitorInfixe implements ArbreVisitor {

    @Override
    public void visitNegation(Negation n) {
        // Test sur la priorité : rien ne devrait être infèrieur à une négation, mais il est présent au cas où
        // Affichage du noeud courant (la négation)
        System.out.print(n.getOp());
        if (n.getPriorite() > n.getOpG().getPriorite()) {
            encapsulate(n.getOpG());
        } else {
            // Traitement du noeud fils sans encapsulation
            n.getOpG().accept(this);
        }

    }

    @Override
    public void visitAddition(Addition n) {
        parcoursInfixeBinaire(n);
    }

    @Override
    public void visitMultiplication(Multiplication n) {
        parcoursInfixeBinaire(n);
    }

    @Override
    public void visitConstante(Constante n) {
        // Affiche la valeur de la constante courante
        System.out.print(n.getValeur());
    }

    // Méthode globale de parcours infixe
    private void parcoursInfixeBinaire(OperateurBinaire n) {
        // Encapsule dans des parenthèses le noeud de gauche si sa priorité est plus faible que celle du noeud courant
        if (n.getPriorite() > n.getOpG().getPriorite()) {
            encapsulate(n.getOpG());
        } else {
            // Traite le noeud de gauche sans encapsulation
            n.getOpG().accept(this);
        }
        // Affiche le noeud courant
        System.out.print(n.getOp());
        
        // Encapsule dans des parenthèses le noeud de droite si sa priorité est plus faible que celle du noeud courant
        if (n.getPriorite() > n.getOpD().getPriorite()) {
            encapsulate(n.getOpD());
        } else {
            // Traite le noeud de droite sans encapsulation
            n.getOpD().accept(this);
        }
    }

    private void encapsulate(Noeud n) {
        // Traite le noeud courant en l'encapsulant à l'aide de parenthèses
        System.out.print("(");
        n.accept(this);
        System.out.print(")");
    }

}
