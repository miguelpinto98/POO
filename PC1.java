public class PC1 extends Veiculo {

	private static final int cld = 6000;
	private static final double fiabilidade = 0.85;

	public PC1() {
		super();
	}

	/** Construtor por partes */
	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		super(marca, modelo, cld, cv, p1, p2);
	}

	/** Construtor de cópia */
	public PC1(PC1 pc) {
		super(pc);
	}
	
	/** Método que cálcula o tempo da próxima volta*/
	public double tempoProximaVolta() {
		return fiabilidade;
	}

	/** Metodo que devolve um clone de um veiculo PC1 */
	public PC1 clone() {
		return new PC1(this);
	}

	/** Método que represente um PC1 sob forma de string */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("PC1");
		s.append(super.toString());

		return s.toString();
	}

	/** Método que compara dois Veiculos do tipo PC1 */
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}
