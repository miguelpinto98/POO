import java.util.*;
public class Main {

	public static void main(String[] args) {
		Campeonato c = null;HashMap<String, Jogador> jogadores = null;
		
		int x = Welcome();
		if(x==1){  jogadores = PedeJogadores(); c.geraCampeonato();}
		else
		    if(x==2){ c = CarregaCampeonato(jogadores);}
		else { System.exit(0);}
		
		
		Manager m = new Manager(c,jogadores);
		CorreCampeonato(c);
	}
		
	

//PedeJOGADORES
	
public static HashMap<String, Jogador> PedeJogadores(){
 
	 HashMap<String, Jogador> aux = new  HashMap<String, Jogador>();
	 String nome,morada; double dc;
	 Jogador p;
	System.out.println("Quantos Jogadores?"); 
	 Scanner s = new Scanner(System.in);
	   	int x  = s.nextInt();
	   	
	   	for(int i = 0; i < x; i++){
	   		System.out.println("Nome do Jogador");
	   	
	   		
	   		 nome =s.nextLine();
	   		 
	   		System.out.println("Morada do Jogador");
	   		
	   		 morada= s.nextLine();
	   		 
	   		System.out.println("Dinheiro na conta");
	   	  dc = s.nextDouble();
	   		p = new Jogador();
	   			p.setNome(nome);
	   		p.setMorada(morada);
	   		p.setDc(dc);
	   		aux.put(nome,p);
	   		
	   	}
	 
	
	
	return aux;
}
// WELCOME
public static int Welcome(){ 
	
try {
	System.out.println("################## RACING MANAGER 2013 ##################");
	System.out.println("#                                                       #");
	System.out.println("#        1 - NOVO CAMPEONATO                            #");
	System.out.println("#        2 - CARREGAR CAMPEONATO                        #");
	System.out.println("#        3 - SAIR                                       #");
	System.out.println("#                                                       #");
	System.out.println("#        Escolha uma opçâo:                             #");
	System.out.println("#########################################################");
	} catch(Exception e){
	//If this thread was intrrupted by nother thread 
	}

   	Scanner s = new Scanner(System.in);
   	int x  = s.nextInt();
 
return x;

}
//CORRE 

public static void CorreCampeonato(Campeonato c){
	
	
	
	
	
	
	
}

//CARREGA 

public static Campeonato CarregaCampeonato(HashMap<String, Jogador>jogadores){
	
	
	Campeonato c = null;
	
	
return c;	
}
}