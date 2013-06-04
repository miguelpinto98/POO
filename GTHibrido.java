import java.util.Random;

public class GTHibrido extends GT implements Hibrida {

	private int potencia;
	
	public GTHibrido() {
		super();
		this.potencia=0;
	}

	public GTHibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int pot) {
		super(marca, modelo, cilindrada, cv, p1, p2);
		this.potencia = pot;
	}

	public GTHibrido(GTHibrido g) {
		super(g);
		this.potencia = g.getPotenciaMotorElectrico();
	}
	
	public int getPotenciaMotorElectrico() {
		return this.potencia;
	}
	
	public void setPotenciaMotorElectrico(int potencia) {
		this.potencia=potencia;
	}
	
	public int converteKWtoCV() {
		return (int)(this.potencia/0.7355);
	}

	public int calculaFiabilidade() {
		return (int)(-.05*this.potencia)+85;
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
			if(this.getCilindrada()>3750) {
				if(this.getCV()>400)
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo()*1.1 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo() + this.getCilindrada()/(this.getPilotoActivo())));
			}
			else {
				if(this.getCV()>400) 
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo()*1.5 + this.getCilindrada()/(this.getPilotoActivo())));
				else
					res = (int) ((c.gettempoGT() + r.nextInt(c.gettempoGT()-c.getTrecord())) + (-(this.getCV()+converteKWtoCV())*this.getPilotoActivo() + (this.getCilindrada()*3)/(this.getPilotoActivo())));
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

	public GTHibrido clone() {
		return new GTHibrido(this);
	}
	
	public String toString() { 
 	   StringBuilder str = new StringBuilder("***** GT Hibrido *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Potencia Motor Electrico: " +  this.potencia + "\n");
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
			GTHibrido g = (GTHibrido) o;
			return (this.getMarca().equals(g.getMarca())
					&& this.getModelo().equals(g.getModelo())
					&& this.getCilindrada() == (g.getCilindrada())
					&& this.getCV() == (g.getCV()) 
					&& this.getPiloto1().equals(g.getPiloto1()) 
					&& this.getPiloto2().equals(g.getPiloto2())
					&& this.potencia == (g.getPotenciaMotorElectrico()));
			}
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
