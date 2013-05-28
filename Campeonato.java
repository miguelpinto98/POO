import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Campeonato {

	private HashSet<Corrida> corridas;
	
	Campeonato() {
		this.corridas = new HashSet<Corrida> ();
	}

	Campeonato(HashSet<Corrida> c) {
	    this.corridas = new HashSet<Corrida>();
		for (Corrida a : c)
			this.corridas.add(a.clone());
	}
	
	Campeonato(Campeonato c) {
		for (Corrida a : c.getCorridas())
			this.corridas.add(a);
	}

	// get
	public HashSet<Corrida> getCorridas() {
		HashSet<Corrida> aux = new HashSet<Corrida>();
		for (Corrida a : corridas)
			aux.add(a.clone());
		return aux;
	}

	// set
	public void setCorridas(HashSet<Corrida> c) {
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
	

}