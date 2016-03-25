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
        n.getOpG().accept(this);
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
        System.out.print(n.getValeur());
    }

    private void postfixeBinaire(OperateurBinaire n) {
        n.getOpG().accept(this);
        n.getOpD().accept(this);
        System.out.print(n.getOp());
    }

}
