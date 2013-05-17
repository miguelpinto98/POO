public abstract Veiculo {
	private String marca;
	private String modelo;
	private int cilindrada;
	private int cv;
	private Piloto p1;
	private Piloto p2;

	/*
	 * Constructor for objects of class Veiculo
	 */
	public Veiculo() {
		this.marca = "";
		this.modelo = "";
		this.cilindrada = 0;
		this.cv = 0;
		this.p1 = new Piloto();
		this.p2 = new Piloto();
	}

	public Veiculo(String marca, String modelo, int cilindrada, int cv,
			Piloto p1, Piloto p2) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.cv = cv;
		this.p1 = p1;
		this.p2 = p2;
	}

	public Veiculo(Veiculo v) {
		this.marca = getMarca();
		this.modelo = getModelo();
		this.cilindrada = getCilindrada();
		this.cv = getCV();
		this.p1 = getPiloto1();
		this.p2 = getPiloto2();
	}

	/*
	 * Métodos de Instância
	 */
	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public int getCilindrada() {
		return this.cilindrada;
	}

	public int getCV() {
		return this.cv;
	}

	public Piloto getPiloto1() {
		return this.p1;
	}

	public Piloto getPiloto2() {
		return this.p2;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCilindrada(int c) {
		this.cilindrada = c;
	}

	public void setCV(int cv) {
		this.cv = cv;
	}

	public void setPiloto1(Piloto p) {
		this.p1 = p;
	}

	public void setPiloto(Piloto p) {
		this.p2 = p;
	}

	/*
	 * clone
	 */
	public Veiculo clone() {
		return new Veiculo();
	}

	/*
	 * equals
	 */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			Veiculo v = (Veiculo) o;
			return (this.marca.equals(v.getMarca())
					&& this.modelo.equals(v.getModelo())
					&& this.cilindrada == (v.getCilindrada())
					&& this.cv == (v.getCV()) && this.p1.equals(v.getPiloto1()) && this.p2
						.equals(v.getPiloto2()));
		}
	}

	/*
	 * toString
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("Marca: " + this.marca + "\n");
		str.append("Modelo: " + this.modelo + "\n");
		str.append("Cilindrada: " + this.cilindrada + "\n");
		str.append("Cavalos: " + this.cv + "\n");
		str.append("Piloto1: " + this.p1.toString() + "\n");
		str.append("Pilto2: " + this.p2.toString() + "\n");

		return str.toString();
	}
}