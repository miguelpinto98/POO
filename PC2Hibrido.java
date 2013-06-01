import java.util.Random;


public class PC2Hibrido extends PC2 implements Hibrida {
	
	private int potencia;
	
	public PC2Hibrido() {
		super();
		this.potencia = 0;
	}

	public PC2Hibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h, int pot) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
		this.potencia = pot;
	}

	public PC2Hibrido(PC2Hibrido pc) {
		super(pc);
		this.potencia = pc.getPotenciaMotorElectrico();
	}
	
	public int getPotenciaMotorElectrico() {
		return this.potencia;
	}
	
	public void setPotenciaMotorElectrico(int potencia) {
		this.potencia = potencia;
	}
	

	public PC2Hibrido clone() {
		return new PC2Hibrido(this);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			PC2Hibrido ph2 = (PC2Hibrido) o;
			return (this.getMarca().equals(ph2.getMarca())
					&& this.getModelo().equals(ph2.getModelo())
					&& this.getCilindrada() == (ph2.getCilindrada())
					&& this.getCV() == (ph2.getCV()) 
					&& this.getPiloto1().equals(ph2.getPiloto1()) 
					&& this.getPiloto2().equals(ph2.getPiloto2())
					&& this.potencia == (ph2.getPotenciaMotorElectrico()));
			}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC2 Hibrido *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Potencia Motor Electrico: " +  this.potencia + "\n");
		str.append("Piloto 1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto 2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public int converteKWtoCV() {
		return (int)(this.potencia/0.7355);
	}
	
	public int calculaFiabilidade() {
		return (int)(-.05*this.potencia)+90;
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
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
			}
			else {
				if(this.getCV()>500) 
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
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
