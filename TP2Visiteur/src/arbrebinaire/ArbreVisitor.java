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
// Interface des classes Visiteur
public interface ArbreVisitor {
    public void visitNegation(Negation n);
    public void visitAddition(Addition n);
    public void visitMultiplication(Multiplication n);
    public void visitConstante(Constante n);
}
