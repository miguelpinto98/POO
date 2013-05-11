public class Jogador {

private String nome,morada; 
private ArrayList<Aposta> adecorrer, hist;  //o histórico de apostas realizadoe as apostas em vigor
private double di,dg,dc; // a conta corrente, investimento e ganhos


public Jogador(Jogador j){
this.nome = j.getNome();
this.morada = j.getMorada();
this.adecorrer = j.getCur();
this.hist = j.getHist();
this.di = j.getDi();
this.dg = j.getDg();
this.dc = j.getDc();
}


//get 
public String getNome(){
return nome;
}
public String getMorada(){
return morada;
}

public int getDi(){return this.di;}
public int getDg(){return this.dg;}
public int getDc(){return this.dc;}
public ArrayList<Aposta> getHist(){
 ArrayList<Aposta> aux  = new ArrayLista<Aposta>(); 
for(Aposta a : adecorrer) { aux.add(a.clone());

}
return aux;
}


public  ArrayList<Aposta> getCur(){  ArrayList<Aposta> aux  = new ArrayLista<Aposta>(); 
for(Aposta a : hist) { aux.add(a.clone());

}
return aux;
}
//set




//clone
public Jogador clone(){ return new Jogador(this);}

//toString


//equals
 public boolean equals(Object o) {
    if (this==o) return true;
    if((o==null)||(this.getClass() != o.getClass()))
     return false;
     else { Jogador v = (Jogador) o;
         return (v.getNome().equals(o.getNome())&& v.getMorada().equals(  o.getMorada())&&v.getDi()== o.getDi()&&v.getDg()== o.getDg()&&v.getDc()== o.getDc());
        }
    
    }
}