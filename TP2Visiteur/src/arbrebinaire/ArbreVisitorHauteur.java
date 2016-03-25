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
    
    private int hauteurCourante = 0;
    private int hauteurMax = 0;

    @Override
    public void visitNegation(Negation n) {
        this.hauteurCourante +=1;
        n.getOpG().accept(this);
        this.hauteurCourante -= 1;
    }

    @Override
    public void visitAddition(Addition n) {
        parcoursHauteur(n);
    }

    @Override
    public void visitMultiplication(Multiplication n) {
        parcoursHauteur(n);
    }

    @Override
    public void visitConstante(Constante n) {
        this.hauteurCourante += 1;
        if(this.hauteurCourante > this.hauteurMax) {
            this.hauteurMax = this.hauteurCourante;
        }
        this.hauteurCourante -= 1;
    }
    
    private void parcoursHauteur(OperateurBinaire n) {
        this.hauteurCourante += 1;
        n.getOpG().accept(this);
        n.getOpD().accept(this);
        this.hauteurCourante -= 1;
    }

    public int getHauteur() {
        return hauteurMax;
    }    
}
