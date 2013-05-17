public class PC1 extends Veiculo{

	//private int cld;
	//private double fiabilidade = 0.70;

	public PC1() {
		super();
	}

	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	

	/** Clone*/	 
	public PC1 clone() {
		return new PC1(this);
	}

	
	public PC1 (PC1 pc) {
	    
        super(pc);
        this.setCilindrada(cld);
        
    }
    
    public void setCilindrada(int cl){
    
    super.setCilindrada(cl);
    }
	/** ToString*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("PC1");
		s.append(super.toString());

		return s.toString();
	}

	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}
