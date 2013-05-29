import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Collection;

public class Corrida {

	private HashSet<Veiculo> conjveiculos;
	private Circuito crt;
	private boolean piso;

	public Corrida() {
		this.conjveiculos = new HashSet<Veiculo>();
		this.crt = new Circuito();
		this.piso = false;
	}

	public Corrida(HashSet<Veiculo> v, Circuito c, boolean p) {
		this.conjveiculos = new HashSet<Veiculo>();
		for (Veiculo vc : v)
			this.conjveiculos.add(vc);
		this.crt = c;
		this.piso = p;
	}

	public Corrida(Corrida c) {
		this.conjveiculos = c.getConjuntoVeiculos();
		this.crt = c.getCircuito();
		this.piso = c.getPiso();
	}

	public HashSet<Veiculo> getConjuntoVeiculos() {
		HashSet<Veiculo> aux = new HashSet<Veiculo>();

		for (Veiculo vc : this.conjveiculos)
			aux.add(vc.clone());

		return aux;
	}

	public Circuito getCircuito() {
		return this.crt;
	}

	public boolean getPiso() {
		return this.piso;
	}

	public void setConjuntoVeiculos(HashSet<Veiculo> vc) {
		this.conjveiculos = vc;
	}

	public void setCircuito(Circuito c) {
		this.crt = c;
	}

	public void setPiso(boolean p) {
		this.piso = p;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append("-----------------Corrida-------------------\n");
		s.append("N��mero de Veiculos: " + this.conjveiculos.size() + "\n");
		s.append("Circuito: " + this.crt.toString() + "\n");
		s.append("Piso Molhado: " + this.piso + "\n");
		s.append("-------------------------------------------\n");

		return s.toString();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || (o.getClass() != this.getClass()))
			return false;
		Corrida v = (Corrida) o;
		return this.conjveiculos.equals(v.getConjuntoVeiculos())
				&& this.crt.equals(v.getCircuito())
				&& this.piso == (v.getPiso());
	}

	public Corrida clone() {
		return new Corrida(this);
	}

	public HashMap<Veiculo, Integer> fazVolta(boolean troca) { int x = 0;
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();

		for (Veiculo v : this.conjveiculos) {
			
			try{ x = v.tempoProximaVolta(this.crt, this.piso);
			      aux.put(v,x); 
			
			} catch(Exception e)  {
				
				conjveiculos.remove(v); aux.put(v,-1);}
		 
			
			
		}
		return aux;
	}

	public void fazVoltas(HashMap<Veiculo, Integer> c, int nvoltas) {
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		int count=0;
		boolean troca = false;
		for (Veiculo v : aux.keySet()) { 
			v.voltaracio(nvoltas);
		}
		for (int i = 0; i < nvoltas; i++) {
			aux = fazVolta(troca);
			count++;

			
			for (Veiculo v : aux.keySet()) { 
				
				if(aux.get(v) != -1) 
				c.put(v, c.get(v) + aux.get(v));
				else c.put(v, -1);
			}
			
			
		}

	}

	public void alteraPilotos() {
		for(Veiculo v : this.conjveiculos)
			v.setPiloto(v.getPiloto2());
	}

	public HashMap<Veiculo, Integer> fazCorrida(HashMap<Veiculo, Integer> c) {
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		TreeMap<Integer, Veiculo> aux2 = new TreeMap<Integer, Veiculo>();
		int x = 0;
		Veiculo v1 = null;

		for (Veiculo v : conjveiculos) {
			aux.put(v, 0);
		}

		this.fazVoltas(aux, crt.getNvoltas());
		
		for (Veiculo v : conjveiculos) {
			aux2.put(aux.get(v), v);
		}

		Collection<Veiculo> ca = aux2.values();
		Iterator<Veiculo> aux2it = ca.iterator();

		while (aux2it.hasNext()) {
			v1 = (Veiculo) aux2it.next();
			
			c.put(v1,c.get(v1) + (30 - x * 2));
	      x++;
		}
		return aux;
	}
	
	
}
