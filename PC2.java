

public class PC2 extends Veiculo{

	private int cld;
	private double fiabilidade = 0.70;

	public PC2() {
		super();
	}

	/** Construtor por partes */
	public PC2(String marca, String modelo, int cilindrada, int cv,
		Piloto p1, Piloto p2) {
		super(marca, modelo, cld, cv, p1, p2);
		
	}

	/** Construtor de cópia */
	public PC2(PC2 pc) {
		super(pc);
	}

	/** Metodo que devolve um clone de um pc1 */
	 
	public PC2 clone() {
		return new PC2(this);
	}

	/** Método que represente um pc1 sob forma de string */
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("PC2  ");
		s.append(super.toString());

		return s.toString();
	}

	/** Método que compara dois pc1 */

	public boolean equals(Object o) {
		return (super.equals(o));
	}
}