import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Jogador implements Serializable {
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
	
	public Jogador(String nome, String morada, ArrayList<Aposta> ad, ArrayList<Aposta> h, double di, double dg, double dc) {
		this.nome = nome;
		this.morada = morada;
		this.adecorrer = ad;
		this.hist = h;
		this.di = di;
		this.dg = dg;
		this.dc = dc;
	}
	
	public Jogador(String nome, String morada, double dcorrente) {
		this.nome = nome;
		this.morada = morada;
		this.adecorrer = new ArrayList<Aposta>();
		this.hist = new ArrayList<Aposta>();
		this.di = 0;
		this.dg = 0;
		this.dc = dcorrente;
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
		for (Aposta a : hist) {
			aux.add(a.clone());
		}
		return aux;
	}

	public ArrayList<Aposta> getApostaCorrente() {
		ArrayList<Aposta> aux = new ArrayList<Aposta>();
		for (Aposta a : adecorrer) {
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
		for(Aposta z : p){this.adecorrer.add(z);}
		
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
	
	public void CheckApostas(String s, HashMap<Veiculo,Integer> c ) {
	   
		for(int i=0; i<this.adecorrer.size(); i++) {
			if(s.equals(this.adecorrer.get(i).getCorrida().getCircuito().getNomeCircuito())) {
				if(this.adecorrer.get(i).checkAposta(c)== 0) 
					di -= this.adecorrer.get(i).getQuant();
				else 
					if( this.adecorrer.get(i).checkAposta(c) == 1) {	// Acertou primeiro
						di-=this.adecorrer.get(i).getQuant();
						dc+=this.adecorrer.get(i).getQuant()*1.5;
						dg +=this.adecorrer.get(i).getQuant()*1.5-this.adecorrer.get(i).getQuant();
					} else
						if(this.adecorrer.get(i).checkAposta(c) == 2) {		//Acertou segundo
							di-=this.adecorrer.get(i).getQuant();
							dc+=this.adecorrer.get(i).getQuant()*1.3;
							dg +=this.adecorrer.get(i).getQuant()*1.3-this.adecorrer.get(i).getQuant();
						} else 
							if(this.adecorrer.get(i).checkAposta(c) == 3) {		// Acertou primeiro e segundo
								di-=this.adecorrer.get(i).getQuant();
								dc+=this.adecorrer.get(i).getQuant()*1.15;
								dg +=this.adecorrer.get(i).getQuant()*1.8-this.adecorrer.get(i).getQuant();
							} else
								if(this.adecorrer.get(i).checkAposta(c) == 4) {		// Acertou terceiro
									di-=this.adecorrer.get(i).getQuant();
									dc+=this.adecorrer.get(i).getQuant()*1.15;
									dg +=this.adecorrer.get(i).getQuant()*1.15-this.adecorrer.get(i).getQuant();
								} else
									if(this.adecorrer.get(i).checkAposta(c) == 5) {		// Acertou terceiro e primeiro
										di-=this.adecorrer.get(i).getQuant();
										dc+=this.adecorrer.get(i).getQuant()*1.65;
										dg +=this.adecorrer.get(i).getQuant()*1.65-this.adecorrer.get(i).getQuant();
									} else
										if(this.adecorrer.get(i).checkAposta(c) == 6 ) {	// Acertou terceiro e segundo
											di-=this.adecorrer.get(i).getQuant();
											dc+=this.adecorrer.get(i).getQuant()*1.45;
											dg +=this.adecorrer.get(i).getQuant()*1.45-this.adecorrer.get(i).getQuant();
										} else 
											if(this.adecorrer.get(i).checkAposta(c) == 7 ) {
												di-=this.adecorrer.get(i).getQuant();
												dc+=this.adecorrer.get(i).getQuant()*1.95;
												dg +=this.adecorrer.get(i).getQuant()*1.95-this.adecorrer.get(i).getQuant();
												}	// Acertou todos 
				}
			this.hist.add(this.adecorrer.get(i).clone());
			this.adecorrer.remove(this.adecorrer.get(i));
			}
	 }

	public void fazAposta(Corrida r,double quant , Veiculo p1,Veiculo p2,Veiculo p3) {
		Aposta p = new Aposta(quant, p1,  p2,  p3,r);
		adecorrer.add(p);
	}
}