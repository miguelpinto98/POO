
public class PC1Hibrido extends PC1 implements Hibrida {

	public PC1Hibrido() {
		super();
	}

	public PC1Hibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC1Hibrido(PC1 pc) {
		super(pc);
	}

	public PC1Hibrido clone() {
		return new PC1Hibrido(this);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public int calculaFiabilidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
