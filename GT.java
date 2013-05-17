public class GT extends Veiculo{

	public GT() {
		super();
	}
	
	public GT(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, boolean h) {
		super(marca,modelo,cilindrada,cv,p1,p2, h);
	}
	
	public GT(GT g) {
		super(g);
	}
	
	/** Clone*/
	public Veiculo clone() {
		return new GT(this);
	}
	
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	/** ToString*/
	public String toString() {
        StringBuilder s = new StringBuilder ();
        s.append("GT");
        s.append(super.toString());
        
        return s.toString();
	}
}
