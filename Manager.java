import java.io.*;
import java.util.TreeMap;
import java.util.HashMap;
public class Manager {

	// variaveis de instancia
	private Campeonato campeonato;
	private TreeMap<String, Jogador> apostadores;
	public int corrida;
	public HashMap<Veiculo, Integer> campstatus;
	
	
	public Manager() {
		this.campeonato = new Campeonato();
		this.apostadores = new TreeMap<String, Jogador>();
		this.corrida = 0;
		this.campstatus = new HashMap<Veiculo, Integer>();
	}
	
	public Manager(Campeonato c, TreeMap<String, Jogador> d) {
		this.campeonato = c;
		this.apostadores = d;
		this.corrida = 0;
		this.campstatus = new HashMap<Veiculo, Integer>();
	}
	

	public Manager(Manager m) {
		this.campeonato = m.getCampeonato();
		TreeMap<String, Jogador> aux = m.getapostadores();
		for (String nome : aux.keySet())
			this.apostadores.put(nome, aux.get(nome));
		this.corrida = 0;
		this.campstatus = m.getCampStatus();
	}
	

	// get
	public HashMap<Veiculo, Integer> getCampStatus(){ 
		
		HashMap<Veiculo, Integer> aux = new HashMap<Veiculo, Integer>();
		for(Veiculo v : this.campstatus.keySet()){ aux.put(v, this.campstatus.get(v));
		
		}
		return aux;		
	
	}
	public int getCorrida(){ return this.corrida;}
	public Campeonato getCampeonato() {
		return this.campeonato.clone();
	}

	public TreeMap<String, Jogador> getapostadores() {
		TreeMap<String, Jogador> aux = new TreeMap<String, Jogador>();
		
		for (String nome : this.apostadores.keySet()) {
			aux.put(nome, this.apostadores.get(nome));
		}
		return aux;
	}

	// set
	public void setCorida(){ this.corrida++; }
	public void setCampeonato(Campeonato c) {
		this.campeonato = c;
	}

	public void setApostadores(TreeMap<String, Jogador> c) {
		this.apostadores = c;
	}

	/** Método que devolve um clone da base de dados */
	public Manager clone() {
		return new Manager(this);
	}

	// toString
	public String toString() {
		StringBuilder s = new StringBuilder("Manager  ");
		s.append(campeonato.toString());
		for (String nome : this.apostadores.keySet()) {
			s.append(this.apostadores.get(nome).toString());
		}
		return s.toString();
	}

	// equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Manager m = (Manager) o;
			return this.campeonato.equals(m.getCampeonato())
					&& this.apostadores.equals(m.getapostadores());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void carregaRM(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream o = new ObjectInputStream(f);
        
        this.campeonato = (Campeonato) o.readObject();
        this.apostadores = (TreeMap<String, Jogador>) o.readObject();
        this.campstatus = (HashMap<Veiculo,Integer>) o.readObject();  
        this.corrida = (int) o.readInt();
        o.close();
        f.close();
	}
	
	public void gravaRM(String file) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream o = new ObjectOutputStream(f);
        
        o.writeObject(this.campeonato);
        o.writeObject(this.apostadores);
        o.writeObject(this.campstatus);
        o.writeInt(this.corrida);
        o.close();
        f.close();
	}
}
