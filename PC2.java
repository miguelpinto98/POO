public class PC2 extends Veiculo{

	//private int cld;
	//private double fiabilidade = 0.70;

	public PC2() {
		super();
	}

	public PC2(String marca, String modelo, int cilindrada, int cv,
		Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2(PC2 pc) {
		super(pc);
	}

	/** Clone*/	 
	public PC2 clone() {
		return new PC2(this);
	}

	
	/** ToString*/
    	 public String toString(){ 
    	   StringBuilder str = new StringBuilder("PC1 ");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	public int tempoProximaVolta(Circuito c , boolean  chuva) { return 1;}
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}