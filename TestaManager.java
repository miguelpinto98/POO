import java.util.*;
public class TestaManager
{
   public static void main(String[] args){
    
    Piloto p1 = new Piloto("QUinze", "China", 1,
			6, true);
			 Piloto p2 = new Piloto("Mario", "Portugal", 100,
			10, false);
			Piloto p3= new Piloto("Jiggs", "Espanha", 30,
			1, false);
			
	    PC1 v1 = new PC1("Renault", "2000", 6000, 4000,p2,  p2,0);
	     PC1 v3 = new PC1("Renault", "2000", 6000, 4000,p3,  p2,0);
		
		
		Circuito c1 = new Circuito (2000, 10, 75000, 80000, 2000, 5000, 70000, 20000, 50, p3);
      Circuito cir1 = new Circuito(2000, 100, 213, 3212, 5532, 34233, 38, 40, 5, p3);
		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(v1);
		Corrida c2 = new Corrida (v, c1 ,false);
		Corrida c3 = new Corrida( v, cir1,true);
		HashSet<Corrida> v2= new HashSet<Corrida>();
		v2.add(c2);
		v2.add(c3);
		Campeonato k1 = new Campeonato(v2);
		int k = 0; int l = 0;
		for(int i = 0 ; i < 5; i++){
		int x = v1.tempoProximaVolta(v1,c1,false);
		int y = v1.tempoProximaVolta(v3,c1,false); 
		l+=y;
		k+=x;
		 if ( x >y) 
		System.out.println(  "JIGGS" + x/1000 );
		else System.out.println(  "MARIO" + y/1000);}
		System.out.println( "JIGGS  "+ l/1000+" Mario "+ k/1000); 
    }
}
