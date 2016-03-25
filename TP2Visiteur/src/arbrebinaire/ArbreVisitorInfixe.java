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
        System.out.print(n.getOp());
        if (n.getPriorite() > n.getOpG().getPriorite()) {
            encapsulate(n.getOpG());
        } else {
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
        System.out.print(n.getValeur());
    }

    private void parcoursInfixeBinaire(OperateurBinaire n) {

        if (n.getPriorite() > n.getOpG().getPriorite()) {
            encapsulate(n.getOpG());
        } else {
            n.getOpG().accept(this);
        }
        System.out.print(n.getOp());
        if (n.getPriorite() > n.getOpD().getPriorite()) {
            encapsulate(n.getOpD());
        } else {
            n.getOpD().accept(this);
        }
    }

    private void encapsulate(Noeud n) {
        System.out.print("(");
        n.accept(this);
        System.out.print(")");
    }

}
