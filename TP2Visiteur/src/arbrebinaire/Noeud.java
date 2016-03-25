package arbrebinaire;

public interface Noeud {
    public void accept(ArbreVisitor visitor);
    public int getPriorite();
}
