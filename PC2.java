import java.util.*;

public class PC2 extends Veiculo{

	//private int cld;
	//private double fiabilidade = 0.70;

	public PC2() {
		super();
	}

	public PC2(String marca, String modelo, int cilindrada, int cv,
		Piloto p1, Piloto p2, int h) {
		super(marca, modelo, cilindrada, cv, p1, p2, h);
	}

	public PC2(PC2 pc) {
		super(pc);
	}

	/** Clone*/	 
	public PC2 clone() {
		return new PC2(this);
	}

	
	/** ToString*/
    	 public String toString(){ 
    	   StringBuilder str = new StringBuilder("PC1 ");

		str.append("Marca: " + this.getMarca() + "\n");
		str.append("Modelo: " + this.getModelo() + "\n");
		str.append("Cilindrada: " + this.getCilindrada() + "\n");
		str.append("Cavalos: " + this.getCV() + "\n");
		str.append("Piloto1: " + this.getPiloto1().toString() + "\n");
		str.append("Pilto2: " + this.getPiloto2().toString() + "\n");

		return str.toString();
	}
	public int tempoProximaVolta(Circuito c , boolean  chuva) { return 1;}
	/** Equals*/
	public boolean equals(Object o) {
		return (super.equals(o));
	}
	
	public PC2 criaRandomPC2(){
	   Random r = new Random();
	   int pc2 = r.nextInt(5);
	   
	   switch (pc2){
	       case 0 : new PC2("Ferrari", "Enzo", r.nextInt(2000)+4000, r.nextInt(200)+800, p1, p1, 0);
	       case 1 : new PC2("Ascari", "A10", r.nextInt(2000)+4000, r.nextInt(200)+800, p2, p2, 0);
	       case 2 : new PC2("Aston Martin", "V12 Zagato", r.nextInt(2000)+4000, r.nextInt(200)+800, p3, p3, 0);
	       case 3 : new PC2("Mercedes-Benz", "Lotec C1000 ", r.nextInt(2000)+4000, r.nextInt(200)+800, p5, p5, 0);
	       case 4 : new PC2("Edonis", "", r.nextInt(2000)+4000, r.nextInt(200)+800, p4, p4, 0);
	       
	   }
	   
	   return PC2;
	   }
}