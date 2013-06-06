import java.util.Random;

public class GTNormal extends GT {
	
	public static int nvoltas = 0;

	public GTNormal() {
		super();
	}

	public GTNormal(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		super(marca, modelo, cilindrada, cv, p1, p2);
	}

	public GTNormal(GTNormal g) {
		super(g);
	}

	public GTNormal clone() {
		return new GTNormal(this);
	}

	public String toString() { 
 	   StringBuilder str = new StringBuilder("***** GT Normal *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto 1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto 2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			GTNormal g = (GTNormal) o;
			return (this.getMarca().equals(g.getMarca())
					&& this.getModelo().equals(g.getModelo())
					&& this.getCilindrada() == (g.getCilindrada())
					&& this.getCV() == (g.getCV()) 
					&& this.getPiloto1().equals(g.getPiloto1()) 
					&& this.getPiloto2().equals(g.getPiloto2()));
			}
	}
	
	public int hashCode() {
		return super.hashCode();
	}

	public int calculaFiabilidade() {
		return (1/3)*nvoltas + 85;
	}

	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
		Random r = new Random();
		int res=0;
		if (this.getVoltas()>0)
			this.setVoltas(this.getVoltas()-1);
		else
			if(this.getVoltas()==0) {
				this.setPilotoActivo();
				this.setVoltas(-1);
				res+=c.getTboxes();
			}
		
		if(r.nextInt(100) >= calculaFiabilidade())
			throw new Exception("DNF");
		else {
			if(this.getCilindrada()>3750) {
				if(this.getCV()>400)
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()*1.1 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
			}
			else {
				if(this.getCV()>400) 
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()*1.5 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + (this.getCilindrada()*3)/(this.getPilotoActivo())));
			}
		}
		
		if(chuva) {
			if(this.ConducaoChuva())
				res+=r.nextInt(c.getDesvioChuva());
			else
				res+=c.getDesvioChuva();
		}
		nvoltas++;
		return res;
	}
}
