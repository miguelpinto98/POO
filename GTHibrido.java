
public class GTHibrido extends GT implements Hibrida {

	public GTHibrido() {
		super();
	}

	public GTHibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca, modelo, cilindrada, cv, p1, p2, hib);
	}

	public GTHibrido(GT g) {
		super(g);
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

	public GTHibrido clone() {
		return new GTHibrido(this);
	}
	
	public String toString() { 
 	   StringBuilder str = new StringBuilder("***** GT Hibrida *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public int getPotenciaMotorElectrico() {
		// TODO Auto-generated method stub
		return 0;
	}
}
