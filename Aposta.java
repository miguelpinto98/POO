import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
public class Aposta {
	private double quant;
	private Veiculo p1, p2, p3;
	private Corrida corr;

	public Aposta(double q, Veiculo p1, Veiculo p2, Veiculo p3,Corrida c) {
		this.quant = q;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.corr = c;
	}

	public Aposta(Aposta p) {
		this.quant = p.getQuant();
		this.p1 = p.getP1().clone();
		this.p2 = p.getP3().clone();
		this.p3 = p.getP2().clone();
		this.corr = p.getCorrida().clone();
	}

	// get
	public double getQuant() {
		return this.quant;
	}

	public Veiculo getP1() {
		return this.p1;
	}

	public Veiculo getP2() {
		return this.p2;
	}

	public Veiculo getP3() {
		return this.p3;
	}
	
	public Corrida getCorrida(){
		return this.corr;
	}
	// Set
	public void setQuant(int i) {
		this.quant = i;
	}

	public void setP1(Veiculo p) {
		this.p1 = p;
	}

	public void setP2(Veiculo p) {
		this.p2 = p;
	}

	public void setP3(Veiculo p) {
		this.p3 = p;
	}
	
	public void setCorr(Corrida c) {
		this.corr = c;
	}
	
    /** Método que devolve um clone de uma aposta */
	public Aposta clone() {
		return new Aposta(this);
	}

    /** Método que represente uma aposta sob forma de string */
	public String toString() {
		StringBuilder s = new StringBuilder("+++ Aposta +++\n");

		s.append("Aposto: " + this.quant);
		s.append("Veiculo: \n" + this.p1.toString() + "\n" + this.p2.toString() + "\n" +this.p3.toString() + "\n");
		s.append("Corrida: " + this.corr.toString());

		return s.toString();
	}
    
	/** Método que compara duas apostas */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Aposta v = (Aposta) o;
			return (v.getP1().equals(this.getP1())
					&& v.getP2().equals(this.getP2())
					&& v.getP3().equals(this.getP3()) 
					&& v.getQuant() == this.getQuant());
		}
	}
	
	public int checkAposta(HashMap<Veiculo,Integer> c){ 
		int res=0, t1=0, t2=0, t3=0;
		Veiculo v1 = null, v2 = null, v3 = null;
		
		TreeMap<Integer, Veiculo> aux2 = new TreeMap<Integer, Veiculo>();
		
		
		for (Veiculo v : c.keySet()) {
		if(aux2.containsKey(c.get(v)) == false)	aux2.put(c.get(v), v);
		else aux2.put(c.get(v)+1, v);
		}
	  Iterator<Integer> veit = aux2.keySet().iterator();
	 t1 = veit.next(); v1 = aux2.get(t1);
	 t2 = veit.next();v2 = aux2.get(t2);
	 t3 = veit.next();v3 = aux2.get(t3);
	 	/*for(Veiculo v : c.keySet()) {
			if(c.get(v) < t1) {
				t3 = t2; 
			   	t2 = t1; 
			   	t1 = c.get(v);  
			   	
			   if(v3!=null)	v3 = v2.clone();
			   if(v2!=null)	v2 = v1.clone();
			   	v1 =  v.clone();
			   	} 
			else	{
				if (c.get(v) < t2) {
					t3 = t2;
					t2 = c.get(v); 
					 if(v3!=null)v3 = v2.clone(); 
					v2 =  v.clone();
				   	}
				else 
					if(c.get(v) < t3) {
						t3 = c.get(v);
						v3 = v.clone();
					}
			}
		}*/
	    if(v1.equals(p1) && v1 != null)  	
	    	res+=1;
	    if(v2.equals(p2) &&	v3 != null) 
	    	res+=2;
	    if(v3.equals(p3)&& v3 != null) 	
	    	res+=4;
	   
	    return res; 
	}
}