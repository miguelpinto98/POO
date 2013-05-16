import java.util.HashMap;
public class Manager
{
    
    //variaveis de instanca
    private Campeonato campeonato;
    private HashMap<String,Jogador> apostadores; 
    
    public Manager (Manager m ) {
    this.campeonato = m.getCampeonato();
    HashMap<String,Jogador> aux = m.getapostadores();
    for(String nome : aux.keySet())
    this.apostadores.put(nome,aux.get(nome));
}
    public Manager ( Campeonato c, HashMap<String,Jogador> d){
    
    }
    
    
    //get
    public Campeonato getCampeonato(){ return this.campeonato.clone();}
    public HashMap<String,Jogador> getapostadores(){   HashMap<String,Jogador> aux = new HashMap<String,Jogador>(); 
        for(String nome : this.apostadores.keySet()){
            
             aux.put(nome,this.apostadores.get(nome).clone());
                
               
            }
            return aux;}
            
   
                                                                                               
    
    //set
    public void setCampeonato(Campeonato c) { this.campeonato = c;}
    public void setApostadores (  HashMap<String,Jogador> c) { this.apostadores = c; }
    
    
    //clone
    
    public Manager clone(){ return new Manager(this);}
    
    //toString
    public String toString(){
    StringBuilder s = new StringBuilder("Manager  ");
		s.append(campeonato.toString());
	  for(String nome : this.apostadores.keySet()){
            
          s.append( this.apostadores.get(nome).toString());
                
               
            }
		

		return s.toString();
    
    }
    
    
    
    //equals
    
    public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Jogador v = (Jogador) o;
			return (true);
		}
	}
}
