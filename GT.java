public abstract class GT extends Veiculo{
	public static int nvoltas = 1;

	public GT() {
		super();
	}
	
	public GT(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca,modelo,cilindrada,cv,p1,p2, hib);
	}
	
	public GT(GT g) {
		super(g);
	}
	
	
	public abstract int calculaFiabilidade() ;
	
	public abstract int tempoProximaVolta(Circuito c, boolean chuva) throws Exception ;
	
	/** Clone*/
	public abstract Veiculo clone() ;
	
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	/** ToString*/
	public abstract String toString() ;
}
