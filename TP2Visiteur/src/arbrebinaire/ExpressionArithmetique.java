package arbrebinaire;

public class ExpressionArithmetique {

    private Noeud racine;
    
    // Défini le point de départ du parcours
    public ExpressionArithmetique(Noeud racine) {
        this.racine = racine;
    }
    
    // Renvoie la racine de l'expression
    public Noeud getRacine() {
        return racine;
    }
    
    // Parcours l'expression selon le parcours postfixe
    public void afficherPostFixe() {
        System.out.println("\n postfixe:");
        this.racine.accept(new ArbreVisitorPostfixe());
        
    }
    
    // Parcours qui calcule le résultat de l'expression suivant un parcours infixe
    public int calculerValeur() {
        ArbreVisitorCalcul av = new ArbreVisitorCalcul();
        this.racine.accept(av);
        return av.getResultat();
    }
    
    // Calcul de la hauteur de l'expression
    public int calculerHauteur() {
        ArbreVisitorHauteur av = new ArbreVisitorHauteur();
        this.racine.accept(av);
        return av.getHauteur();
    }

    // Parcours l'expression selon le parcours infixe
    public void afficherInFixe() {
        System.out.println("\n infixe:");
	this.racine.accept(new ArbreVisitorInfixe());
        
    }
    
}
