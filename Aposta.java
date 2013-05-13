public class Aposta {
	private int quant;
	private Veiculo p1, p2, p3;

	public Aposta(Aposta p) {
		quant = p.getQuant();
		p1 = p.getP1().clone();
		p2 = p.getP3().clone();
		p3 = p.getP2().clone();
	}

	public Aposta(int q, Veiculo p1, Veiculo p2, Veiculo p3) {
		this.quant = q;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	// get
	public int getQuant() {
		return this.quant;
	}

	public Veiculo getP1() {
		return this.p1;
	}

	public Veiculo getP2() {
		return this.p2;
	}

	public Veiculo getP3() {
		return this.p3;
	}

	// Set
	public void setQuant(int i) {
		this.quant = i;
	}

	public void setP1(Veiculo p) {
		this.p1 = p;
	}

	public void setP2(Veiculo p) {
		this.p2 = p;
	}

	public void setP3(Veiculo p) {
		this.p3 = p;
	}

	public Aposta clone() {
		return new Aposta(this);
	}

	// toString
	public String toString() {
		StringBuilder s = new StringBuilder("Aposta  ");

		s.append("quant:" + quant);
		s.append(",p1=" + p1.toString());
		s.append(",p2=" + p2.toString());
		s.append(",p3=" + p3.toString());

		return s.toString();

	}

	// equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Aposta v = (Aposta) o;
			return (v.getP1().equals(this.getP1()) && 
					v.getP2().equals(this.getP2()) && 
					v.getP3().equals(this.getP3()) && 
					v.getQuant() == this.getQuant());
		}
	}
}