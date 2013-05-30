
public class PC2Hibrido extends PC2 implements Hibrida {

	public PC2Hibrido() {
		super();
	}

	public PC2Hibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2Hibrido(PC2 pc) {
		super(pc);
	}

	public PC2Hibrido clone() {
		return new PC2Hibrido(this);
	}
	
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC2 Hibrido *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
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

	@Override
	public int getPotenciaMotorElectrico() {
		// TODO Auto-generated method stub
		return 0;
	}
}
