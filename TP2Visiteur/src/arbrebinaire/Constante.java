package arbrebinaire;

public class Constante implements Noeud{
	private int valeur;
	public Constante(int v){
		valeur = v;
	}
	public int getValeur(){return valeur;}

    @Override
    public void accept(ArbreVisitor visitor) {
        visitor.visitConstante(this);
    }

    @Override
    public int getPriorite() {
        return 3;
    }
}
