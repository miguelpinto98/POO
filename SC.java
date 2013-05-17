public class SC extends Veiculo {
	private static final int cld = 2500;
	//private static final double fpiloto = 0.75;
	//private static final double fcilindrada = 0.25;
	
	public SC() {
		super();
	}

	public SC(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca,modelo,cld,cv,p1,p2,0);
	}
	
	public SC(SC s) {
		super(s);
		this.setCilindrada(cld);
	}
	
	/** Clone*/
	public Veiculo clone() {
		return new SC(this);
	}
	
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	/** ToString*/
	public String toString() {
        StringBuilder s = new StringBuilder ();
        s.append("SC");
        s.append(super.toString());
        
        return s.toString();
	}
}
