package arbrebinaire;

public class ExpressionArithmetique {

    private Noeud racine;
    
    public ExpressionArithmetique(Noeud racine) {
        this.racine = racine;
    }
    
    public Noeud getRacine() {
        return racine;
    }
    
    public void afficherPostFixe() {
        System.out.println("\n postfixe:");
        this.racine.accept(new ArbreVisitorPostfixe());
        
    }
    
    public int calculerValeur() {
        ArbreVisitorCalcul av = new ArbreVisitorCalcul();
        this.racine.accept(av);
        return av.getResultat();
    }
    
    public int calculerHauteur() {
        ArbreVisitorHauteur av = new ArbreVisitorHauteur();
        this.racine.accept(av);
        return av.getHauteur();
    }

    public void afficherInFixe() {
        System.out.println("\n infixe:");
	this.racine.accept(new ArbreVisitorInfixe());
        
    }
    
}
