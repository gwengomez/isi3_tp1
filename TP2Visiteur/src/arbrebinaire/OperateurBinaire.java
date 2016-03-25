package arbrebinaire;

public abstract class OperateurBinaire  extends OperateurUnaire{

	private Noeud opD;
	
	public OperateurBinaire(String s,Noeud ng,Noeud nd){
		super(s,ng);
		opD=nd;
	}
	
	public Noeud getOpD(){
		return opD;
	}

}
