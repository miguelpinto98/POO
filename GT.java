import java.util.Random;

public class GT extends Veiculo{
	public static int nvoltas = 1;

	public GT() {
		super();
	}
	
	public GT(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca,modelo,cilindrada,cv,p1,p2, hib);
	}
	
	public GT(GT g) {
		super(g);
	}
	
	public int calculaFiabilidade() {
		Random r = new Random();
		for(int i=this.getNvoltas(); i>0; i--){
		  return (this.getCilindrada()* (i*r.nextInt(1)))/3000;
		  }
		
	}
	
	public int tempoProximaVolta(Circuito c , boolean  chuva) {
		Random r = new Random();
		int res=0;
	
		if(r.nextInt(1) == 2)
			res = -1000;
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
	
	/** Clone*/
	public Veiculo clone() {
		return new GT(this);
	}
	
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	/** ToString*/
    	 public String toString(){ 
    	   StringBuilder str = new StringBuilder("***** GT *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
}
