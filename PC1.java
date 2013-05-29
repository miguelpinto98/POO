public abstract class PC1 extends Veiculo {

	private static final int cld = 6000;
	protected static final int fiabilidade = 85;

	public PC1() {
		super();
	}

	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cld, cv, p1, p2, h);
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
	//LIXO DE TESTES - para possivel utilização
	//res = (int) (c.gettempoPC1() + r.nextInt((c.gettempoPC1()-c.getTrecord())) - ((int)(this.getPilotoActivo()*1000 + ((this.getCilindrada()+this.getCV()*this.getPilotoActivo())/(this.getCilindrada()-this.getCV())))));
	//res = (int)(c.gettempoPC1() + r.nextInt((c.gettempoPC1()-c.getTrecord())) - ((this.getPilotoActivo()*1000 + this.getCV())));

	/** Clone */
	public abstract PC1 clone() ;
	
	/** 
	 * ToString 
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC1 *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}

	/** Equals */ //ESTE METODO NÂO DEVE SER ASSIM
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
