package arbrebinaire;

public class Addition extends OperateurBinaire{
	public Addition(Noeud ng, Noeud nd) {
		super("+", ng, nd);
	}

    @Override
    public void accept(ArbreVisitor visitor) {
        visitor.visitAddition(this);
    }

    @Override
    public int getPriorite() {
        return 1;
    }
}
