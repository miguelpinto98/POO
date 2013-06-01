public abstract class PC1 extends Veiculo {

	private static final int cld = 6000;
	protected static final int fiabilidade = 95;

	public PC1() {
		super();
	}

	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		super(marca, modelo, cld, cv, p1, p2);
	}

	public PC1(PC1 pc) {
		super(pc);
		this.setCilindrada(cld);
	}

	public void setCilindrada(int cl) {
		super.setCilindrada(cl);
	}
	
	public abstract int calculaFiabilidade();

	public abstract int tempoProximaVolta(Circuito c, boolean chuva) throws Exception ;
	
	public abstract PC1 clone() ;
	
	public abstract String toString() ;

	public abstract boolean equals(Object o) ;
	
	public int hashCode() {
		return super.hashCode();
	}
}
