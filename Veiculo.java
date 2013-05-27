import java.util.HashSet;

public abstract class Veiculo {
	private String marca;
	private String modelo;
	private int cilindrada;
	private int cv;
	private Piloto p1;
	private Piloto p2;
	private int hibrido;
	private boolean pactivo;

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
		this.pactivo = true;
	}

	public Veiculo(String marca, String modelo, int cilindrada, int cv,
			Piloto p1, Piloto p2, int h) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.cv = cv;
		this.p1 = p1;
		this.p2 = p2;
		this.hibrido = h;
		this.pactivo = true;
	}

	public Veiculo(Veiculo v) {
		this.marca = v.getMarca();
		this.modelo = v.getModelo();
		this.cilindrada = v.getCilindrada();
		this.cv = v.getCV();
		this.p1 = v.getPiloto1();
		this.p2 = v.getPiloto2();
		this.hibrido = v.getHibrido();
		this.pactivo = v.getPactivo();
	}

	/*
	 * Métodos de Instância
	 */
	public boolean getPactivo() {
		return this.pactivo;
	}

	public int getPilotoActivo() {
		int x = 0;
		if (pactivo == true)
			x = p1.getQualidade();
		if (pactivo == false)
			x = p2.getQualidade();
		return x;
	}

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

	public void setPilotoActivo() {
		if (pactivo == true)
			pactivo = false;
		if (pactivo == false)
			pactivo = true;
	}

	public boolean ConducaoChuva() {
		boolean x = false;
		if (pactivo == true)
			x = p1.getChuva();
		if (pactivo == false)
			x = p2.getChuva();
		return x;
	}

	/*
	 * clone
	 */
	public abstract Veiculo clone();

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
	public abstract String toString();

	public abstract int tempoProximaVolta(Circuito c, boolean chuva);
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.cilindrada;
		result = prime * result + this.cv;
		result = prime * result + this.hibrido;
		result = prime * result + ((this.marca == null) ? 0 : this.marca.hashCode());
		result = prime * result + ((this.modelo == null) ? 0 : this.modelo.hashCode());
		return result;
	}
public  HashSet<Veiculo> geraVeiculos(){
	
	
	
	
}
	
	
}