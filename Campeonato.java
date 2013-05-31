import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Campeonato {

	private TreeSet<Corrida> corridas;
	
	Campeonato() {
		this.corridas = new TreeSet<Corrida> ();
	}

	Campeonato(TreeSet<Corrida> c) {
	    this.corridas = new TreeSet<Corrida>();
		for (Corrida a : c)
			this.corridas.add(a.clone());
	}
	
	Campeonato(Campeonato c) { this.corridas =  new TreeSet<Corrida> ();
		for (Corrida a : c.getCorridas())
			this.corridas.add(a);
	}

	// get
	public TreeSet<Corrida> getCorridas() {
		TreeSet<Corrida> aux = new TreeSet<Corrida>();
		for (Corrida a : corridas)
			aux.add(a.clone());
		return aux;
	}

	// set
	public void setCorridas(TreeSet<Corrida> c) {
		this.corridas = c;
	}
	
	// clone
	public Campeonato clone() {
		return new Campeonato(this);
	}

	// toString
	public String toString() {
		StringBuilder s = new StringBuilder("Campeonato \n");
		for (Corrida a : corridas)
			s.append(a.toString());

		return s.toString();

	}

	// equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Campeonato c = (Campeonato) o;
			return this.corridas.equals(c.getCorridas());
		}

	}
    
	public TreeMap<Integer,Veiculo> fazCampeonato(){
	   
	   TreeMap<Integer,Veiculo> aux = new TreeMap<Integer,Veiculo>();
	   HashMap<Veiculo,Integer> aux2 = new HashMap<Veiculo,Integer>();
	   for(Corrida r : corridas){ r.fazCorrida(aux2);
	   
	   }
	   for( Veiculo v: aux2.keySet()){
	        aux.put(aux2.get(v), v);
	   }
	   return aux;
	}
	
	public static Campeonato geraCampeonato() {
		Random r = new Random();
		int x=r.nextInt(10)+11, i=0;
		TreeSet<Corrida> aux = new TreeSet<Corrida>();
		HashSet<Veiculo> aux2 = new HashSet<Veiculo>();
		
		aux2=Veiculo.geraVeiculos();
		while (i<x) {
			aux.add(Corrida.geraCorrida(aux2));
			i++;
		}
		return (new Campeonato(aux));
	}
}