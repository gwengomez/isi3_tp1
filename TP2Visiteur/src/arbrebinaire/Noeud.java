package arbrebinaire;

public interface Noeud {
    // Traite le noeud courant
    public void accept(ArbreVisitor visitor);
    // Renvoie sa priorité
    public int getPriorite();
}
