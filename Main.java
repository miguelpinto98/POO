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
		
		int k = 0, x;		
		do {
			x = Welcome();
		if(x==1) { 
			jogadores = PedeJogadores(); 
			
			c = Campeonato.geraCampeonato(); 
			m = new Manager(c,jogadores); 
			
			Iterator<Corrida> cor = m.getCampeonato().getCorridas().iterator();
			Corrida r = cor.next();
			for(Veiculo v : r.getConjuntoVeiculos()) {
				m.campstatus.put(v, 0-k);
				k++;
			}	  
		}
		else 
			if(x==2) {
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
			else {
				if(x==3)
					System.exit(0);
				else {
					System.out.println("Opção Inválida!\n");
				}	
			}
		} while(x>3);
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
			System.out.println("#  * Insira o nome do "+(i+1)+"º jogador.                       #"); 
	   		nome = s.nextLine();
	   		System.out.println("#  * Insira a sua morada.");
	   		morada = s.nextLine();
	   		System.out.println("#  * Insira dinheiro inicial no formato XX,XX.");
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
	
	public static void MenuAdicionarJogador(Manager m) {
		String nome=null, morada=null;
		double dc=0;
		
		System.out.println("#################### INSERIR JOGADOR ####################");
		System.out.println("#                                                       #");
		s.nextLine();
		System.out.println("#  * Insira o nome do "+(m.getapostadores().size() +1)+"º jogador.                        #"); 
   		nome = s.nextLine();
   		System.out.println("#  * Insira a sua morada.");
   		morada = s.nextLine();
   		System.out.println("#  * Insira dinheiro inicial no formato XX,XX. \n");
   		dc = s.nextDouble();
   		
   		m.adicionaJogador(nome, morada, dc);
   	}
	
	public static void MenuRemoveJogador(Manager m) throws IOException {
		System.out.println("#################### REMOVER JOGADOR ####################");
		System.out.println("#                                                       #");
		s.nextLine();
		System.out.println("#  * Insira o nome do jogador que pretende remover.     #");
		
		for(Jogador j : m.getapostadores().values())
			System.out.println("#       "+j.getNome());
		System.out.println("#                                                       #");
		System.out.println("#       1 - Voltar                                      #");
		System.out.println("#########################################################");

		if((str=s.next()).equals("1"))
			MenuPrincipal(m);
		else{
			m.removeJogador(str);
		}
	}
	
	public static void MenuPrincipal(Manager m) throws FileNotFoundException, IOException {
		int x = 0;
		
		do {
		System.out.println("#################### MENU PRINCIPAL #####################");
		System.out.println("#                                                       #");
		System.out.println("#        1 - FAZER CORRIDA                              #");
		System.out.println("#        2 - CONSULTAS                                  #");
		System.out.println("#        3 - APOSTAS                                    #");
		System.out.println("#        4 - ADICIONAR JOGADOR                          #");
		System.out.println("#        5 - REMOVER JOGADOR                            #");
		System.out.println("#        6 - GRAVAR                                     #");
		System.out.println("#        7 - SAIR                                       #");
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
			MenuEscolheJogador(m,-1);
		}
		if(x==4) {
			MenuAdicionarJogador(m);
			MenuPrincipal(m);
		}
		if(x==5) {
			MenuRemoveJogador(m);
			MenuPrincipal(m);
		}
		if(x==6) {
			str=MenuGravaJogo();
			m.gravaRM(str);
			MenuPrincipal(m);
		}
		if(x==7) {
			System.exit(0);
		} else
			System.out.println("Opção Inválida!");
		} while(x>7);
	}

	private static void MenuCorrida(Manager m) throws FileNotFoundException, IOException {
		int x = 0;
		Corrida cit = new Corrida();
		HashMap<Veiculo, Integer> z = new HashMap<Veiculo, Integer> ();
		
		Iterator<Corrida> aux = m.getCampeonato().getCorridas().iterator();

		while(aux.hasNext() && x < m.getCorrida()) {
			aux.next();
			x++;
		}
		
		if(aux.hasNext()) {
			cit = aux.next();
			z = cit.fazCorrida(m.campstatus);
		
			for(Jogador h :m.getapostadores().values()) { 
				h.CheckApostas(cit.getCircuito().getNomeCircuito(), z);
			}
		m.setCorida();
		} else
			System.out.println("O campeonato chegou ao fim!");
      
		for(Jogador j : m.getapostadores().values()) {
			j.CheckApostas(cit.getCircuito().getNomeCircuito(), z);
    	}
		MenuPrincipal( m);
	}

	public static void MenuConsultas(Manager m) throws FileNotFoundException, IOException{
	   	int x  = 0,corr = 0;
	   	
	   	do {
		System.out.println("#################### MENU CONSULTAS #####################");
		System.out.println("#                                                       #");
		System.out.println("#        1 - CLASSIFICAÇÃO CAMPEONATO GERAL             #");
		System.out.println("#        2 - TROFÉU HÍBRIDO                             #");
		System.out.println("#        3 - TOP JOGADORES                              #");
		System.out.println("#        4 - CORRIDAS AGENDADAS                         #");
		System.out.println("#        5 - VEÍCULOS NO CAMPEONATO                     #");
		System.out.println("#        6 - VOLTAR AO MENU PRINCIPAL                   #");
		System.out.println("#                                                       #");
		System.out.println("#        Escolha uma opção:                             #");
		System.out.println("#########################################################");
		
		
		x = s.nextInt();
		if(x==1) {
			do {
			HashMap<Integer,String> aux = new HashMap<Integer,String>();
			 
			for(Veiculo v : m.campstatus.keySet()) {
				if(v.veHib() == false)
				aux.put(m.campstatus.get(v), v.getMarca()+" "+v.getModelo());
			}
			
			System.out.println("################## CLASSIFICAÇÃO GERAL ##################");
			System.out.println("#    Pontos                                             #");
			
			for(int y : aux.keySet()) {
				if(y>0)
					System.out.println("#       " + y +"   "+ aux.get(y));
				else
					System.out.println("#       " + 0 +"   "+ aux.get(y));
			}
			System.out.println("#                                                       #");
			System.out.println("#       1 - VOLTAR                                      #");
			System.out.println("#########################################################");
			option = s.nextInt();
			
			if(option==1)
				MenuConsultas(m);
			else
				System.out.println("Opção Inválida!");
			} while(option>1);
		} else 
			if(x==2) {
				do {
				System.out.println("##################### TROFEU HÍBRIDO ####################");
			    HashMap<Integer,String> aux6 = new HashMap<Integer,String>();
				 
				for(Veiculo v : m.campstatus.keySet()) {
					if(v.veHib() == true)
					aux6.put(m.campstatus.get(v), v.getMarca()+" "+v.getModelo());
				}
				
				System.out.println("################## CLASSIFICAÇÃO GERAL ##################");
				System.out.println("#     Pontos                                            #");
				for(int y : aux6.keySet()) {
					if(y>0)
						System.out.println("#        " + y +"   "+ aux6.get(y));
					else
						System.out.println("#        " + 0 +"   "+ aux6.get(y));
				}
				System.out.println("#                                                       #");
				System.out.println("#        1 - VOLTAR                                     #");
				System.out.println("#########################################################");
				option = s.nextInt();

				if(option==1)
					MenuConsultas(m);
				else
					System.out.println("Opção Inválida!");
				} while(option>1);
			} else 
				if(x==3) {
					do {
					System.out.println("##################### TOP 3 JOGADORES ###################");
				    System.out.println("#                                                       #");
					for(Jogador xx : m.topJog())
						System.out.println("#        "+xx.getNome()+" Já ganhou "+xx.getDg());
				    System.out.println("#                                                       #");
					System.out.println("#        1 - VOLTAR                                     #");
					System.out.println("#########################################################");
					option = s.nextInt();

					if(option==1)
						MenuConsultas(m);
					else
						System.out.println("Opção Inválida!");
					} while(option>1);						
				} else 
					if(x==4){
						do {
						System.out.println("################## CORRIDAS AGENDADAS ###################");
						System.out.println("#                                                       #");
						
						for(Corrida r : m.getCampeonato().getCorridas()) { 
							if(corr == m.getCorrida()) {	
								System.out.println("################## PRÓXIMA CORRIDA ######################");	
								System.out.println("#                                                       #");
								System.out.print(r.toString());
								System.out.println("#                                                       #");
								System.out.println("#########################################################");
								corr++;
							} else {
								corr++;
								System.out.println(r.toString());
								}
							}
						System.out.println("#                                                       #");
						System.out.println("#        1 - VOLTAR                                     #");
						System.out.println("#########################################################");
						option = s.nextInt();

						if(option==1)
							MenuConsultas(m);
						else
							System.out.println("Opção Inválida!");
						} while(option>1);	
					} else 
						if(x==5) {
							do {
							System.out.println("################### VEÍCULOS EM PROVA ###################");
							System.out.println("#                                                       #");
							
							Iterator<Corrida> itc = m.getCampeonato().getCorridas().iterator();
							Corrida r = itc.next();
						    	for(Veiculo v : r.getConjuntoVeiculos()) {
						        	  System.out.println(v.toString());
						          }
						    	
						    System.out.println("#                                                       #");
						   	System.out.println("#        1 - VOLTAR                                     #");
						   	System.out.println("#########################################################");
						   	option = s.nextInt();

							if(option==1)
								MenuConsultas(m);
							else
								System.out.println("Opção Inválida!");
							} while(option>1);		
						} else
							if(x==6)
								MenuPrincipal(m);
							else
								System.out.println("Opção Inválida!");
		} while(x>6);		
	}

	public static int jogpos(TreeMap<String, Jogador> treeMap) {
		int x = 0;
		System.out.println("###########  ESCOLHA UM JOGADOR PARA APOSTAR ############");
		System.out.println("#                                                       #");
		
		for(String z : treeMap.keySet()) {
			System.out.println("#        "+x+" - " +treeMap.get(z).getNome());
			x++;
		}
		System.out.println("#                                                       #");
	   	System.out.println("#        Escolha uma opção:                             #");
	   	System.out.println("#########################################################");
	   	
	   	return s.nextInt();
	}
	
	public static void MenuEscolheJogador(Manager m, int i) throws FileNotFoundException, IOException {
	   	int x = 0, ejog = 0;
	   	Jogador j = new Jogador();

	   	if(i==(-1))
	   		ejog=jogpos(m.getapostadores()); 
		else 
			ejog=i;
	   	
	   	Iterator<Jogador> auxj =  m.getapostadores().values().iterator();
	 
		while(auxj.hasNext() && x<ejog) {
			auxj.next();
			x++;
		}
	
		if(auxj.hasNext())
			j=auxj.next();
		else {
			System.out.println("Jogador não existe!"); 
			MenuEscolheJogador(m,-1);
		}
		MenuJogadorAposta(m, ejog, j);
	}
	
	public static void MenuJogadorAposta(Manager m, int ejog, Jogador j) throws FileNotFoundException, IOException {
		int x=0;
		
		do {
		System.out.println("##################### MENU APOSTAS ######################");
		System.out.println("#                                                       #");
		System.out.println("#        Jogador: "+j.getNome());
		System.out.println("#                                                       #");
		System.out.println("#        1 - FAZER APOSTA CORRIDA                       #");
		System.out.println("#        2 - VER APOSTAS POR ACONTECER                  #");
		System.out.println("#        3 - VER HISTÓRICO                              #");
		System.out.println("#        4 - SALDO CURRENTE                             #");
		System.out.println("#        5 - DINHEIRO INVESTIDO                         #");
		System.out.println("#        6 - DINHEIRO GANHO                             #");
		System.out.println("#        7 - TROCAR JOGADOR                             #");
		System.out.println("#        8 - VOLTAR MENU PRINCIPAL                      #");
		System.out.println("#                                                       #");
		System.out.println("#        Escolha uma opção:                             #");
		System.out.println("#########################################################");
		x=s.nextInt();
		
		if(x==1)
			MenuFazAposta(m,ejog);
		else 
			if(x==2) {
				do {
				System.out.println("##################### APOSTAS EM VIGOR ##################");
				System.out.println("#                                                       #");
				
				for(Aposta v : j.getApostaCorrente())
					System.out.println(v.toString());
				
				System.out.println("#                                                       #");
				System.out.println("#        1 - VOLTAR                                     #");
				System.out.println("#########################################################");
				option = s.nextInt();

				if(option==1)
					MenuJogadorAposta(m, ejog, j);
				else
					System.out.println("Opção Inválida!");
				} while(option>1);	
			} else 
				if(x==3) {
					do {
					System.out.println("################### HISTÓRICO APOSTAS ###################");
					System.out.println("#                                                       #");
					
				    for(Aposta v : j.getHistorico())
				    	System.out.print(v.toString());
					
					System.out.println("#                                                       #");
					System.out.println("#        1 - VOLTAR                                     #");
					System.out.println("#########################################################");
					option = s.nextInt();

					if(option==1)
						MenuJogadorAposta(m, ejog, j);
					else
						System.out.println("Opção Inválida!");
					} while(option>1);	
				} else 
					if(x==4) {
						do {
						System.out.println("#    * Saldo Actual: "+j.getDc());
						System.out.println("#                                                       #");
						System.out.println("#    1 - VOLTAR                                         #");
						System.out.println("#########################################################");
						option = s.nextInt();

						if(option==1)
							MenuJogadorAposta(m, ejog, j);
						else
							System.out.println("Opção Inválida!");
						} while(option>1);	
					} else
						if(x==5) {
							do {
							System.out.println("#    * Dinheiro Investido: "+j.getDi());
							System.out.println("#                                                       #");
							System.out.println("#    1 - VOLTAR                                         #");
							System.out.println("#########################################################");
							option = s.nextInt();

							if(option==1)
								MenuJogadorAposta(m, ejog, j);
							else
								System.out.println("Opção Inválida!");
							} while(option>1);	
						} else
							if(x==6) {
								do {
								System.out.println("#    * Dinheiro Ganho: "+j.getDg());
								System.out.println("#                                                       #");
								System.out.println("#    1 - VOLTAR                                         #");
								System.out.println("#########################################################");
								option = s.nextInt();

								if(option==1)
									MenuJogadorAposta(m, ejog, j);
								else
									System.out.println("Opção Inválida!");
								} while(option>1);	
							} else
								if(x==7) {
									MenuEscolheJogador(m, -1);
								} else
									if(x==8) {
										MenuPrincipal(m);
									} else
										System.out.println("Opção Inválida!");
		} while(x>8);
	}
	
	private static void MenuFazAposta(Manager m, int jog) throws FileNotFoundException, IOException {
		int x=0, y=0;
		double q = 0;
		Veiculo p1=null, p2=null, p3=null;
		Corrida corr = new Corrida();
		Jogador j = new Jogador();
	
		Iterator<Jogador> jogit = m.getapostadores().values().iterator();
     
	 	while(jogit.hasNext() && y<jog) {
	 		jogit.next();
	 		y++;
	 	}
	 	
	 	if(jogit.hasNext()) 
	 		j = jogit.next();
	
	 	y=0;
	 	System.out.println("############ ESCOLHA CORRIDA PARA APOSTAR ###########");
		System.out.println("#                                                   #");
		
		for(Corrida r : m.getCampeonato().getCorridas()){
			if(x >= m.getCorrida()) {
				if(x == m.getCorrida())
					System.out.println("#    "+x+" "+ r.getCircuito().getNomeCircuito() + " <--- PRÓX. CORRIDA");
				else
					System.out.println("#    "+x+" "+ r.getCircuito().getNomeCircuito());
				}
			x++;
		}
		System.out.println("#                                                   #");
		System.out.println("#    "+x+" - Voltar                                    #");
		System.out.println("#####################################################");
		x = s.nextInt();
		
		if(x==m.getCampeonato().getCorridas().size()+1)
			MenuJogadorAposta(m,jog,j);
			
		Iterator<Corrida> corrit = m.getCampeonato().getCorridas().iterator();
		while(corrit.hasNext() && y<x) {
			corrit.next();
			y++;
		}
		
		if(corrit.hasNext()) {
			corr = corrit.next();
			p1 = escolheVeiculo(corr,1);
			p2 = escolheVeiculo(corr,2);
			if(p2.equals(p1)) {
				while(p2.equals(p1)) {
					System.out.println("Esse veículo já existe na aposta.");
					p2 = escolheVeiculo(corr,2);
					}
				}
			p3 = escolheVeiculo(corr,3);
			if(p3.equals(p1)|| p3.equals(p2)) {
				while(p2.equals(p1)|| p3.equals(p2)) {
					System.out.println("Esse veículo já existe na aposta."); 
					p3 = escolheVeiculo(corr,3);
					}
				}
			System.out.println("Saldo Actual: "+ j.getDc());  
			System.out.println("#    * Insira quantia a apostar:                    #");
			q=s.nextDouble();
		
			if(q<=j.getDc()) {	
				j.fazAposta(corr,q,p1,p2,p3);
				j.setDc(j.getDc()-q);
				j.setDi(j.getDi()+q);
				TreeMap<String, Jogador> auxjog = m.getapostadores();
				auxjog.put(j.getNome(), j);
				m.setApostadores(auxjog); 
				} else
					System.out.println("Não tem dinheiro suficiente.");
			}
		MenuJogadorAposta(m, jog, j);
	}

	public static Veiculo escolheVeiculo(Corrida corr,int classi) {
		int x = 0 ,y = 0;
		Veiculo vi = null;
		System.out.println("######### ESCOLHA O "+classi+"º classificado #################");
		System.out.println("#                                                   #");
		
		for(Veiculo v : corr.getConjuntoVeiculos()){
			System.out.println("#    "+x +" "+v.getMarca()+" "+v.getModelo());
			x++;	
		}
		System.out.println("#                                                   #");
		System.out.println("#    Escolha uma opção:                             #");
		System.out.println("#####################################################");
		x = s.nextInt();
		
		Iterator<Veiculo> carit = corr.getConjuntoVeiculos().iterator();
		while(carit.hasNext() && y<x) {
			carit.next();
			y++;
		}
     
		if(carit.hasNext())
			vi=carit.next().clone();
		
     return vi;
    }
}