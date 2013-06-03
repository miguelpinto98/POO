import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Main {

	private static Scanner s = new Scanner(System.in);
	private static String str = null;
	private static int option = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Campeonato c =new Campeonato() ;
		TreeMap<String, Jogador> jogadores = new TreeMap<String,Jogador>() ;

		Manager m = null;
		
		int k = 0;
		int x = Welcome();
	
		if(x==1){ 
			jogadores = PedeJogadores(); 
			
			for(Jogador caaa : jogadores.values()){ System.out.println(caaa.toString());}
			
			c = Campeonato.geraCampeonato(); 
			m = new Manager(c,jogadores); 
			
			Iterator<Corrida> cor = m.getCampeonato().getCorridas().iterator();
			Corrida r = cor.next();
			for(Veiculo v : r.getConjuntoVeiculos()) {
				m.campstatus.put(v, 0-k);
				k++;
			}	  
		}
		else if(x==2) {
		    m  = new Manager();
		    boolean flag = true;
		    
		    do {
			   	try {
			   		str=MenuCarregaJogo();
			   		m.carregaRM(str);
			   		flag=false;
			   	} catch(FileNotFoundException e) {
			   		System.out.println("Ficheiro não encontrado, insira novamente!");
			   	}
		    } while(flag);
		}
		else if(x==3)
		    System.exit(0);

		MenuPrincipal(m);
	}
	
	public static int Welcome() {
		System.out.println("################## RACING MANAGER 2013 ##################");
		System.out.println("#                                                       #");
		System.out.println("#        1 - NOVO CAMPEONATO                            #");
		System.out.println("#        2 - CARREGAR CAMPEONATO                        #");
		System.out.println("#        3 - SAIR                                       #");
		System.out.println("#                                                       #");
		System.out.println("#        Escolha uma opção:                             #");
		System.out.println("#########################################################");
	 
		return s.nextInt();
	}
		
	public static TreeMap<String, Jogador> PedeJogadores() {
		TreeMap<String,Jogador> aux = new TreeMap<String,Jogador>();
		String nome, morada; 
		double dc = 0;
		Jogador p;
		
		System.out.println("#################### CRIAR JOGADORES ####################");
		System.out.println("#                                                       #");
		System.out.println("#  * Quantos jogadores pretende criar neste campeonato? #"); 
		int x = s.nextInt(); 
	   	
		System.out.println("################### INSERIR JOGADORES ###################");
		System.out.println("#                                                       #");
	   	
		for(int i = 0; i < x; i++) {
	   	  	s.nextLine();
			System.out.println("#  * Insira o nome do "+(i+1)+"º jogador."); 
	   		nome = s.nextLine();
	   		System.out.println("#  * Insira a sua morada.");
	   		morada = s.nextLine();
	   		System.out.println("#  * Insira dinheiro inicial no formato XX,XX. \n");
	   		dc = s.nextDouble();
	   		
	   		p = new Jogador();
	   		p.setNome(nome);
	   		p.setMorada(morada);
	   		p.setDc(dc);
	   		aux.put(nome,p);
	   	}
		return aux;
	}
	
	public static String MenuCarregaJogo() {
		System.out.println("##################### CARREGAR JOGO #####################");
		System.out.println("#                                                       #");
		System.out.println("#  * Insira o nome do ficheiro a ser carregado.         #");

		return s.next();
	}
	
	public static String MenuGravaJogo() {
		System.out.println("###################### GRAVAR JOGO ######################");
		System.out.println("#                                                       #");
		System.out.println("#  * Insira o nome do ficheiro a ser gravado.           #");

		return s.next();
	}
	
	public static void MenuPrincipal(Manager m) throws FileNotFoundException, IOException {
		int x = 0;
		System.out.println("#################### MENU PRINCIPAL #####################");
		System.out.println("#                                                       #");
		System.out.println("#        1 - FAZER CORRIDA                              #");
		System.out.println("#        2 - CONSULTAS                                  #");
		System.out.println("#        3 - APOSTAS                                    #");
		System.out.println("#        4 - GRAVAR                                     #");
		System.out.println("#        5 - SAIR                                       #");
		System.out.println("#                                                       #");
		System.out.println("#        Escolha uma opção:                             #");
		System.out.println("#########################################################");
		
		x  = s.nextInt();
		
		if(x==1) {
			MenuCorrida(m);
			}
		if(x==2) {
			MenuConsultas(m);
			}
		if(x==3) {
			MenuApostas(m,-1);
			}
		if(x==4) {
			str=MenuGravaJogo();
			m.gravaRM(str);
			MenuPrincipal(m);
			}
		if(x==5) {
			System.exit(0);
			}	
	}

	private static void MenuCorrida(Manager m) throws FileNotFoundException, IOException {
		int x = 0;
		Corrida cit = new Corrida();
		HashMap<Veiculo, Integer> z = new HashMap<Veiculo, Integer> ();
		
		Iterator<Corrida> aux = m.getCampeonato().getCorridas().iterator();

	while(aux.hasNext() && x < m.getCorrida() )
	{
		 aux.next();
		 x++;
	}
    if(aux.hasNext()){  cit = aux.next();
   
  	
      z = cit.fazCorrida(m.campstatus);
      for(Jogador h :m.getapostadores().values()){ h.CheckApostas(cit.getCircuito().getNomeCircuito(), m.campstatus);}
      m.setCorida(); } else System.out.println("O Campeonato Acabou!");
      
      for(Jogador j : m.getapostadores().values()){
    	  j.CheckApostas(cit.getCircuito().getNomeCircuito(), z);
    	  
      }
   
	MenuPrincipal( m);
}



	//Menu Consulta 
	public static void MenuConsultas(Manager m) throws FileNotFoundException, IOException{
	   	int x  = 0,corr = 0;
	
		System.out.println("#################### MENU CONSULTAS #####################");
		System.out.println("#                                                       #");
		System.out.println("#        1 - CLASSIFICAÇÃO CAMPEONATO GERAL             #");
		System.out.println("#        2 - TROFEU HIBRIDO                             #");
		System.out.println("#        3 - TOP JOGADORES                              #");
		System.out.println("#        4 - CORRIDAS AGENDADAS                         #");
		System.out.println("#        5 - VEICULOS DO CAMPEONATO                     #");
		System.out.println("#        6 - VOLTAR MENU PRINCIPAL                      #");
		System.out.println("#                                                       #");
		System.out.println("#        Escolha uma opção:                             #");
		System.out.println("#########################################################");
		
		x  = s.nextInt();
		
		 
		if(x==1) {
			HashMap<Integer,String> aux = new HashMap<Integer,String>();
			 
			for(Veiculo v : m.campstatus.keySet()) {
				aux.put(m.campstatus.get(v), v.getMarca()+" "+v.getModelo());
			}
			
			System.out.println("################## CLASSIFICAÇÃO GERAL ##################");
			System.out.println("#                                                       #");
			
			for(int y : aux.keySet()) {
				if(y>0)
					System.out.println("#        " + y +"   "+ aux.get(y));
				else
					System.out.println("#        " + 0 +"   "+ aux.get(y));
			}
			System.out.println("#                                                       #");
			System.out.println("#        1 - VOLTAR                                     #");
			System.out.println("#########################################################");
			option = s.nextInt();
			
			if(option==1)
				MenuConsultas(m);
		}
		else if(x==2){  
			
			
			
			
			
			
		}
		else if(x==3){ 
			
			
			
			
		}
		else if(x==4){
			System.out.println("################## CORRIDAS AGENDADAS ###################");
			System.out.println("#                                                       #");
		
			for(Corrida r : m.getCampeonato().getCorridas() ){ 
			
			if(corr == m.getCorrida()) {	
				System.out.println("################## PROXIMA CORRIDA ######################");	
				System.out.println("#                                                       #");
			System.out.println(r.toString()); corr++;
			System.out.println("#                                                       #");
			
			System.out.println("#########################################################");
			}else{
			 corr++;
			System.out.println(r.toString());}
			
		}
		System.out.println("#                                                       #");
		System.out.println("#        1 - VOLTAR                                     #");
		System.out.println("#########################################################");
		
		if(s.nextInt()==1)
			MenuConsultas(m);	
		}
		else if(x==5){   System.out.println("################## VEICULO   ##################");
		System.out.println("#                                                   #");
		Iterator<Corrida> banana = m.getCampeonato().getCorridas().iterator();
		Corrida r = banana.next();
	           for(Veiculo v : r.getConjuntoVeiculos() ){
	        	   System.out.println(v.toString());
	           }
		
		  
	    System.out.println("#                                                       #");
	   	System.out.println("#        1 - VOLTAR                                     #");
	   	System.out.println("#########################################################");
		if(s.nextInt()==1)
			MenuConsultas(m);	
		}
		
		else if(x==6){ MenuPrincipal(m);}
		
		if(x==1) MenuConsultas(m);
	}




//
public static int jogpos(TreeMap<String, Jogador> treeMap){

int x = 0;

	
System.out.println("################  ESCOLHA JOGADOR  ##################");
System.out.println("#                                                   #");
for(String z : treeMap.keySet() ){
	
	System.out.println( "#       " + x +" " +treeMap.get(z).getNome() +"                #");
	x++;
}
System.out.println("#                                                   #");
System.out.println("#####################################################");

 x  = s.nextInt();
return x;
}
//Menu Aposta
public static void MenuApostas(Manager m, int i) throws FileNotFoundException, IOException{
   	int x  = 0;
 int waka = 0;
 if( i== -1){
	 waka = jogpos(m.getapostadores()); 
	}else waka = i;
 Jogador j = new Jogador();
 Iterator<Jogador> auxi =  m.getapostadores().values().iterator();
 
	while(auxi.hasNext() && x < waka )
	{
		 auxi.next();
		x++;
		
	}

	if(auxi.hasNext()){  j =auxi.next();}
	else{ System.out.println("Nao ha mais jogadores"); MenuApostas(m,-1);
 }
		
	 System.out.println("##################  MENU APOSTAS     ##################");
		System.out.println("#                                                   #");
		System.out.println("#                " + j.getNome()  + "               #");
		System.out.println("#                                                   #");
		System.out.println("#        1 - FAZER APOSTA  CORRIDA              #");
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
		 if(x==1){   MenuFazAposta(m,waka);
				 
				
				
				
			} //Menu faz aposta
			else if(x==2){
				System.out.println("################## APOSTAS   ##################");
			System.out.println("#            "+j.getNome()+"                                       #");
			
			
			           for(Aposta v : j.getApostaCorrente() ){
		        	   System.out.println("bla "+v.toString());
		}
			
			  
			System.out.println("#         1 - VOLTAR                                #");
			System.out.println("#####################################################");
				
				
			} 
			else if(x==3){
				System.out.println("################## APOSTAS   ##################");
				System.out.println("#            "+j.getNome()+"                                       #");
				

		           for(Aposta v : j.getHistorico() ){
			        	   System.out.println(v.toString());
			}
				
				  
				System.out.println("#         1 - VOLTAR                                #");
				System.out.println("#####################################################");
				
				
			} 
			else
				
				if(x==4){ System.out.println("Saldo Actual: "+j.getDc());  }
			else if(x==5){ System.out.println("Dinheiro Investido: "+j.getDi()); } 
			else if(x==6){ MenuApostas(m,waka); }
			
				x = s.nextInt();
			
			
			if(x==1) MenuApostas(m,waka);

		 }
 if(x==7){ MenuPrincipal(m);}
                            }



private static void MenuFazAposta(Manager m, int waka) throws FileNotFoundException, IOException {
	
	//necessario pa uma posta 
	 double q = 0;
	Veiculo p1 = null;Veiculo p2 = null; Veiculo  p3 = null;

    Corrida corr = new Corrida();
	Jogador j = new Jogador();
	//fun�ao 
	 int x = 0, y = 0;
	
	 Iterator<Jogador> jogit = m.getapostadores().values().iterator();
     
	 	while(jogit.hasNext() && y < waka )
	 	{
	 		 jogit.next();
	 		 y++;
	 	}
	 	
	  if(jogit.hasNext()) j = jogit.next();
	
	//CORRIDA;
y = 0;
	 System.out.println("#            "+j.getNome()+"                                       #");
	   System.out.println("################ ESCOLHA CORRIDA   ################");
		System.out.println("#                                                   #");
		for(Corrida r : m.getCampeonato().getCorridas() ){
			System.out.println(x +" "+ r.getCircuito().getNomeCircuito());
			x++;
		}
		System.out.println("#                                                   #");
		System.out.println("#####################################################");
     x = s.nextInt();
     Iterator<Corrida> corrit = m.getCampeonato().getCorridas().iterator();
 	while(corrit.hasNext() && y <x )
 	{
 		 corrit.next();
 		 y++;
 	}
     if(corrit.hasNext()){  corr = corrit.next();
     
		//PRIMEIRO CLASSIFICADO
		x= 0;
		System.out.println("################## ESCOLHA 1� classificado   ##################");
		System.out.println("#                                                   #");
		for(Veiculo v : corr.getConjuntoVeiculos()){
			System.out.println(x +" "+v.getMarca()+" "+v.getModelo());
			x++;
			
		}
		System.out.println("#                                                   #");
		System.out.println("#####################################################");
		x  = s.nextInt();
		 Iterator<Veiculo> carit = corr.getConjuntoVeiculos().iterator();
	 	while(carit.hasNext() && y <x )
	 	{
	 		 carit.next();
	 		 y++;
	 	}
	     if(carit.hasNext()){  p1 = carit.next().clone();}
	
		
		//SEGUNDO CLASSIFICADO
		x = 0;
		y= 0;
		System.out.println("################## ESCOLHA 2� classificado   ##################");
		System.out.println("#                                                   #");
		for(Veiculo v : corr.getConjuntoVeiculos()){
			System.out.println(x +" "+v.getMarca()+" "+v.getModelo());
			x++;
			
		}
		System.out.println("#                                                   #");
		System.out.println("#####################################################");
		x = s.nextInt();
		carit = corr.getConjuntoVeiculos().iterator();
		 	while(carit.hasNext() && y <x )
		 	{
		 		 carit.next();
		 		 y++;
		 	}
		     if(carit.hasNext()){  p2 = carit.next().clone();}
		if(p2.equals(p1)) System.out.println("Esse piloto ja existe na aposta");
		//TERCEIRO CLASSIFICADO
		x = 0;
		y = 0;
		System.out.println("################## ESCOLHA 3� classificado   ##################");
		System.out.println("#                                                   #");
		for(Veiculo v : corr.getConjuntoVeiculos()){
			System.out.println(x +" "+v.getMarca()+" "+v.getModelo());
			x++;
			
		}
		System.out.println("#                                                   #");
		System.out.println("#####################################################");
		x = s.nextInt();
		carit = corr.getConjuntoVeiculos().iterator();
	 	while(carit.hasNext() && y <x )
	 	{
	 		 carit.next();
	 		 y++;
	 	}
	     if(carit.hasNext()){  p3 = carit.next().clone();
	   }
	     
	     if(p3.equals(p2)|| p3.equals(p1)) System.out.println("Esse piloto ja existe na aposta");
		
		y=0;
		//Perguntar quantia do jogador na posi�ao waka
	     System.out.println(j.toString());
		 System.out.println("Saldo Actual: "+ j.getDc());  
	     System.out.println(" *Insira Quantia.");
		q = s.nextDouble();
		if(q<=j.getDc()){
		//inserir aposta na lista d apostas do waka
	
	j.fazAposta(corr,q,p1,p2,p3);
	j.setDc(j.getDc()-q);
	j.setDi(j.getDi()+q);
	TreeMap<String, Jogador> auxjog = m.getapostadores();
	auxjog.put(j.getNome(), j);
	m.setApostadores(auxjog);
	
	
	
	
	
		}else System.out.println("Nao tem diheiro suficiente");
	//JA INSERE
		       
		     
     
     }


            MenuApostas(m,waka);                                      }
}