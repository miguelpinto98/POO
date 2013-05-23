import java.util.Random;    
public class PC1 extends Veiculo{
    
    	private static final int cld = 6000;
    	private double fiabilidade = 0.70;
    
    	public PC1() {
    		super();
    	}
    
    	public PC1(String marca, String modelo, int cilindrada, int cv, Piloto p1, Piloto p2, int h) {
    		super(marca, modelo, cld, cv, p1, p2, h);
    	}
    
    	
    
    	/** Clone*/	 
    	public PC1 clone() {
    		return new PC1(this);
    	}
    
    	
    	public PC1 (PC1 pc) {
            super(pc);
            this.setCilindrada(cld);      
        }
        
        public void setCilindrada(int cl){
        
        super.setCilindrada(cl);
        }
    	/** ToString*/
    	public String toString() {
    		StringBuilder s = new StringBuilder();
    		s.append("PC1");
    		s.append(super.toString());
    
    		return s.toString();
    	}
    
    	/** Equals*/
    	public boolean equals(Object o) {
    		return (super.equals(o));
    	}
    	private double Escala(int cil, int cav){
    	    

    	    double x1 = (cil+cav)*fiabilidade;
    	    
    	    
    	    
    	    
    	    return x1;
    	   }
    	public int tempoProximaVolta(Veiculo v, Circuito c,boolean chuva){
    	    Random r = new Random();
    	    int res = c.getTpc1() + r.nextInt(c.getTdesviom())- ((int)(v.getPilotoActivo()* 500 + Escala(v.getCilindrada(),v.getCV() ) )) ;
    	    /*int xaxa = c.getTpc1() - c.getTrecord();
    	    System.out.println(xaxa + "\n");*/
    	   if(res < c.getTrecord()) c.setTrecord(res);
    	 return res;
    	   
    	   }
    }
