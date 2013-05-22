public abstract class Veiculo {
	private String marca;
	private String modelo;
	private int cilindrada;
	private int cv;
	private Piloto p1;
	private Piloto p2;
	private int hibrido;

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
		this.hibrido = 0;
	}

	public Veiculo(String marca, String modelo, int cilindrada, int cv,
			Piloto p1, Piloto p2,int h) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.cv = cv;
		this.p1 = p1;
		this.p2 = p2;
		this.hibrido = h;
	}

	public Veiculo(Veiculo v) {
		this.marca = v.getMarca();
		this.modelo = v.getModelo();
		this.cilindrada = v.getCilindrada();
		this.cv = v.getCV();
		this.p1 = v.getPiloto1();
		this.p2 = v.getPiloto2();
		this.hibrido = v.getHibrido();
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
	
	public int getHibrido() {
		return this.hibrido;
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
	
	public void setHibrido(int h) {
		this.hibrido = h;
	}

	/*
	 * clone
	 */
	public abstract Veiculo clone() ;

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