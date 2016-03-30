package test;

import arbrebinaire.Addition;
import arbrebinaire.Constante;
import arbrebinaire.ExpressionArithmetique;
import arbrebinaire.Multiplication;
import arbrebinaire.Negation;

public class TestArbreBinaire {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // 1+2*3+(-4)
        Addition racine = new Addition(new Addition(new Constante(1), new Multiplication(new Constante(2),new Constante(3))), new Negation(new Constante(4)));
        ExpressionArithmetique exp = new ExpressionArithmetique(racine);

        exp.afficherInFixe();
        System.out.println("\n calcul valeur: " + exp.calculerValeur());
        System.out.println("\n calcul hauteur: " + exp.calculerHauteur());
        exp.afficherPostFixe();

        
        
        // 2+7*(3+(-5)+3*(2+1))
        Addition racineB = new Addition(new Constante(2), new Multiplication(new Constante(7), new Addition(new Addition(new Constante(3),new Negation(new Constante(5))), new Multiplication(new Constante(3), new Addition(new Constante(2), new Constante(1))))));
        ExpressionArithmetique expb = new ExpressionArithmetique(racineB);

        expb.afficherInFixe();
        System.out.println("\n calcul valeur: " + expb.calculerValeur());
        System.out.println("\n calcul hauteur: " + expb.calculerHauteur());
        expb.afficherPostFixe();


        // 2+3+(-5)
        Addition ope = new Addition(new Constante(2), new Addition(new Constante(3), new Negation(new Constante(5))));
        ExpressionArithmetique expc = new ExpressionArithmetique(ope);

        expc.afficherInFixe();
        System.out.println("\n calcul valeur: " + expc.calculerValeur());
        System.out.println("\n calcul hauteur: " + expc.calculerHauteur());
        expc.afficherPostFixe();
        
    }
}
