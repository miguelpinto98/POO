import java.util.Random;

public class PC1Normal extends PC1 {
	
	public PC1Normal() {
		super();
	}

	public PC1Normal(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC1Normal(PC1Normal pc) {
		super(pc);
	}
	
	public int calculaFiabilidade() {
		return PC1.fiabilidade;
	}
	
	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception   {
		Random r=new Random();
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
			if(this.getPilotoActivo()>7 && this.getCV()<1000)
				res = (int) ((c.gettempoPC1() + r.nextInt(c.gettempoPC1()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()) + this.getCilindrada()*1.5);
			else
				res = (int) ((c.gettempoPC1() + r.nextInt(c.gettempoPC1()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo()) + this.getCilindrada()/1.5);
			}	
		if(chuva) {
			if(this.ConducaoChuva())
				res+=r.nextInt(c.getDesvioChuva());
			else
				res+=c.getDesvioChuva();
		}
		return res;
	}

	public PC1Normal clone() {
		return new PC1Normal(this);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC1 Normal *****\n");

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
			PC1Normal pn1 = (PC1Normal) o;
			return (this.getMarca().equals(pn1.getMarca())
					&& this.getModelo().equals(pn1.getModelo())
					&& this.getCilindrada() == (pn1.getCilindrada())
					&& this.getCV() == (pn1.getCV()) 
					&& this.getPiloto1().equals(pn1.getPiloto1()) 
					&& this.getPiloto2().equals(pn1.getPiloto2()));
			}
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
