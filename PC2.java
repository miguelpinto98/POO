public abstract class PC2 extends Veiculo {
	protected static final int fiabilidade = 85;

	public PC2() {
		super();
	}

	public PC2(String marca, String modelo, int cilindrada, int cv, Piloto p1,Piloto p2) {
		super(marca, modelo, cilindrada, cv, p1, p2);
	}

	public PC2(PC2 pc) {
		super(pc);
	}
	
	public abstract int calculaFiabilidade() ;
	
	public abstract int tempoProximaVolta(Circuito c, boolean chuva) throws Exception ; 

	public abstract PC2 clone() ;

	public abstract String toString() ;

	public abstract boolean equals(Object o) ;
}