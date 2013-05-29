public abstract class PC2 extends Veiculo {
	protected static final int fiabilidade = 70;

	public PC2() {
		super();
	}

	public PC2(String marca, String modelo, int cilindrada, int cv, Piloto p1,
			Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2(PC2 pc) {
		super(pc);
	}
	
	public abstract int calculaFiabilidade() ;
	
	//MAIS TESTES
	//res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + (this.getCilindrada()*this.getPilotoActivo())/(this.getCV()*this.getCilindrada())));		
	//res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getCilindrada()*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
	public abstract int tempoProximaVolta(Circuito c, boolean chuva) throws Exception ; 

	/** Clone */
	public abstract PC2 clone() ;

	/** ToString */
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC2 *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}

	/** Equals */ //ESTE METODO NÃO DEVE SER ASSIM, PORTANTO DUVIDA
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}