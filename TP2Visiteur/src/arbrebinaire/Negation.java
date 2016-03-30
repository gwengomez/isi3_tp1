package arbrebinaire;

public class Negation extends OperateurUnaire {
    
    public Negation(Noeud n) {
        super("-", n);
    }
    
    @Override
    public void accept(ArbreVisitor visitor) {
        // Traite un opérateur -
        visitor.visitNegation(this);
    }    

    @Override
    public int getPriorite() {
        return 0;
    }
}
