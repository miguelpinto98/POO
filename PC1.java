import java.util.Random;
import java.lang.Math;

public class PC1 extends Veiculo {

	private static final int cld = 6000;
	private double fiabilidade = 0.85;

	public PC1() {
		super();
	}

	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1,
			Piloto p2, int h) {
		super(marca, modelo, cld, cv, p1, p2, h);
	}

	/** Clone */
	public PC1 clone() {
		return new PC1(this);
	}

	public PC1(PC1 pc) {
		super(pc);
		this.setCilindrada(cld);
	}

	public void setCilindrada(int cl) {

		super.setCilindrada(cl);
	}

	/** ToString */
	public String toString() {
		StringBuilder str = new StringBuilder("PC1 ");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}

	/** Equals */
	public boolean equals(Object o) {
		return (super.equals(o));
	}

	public int tempoProximaVolta(Circuito c, boolean chuva) {
		Random r = new Random();
		int res=0;
				
		if(r.nextInt(85) == 0)
			res = -1000;
		else {
			res = (int) (c.gettempoPC1() + r.nextInt(c.gettempoPC1()/c.getDistancia() + (c.gettempoPC1()-c.getTrecord())) - ((int)(this.getPilotoActivo()*1000 + ((this.getCilindrada()+this.getCV())/(this.getCilindrada()-this.getCV())))));
		}
		return res;
	}
}
