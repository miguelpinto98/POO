import java.util.*;
public class TestaManager
{
   public static void main(String[] args){
    
    Piloto p1 = new Piloto("QUinze", "China", 1,
			6, true);
			 Piloto p2 = new Piloto("Mario", "Portugal", 100,
			10, false);
			Piloto p3= new Piloto("Jiggs", "Espanha", 30,
			7, false);
			
	    PC1 v1 = new PC1("Renault", "2000", 6000, 4000,p1,  p2,0);
		
		Time tpc1 = new Time(1,15,30);
		Time tpc2 = new Time(1,15,30);
		Time tgt = new Time(1,15,30);
		Time tsc= new Time(1,15,30);
		Time trecord = new Time(1,15,30);
		Time tdesviom = new Time(1,15,30);
		Time tboxes = new Time(1,15,30);
		Circuito c1 = new Circuito (2000, 100, tpc1, tpc2, tgt, tsc, trecord, tdesviom, tboxes, p3);
      Circuito cir1 = new Circuito(2000, 100, tpc1, tpc2, tgt, tsc, trecord, tdesviom, tboxes, p3);
		HashSet<Veiculo> v = new HashSet<Veiculo>();
		v.add(v1);
		Corrida c2 = new Corrida (v, c1 ,false);
		Corrida c3 = new Corrida( v, cir1,true);
		HashSet<Corrida> v2= new HashSet<Corrida>();
		v2.add(c2);
		v2.add(c3);
		Campeonato k1 = new Campeonato(v2);
		System.out.println(k1.toString());
    }
}
