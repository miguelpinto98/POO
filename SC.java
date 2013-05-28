import java.util.Random;

public class SC extends Veiculo {
	private static final int cld = 2500;
	
	public SC() {
		super();
	}

	public SC(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca,modelo,cld,cv,p1,p2,0);
	}
	
	public SC(SC s) {
		super(s);
		this.setCilindrada(cld);
	}
	
	public double calculaFiabilidade() {                     
		return (.75*this.getPilotoActivo() + .25*this.getCilindrada()); //Preciso rever e melhorar isto
	}
	
	public int tempoProximaVolta(Circuito c, boolean chuva) { 
		Random r = new Random();
		int res=0;
		
		if(r.nextInt(1) == 2)
			res = -1000;
		else {
			if(this.getPilotoActivo()>7 && this.getCV()<250)
				res = (int) ((int) c.gettempoSC() + r.nextInt(c.gettempoSC()-c.getTrecord()) + (-this.getCV()*this.getPilotoActivo() + this.getCilindrada()));
			else
				res = (int) ((int) c.gettempoSC() + r.nextInt(c.gettempoSC()-c.getTrecord()) + (-this.getCV()*this.getPilotoActivo()*2.5 + this.getCilindrada()));
		}
		
		if(chuva) {
			if(this.ConducaoChuva())
				res+=r.nextInt(c.getDesvioChuva());
			else
				res+=c.getDesvioChuva();
		}
		return res;
	}
	
	/** Clone*/
	public Veiculo clone() {
		return new SC(this);
	}
	
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	/** ToString*/
    	 public String toString(){ 
    	   StringBuilder str = new StringBuilder("***** SC *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
}
