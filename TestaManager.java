import java.util.*;

public class TestaManager {
	public static void main(String[] args) {

		Piloto p1 = new Piloto("QUinze", "China", 1, 6, true);
		Piloto p2 = new Piloto("Mario", "Portugal", 100, 1, false);
		Piloto p3 = new Piloto("Jiggs", "Espanha", 30, 10, false);

		PC1 v1 = new PC1("Renault", "2000", 6000, 4000, p2, p2, 0); // M
		PC1 v3 = new PC1("Renault", "2000", 6000, 1000, p3, p2, 0); // J

		Circuito c1 = new Circuito(2000, 10, 75000, 0, 0, 0, 70000, 20000, 50, p3);
		Circuito cir1 = new Circuito(2000, 100, 213, 3212, 5532, 34233, 38, 40, 5, p3);

		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(v1);
		v.add(v3);
		Corrida c2 = new Corrida (v, c1 ,false);
		Corrida c3 = new Corrida( v, cir1,true);
		HashSet<Corrida> v2= new HashSet<Corrida>();
		v2.add(c2);
		v2.add(c3);
		Campeonato k1 = new Campeonato(v2);
		
		int k = 0; int l = 0;
		for(int i = 0 ; i < 5; i++){
		int x = v1.tempoProximaVolta(c1,false);
		int y = v3.tempoProximaVolta(c1,false); 
		l+=y;
		k+=x;
		
		
		 //if (x>y) 
			 System.out.println(  "JIGGS " + (double) y/(double)1000 + "MARIO " + (double)x/(double)1000);}
		System.out.println( "JIGGS  "+ l/1000+" Mario "+ k/1000);
		
		//for(Veiculo vaa : c2.fazCircuito().keySet()){ System.out.println("um " + c2.fazCircuito().get(vaa)/1000+ "\n");}
	}	
}
