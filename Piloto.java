import java.util.*;

public class Piloto {
	private String nome;
	private String nacionalidade;
	private int palmares;
	private int qualidade;
	private boolean chuva;

	/*
	 * Constructor for objects of class Piloto
	 */
	public Piloto() {
		this.nome = "";
		this.nacionalidade = "";
		this.palmares = 0;
		this.qualidade = 0;
		this.chuva = false;
	}

	public Piloto(String nome, String nacionalidade, int palmares,
			int qualidade, boolean chuva) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.palmares = palmares;
		this.qualidade = qualidade;
		this.chuva = chuva;
	}

	public Piloto(Piloto p) {

		this.nome = p.getNome();
		this.nacionalidade = p.getNacionalidade();
		this.palmares = p.getPalmares();
		this.qualidade = p.getQualidade();
		this.chuva = p.getChuva();
	}

	// get
	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public boolean getChuva() {
		return this.chuva;
	}

	public String getNome() {
		return this.nome;
	}

	public int getPalmares() {
		return this.palmares;
	}

	public int getQualidade() {
		return this.qualidade;
	}

	// set
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setPalmares(int palmares) {
		this.palmares = palmares;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}

	public void setChuva(boolean chuva) {
		this.chuva = chuva;
	}

	// clone
	public Piloto clone() {
		return new Piloto(this);
	}

	// equals
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Piloto v = (Piloto) o;
			return (v.getNome().equals(this.getNome())
					&& v.getNacionalidade().equals(this.getNacionalidade())
					&& v.getPalmares() == this.getPalmares()
					&& this.getChuva() == v.getChuva() && v.getQualidade() == this
					.getQualidade());
		}
	}

	// toString
	public String toString() {
		StringBuilder s = new StringBuilder("Piloto ");

		s.append("Nome: " + this.nome + "\n");
		s.append("Nacionalidade: " + this.nacionalidade + "\n");
		s.append("Palmares: " + this.palmares + "\n");
		s.append("Qualidade: " + this.qualidade + "\n");
		s.append("Chove: " + this.chuva + "\n");

		return s.toString();
	}
	
	public Piloto criaRandomPiloto(){
	   Random r = new Random();
	   int piloto = r.nextInt(10);
	   
	   switch (piloto){
	       case 0 : new Piloto("Ale Pelle", "Italia", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 1 : new Piloto("Romain Louis Grosjean", "Fran��a", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 2 : new Piloto("Krist��f Kov��cs", "Hungria", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 3 : new Piloto("B-J van Veenendaal", "Holanda", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 4 : new Piloto("Jonnas Vitorino", "Portugal", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 5 : new Piloto("Jan Magnussen", "Dinamarca", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 6 : new Piloto("Xiaoxin Liu", "China", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 7 : new Piloto("Michael Romanovich Novikov", "Russia", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 8 : new Piloto("Raul Da Costa", "��frica do Sul", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       case 9 : new Piloto("Anthony Ventura", "Estados Unidos", r.nextInt(99)+1, r.nextInt(9)+1, false);
	       
	       default : break;
	   }
	return null;
	   }

}