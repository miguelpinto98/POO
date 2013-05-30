import java.io.*;
import java.util.HashMap;

public class Manager {

	// variaveis de instancia
	private Campeonato campeonato;
	private HashMap<String, Jogador> apostadores;

	public Manager() {
		this.campeonato = new Campeonato();
		this.apostadores = new HashMap<String, Jogador>();
	}
	
	public Manager(Campeonato c, HashMap<String, Jogador> d) {
		this.campeonato = c;
		this.apostadores = d;
	}

	public Manager(Manager m) {
		this.campeonato = m.getCampeonato();
		HashMap<String, Jogador> aux = m.getapostadores();
		for (String nome : aux.keySet())
			this.apostadores.put(nome, aux.get(nome));
	}

	// get
	public Campeonato getCampeonato() {
		return this.campeonato.clone();
	}

	public HashMap<String, Jogador> getapostadores() {
		HashMap<String, Jogador> aux = new HashMap<String, Jogador>();
		
		for (String nome : this.apostadores.keySet()) {
			aux.put(nome, this.apostadores.get(nome).clone());
		}
		return aux;
	}

	// set
	public void setCampeonato(Campeonato c) {
		this.campeonato = c;
	}

	public void setApostadores(HashMap<String, Jogador> c) {
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
        this.apostadores = (HashMap<String,Jogador>) o.readObject();
            
        o.close();
        f.close();
	}
	
	public void gravaRM(String file) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream o = new ObjectOutputStream(f);
        
        o.writeObject(this.campeonato);
        o.writeObject(this.apostadores);
        
        o.close();
        f.close();
	}
}
