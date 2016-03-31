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
public class ArbreVisitorCalcul implements ArbreVisitor{
    
    //utilise le parcours infixe pour effectuer le calcul de l'expression arithmétique
    private int resultat = 0;

    @Override
    public void visitNegation(Negation n) {
        // Copie le résultat courant
        int copyRes = resultat;
        // Traite le noeud fils
        n.getOpG().accept(this);
        // Soustrait le résultat du noeud fils au résultat courant
        this.resultat = copyRes - this.resultat;
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
        // Assigne la valeur de la constante au résultat courant
        this.resultat = n.getValeur();
    }
    
    private void parcoursInfixeBinaire(OperateurBinaire n) {
        // Initialise le résultat courant
        this.resultat = 0;
        // Traite le noeud de gauche
        n.getOpG().accept(this);
        // Met de côté le résultat du noeud gauche
        int copyGauche = this.resultat;
        // Réinitialise le résultat courant
        this.resultat = 0;
        // Traite le noeud droit
        n.getOpD().accept(this);
        // Met de côté le résultat du noeud droit
        int copyDroite = this.resultat;
        // Réalise l'opération correspondante à l'opérateur du noeud courant
        switch(n.getOp()) {
            case "*":
                this.resultat = copyGauche * copyDroite;
                break;
            case "+":
                this.resultat = copyGauche + copyDroite;
                break;
        }
    }

    public int getResultat() {
        return resultat;
    }
}
