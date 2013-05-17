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
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("PC2");
		s.append(super.toString());

		return s.toString();
	}

	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}