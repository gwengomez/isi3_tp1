package arbrebinaire;

// Interface définissant les classes des operateurs et de la constante
public interface Noeud {
    public void accept(ArbreVisitor visitor);
    public int getPriorite();
}
