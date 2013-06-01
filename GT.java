public abstract class GT extends Veiculo{
	public static int nvoltas = 1;

	public GT() {
		super();
	}
	
	public GT(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		super(marca,modelo,cilindrada,cv,p1,p2);
	}
	
	public GT(GT g) {
		super(g);
	}
	
	
	public abstract int calculaFiabilidade() ;
	
	public abstract int tempoProximaVolta(Circuito c, boolean chuva) throws Exception ;
	
	public abstract Veiculo clone() ;
	
	public abstract boolean equals(Object o) ;
	
	public abstract String toString() ;
}
