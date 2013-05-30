import java.util.*;
public class Main {

	public static void main(String[] args) {
		Campeonato c = null;
		
		try {
			System.out.println("################## RACING MANAGER 2013 ##################");
			System.out.println("#                                                       #");
			System.out.println("#        1 - NOVO CAMPEONATO                            #");
			System.out.println("#        2 - CARREGAR CAMPEONATO                        #");
			System.out.println("#        3 - SAIR                                       #");
			System.out.println("#                                                       #");
			System.out.println("#        Escolha uma opção:                             #");
			System.out.println("#########################################################");
			} catch(Exception e){
			//If this thread was intrrupted by nother thread 
			}
		
		   	Scanner s = new Scanner(System.in);
		   	int x  = s.nextInt();
	     
		   	switch(x) {
		   	//case 1: c= geraCampeonato(); break;
		   	case 2: ; break;
		   	case 3: ; break;
		   	}
	}
}
