import java.util.*;
public class Main {

	

	
	
	
	public static void main(String[] args) {
		Campeonato c =new Campeonato() ;
		
		HashMap<String, Jogador> jogadores = new HashMap<String,Jogador>() ;
		
		int x = Welcome();
	
		if(x==1){  
			jogadores = PedeJogadores(); c = Campeonato.geraCampeonato();}
		else
		    if(x==2){ c = CarregaCampeonato(jogadores);}
		else { 
			System.exit(0);}
		
		HashMap<Veiculo, Integer> camp = new HashMap<Veiculo, Integer>();
		
		
		Iterator<Corrida> banana = c.getCorridas().iterator();
		Corrida r = banana.next();
	for(Veiculo v : r.getConjuntoVeiculos() ){
		camp.put(v, 0);
		System.out.println(v.toString());
	}
		
		
	
				
	
		Manager m = new Manager(c,jogadores);
		MenuPrincipal(m,0,camp);
	}
		
	

//PedeJOGADORES
public static HashMap<String, Jogador> PedeJogadores(){
 
	 HashMap<String,Jogador> aux = new HashMap<String,Jogador>();
	 String nome, morada; 
	 double dc = 0;
	 Jogador p;
	
	 System.out.println("Quantos Jogadores?"); 
	 Scanner s = new Scanner(System.in);
	   	int x  = s.nextInt(); 
	   	
	   	System.out.println("################# INSERIR JOGADOR ################");
	   	for(int i = 0; i < x; i++){
	   	
	   		
	   		
	   	  	s.nextLine();
	   	 System.out.println(" *Insira Nome.");
	   		nome = s.nextLine();
	   		System.out.println(" *Insira Morada");
	   		morada = s.nextLine();
	   		System.out.println(" * Insira Dinheiro Inicial nor dormato XX,XX \n");
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
	

	System.out.println("################## RACING MANAGER 2013 ##################");
	System.out.println("#                                                       #");
	System.out.println("#        1 - NOVO CAMPEONATO                            #");
	System.out.println("#        2 - CARREGAR CAMPEONATO                        #");
	System.out.println("#        3 - SAIR                                       #");
	System.out.println("#                                                       #");
	System.out.println("#                                                       #");
	System.out.println("#########################################################");
	

   	Scanner s = new Scanner(System.in);
   	int x  = s.nextInt();
 
return x;

}
//CORRE 

public static void MenuPrincipal(Manager m,int griffin, HashMap<Veiculo, Integer> camp){
	Scanner s = new Scanner(System.in);
   	int x  = 0;
	
	System.out.println("BEM VINDO");
	
	
	System.out.println("##################  MENU PRINCIPAL ##################");
	System.out.println("#                                                   #");
	System.out.println("#        1 - FAZER CORRIDA                          #");
	System.out.println("#        2 - CONSULTAS                              #");
	System.out.println("#        3 - APOSTAS                                #");
	System.out.println("#        4-  GRAVAR                                 #");
	System.out.println("#        5-  SAIR                                   #");
	System.out.println("#                                                   #");
	System.out.println("#####################################################");
	 x  = s.nextInt();
	if(x==1){  MenuCorrida(m,griffin,camp);  }
	else if(x==2){ MenuConsultas(m,griffin, camp);}
	else if(x==3){MenuApostas(m,griffin,camp);}
	else if(x==4){ }
	else if(x==5){ System.exit(0); }
	
	
	
	
	}
	



private static void MenuCorrida(Manager m,int griffin, HashMap<Veiculo, Integer> camp) {
	
	int x = 0;	Corrida cit = new Corrida();
	Iterator<Corrida> aux = m.getCampeonato().getCorridas().iterator();
	
	while(aux.hasNext() && x < griffin )
	{
		 aux.next();
		 x++;
	}
    if(aux.hasNext()){  cit = aux.next();

  	
      cit.fazCorrida(camp);}
    else System.out.println("O Campeonato Acabou!");
	MenuPrincipal( m,griffin+1,camp);
}



//Menu Consulta 
public static void MenuConsultas(Manager m, int griffin, HashMap<Veiculo, Integer> camp){
	Scanner s = new Scanner(System.in);
   	int x  = 0;
	System.out.println("##################  MENU CONSULTAS ##################");
	System.out.println("#                                                   #");
	System.out.println("#        1 - CLASSIFICï¿½O DO CAMPEONATO              #");
	System.out.println("#        2 - TROFEU HIBRIDO                         #");
	System.out.println("#        3 - TOP JOGADORES                          #");
	System.out.println("#        4- CORRIDAS AGENDADAS                      #");
	System.out.println("#        5-  VEICULOS DO CAMPEONATO                 #");
	System.out.println("#        6- VOLTAR MENU PRINCIPAL                   #");
	System.out.println("#                                                   #");
	System.out.println("#####################################################");
	 x  = s.nextInt();
	
	 
	 if(x==1){ 
		 
		 HashMap<Integer,String> aux = new HashMap<Integer,String>();
		 
		for(Veiculo v : camp.keySet()){
			aux.put(camp.get(v), v.getMarca()+" "+v.getModelo() );
		}
		System.out.println("################## CLASSIFICAÇÃO   ##################");
		System.out.println("#                                                   #");
		for(int y : aux.keySet()){
			System.out.println( y +" " + aux.get(y));
			
		}
		System.out.println("#         1 - VOLTAR                                #");
		System.out.println("#####################################################");
	}
	else if(x==2){  
		
		
		
		
		
		
	}
	else if(x==3){ 
		
		
		
		
	}
	else if(x==4){
    System.out.println("################## CORRIDAS   ##################");
	System.out.println("#                                                   #");
	for(Corrida r : m.getCampeonato().getCorridas() ){
		System.out.println( r.toString());
		
	}
	System.out.println("#         1 - VOLTAR                                #");
	System.out.println("#####################################################");
		
		
		
	}
	else if(x==5){   System.out.println("################## VEICULO   ##################");
	System.out.println("#                                                   #");
	Iterator<Corrida> banana = m.getCampeonato().getCorridas().iterator();
	Corrida r = banana.next();
           for(Veiculo v : r.getConjuntoVeiculos() ){
        	   System.out.println(v.toString());
}
	
	  
	System.out.println("#         1 - VOLTAR                                #");
	System.out.println("#####################################################");
		
		
		
	}
	else if(x==6){ MenuPrincipal(m, griffin, camp);}
	x = s.nextInt();
	if(x==1) MenuConsultas(m,griffin,camp);
}


//Menu Aposta
public static void MenuApostas(Manager m, int griffin, HashMap<Veiculo,Integer> camp){
	Scanner s = new Scanner(System.in);
   	int x  = 0;
   	Jogador j = null;
	System.out.println("################  ESCOLHA JOGADOR  ##################");
	System.out.println("#                                                   #");
	for(String z :m.getapostadores().keySet() ){
		
		System.out.println( "#       " + x +" " +m.getapostadores().get(z).getNome() +"                #");
		x++;
	}
	System.out.println("#                                                   #");
	System.out.println("#####################################################");
	
	 x  = s.nextInt();
	 //iterador ate x, edepois 
	 System.out.println("##################  MENU APOSTAS     ##################");
		System.out.println("#                                                   #");
		System.out.println("#        1 - FAZER APOSTA PROX CORRIDA              #");
		System.out.println("#        2 - VER APOSTAS POR ACONTECER              #");
		System.out.println("#        3 - VER HISTORICO                          #");
		System.out.println("#        4- SALDO CURRENTE                          #");
		System.out.println("#        5-  DINHEIRO INVESTIDO                     #");
		System.out.println("#        6- VOLTAR MENU APOSTA                      #");
		System.out.println("#        7 - VOLTAR MENU PRINCIPAL                  #");
		System.out.println("#                                                   #");
		System.out.println("#####################################################");
		 x  = s.nextInt();
			if(x==1){   }
			else if(x==2){ }
			else if(x==3){}
			else if(x==4){ }
			else if(x==5){ }
			else if(x==6){ MenuApostas(m,griffin,camp); }
			else if(x==7){ MenuPrincipal(m,griffin,camp);}
}
//CARREGA 

public static Campeonato CarregaCampeonato(HashMap<String, Jogador>jogadores){
	
	
	Campeonato c = null;
	
	
return c;	
}
}