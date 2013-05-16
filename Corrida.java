import java.util.HashSet;

public class Corrida {

	private HashSet<Veiculo> conjveiculos;
	private Circuito crt;
	private boolean piso;
	
	public Corrida() {
		this.conjveiculos = new HashSet<Veiculo> ();
		this.crt = new Circuito();
		this.piso = false;
	}
	
	public Corrida(HashSet<Veiculo> v, Circuito c, boolean p) {
		for(Veiculo vc : v)
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
		HashSet<Veiculo> aux = new HashSet<Veiculo> ();
		
		for(Veiculo vc : this.conjveiculos)
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
	
	public Corrida clone() {
		return new Corrida(this);
	}
}
