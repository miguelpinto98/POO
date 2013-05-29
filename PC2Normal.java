import java.util.Random;

public class PC2Normal extends PC2 {

	public PC2Normal() {
		super();
	}

	public PC2Normal(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2Normal(PC2 pc) {
		super(pc);
	}

	public PC2Normal clone() {
		return new PC2Normal(this);
	}
	
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public int calculaFiabilidade() {
		return (int)(PC2.fiabilidade*this.getCilindrada())/6000;
	}

	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
		Random r = new Random();
		int res=0;
		if (this.getVoltas() > 0 )this.setVoltas(this.getVoltas()-1) ; else if (this.getVoltas() ==0){  this.setPilotoActivo();	this.setVoltas(-1); res+=c.getTboxes();}
		if(r.nextInt(PC2.fiabilidade) == 0)
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
