import java.util.ArrayList;

public class Jogador {
	private String nome;
	private String morada;
	private ArrayList<Aposta> adecorrer;
	private ArrayList<Aposta> hist; // o histórico de apostas realizadoe as
									// apostas em vigor
	private double di;
	private double dg;
	private double dc; // a conta corrente, investimento e ganhos

	public Jogador() {
		this.nome = "";
		this.morada = "";
		this.adecorrer = new ArrayList<Aposta>();
		this.hist = new ArrayList<Aposta>();
		this.di = 0;
		this.dg = 0;
		this.dc = 0;
	}

	public Jogador(Jogador j) {
		this.nome = j.getNome();
		this.morada = j.getMorada();
		this.adecorrer = j.getApostaCorrente();
		this.hist = j.getHistorico();
		this.di = j.getDi();
		this.dg = j.getDg();
		this.dc = j.getDc();
	}

	// GETTERS
	public String getNome() {
		return nome;
	}

	public String getMorada() {
		return morada;
	}

	public double getDi() {
		return this.di;
	}

	public double getDg() {
		return this.dg;
	}

	public double getDc() {
		return this.dc;
	}

	public ArrayList<Aposta> getHistorico() {
		ArrayList<Aposta> aux = new ArrayList<Aposta>();
		for (Aposta a : adecorrer) {
			aux.add(a.clone());
		}
		return aux;
	}

	public ArrayList<Aposta> getApostaCorrente() {
		ArrayList<Aposta> aux = new ArrayList<Aposta>();
		for (Aposta a : hist) {
			aux.add(a.clone());
		}
		return aux;
	}

	// SETTERS
	public void setDi(double m) {
		this.di = m;
	}

	public void setDg(double m) {
		this.dg = m;
	}

	public void setDc(double m) {
		this.dc = m;
	}

	public void setNome(String s) {
		this.nome = s;
	}

	public void setMorada(String s) {
		this.morada = s;
	}

	public void setApostaCorrente(ArrayList<Aposta> p) {
		this.adecorrer = p;
	}

	public void seHistorico(ArrayList<Aposta> p) {
		this.hist = p;
	}

	// clone
	public Jogador clone() {
		return new Jogador(this);
	}

	// toString
	public String toString() {
		StringBuilder s = new StringBuilder("Jogador ");
		s.append("nome=" + nome);
		s.append(", morada=" + morada);
		s.append(", dinheiro investido" + di);
		s.append(", dinheiro ganho=" + dg);
		s.append(", conta currente=" + dc);
		s.append(" \n Apostas por verificar");
		for (Aposta a : adecorrer)
			s.append(a.toString());
		s.append(" \n Apostas verificadas");
		for (Aposta a : hist)
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
			Jogador v = (Jogador) o;
			return (this.nome.equals(v.getNome())
					&& this.morada.equals(v.getMorada())
					&& this.di == (v.getDi()) && this.dg == (v.getDg()) && this.dc == (v
						.getDc()));
		}
	}
}