import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Main {

	private static Scanner s = new Scanner(System.in);
	private static String str = null;

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
			
			//inserir na classifica�ao campeonato
			Iterator<Corrida> banana = m.getCampeonato().getCorridas().iterator();
			Corrida r = banana.next();
			  for(Veiculo v : r.getConjuntoVeiculos() ){
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
	    else {
			System.out.println("Opção Errada!");
		    System.exit(0);
		}
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
	   		System.out.println(" * Insira Dinheiro Inicial nor formato XX,XX \n");
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
	//Carrega Jogo
	public static String MenuCarregaJogo() {
		System.out.println("##################### Carregar Jogo #####################");
		System.out.println("#                                                       #");
		System.out.println("#  * Insira o nome do ficheiro a ser carregado.         #");

		return s.next();
	}
	
	//Gravar Jogo
	public static String MenuGravaJogo() {
		System.out.println("###################### Gravar Jogo ######################");
		System.out.println("#                                                       #");
		System.out.println("#  * Insira o nome do ficheiro a ser gravado.           #");

		return s.next();
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
	if(x==2){ MenuConsultas(m);}
	if(x==3){MenuApostas(m,-1);}
	if(x==4) {
		str=MenuGravaJogo();
		m.gravaRM(str);
		MenuPrincipal(m);
		}
	if(x==5){ System.exit(0); }
	
	
	
	
	}
	



private static void MenuCorrida(Manager m) throws FileNotFoundException, IOException {
	
	int x = 0;	Corrida cit = new Corrida();
	Iterator<Corrida> aux = m.getCampeonato().getCorridas().iterator();
	HashMap<Veiculo, Integer> z = new HashMap<Veiculo, Integer> ();
	while(aux.hasNext() && x < m.getCorrida() )
	{
		 aux.next();
		 x++;
	}
    if(aux.hasNext()){  cit = aux.next();
   
  	
      z = cit.fazCorrida(m.campstatus);
      m.setCorida(); } else System.out.println("O Campeonato Acabou!");
      
      for(Jogador j : m.getapostadores().values()){
    	  j.CheckApostas(cit.getCircuito().getNomeCircuito(), z);
    	  
      }
   
	MenuPrincipal( m);
}



//Menu Consulta 
public static void MenuConsultas(Manager m) throws FileNotFoundException, IOException{
   	int x  = 0;
	System.out.println("##################  MENU CONSULTAS ##################");
	System.out.println("#                                                   #");
	System.out.println("#        1 - CLASSIFIC�O DO CAMPEONATO              #");
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
		System.out.println("################## CLASSIFICA��O   ##################");
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




//
public static int jogpos(HashMap<String, Jogador> j){

int x = 0;

	
System.out.println("################  ESCOLHA JOGADOR  ##################");
System.out.println("#                                                   #");
for(String z : j.keySet() ){
	
	System.out.println( "#       " + x +" " +j.get(z).getNome() +"                #");
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
 if(i== -1){
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
		 if(x==1){   MenuFazAposta(m,waka);
				 
				
				
				
			} //Menu faz aposta
			else if(x==2){
				System.out.println("################## APOSTAS   ##################");
			System.out.println("#                                                   #");
			
			ArrayList<Aposta> aux4 = new ArrayList<Aposta>();
			aux4 =j.getApostaCorrente();
			           for(Aposta v : aux4 ){
		        	   System.out.println("bla "+v.toString());
		}
			
			  
			System.out.println("#         1 - VOLTAR                                #");
			System.out.println("#####################################################");
				
				
			} 
			else if(x==3){
				System.out.println("################## APOSTAS   ##################");
				System.out.println("#                                                   #");
				
				ArrayList<Aposta> aux4 = new ArrayList<Aposta>();
			aux4 =j.getHistorico();
			           for(Aposta v : aux4 ){
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
	Jogador j = null;
	//fun�ao 
	 int x = 0, y = 0;
	 
	
	
	//CORRIDA;
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
	     Iterator<Jogador> jogit = m.getapostadores().values().iterator();
		 	while(jogit.hasNext() && y < waka )
		 	{
		 		 carit.next();
		 		 y++;
		 	}
		     if(jogit.hasNext()){ j = jogit.next();
		 System.out.println("Saldo Actual: "+ j.getDc());  
	     System.out.println(" *Insira Quantia.");
		q = s.nextDouble();
		if(q<=j.getDc()){
		//inserir aposta na lista d apostas do waka
		Aposta p = new Aposta(q,p1,p2,p3,corr);
		ArrayList<Aposta> pp = j.getApostaCorrente();
	pp.add(p);j.setApostaCorrente(pp);
	for(Aposta o : pp){ System.out.println(o.toString());}
	j.setApostaCorrente(pp);
		}else System.out.println("Nao tem diheiro suficiente");
	//JA INSERE
		     }   
		     
     
     }


            MenuApostas(m,waka);                                      }
}