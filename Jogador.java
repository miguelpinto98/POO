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
		ArrayList<Aposta> aux = this.getApostaCorrente();
	   //int premio = 0; 
	   for(Aposta v : aux){
	    if(s.equals(v.getCorrida().getCircuito().getNomeCircuito())) { // Falta decidir o que fazer quando se ganha
	       
	        
	       if( v.checkAposta(c) == 1){ di-=v.getQuant(); dc+=v.getQuant()*1.5; dg +=v.getQuant()*1.5-v.getQuant();  } // Acertou primeiro
	        
	        if(v.checkAposta(c) == 2){ di-=v.getQuant(); dc+=v.getQuant()*1.3; dg +=v.getQuant()*1.3-v.getQuant();  } //Acertou segundo
	        if(v.checkAposta(c) == 3){ di-=v.getQuant(); dc+=v.getQuant()*1.15; dg +=v.getQuant()*1.8-v.getQuant();  } // Acertou primeiro e segundo
	        if(v.checkAposta(c) == 4 ){ di-=v.getQuant(); dc+=v.getQuant()*1.15; dg +=v.getQuant()*1.15-v.getQuant();  }// Acertou terceiro
	         
	         if(v.checkAposta(c) == 5){ di-=v.getQuant(); dc+=v.getQuant()*1.65; dg +=v.getQuant()*1.65-v.getQuant();  } // Acertou terceiro e primeiro
	        if(v.checkAposta(c) == 6 ){ di-=v.getQuant(); dc+=v.getQuant()*1.45; dg +=v.getQuant()*1.45-v.getQuant();  }// Acertou terceiro e segundo
	        
	        
	        if(v.checkAposta(c) == 7 ){ di-=v.getQuant(); dc+=v.getQuant()*1.95; dg +=v.getQuant()*1.95-v.getQuant();  }// Acertou todos      
	       
	        hist.add(v.clone());
	        adecorrer.remove(v);
	        
	       }
	   
	   }
	   }

public void fazAposta(Corrida r,double quant , Veiculo p1,Veiculo p2,Veiculo p3){
	
	Aposta p = new Aposta(quant, p1,  p2,  p3,r);
	adecorrer.add(p);
	
}


}