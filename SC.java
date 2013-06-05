import java.util.Random;

public class SC extends Veiculo {
	private static final int cld = 2500;
	
	public SC() {
		super();
	}

	public SC(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2) {
		super(marca,modelo,cld,cv,p1,p2);
	}
	
	public SC(SC s) {
		super(s);
		this.setCilindrada(cld);
	}
	
	public int calculaFiabilidade() {                     
		return (int) (1.5*this.getPilotoActivo()+60);
	}
	
	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception   {
		Random r = new Random();
		int res=0;
		
		if (this.getVoltas()>0)
			this.setVoltas(this.getVoltas()-1);
		else 
			if (this.getVoltas() ==0) {
				this.setPilotoActivo();
				
				this.setVoltas(-1);
				res+=c.getTboxes();
			}
				
		if(r.nextInt(100) == calculaFiabilidade())
			throw new Exception("DNF");
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
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			SC sc = (SC) o;
			return (this.getMarca().equals(sc.getMarca())
					&& this.getModelo().equals(sc.getModelo())
					&& this.getCilindrada() == (sc.getCilindrada())
					&& this.getCV() == (sc.getCV()) 
					&& this.getPiloto1().equals(sc.getPiloto1()) 
					&& this.getPiloto2().equals(sc.getPiloto2()));
			}
	}
	
	/** ToString*/
    	 public String toString(){ 
    	   StringBuilder str = new StringBuilder("***** SC *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto 1: " + this.getPiloto1().toString() + "\n");
		str.append("Piloto 2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
}
