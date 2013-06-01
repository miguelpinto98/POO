import java.util.Random;

public class PC2Normal extends PC2 {

	public PC2Normal() {
		super();
	}

	public PC2Normal(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2Normal(PC2Normal pc) {
		super(pc);
	}

	public PC2Normal clone() {
		return new PC2Normal(this);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			PC2Normal pn2 = (PC2Normal) o;
			return (this.getMarca().equals(pn2.getMarca())
					&& this.getModelo().equals(pn2.getModelo())
					&& this.getCilindrada() == (pn2.getCilindrada())
					&& this.getCV() == (pn2.getCV()) 
					&& this.getPiloto1().equals(pn2.getPiloto1()) 
					&& this.getPiloto2().equals(pn2.getPiloto2()));
			}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC2 Normal *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto 1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto 2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public int calculaFiabilidade() {
		return (int)(0.01*this.getCilindrada() + 40);
	}

	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
		Random r = new Random();
		int res=0;
		
		if(this.getVoltas()>0)
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
			if(this.getCilindrada()>5000) {
				if(this.getCV()>500)
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
			}
			else {
				if(this.getCV()>500) 
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
			}
		}
		
		if(chuva) {
			if(this.ConducaoChuva())
				res+=r.nextInt(c.getDesvioChuva());
			else
				res+=c.getDesvioChuva();
		}
		return res;
	}
}
