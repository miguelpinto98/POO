import java.util.Random;


public class GTNormal extends GT {

	public GTNormal() {
		super();
	}

	public GTNormal(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int hib) {
		super(marca, modelo, cilindrada, cv, p1, p2, hib);
	}

	public GTNormal(GT g) {
		super(g);
	}

	public GTNormal clone() {
		return new GTNormal(this);
	}

	public String toString() {
		return super.toString();
	}
	
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	public int hashCode() {
		return super.hashCode();
	}

	public int calculaFiabilidade() {
		// TODO Auto-generated method stub
		/*	Random r = new Random();
		for(int i=this.getNvoltas(); i>0; i--){
		  return (this.getCilindrada()* (i*r.nextInt(1)))/3000;
		  }
		 */
		return 0;
	}

	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception {
		Random r = new Random();
		int res=0;
		if (this.getVoltas() > 0 )this.setVoltas(this.getVoltas()-1) ; else if (this.getVoltas() ==0){  this.setPilotoActivo();	this.setVoltas(-1); res+=c.getTboxes();}
		if(r.nextInt(calculaFiabilidade()) == 0)
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
