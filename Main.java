import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		try{
			
			System.out.println("########## RACING MANAGER 2013 ##########");
			Thread.sleep(500); 
			System.out.println("1 - NOVO CAMPEONATO");
			Thread.sleep(500); 
			System.out.println("2 - CARREGAR CAMPEONATO");
			Thread.sleep(500);
			System.out.println("3 - SAIR");
			Thread.sleep(500);
			  System.out.println("             Escolha opção");
			  Thread.sleep(500);
			  System.out.println("#########################################");
			  Runtime.getRuntime().exec("cls");
			}
			catch(Exception e){
				 System.out.println("#########################################");
			}
			   
		   Scanner scanner = new Scanner(System.in);
		   
	     int x  = scanner.nextInt();
	     try{
	     switch(x){
	     
	     case 1 :  break;
	     case 2 : break;
	     case 3 : break;
	     
	     
	     
	     
	     }
	    
	     }catch(Exception e){
				//If this thread was intrrupted by nother thread 
				}
	     
	     
	}
}
