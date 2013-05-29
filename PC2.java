import java.util.*;
import java.io.*;
public class PC2 extends Veiculo {
	private static final double fiabilidade = 70;

	public PC2() {
		super();
	}

	public PC2(String marca, String modelo, int cilindrada, int cv, Piloto p1,
			Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2(PC2 pc) {
		super(pc);
	}
	
	public int calculaFiabilidade() {
		return (int)(fiabilidade*this.getCilindrada())/6000;
	}
	
	//MAIS TESTES
	//res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getPilotoActivo() + (this.getCilindrada()*this.getPilotoActivo())/(this.getCV()*this.getCilindrada())));		
	//res = (int) ((c.gettempoPC2() + r.nextInt(c.gettempoPC2()-c.getTrecord())) + (-this.getCV()*this.getCilindrada()*this.getPilotoActivo()*1.2 + this.getCilindrada()/(this.getPilotoActivo())));
	public int tempoProximaVolta(Circuito c, boolean chuva) throws Exception   {
		Random r = new Random();
		int res=0;
		if (this.getVoltas() > 0 )this.setVoltas(this.getVoltas()-1) ; else if (this.getVoltas() ==0){  this.setPilotoActivo();	this.setVoltas(-1); res+=c.getTboxes();}
		if(r.nextInt(fiabilidade) == 0)
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

	/** Clone */
	public PC2 clone() {
		return new PC2(this);
	}

	/** ToString */
	public String toString() {
		StringBuilder str = new StringBuilder("***** PC2 *****\n");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}

	/** Equals */ //ESTE METODO NÃO DEVE SER ASSIM, PORTANTO DUVIDA
	public boolean equals(Object o) {
		return (super.equals(o));
	}
}