import java.util.Random;


public class PC1Hibrido extends PC1 implements Hibrida {

	private int potencia;
	
	public PC1Hibrido() {
		super();
		this.potencia = 0;
	}

	public PC1Hibrido(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h, int p) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
		this.potencia=p;
	}

	public PC1Hibrido(PC1Hibrido pc) {
		super(pc);
		this.potencia = pc.getPotenciaMotorElectrico();
	}
	
	public int getPotenciaMotorElectrico() {
		return this.potencia;
	}
	
	public void setPotenciaMotorElectrico(int potencia) {
		this.potencia = potencia;
	}
	
	public PC1Hibrido clone() {
		return new PC1Hibrido(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder("***** PC1 Hibrido *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Potencia: " + this.getPotenciaMotorElectrico() + "\n");
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
			PC1Hibrido ph1 = (PC1Hibrido) o;
			return (this.getMarca().equals(ph1.getMarca())
					&& this.getModelo().equals(ph1.getModelo())
					&& this.getCilindrada() == (ph1.getCilindrada())
					&& this.getCV() == (ph1.getCV()) 
					&& this.getPiloto1().equals(ph1.getPiloto1()) 
					&& this.getPiloto2().equals(ph1.getPiloto2())
					&& this.potencia == (ph1.getPotenciaMotorElectrico()));
			}
	}
	public int hashCode() {
		return super.hashCode();
	}

	public int converteKWtoCV() {
		return (int)(this.potencia/0.7355);
	}
	
	public int calculaFiabilidade() {
		return (int)(-.075*this.potencia)+95;
	}
	

	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
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
				res = (int) ((c.gettempoPC1() + r.nextInt(c.gettempoPC1()-c.getTrecord())) + (-(this.getCV()+this.converteKWtoCV())*this.getPilotoActivo()) + this.getCilindrada()*1.5);
			else
				res = (int) ((c.gettempoPC1() + r.nextInt(c.gettempoPC1()-c.getTrecord())) + (-(this.getCV()+this.converteKWtoCV())*this.getPilotoActivo()) + this.getCilindrada()/1.5);
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
