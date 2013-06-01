import java.io.Serializable;
import java.util.Random;

public class Piloto implements Serializable{
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

	public String getNome() {
		return this.nome;
	}

	public int getPalmares() {
		return this.palmares;
	}

	public int getQualidade() {
		return this.qualidade;
	}
	
	public boolean getChuva() {
		return this.chuva;
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
		StringBuilder s = new StringBuilder();

		s.append("\nNome: " + this.nome);
		s.append(" Nacionalidade: " + this.nacionalidade);
		s.append(" Palmares: " + this.palmares);
		s.append(" Qualidade: " + this.qualidade);
		s.append(" Bom condutor à chuva: " + this.chuva);

		return s.toString();
	}
	
	public static String daNome() {
		Random r = new Random();
		int x = r.nextInt(31);
		StringBuilder s = new StringBuilder();
		
		switch(x) {
            case 0: s.append("Haywood "); break;
            case 1: s.append("Willis "); break;
            case 2: s.append("Dewitt "); break;
            case 3: s.append("Claude "); break;
            case 4: s.append("Felipe "); break;
            case 5: s.append("Ellis "); break;
            case 6: s.append("Efren "); break;
            case 7: s.append("Forest "); break;
            case 8: s.append("Ira "); break;
            case 9: s.append("Neil "); break;
            case 10: s.append("Chase "); break;
            case 11: s.append("Sean "); break;
            case 12: s.append("Curt "); break;
            case 13: s.append("Mose "); break;
            case 14: s.append("Boris "); break;
            case 15: s.append("Miguel "); break;
            case 16: s.append("Len "); break;
            case 17: s.append("Forrest "); break;
            case 18: s.append("Buck "); break;
            case 19: s.append("Pedro "); break;
            case 20: s.append("Jonas "); break;
            case 21: s.append("Stewart "); break;
            case 22: s.append("Stephan "); break;
            case 23: s.append("Randy "); break;
            case 24: s.append("Steven "); break;
            case 25: s.append("Johnie "); break;
            case 26: s.append("Hayden "); break;
            case 27: s.append("Cole "); break;
            case 28: s.append("James "); break;
            case 29: s.append("Jim "); break;
            case 30: s.append("Kim "); break;
		}
		
		x = r.nextInt(31);
		switch(x) {
            case 0: s.append("Hommel"); break;
            case 1: s.append("Wordlaw"); break;
            case 2: s.append("Doney"); break;
            case 3: s.append("Chatterton"); break;
            case 4: s.append("Fenderson"); break;
            case 5: s.append("Encinas"); break;
            case 6: s.append("Espinoza"); break;
            case 7: s.append("Foland"); break;
            case 8: s.append("Lima"); break;
            case 9: s.append("Pinto"); break;
            case 10: s.append("Faria"); break;
            case 11: s.append("Insley"); break;
            case 12: s.append("Nehls"); break;
            case 13: s.append("Cleghorn"); break;
            case 14: s.append("Secord"); break;
            case 15: s.append("Courchesne"); break;
            case 16: s.append("Mcdade"); break;
            case 17: s.append("Brinn"); break;
            case 18: s.append("Wills"); break;
            case 19: s.append("Laufer"); break;
            case 20: s.append("Fickett"); break;
            case 21: s.append("Bradt"); break;
            case 22: s.append("Strauch"); break;
            case 23: s.append("Stills"); break;
            case 24: s.append("Rizer"); break;
            case 25: s.append("Shackleford"); break;
            case 26: s.append("Janson"); break;
            case 27: s.append("Hitt"); break;
            case 28: s.append("Carone"); break;
            case 29: s.append("Jusino"); break;
            case 30: s.append("Kampa"); break;
		}
		return s.toString();
	}
	
	public static String daNacionalidade() {
		Random r = new Random();
		int  x = r.nextInt(31);
		String s = "";
        
		switch(x) {
            case 0: s = "Portuguesa"; break;
            case 1: s = "Albanesa,"; break;
            case 2: s = "Alemã"; break;
            case 3: s = "Austríaca"; break;
            case 4: s = "Belga"; break;
            case 5: s = "Croata"; break;
            case 6: s = "Dinamarquesa"; break;
            case 7: s = "Eslovaca"; break;
            case 8: s = "Espanhola"; break;
            case 9: s = "Francesa"; break;
            case 10: s = "Grega"; break;
            case 11: s = "Irlandesa"; break;
            case 12: s = "Italiana"; break;
            case 13: s = "Holandesa"; break;
            case 14: s = "Polaca"; break;
            case 15: s = "Inglesa"; break;
            case 16: s = "Russa"; break;
            case 17: s = "Sueca"; break;
            case 18: s = "Turca"; break;
            case 19: s = "Ucraniana"; break;
            case 20: s = "Argentina"; break;
            case 21: s = "Chilena"; break;
            case 22: s = "Cubana"; break;
            case 23: s = "Mexicana"; break;
            case 24: s = "Chinesa"; break;
            case 25: s = "Indiana"; break;
            case 26: s = "Iraniana"; break;
            case 27: s = "Japonesa"; break;
            case 28: s = "Sul Africano"; break;
            case 29: s = "Angolano"; break;
            case 30: s = "Cabo Verdiano"; break;
		}
		return s;
	}
    
	public static Piloto geraPiloto() {
		Random r = new Random();
        
		return new Piloto(daNome(), daNacionalidade(), r.nextInt(25) +1, r.nextInt(9) +1, r.nextBoolean());
	}
}