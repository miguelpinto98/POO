import java.util.Random;

public class PC1 extends Veiculo {

	private static final int cld = 6000;
	private double fiabilidade = 0.70;

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
		
		// int res = c.getTpc1() + r.nextInt() - ((int)(this.getPilotoActivo()*1000 + ((this.getCilindrada()+this.getCV())/(this.getCilindrada()-this.getCV()))*fiabilidade));
		// int res = c.getTpc1() + r.nextInt(c.getDistancia() + c.getTpc1()) -(this.getPilotoActivo()*1000);
		
		if(r.nextInt(80) == 0)
			res = -1000;
		else {
			//System.out.println(c.getTpc1());
			res = r.nextInt(c.getTpc1()) - ((10-this.getPilotoActivo())+this.getCV()*this.getCilindrada());
		}
			

		return res;

	}
}
