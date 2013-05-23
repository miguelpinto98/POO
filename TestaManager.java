import java.util.*;

public class TestaManager {
	public static void main(String[] args) {

		Piloto p1 = new Piloto("Muito Fraco", "China", 0, 1, false);
		Piloto p2 = new Piloto("Fraco", "Portugal", 5, 3, false);
		Piloto p3 = new Piloto("Razoavel", "Espanha", 10, 5, false);
		Piloto p4 = new Piloto("Bom", "Reino Unido", 15, 7, false);
		Piloto p5 = new Piloto("Mt bom", "França", 20, 10, false);
		

		PC1 v1 = new PC1("Lotec C1000 Mercedes-Benz", "2000", 6000, 500, p1, p1, 0);
		PC1 v3 = new PC1("Bugatti Veyron 16.4", "2000", 6000, 1000, p3, p3, 0);
		PC1 v2 = new PC1("Porsche GT9-R", "2000", 6000, 2000, p2, p2, 0);
		PC1 v4 = new PC1("SSC Tuatara", "2000", 6000, 2500, p4, p4, 0); 
		PC1 v5 = new PC1("Bugatti Veyron", "2000", 6000, 4000, p5, p5, 0); 

		Circuito Algarve = new Circuito(4664, 16, 100000, 0, 0, 0, 100000, 20000, 50000, p3);
		Circuito Estoril = new Circuito(4182, 13, 84000, 0, 0, 0, 84000, 40000, 50000, p3);

		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(v1);
		v.add(v3);
		Corrida c2 = new Corrida (v, Algarve ,false);
		Corrida c3 = new Corrida( v, Estoril,true);
		HashSet<Corrida> v96= new HashSet<Corrida>();
		v96.add(c2);
		v96.add(c3);
		Campeonato k1 = new Campeonato(v96);
		/*
		int k = 0; int l = 0;
		for(int i = 0 ; i < 5; i++){
		int x = v1.tempoProximaVolta(c1,false);
		int y = v3.tempoProximaVolta(c1,false); 
		l+=y;
		k+=x;
		
		
		if (x>y) 
			 System.out.println(  "JIGGS " + (double) y/(double)1000 + "MARIO " + (double)x/(double)1000);}
		System.out.println( "JIGGS  "+ l/1000+" Mario "+ k/1000);
		*/
		for(Veiculo vaa : c2.fazCampeonato().keySet()){ System.out.println("um " + c2.fazCampeonato().get(vaa)/1000+ "\n");}
	}	
}
