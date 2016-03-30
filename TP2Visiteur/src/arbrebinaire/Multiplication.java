package arbrebinaire;

public class Multiplication extends OperateurBinaire {

    public Multiplication(Noeud ng, Noeud nd) {
        super("*", ng, nd);
    }

    @Override
    public void accept(ArbreVisitor visitor) {
        // Traite un opérateur *
        visitor.visitMultiplication(this);
    }

    @Override
    public int getPriorite() {
        return 2;
    }
}
