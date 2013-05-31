import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Main {

	

	
	
	
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Campeonato c =new Campeonato() ;
		HashMap<String, Jogador> jogadores = new HashMap<String,Jogador>() ;

		Manager m = null;
		
		int k = 0;
		int x = Welcome();
	
		if(x==1){ 
			//criar necessario para o campeoanto
			jogadores = PedeJogadores(); 
			c = Campeonato.geraCampeonato(); 
			m = new Manager(c,jogadores); 
			
			//inserir na classificaçao campeonato
			Iterator<Corrida> banana = m.getCampeonato().getCorridas().iterator();
			Corrida r = banana.next();
			  for(Veiculo v : r.getConjuntoVeiculos() ){
				m.campstatus.put(v, 0-k);
			k++;
			    }
			  
			 
		}
		else
		    if(x==2){
		    	//inicia manager
		    	m  = new Manager();
		    	//carrega manager guardado
		    	m.carregaRM("file.tmp"); }  
		else { 
			System.exit(0);}
		
		
		
		
		
	
				
	
		MenuPrincipal(m);
	}
		
	

//PedeJOGADORES
public static HashMap<String, Jogador> PedeJogadores(){
 
	 HashMap<String,Jogador> aux = new HashMap<String,Jogador>();
	 String nome, morada; 
	 double dc = 0;
	 Jogador p;
	
	 System.out.println("Quantos Jogadores?"); 
	 s = new Scanner(System.in);
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
	

   	int x  = s.nextInt();
 
return x;

}
//CORRE 

public static void MenuPrincipal(Manager m) throws FileNotFoundException, IOException{
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
	if(x==1){  MenuCorrida(m);  }
	else if(x==2){ MenuConsultas(m);}
	else if(x==3){MenuApostas(m);}
	else if(x==4){ m.gravaRM("file.tmp"); MenuPrincipal(m);}
	else if(x==5){ System.exit(0); }
	
	
	
	
	}
	



private static void MenuCorrida(Manager m) throws FileNotFoundException, IOException {
	
	int x = 0;	Corrida cit = new Corrida();
	Iterator<Corrida> aux = m.getCampeonato().getCorridas().iterator();
	
	while(aux.hasNext() && x < m.getCorrida() )
	{
		 aux.next();
		 x++;
	}
    if(aux.hasNext()){  cit = aux.next();

  	
      cit.fazCorrida(m.campstatus);
      m.setCorida(); }
    else System.out.println("O Campeonato Acabou!");
	MenuPrincipal( m);
}



//Menu Consulta 
public static void MenuConsultas(Manager m) throws FileNotFoundException, IOException{
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
		 
		for(Veiculo v : m.campstatus.keySet()){
			aux.put(m.campstatus.get(v), v.getMarca()+" "+v.getModelo() );
		}
		System.out.println("################## CLASSIFICAï¿½ï¿½O   ##################");
		System.out.println("#                                                   #");
		for(int y : aux.keySet()){
			
			if(y>0)
			System.out.println( y +" " + aux.get(y));
			else System.out.println( 0 +" " + aux.get(y));
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
	else if(x==6){ MenuPrincipal(m);}
	
	if(x==1) MenuConsultas(m);
}


//Menu Aposta
public static void MenuApostas(Manager m) throws FileNotFoundException, IOException{
   	int x  = 0, waka = 0;
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
	 Iterator<Jogador> auxi =  m.getapostadores().values().iterator();
	 
		while(auxi.hasNext() && waka  < x )
		{
			 auxi.next();
			 waka++;
			
		}
	    if(auxi.hasNext()){  j =auxi.next();} else{ System.out.println("Nao ha mais jogadores"); MenuApostas(m);}

	 
	 //iterador ate x, edepois 
	 System.out.println("##################  MENU APOSTAS     ##################");
		System.out.println("#                                                   #");
		System.out.println("#                " + j.getNome()  + "               #");
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
		 while(x !=7){
		 if(x==1){   
				
				
				
				
			} //Menu faz aposta
			else if(x==2){
				System.out.println("################## APOSTAS   ##################");
			System.out.println("#                                                   #");
			
		
		           for(Aposta v : j.getApostaCorrente() ){
		        	   System.out.println(v.toString());
		}
			
			  
			System.out.println("#         1 - VOLTAR                                #");
			System.out.println("#####################################################");
				
				
			} 
			else if(x==3){
				System.out.println("################## APOSTAS   ##################");
				System.out.println("#                                                   #");
				
			
			           for(Aposta v : j.getHistorico() ){
			        	   System.out.println(v.toString());
			}
				
				  
				System.out.println("#         1 - VOLTAR                                #");
				System.out.println("#####################################################");
				
				
			} 
			else
				
				if(x==4){ System.out.println("Saldo Actual: "+j.getDc());  }
			else if(x==5){ System.out.println("Dinheiro Investido: "+j.getDi()); } 
			else if(x==6){ MenuApostas(m); }
			else if(x==7){ MenuPrincipal(m);}
				x = s.nextInt();
			
			x = s.nextInt();
			if(x==1) MenuApostas(m);

		 }

                            }
}