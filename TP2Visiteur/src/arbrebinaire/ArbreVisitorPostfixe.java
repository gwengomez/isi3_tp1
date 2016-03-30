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
public class ArbreVisitorPostfixe implements ArbreVisitor {

    @Override
    public void visitNegation(Negation n) {
        // Traite le noeud fils
        n.getOpG().accept(this);
        // Affiche le noeud courant
        System.out.print(n.getOp());
    }

    @Override
    public void visitAddition(Addition n) {
        postfixeBinaire(n);
    }

    @Override
    public void visitMultiplication(Multiplication n) {
        postfixeBinaire(n);
    }

    @Override
    public void visitConstante(Constante n) {
        // Affichage la valeur de la constante courante
        System.out.print(n.getValeur());
    }

    // Méthode globale de parcours postfixe
    private void postfixeBinaire(OperateurBinaire n) {
        // Traite le noeud de gauche
        n.getOpG().accept(this);
        // Traite le noeud de droite
        n.getOpD().accept(this);
        // Traite le noeud courant
        System.out.print(n.getOp());
    }

}
